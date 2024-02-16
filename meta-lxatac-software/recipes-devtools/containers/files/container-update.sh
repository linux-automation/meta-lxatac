#!/bin/sh

echo "ATTENTION: Container update requires Internet access and correct system time!"


if wget -q --spider "https://hub.docker.com"; then
	echo "INFO: Got connection with hub.docker.com"
else
	echo "FAIL: Can not establish a connection to hub.docker.com"
	echo "INFO: Try to connect to pengutronix.de"

	if wget -q --spider "https://pengutronix.de"; then
		echo "INFO: Got connection with pengutronix.de"
		echo "FAIL: Internet connection seems present, but hub.docker.com can not be reached to pull an image. Terminate."
	else
		echo "FAIL: No internet connection. Terminate."
	fi
	exit 2
fi

podman pull debian:latest

exit 0
