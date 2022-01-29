build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

lint:
	./gradlew checkstyleMain checkstyleTest

check-updates:
	./gradlew dependencyUpdates

report:
	./gradlew jacocoTestReport

build-run: build run
.PHONY: build