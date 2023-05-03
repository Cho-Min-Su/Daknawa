package com.kh.menu.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
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
    public void onConnect(Session session, EndpointConfig config) { 
    	HttpSession hSession = (HttpSession)config.getUserProperties().get("hSession"); 
    	clients.add(session);
    	System.out.println(hSession.getAttribute("loginID"));
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message received: " + message);

        for (Session client : getAllClients()) {
            try {
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

    private Set<Session> getAllClients() {
        return clients;
    }
}