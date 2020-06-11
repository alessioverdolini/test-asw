#!/bin/bash

echo Building all projects...

gradle clean build

docker-compose -f docker-compose.yml build

docker-compose -f docker-compose.yml push


