clean:
	./mvnw clean install
start_assignment:
	./mvnw clean install -f pom.xml
	 java -jar target/assignment-0.0.1-SNAPSHOT.jar
pull:
	git pull origin develop
up:
	docker-compose up -d
