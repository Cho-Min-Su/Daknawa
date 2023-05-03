package com.kh.common.controller;

import javax.mail.Authenticator;

import javax.mail.PasswordAuthentication;

 

public class MailAuth extends Authenticator{

    

    PasswordAuthentication pa;

    

    public MailAuth() {

        String mail_id = "daknawa@gmail.com";

        String mail_pw = "ebagaudsvwxggntu";

        

        pa = new PasswordAuthentication(mail_id, mail_pw);

    }

    

    public PasswordAuthentication getPasswordAuthentication() {

        return pa;

    }

}