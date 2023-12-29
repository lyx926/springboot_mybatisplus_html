# docker shjar

## docker login

```shell
docker login
```

## start.sh脚本

```shell
#!/bin/sh
java -jar \
-Dname=api \
-Dserver.port=8080 \
-Dfile.encoding=utf-8 \
-Duser.timezone=Asia/Shanghai \
-Djava.security.egd=file:/dev/./urandom \
-Xss16m \
-Xms512m \
-Xmx1024m \
-XX:MetaspaceSize=128m \
-XX:MaxMetaspaceSize=512m \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:+PrintGCDateStamps \
-XX:+PrintGCDetails \
-XX:NewRatio=1 \
-XX:SurvivorRatio=30 \
-XX:+UseParallelGC \
-XX:+UseParallelOldGC \
/java/*.jar
```

## Dockerfile

```shell
FROM openjdk:8-alpine3.9
RUN echo "http://mirrors.aliyun.com/alpine/v3.9/community" > /etc/apk/repositories && \
    echo "http://mirrors.aliyun.com/alpine/v3.9/main" >> /etc/apk/repositories && \
    echo "https://mirrors.aliyun.com/alpine/v3.9/releases" >> /etc/apk/repositories
ENV TZ=Asia/Shanghai
RUN apk add fping \
        ttf-dejavu \
        fontconfig \
        tzdata && \
        cp /usr/share/zoneinfo/${TZ} /etc/localtime && \
        echo ${TZ} > /etc/timezone
EXPOSE 8080
ENV APP_PORT=8080
ADD start.sh /start.sh
RUN chmod +x /start.sh
CMD ["sh","-c","/java/*.sh"]
```

## docker build

```shell
docker build -t shjar .
```

## docker tga

```shell
docker tag shjar 15588855251/shjar
docker push 15588855251/shjar
```

## docker run

```shell
docker run \
--name shjar \
--privileged=true \
--restart=always \
-v /home/app/shjar/java:/java \
-p 8081:8080 \
-e TZ=Asia/Shanghai \
-itd 15588855251/shjar && \
docker cp shjar:/start.sh /home/app/shjar/java
```