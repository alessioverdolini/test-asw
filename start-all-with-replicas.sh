#!/bin/bash

echo Starting Application with Replicas...

docker-compose up --scale ricette=2 --scale connessioni=2 --scale ricette-seguite=2
