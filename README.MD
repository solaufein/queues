# STOMP websockets example

### Requirements
    - java 11
    - gradle 6
    - docker
    - nodejs(npm)

### Install server
    ./gradlew build
 
### Install client
    cd ws-client && npm install

### Activemq start
    ./activemq-start.sh
    
### Activemq stop
    ./activemq-stop.sh

### Activemq console
    http://localhost:8161/admin/
    user: admin
    pass: admin

### Send message to websocket    
- http://localhost:8080/chat/send1
- http://localhost:8080/chat/send2
- http://localhost:8080/chat/send3
- http://localhost:8080/chat/send4

### Subscribe to ws
    node ws-client/subscriber1.js
    