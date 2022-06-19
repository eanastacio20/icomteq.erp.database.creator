#!/bin/sh

echo "*DUMPING DATABASE $5"
mysqldump --routines --events -h $1 -u $2 -p$3 $4 > $5

echo "*CREATING DATABASE $6"
mysql -h $1 -u $2 -p$3 -e "CREATE DATABASE $6 character set = $7;"

echo "*TABLE, STORED PROCEDURES, VIEWS, TRIGGERS AND EVENT CREATION"
mysql -h $1 -u $2 -p$3 $6 < $5

echo "*DELETING DUMP FILE $5"
rm -f $5?