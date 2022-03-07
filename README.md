# Spring Skeleton
> Spring Boot를 최신화 하여 나만의 틀을 만들기

### skeleton-spring-boot-starter 로컬 Maven Repository에 배포 하기
```
$ ./gradlew skeleton-spring-boot-starter:clean \
 skeleton-spring-boot-starter:build \
 skeleton-spring-boot-starter:publishToMavenLocal
```

### MySQL DB 구동
```
$ docker-compose up -d --build
```