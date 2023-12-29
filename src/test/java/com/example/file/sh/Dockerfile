FROM openjdk:8-alpine3.9
RUN echo "http://mirrors.aliyun.com/alpine/v3.9/community" > /etc/apk/repositories && \
    echo "http://mirrors.aliyun.com/alpine/v3.9/main" >> /etc/apk/repositories && \
	echo "https://mirrors.aliyun.com/alpine/v3.9/releases" >> /etc/apk/repositories
ENV TZ=Asia/Shanghai
RUN apk add fping ttf-dejavu fontconfig tzdata && cp /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone
EXPOSE 8080
ENV APP_PORT=8080
ADD start.sh /start.sh
RUN chmod +x /start.sh
CMD ["sh","-c","/java/*.sh"]