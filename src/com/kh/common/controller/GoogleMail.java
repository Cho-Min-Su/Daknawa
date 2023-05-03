package com.kh.common.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class GoogleMail
 */
@WebServlet("/emailConfirmForm.me")
public class GoogleMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		
		String email = new MemberService().searchPwd(userId);
		
		if(email == null) { // 실패 (없는 유저)
			
			request.getSession().setAttribute("alertMsg", "아이디가 존재하지 않습니다. 확인 후 다시 입력해 주세요.");
			
			
			request.getRequestDispatcher("/searchPwd.me").forward(request, response);
		} else { // 성공
		
		Properties prop = System.getProperties();

        prop.put("mail.smtp.starttls.enable", "true");

        prop.put("mail.smtp.host", "smtp.gmail.com");

        prop.put("mail.smtp.auth", "true");

        prop.put("mail.smtp.port", "587");

        

        Authenticator auth = new MailAuth();
        
        Session session = Session.getDefaultInstance(prop, auth);
        
        MimeMessage msg = new MimeMessage(session);
        
        int random = (int)(Math.random() * 900000 + 100000); // 100000 ~ 999999
        
        request.getSession().setAttribute("random", random); // 세션에 랜덤값 저장
        request.getSession().setAttribute("userId", userId); // 세션에 입력받은 아이디 저장
        
        try {

            msg.setSentDate(new Date());
            
            msg.setFrom(new InternetAddress("daknawa@gmail.com", "닭나와"));

            InternetAddress to = new InternetAddress(email);

            msg.setRecipient(Message.RecipientType.TO, to);

            msg.setSubject("닭나와 이메일 인증번호입니다.", "UTF-8");

            msg.setText("안녕하세요! 닭나와입니다. 인증번호는 " + random + " 입니다.", "UTF-8");

            Transport.send(msg);

            

        } catch(AddressException ae) {            

            System.out.println("AddressException : " + ae.getMessage());           

        } catch(MessagingException me) {            

            System.out.println("MessagingException : " + me.getMessage());

        } catch(UnsupportedEncodingException e) {

            System.out.println("UnsupportedEncodingException : " + e.getMessage());

        }
        
        request.getRequestDispatcher("views/member/emailConfirmForm.jsp").forward(request, response);
		}
	}
    
}
