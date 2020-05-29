#!/bin/sh

BACKEND_DIR="$(readlink -f $(dirname $0))"
SOURCE_DIR="$BACKEND_DIR/src/main/java"
RESOURCES_DIR="$BACKEND_DIR/src/main/resources"
TEST_DIR="$BACKEND_DIR/src/test"

function run_docker() {
	docker run \
		--hostname backend_finstrategist \
		--link finstrategist_postgres \
		-it --rm \
		--name finstrategist_backend \
		-v "$BACKEND_DIR/pom.xml":/usr/src/mymaven/pom.xml \
		-v "$SOURCE_DIR":/usr/src/mymaven/src/main/java \
		-v "$TEST_DIR":/usr/src/mymaven/src/test \
		-v "$RESOURCES_DIR/":/usr/src/mymaven/src/main/resources/ \
		-v "$BACKEND_DIR/.m2/":/root/.m2 \
		-w /usr/src/mymaven \
		--publish 9000:8080 \
		maven mvn $1
}

if [ $1 = "test" ]; then
	run_docker test
else
	run_docker spring-boot:run
fi
