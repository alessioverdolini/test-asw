#!/bin/bash

echo Building Application...

gradle clean build

docker-compose -f docker-compose.yml build

docker-compose -f docker-compose.yml push


