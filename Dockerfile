FROM dockerfile/java:oracle-java7
MAINTAINER himanshuy@outlook.com
EXPOSE 8080
CMD java -jar /data/bootBlog-0.1.0.jar
ADD build/libs/bootBlog-0.1.0.jar /data/bootBlog-0.1.0.jar
