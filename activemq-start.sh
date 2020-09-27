#!/bin/bash

docker run -itd -p 61616:61616 -p 61613:61613 -p 61614:61614 -p 8161:8161 --name my-activemq rmohr/activemq

