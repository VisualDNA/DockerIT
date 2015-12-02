#!/bin/bash

while ! echo $(mysql -h 127.0.0.1 -P 3306 -u${test.mysql.root.username} -p${test.mysql.root.password} -e "SELECT 'ready'") | grep --quiet "ready"; do
    sleep 2
    echo "====================================="
    echo "Waiting for mysql Server to be ready"
    echo "====================================="

done

mysql -h 127.0.0.1 -P 3306 -u${test.mysql.root.username} -p${test.mysql.root.password} < $1
