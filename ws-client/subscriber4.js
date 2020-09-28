// This is example of DURABLE topic subscription

var Stomp = require('stompjs');
var url = 'ws://localhost:8080/stomp/websocket';
var client = Stomp.overWS(url);

var user = '111';
var destination = '/topic/hello-' + user;

console.log('try connect...');
client.connect({'client-id': user}, function() {
    console.log('connected...');
    client.subscribe(destination, function(body, headers) {
      console.log('This is the body of a message on the subscribed topic:', body);
    }, {'activemq.subscriptionName': user});
}, function(frame) {
    console.log('disconnected...');
});