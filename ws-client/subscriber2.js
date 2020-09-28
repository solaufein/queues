// This is example of standard queue subscription

var Stomp = require('stompjs');
var url = 'ws://localhost:8080/stomp/websocket';
var client = Stomp.overWS(url);

var user = '111';
var destination = '/queue/chat-' + user;

console.log('try connect...');
client.connect({}, function() {
    console.log('connected...');
    client.subscribe(destination, function(body, headers) {
      console.log('This is the body of a message on the subscribed queue:', body);
    });
}, function(frame) {
    console.log('disconnected...');
});