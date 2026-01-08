@echo off

set CONFIG=.\config\application.yml
set JAR=.\target\lmx-0.0.1-SNAPSHOT.jar

if not exist %CONFIG% (
  echo 数据库配置文件不存在！
  echo 请复制 application-example.yml 并填写数据库信息
  pause
  exit /b
)

java -jar %JAR% --spring.config.location=%CONFIG%
pause
