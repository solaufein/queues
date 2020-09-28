// This is example of subscription to user queue

var Stomp = require('stompjs');
var url = 'ws://localhost:8080/stomp/websocket';
var client = Stomp.overWS(url);

var user = '111';
var destination = '/user/queue/chat';

console.log('try connect...');
client.connect({'client-id': user}, function() {
    console.log('connected...');
    client.subscribe(destination, function(body, headers) {
      console.log('This is the body of a message on the subscribed queue:', body);
    });
}, function(frame) {
    console.log('disconnected...');
});