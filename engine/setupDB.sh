#!/bin/sh

psql --host localhost --port 6666 --user postgres --password -c 'create database "finstrategist"'  -c 'grant ALL on database "finstrategist" to "postgres"'
