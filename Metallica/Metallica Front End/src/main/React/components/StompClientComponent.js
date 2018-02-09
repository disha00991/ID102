var sockJS = require('sockjs-client'); 
var stomp = require('webstomp-client');

export const  stompClient = (registrations)=> {
    var socket = sockJS('/gs-guide-websocket'); 
    var stompClient = stomp.over(socket);
    stompClient.connect({}, function(frame) {
        registrations.forEach(function (registration) { 
          stompClient.subscribe(registration.route, registration.callback);
        });
    });
}
