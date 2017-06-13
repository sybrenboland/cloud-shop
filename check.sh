while [ -z ${EDGE_SERVICE_READY} ]; do
  echo "Waiting for edge service..."
  if [ "$(curl --silent localhost:9000/basket/basket 2>&1 | grep -q '\"productList\"'; echo $?)" = 0 ]; then
      EDGE_SERVICE_READY=true;
  fi
  sleep 2
done

echo "$(curl localhost:9000/basket/basket)"
