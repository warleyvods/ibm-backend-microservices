#!/bin/bash

echo Config Server: BUILDING
cd config-server
mvn clean install -U
cd ..
clear

echo Config Server: BUILD DONE
echo Discovery Server: BUILDING
cd discovery-server
mvn clean install -U
cd ..
clear

echo Config Server: BUILD DONE
echo Discovery Server: DONE
echo Gateway Server: BUILDING
cd gateway-server
mvn clean install -U
cd ..
clear

echo Config Server: BUILD DONE
echo Discovery Server: DONE
echo Gateway Server: DONE
echo Hashtag Tracker API: BUILDING
cd hashtag-tracker
mvn clean install -U
cd ..
clear

echo Config Server: BUILD DONE
echo Discovery Server: DONE
echo Gateway Server: DONE
echo Hashtag Tracker API: DONE
echo ---
echo Starting Application...

docker-compose up -d --build

sleep 60
