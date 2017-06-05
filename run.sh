# Start discovery service
docker-compose up -d discovery-service

while [ -z ${DISCOVERY_SERVICE_READY} ]; do
  echo "Waiting for discovery service..."
  if [ "$(curl --silent localhost:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      DISCOVERY_SERVICE_READY=true;
  fi
  sleep 2
done

# Start the other containers
docker-compose up -d

while [ -z ${EDGE_SERVICE_READY} ]; do
  echo "Waiting for edge service..."
  if [ "$(curl --silent localhost:9000/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      EDGE_SERVICE_READY=true;
  fi
  sleep 2
done

echo "$(curl localhost:9000/health)"
