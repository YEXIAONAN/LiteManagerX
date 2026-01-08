# LiteManagerX a manager system

Lite Manager X（简称 **LMX**）是一个用于**统一接入、规范管理和集中处理请求**的轻量级管理平台，主要解决多接口、多模块场景下请求分散、命名混乱、维护成本高的问题。

LMX 关注**结构统一、规范先行和工程可维护性**，而不是功能堆叠。





## 项目特性

### 强大

* 基于主流 Web 技术栈构建
* 后端采用 **Spring Boot** 作为核心服务框架
* 统一接收前端或第三方请求，并进行集中处理与调度

### 易用

* 提供 **Docker 化部署方案**
* 支持 **macOS / Windows / Linux**
* 无需复杂环境配置，可快速启动并运行

### 统一

LMX 强调通过规范减少混乱，通过结构降低维护成本。



#### 请求路径规范

* 使用小写字母
* 单词之间使用中划线 `-`
* 路径体现资源与行为语义

示例：

```
/api/user/create
/api/user/query
/api/task/execute
```

---

#### 代码结构与命名规范

| 类型         | 说明               | 命名规则            |
| ---------- | ---------------- | --------------- |
| Controller | 接口层，仅负责请求接收与参数校验 | `XxxController` |
| Service    | 业务逻辑层            | `XxxService`    |
| 请求对象       | 接收前端参数           | `XxxRequest`    |
| 返回对象       | 接口响应数据           | `XxxResponse`   |

示例：

```
UserController
UserService
CreateUserRequest
UserResponse
```

---

#### 统一接口返回格式

所有接口统一返回结构，避免前端做特殊判断：

```json
{
  "code": 0,
  "message": "success",
  "data": {}
}
```

* `code`：业务状态码
* `message`：提示信息
* `data`：实际返回数据

---

## 技术栈

* 后端：Java / Spring Boot
* 容器化：Docker / Docker Compose
* 构建工具：Maven 
* 接口风格：RESTful
* 数据库：MySQL

---

## 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/yexiaonan/LiteManagerX.git
cd LiteManagerX
```



### 2.配置项目基础信息

项目Clone完毕后，前往 **LiteManagerX/config** 目录下，复制并移动 **confg/appllication-exam.yaml** 文件，将其重命名为 **config/application.yaml** 并在里面填入数据库信息。

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/LiteManagerX # 修改ip地址，以及mysql服务端口
    username: root # 修改用户名
    password: your_pasword # 修改密码
    driver-class-name: com.mysql.cj.jdbc.Driver

```



做好这些准备工作后，你还需要将 config/InitSQL.sql 这个文件导入你的MySQL主机下，然后执行命令导入。

```bash
source InitSQL.sql
```






### 3. 使用 Docker 启动

```bash
docker compose up -d
```

### 4. 访问服务

```
http://localhost:8080
```



## 设计理念

* 规范优于约定
* 可读性优先于技巧
* 一致性本身就是功能
* 保持克制，便于长期维护

LMX 更像是一个**请求治理的基础骨架**，而不是强绑定业务的框架。

---

## 规划路线

* 请求链路追踪
* 统一鉴权与权限模型
* 插件化处理机制
* 可视化管理界面

---

## 开源协议

MIT License

