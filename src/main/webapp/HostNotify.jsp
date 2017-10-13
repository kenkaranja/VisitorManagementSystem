<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/2/2017
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="navHost.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    var socket;

    function connect() {
        var uname = document.getElementById("sender").value;
        socket = new WebSocket("ws://localhost:8888/VisitorManagementSystem/chat/" + uname);
        socket.onmessage = onMesage;
    }

    WebSocket.onclose = function (event) {
        onClose(event)
    }

    WebSocket.onerror = function (event) {
        onError(event)
    };
    WebSocket.function
    onClose(event)
    {
        alert(event.data)
    }

    function onMesage(event) {
        alert(event.data);
    }

    function sendMsg() {
        socket.send(JSON.stringify({
            "receiver": document.getElementById("receiver").value,
            "content": document.getElementById("msg").value,
            "sender": document.getElementById("sender").value
        }));
    }

    function onClose() {
        alert(event.data)
    }


    function onError(event) {
        alert(event.data)
    }


</script>
</head>

<body>

Enter Sender: <input type="text" id="sender">
<input type="button" value="Connect" onclick="connect()"><br>
Enter Receiver <input type="text" id="receiver"><br>
Message<textarea id="msg" rows="10" cols="10"></textarea>
<input type="button" value="Send Message" onclick="sendMsg()">
<input type="button" value="Leave" onclick="onClose()">
</body>
</body>
</html>

</body>
</html>
