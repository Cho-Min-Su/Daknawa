package com.kh.menu.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.kh.member.model.vo.Member;


@ServerEndpoint("/chat")
public class ChatServer {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
        session.getUserProperties().put("userId", ""); // 빈 문자열로 초기화
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message received: " + message);

        // 모든 클라이언트에게 메시지 전송
        for (Session client : session.getOpenSessions()) {
            try {
                // 클라이언트로 보낼 메시지 작성 (보낸 사용자 ID + 메시지 내용)
            	String userId = (String) session.getUserProperties().get("userId");
            	String fullMessage = userId + " " + message;

                client.getBasicRemote().sendText(fullMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket closed: " + session.getId());
        clients.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }
}