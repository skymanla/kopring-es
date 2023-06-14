# kopring-es
코프링 + 엘라스틱(docker)

## elastic + kibana
- 화면은 kibana

## Kotlin + Springboot
- elastic과 연결할 API 역할

## How to use
```
$ docker compose -f els.yml up -d --build
$ ./gradlew build
$ java -jar ${packge}-0.0.1-SNAPSHOT.jar
```
- elastic과 kibana가 올라간 것을 먼저 확인 후 코프링을 구동
- test code 작성되어 있으니 test 코드로 구동확인
