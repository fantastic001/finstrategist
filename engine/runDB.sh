#!/bin/sh

docker run --hostname "finstrategist_db" --rm -it --name finstrategist_postgres -e POSTGRES_PASSWORD=admin --publish 6666:5432 postgres
