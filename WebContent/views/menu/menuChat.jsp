<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
	String contextPath = request.getContextPath(); // "/jsp"

Member loginName = (Member) request.getSession().getAttribute("loginUser");
String userId = loginName != null ? loginName.getUserName() : "익명";

String alertMsg = (String) session.getAttribute("alertMsg"); // alert 메세지
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>닭나와 채팅방</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<style>

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.chat-box {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	justify-content: flex-end;
	width: 400px;
	height: 400px;
	border: 1px solid #d1d1d1;
	border-radius: 5px;
	padding: 20px;
	background-color: #fff;
	overflow-y: auto;
}

.message {
	max-width: 300px;
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 5px;
	background-color: #d1d1d1;
}

.message.sent {
	align-self: flex-end;
	background-color: #2979ff;
	color: #fff;
}

.chat-controls {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	width: 400px;
	margin-top: 20px;
}

.chat-input {
	flex-grow: 1;
	min-height: 40px;
	padding: 10px;
	border: 1px solid #d1d1d1;
	border-radius: 5px;
	font-size: 16px;
	resize: none;
}

.chat-send {
	margin-left: 10px;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #2979ff;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s ease-in-out;
}

.chat-send:hover {
	background-color: #2166e0;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Chat Room</h1>
        <div class="chat-box" id="chat-box"></div>
        <div class="chat-controls">
            <textarea class="chat-input" id="chat-input" placeholder="Type your message here..."></textarea>
            <button class="chat-send" id="chat-send">Send</button>
        </div>
        <div class="user-list" id="user-list"></div>
        <div class="user-list" id="user-list-online"></div>
    </div>

    <script>
        const chatBox = document.getElementById("chat-box");
        const chatInput = document.getElementById("chat-input");
        const chatSend = document.getElementById("chat-send");
        const userListElement = document.getElementById("user-list");
        const onlineUserListElement = document.getElementById("user-list-online");

        // WebSocket 객체 생성
        const socket = new WebSocket("ws://192.168.40.28:8889/Daknawa/chat");

        const userId = "<%=userId%>";

        socket.addEventListener("open", function (event) {
            console.log("WebSocket connected!");
        });

        // 메시지 수신 시 처리
        socket.onmessage = function (event) {
            const message = event.data;
            const messageElement = document.createElement("div");

            // 보낸 사용자 정보와 함께 메시지 출력
            messageElement.innerHTML = message;
            chatBox.appendChild(messageElement);

            // 사용자 리스트 처리
            if (message.startsWith("user_list:")) {
                const userList = message.substring("user_list:".length).split(",");
                userListElement.innerHTML = "";

                userList.forEach(function (user) {
                    const userElement = document.createElement("div");
                    userElement.innerHTML = user;
                    userListElement.appendChild(userElement);
                });
            }
        };

        // Send 버튼 클릭 이벤트 처리
        chatSend.addEventListener("click", function () {
            const message = chatInput.value;
            socket.send(userId + ": " + message);
            chatInput.value = "";
        });
    </script>
</body>         
</html>