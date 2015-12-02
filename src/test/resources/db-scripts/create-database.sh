#!/bin/bash

mysql -u${test.mysql.root.username} -h 127.0.0.1 -p${test.mysql.root.password} -P 3306 -e "SELECT 1"
