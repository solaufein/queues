// This is example of standard topic subscription

var Stomp = require('stompjs');
var SockJS = require('sockjs-client');
var url = 'http://localhost:8080/ws';
var ws = new SockJS(url);
var client = Stomp.over(ws);

var user = '111';
var destination = '/topic/hello';

console.log('try connect...');
client.connect({}, function() {
    console.log('connected...');
    client.subscribe(destination, function(body, headers) {
      console.log('This is the body of a message on the subscribed topic:', body);
    });
}, function(frame) {
    console.log('disconnected...');
});