## 简介
欢迎使用易盾 JAVA 开发者SDK，SDK是易盾 API 的配套工具。当前已经支持内容安全产品，后续其他产品会逐渐添加支持。
SDK中各接口调用方式基本相同，接入方式统一，并提供了一些接口调用过程中常见的异常处理方案。
为了简化 JAVA 开发者调试和接入易盾 API 的成本，这里向您介绍适用于 JAVA 的SDK的使用流程，并提供首次使用SDK的简单示例。
让您快速了解SDK的特性和功能，并快速使用起来。


### 1. 准备工作

#### 1.1 环境要求

* Java: 1.8+

  > **说明** 您可以执行命令`java -version` 查看Java版本。
  >
* 从 易盾控制台 开通账号，套餐以及相应产品和业务。
* 从 易盾控制台 获取 SecretID、SecretKey、BusinessId，如果有疑问请联系您的商务经理

#### 1.2 安装SDK

* 开发环境安装并配置好maven管理工具
* 在您的项目中添加maven依赖，只需在 pom.xml 中找到 `<dependencies>` 标签，在里面添加以下依赖项即可。

  ```
  <dependency>
      <groupId>com.netease.yidun</groupId>
      <artifactId>yidun-java-sdk</artifactId>
      <version>1.0.0</version>
  </dependency>
  ```

  > 注意： 这里的版本号只是举例，您可以在 Maven 仓库 上找到最新的版本。
  >

#### 2. 使用SDK

请参考demo模块下各接口使用方式

#### 3. 功能特性

- 用户可配置：接口超时时间、重试机制、请求方式（GET/POST）、协议（HTTP/HTTPS）、region配置等
- 用户无感知：接口地址、版本变更、加签算法、Region降级策略
- 功能可扩展：签名算法（排序MD5、SHA256、HMAC）

#### 4. 配置支持

* http请求各项参数配置

  ```
   ClientProfile clientProfile = AntispamRequester.createDefaultProfile("SecretId", "SecretKey");
   // 按照需求设置http请求的多个参数配置
   HttpClientConfig httpClientConfig = clientProfile.getHttpClientConfig();
   httpClientConfig.setSocketTimeoutMillis(60000);
  ```
* 熔断配置

  ```
  ClientProfile clientProfile = AntispamRequester.createDefaultProfile("SecretId", "SecretKey");
  // 按照需求设置固定窗口的多个熔断参数配置
  FixedWindowBreakStrategy.Config breakerConfig = clientProfile.getBreakerConfig();
  breakerConfig.statWindowMillis(300000);
  ```
* 重试配置

  ```
  ClientProfile clientProfile = AntispamRequester.createDefaultProfile("SecretId", "SecretKey");
  // 最大10次
  clientProfile.setMaxRetryCount(2);
  ```
