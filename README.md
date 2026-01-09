# 🧩 LiteManagerX 

Lite Manager X（简称 **LMX**）是一个偏工程化取向的轻量级管理系统。

LMX 希望通过 **统一的结构、明确的规范和克制的设计**，让系统在规模增长后依然可读、可维护。

---

## 项目特性 ✨

### 强大 💪

* 基于主流 Web 技术栈构建
* 后端采用 **Spring Boot** 作为核心服务框架
* 统一接收前端或第三方请求，并进行集中处理与调度

### 易用 ⚙️

* 提供 **Docker 化部署方案**
* 支持 **macOS / Windows / Linux**
* 无需复杂环境配置，拉起即可运行

### 统一 📐

LMX 的重点不在功能数量，而在于：

* 请求路径是否统一
* 代码结构是否清晰
* 新成员是否能快速理解并参与开发

---

## 规范说明 📏

### 请求路径规范 🔗

* 全部使用小写字母
* 单词之间使用中划线 `_`
* 路径尽量体现资源含义，而不是实现细节

示例：

```
/get/
/api/user/user_name
/api/information/user
```

---

### 代码结构与命名 🧱

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

### 接口返回格式 📦

所有接口统一返回以下结构，避免前端或调用方做额外判断：

```json
{
  "code": 0,
  "message": "success",
  "data": {}
}
```

---

## 技术栈 🛠️

* 后端：Java / Spring Boot
* 构建工具：Maven
* 接口风格：RESTful
* 数据库：MySQL
* 容器化：Docker / Docker Compose

---

## 快速开始 🚀

### 1. 克隆项目

```bash
git clone https://github.com/yexiaonan/LiteManagerX.git
cd LiteManagerX
```

### 2. 配置数据库

进入 `LiteManagerX/config` 目录：

* 复制 `application-example.yaml`
* 重命名为 `application.yaml`
* 根据实际环境填写数据库配置

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/LiteManagerX
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

然后将 `InitSQL.sql` 导入到 MySQL：

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

---

## 设计想法 🧠

* 规范不是为了限制，而是为了减少沟通成本
* 可读性比“写得聪明”更重要
* 一致的代码风格，本身就是生产力

---

## 规划方向 🗺️

* 请求链路追踪
* 统一鉴权与权限模型
* 插件化处理机制
* 简单的可视化管理界面

---

## 贡献 🤝

如果你对项目结构、规范设计或实现方式有改进建议，欢迎提交 Issue 或 Pull Request。

哪怕只是指出不合理的地方，也同样有价值。

---

## 贡献者 👥

* 叶小楠 *
* oulao *

---

## 开源协议 📄

MIT License** 开源。

你可以自由地使用、修改和分发它，但请保留原始版权声明。
