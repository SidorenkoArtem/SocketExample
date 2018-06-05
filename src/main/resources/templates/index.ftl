<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="sockjs-0.3.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/main');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/message', function(message){
                    showGreeting(JSON.parse(message.body).context);
                });
                loadChat();
            });
        }

        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName() {
            var name = document.getElementById('name').value;
            var message = document.getElementById('message').value;
            stompClient.send("/app/main", {}, JSON.stringify({ 'messageText': name, 'message':message }));
        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            console.log(message);
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
        function loadChat() {
            $.ajax({
                url: "/chat",
                method: "POST",
                success: function(result) {
                    result.forEach(function (mess) {
                        var response = document.getElementById('response');
                        var p = document.createElement('p');
                        p.style.wordWrap = 'break-word';
                        p.className = 'h3';
                        console.log(mess.context);
                        p.appendChild(document.createTextNode(mess.context));
                        response.appendChild(p);
                    });
                    console.log(result);
                }
            });

        }
    </script>
</head>
<body bgcolor="#8fbc8f">
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button class="btn btn-lg btn-primary" id="connect" onclick="connect();">Connect</button>
        <button class="btn btn-lg btn-primary" id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>What is your name?</label><input type="text" id="name" />
        <label>Message</label><input type="text" id="message"/>
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>