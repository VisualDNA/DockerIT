#!/bin/bash

mysql -u${test.mysql.root.username} -p${test.mysql.root.password} -e "CREATE DATABASE testDb"
