package com.kh.member.model.vo;

import javax.websocket.Session;

public class User {
    private String userName;
    private Session session;
    
    public User(String userName, Session session) {
        this.userName = userName;
        this.session = session;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public Session getSession() {
        return session;
    }
}
