# 接口规范说明文档

**Lite Manager X（LMX）**

---

## 1. 文档目的

本文档用于规范 Lite Manager X（LMX）项目中的接口设计与实现方式，统一接口风格、命名规则、请求与响应结构，降低前后端协作成本，提高系统可维护性与可扩展性。

本规范适用于 **所有对外及内部接口**。

---

## 2. 基本约定

### 2.1 接口风格

* 接口采用 **RESTful 风格**
* 数据交互格式统一使用 **JSON**
* 字符编码统一为 **UTF-8**

---

### 2.2 接口前缀

* 所有接口必须以统一前缀开头：

```
/api
```

示例：

```
/api/user/create
/api/task/execute
```

---

## 3. 接口命名规范

### 3.1 路径命名规则

* 全部使用 **小写字母**
* 单词之间使用中划线 `-`
* 禁止使用拼音缩写、无意义缩写

示例（正确）：

```
/api/user/create
/api/order/query-detail
```

示例（错误）：

```
/api/User/Create
/api/getUserInfo
```

---

### 3.2 资源与行为

* 路径应体现 **资源 + 行为**
* 行为动词应明确，避免歧义

常用行为动词：

* `create`：创建
* `update`：更新
* `delete`：删除
* `query`：查询
* `detail`：详情
* `execute`：执行操作

---

## 4. HTTP 方法规范

| 方法     | 使用场景     |
| ------ | -------- |
| GET    | 查询类接口    |
| POST   | 创建、执行类接口 |
| PUT    | 更新类接口    |
| DELETE | 删除类接口    |

说明：
如业务场景复杂，可统一使用 `POST`，但必须在命名中体现行为。

---

## 5. 请求参数规范

### 5.1 参数传递方式

* GET 请求：通过 Query 参数传递
* POST / PUT 请求：通过 JSON Body 传递
* 禁止混合多种参数传递方式

---

### 5.2 请求对象规范

* 所有请求参数必须封装为对象
* 禁止在 Controller 中直接使用基础类型接参

命名规则：

```
XxxRequest
```

示例：

```
CreateUserRequest
UpdateTaskRequest
```

---

### 5.3 参数命名规则

* 使用小驼峰命名法
* 命名应具备明确业务含义

示例：

```
userId
taskName
createTime
```

---

## 6. 接口响应规范

### 6.1 统一返回结构

所有接口必须返回统一格式：

```json
{
  "code": 0,
  "message": "success",
  "data": {}
}
```

---

### 6.2 字段说明

| 字段      | 类型     | 说明    |
| ------- | ------ | ----- |
| code    | int    | 业务状态码 |
| message | string | 提示信息  |
| data    | object | 返回数据  |

---

### 6.3 状态码约定

| code | 说明     |
| ---- | ------ |
| 0    | 成功     |
| 400  | 参数校验失败 |
| 401  | 未授权    |
| 403  | 无权限    |
| 404  | 资源不存在  |
| 500  | 系统内部错误 |

---

## 7. 返回数据对象规范

* 返回数据必须封装为独立对象
* 禁止直接返回实体类或 Map

命名规则：

```
XxxResponse
```

示例：

```
UserResponse
TaskDetailResponse
```

---

## 8. Controller 层规范

* Controller 仅负责：

    * 接收请求
    * 参数校验
    * 调用 Service
* 禁止在 Controller 中编写业务逻辑
* 禁止直接操作数据库或 Mapper

---

## 9. Service 层规范

* 业务逻辑必须放在 Service 层
* 一个 Service 只负责一个领域的业务
* 复杂逻辑应拆分为多个私有方法

---

## 10. 异常处理规范

* 禁止在接口中直接抛出 RuntimeException
* 所有异常必须统一处理
* 返回标准错误码与错误信息

推荐使用：

* 全局异常处理器（如 `@ControllerAdvice`）

---

## 11. 接口示例

### 创建用户接口

**请求路径**

```
POST /api/user/create
```

**请求参数**

```json
{
  "username": "test_user",
  "password": "123456"
}
```

**响应结果**

```json
{
  "code": 0,
  "message": "success",
  "data": {
    "userId": 1001
  }
}
```

---

## 12. 版本与兼容性

* 接口变更必须向下兼容
* 不兼容变更必须通过版本号区分
* 示例：

```
/api/v1/user/create
/api/v2/user/create
```

---

## 13. 附则

本规范作为 LMX 项目接口设计的强制约束，所有新增或修改接口必须遵循本说明文档。

