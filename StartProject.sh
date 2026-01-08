#!/bin/bash

CONFIG=./config/application.yml
JAR=./target/lmx-0.0.1-SNAPSHOT.jar

if [ ! -f "$CONFIG" ]; then
  echo "❌ 未检测到配置文件：$CONFIG"
  echo "👉 请复制 config/application-example.yml 为 application.yml 并填写数据库信息"
  exit 1
fi

java -jar $JAR \
  --spring.config.location=$CONFIG
