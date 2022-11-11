#!/bin/sh

if podman ps -a | grep -q debian; then
        echo "INFO: Starting Debian container using Podman."
        podman start -a debian
	exit 0

else
        echo "INFO: No Debian container present. Starting a new one using Podman."
        echo "ATTENTION: Container installation might require Internet access and correct system time!"
        podman run -it --name=debian --hostname "${HOSTNAME}-debian" --privileged --network=host --volume=/home/:/home/ --volume=/srv/:/srv/ debian

	podmanerr=$?

	if [ $podmanerr -ne 0 ]; then
		echo "FAIL: Podman run failed with error code" $podmanerr
		echo "INFO: Checking the obligatory internet connection..."
		wget -q --spider https://hub.docker.com
		
		if [ $? -eq 0 ]; then
			echo "INFO: Got connection with hub.docker.com"
			echo "FAIL: Internet connection seems present, but podman failed anyways. Terminate."
		else
			echo "FAIL: Can not establish a connection to hub.docker.com"
			echo "INFO: Try to connect to pengutronix.de"
			wget -q --spider https://pengutronix.de
		
			if [ $? -eq 0 ]; then
				echo "INFO: Got connection with pengutronix.de"
				echo "FAIL: Internet connection seems present, but hub.docker.com can not be reached to pull an image. Terminate."
			else
				echo "FAIL: No internet connection. Terminate."
			fi
			exit 2
		fi
	fi
fi

exit 0
