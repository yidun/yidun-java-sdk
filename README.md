## 简介

欢迎使用易盾 JAVA 开发者SDK，SDK是易盾 API 的配套工具。当前已经支持内容安全与业务安全产品，后续其他产品会逐渐添加支持。
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
      <version>1.2.4</version>
  </dependency>
  ```

  > 注意： 这里的版本号只是举例，您可以在 Maven 仓库 上找到最新的版本。
  >

#### 2. 使用SDK

请参考demo模块下各接口使用方式

#### 3. 功能特性

- 完善的失败处理：

  - 接口请求提供同步重试机制，在出现调用失败时，会自动重试指定region内的下一个请求节点。

  - 接口请求提供故障恢复机制，在同步重试仍然失败时，请求会自动写入本地文件，并在后台异步重试，直到成功后调用预设的业务handler。

  - 接口请求支持熔断降级，在当前时间窗口内，指定region的某个节点失败请求次数到达阈值时，会触发熔断，后续请求会自动路由到region内的其他可用节点，直到超过熔断时间再对熔断节点探活。
- 丰富的签名算法：

  - 内置多种接口签名算法支持，包括MD5、SHA1、SHA256、SM3
- 灵活的接口配置：

  - 常用的http请求的各项配置，包括接口超时参数，http连接池连接数、空闲时间等核心参数。

  - 切换请求协议，通过在请求对象中设置protocol字段，切换HTTP/HTTPS协议，默认HTTPS。

  - 指定region（默认杭州），根据您服务器的所在地，选择适合的region，以达到更好的请求效果，支持的region列表请咨询您的商务经理。

  - 熔断窗口的各项配置，包括窗口大小、熔断时间、错误率阈值、熔断生效的请求数阈值。

  - 同步重试和故障恢复的各项配置，包括文件路径、重试次数、重试间隔等。

#### 4. 配置支持

* http请求各项参数配置

  ```
   // 按照需求设置http请求的多个参数配置
   HttpClientConfig httpClientConfig = clientProfile.getHttpClientConfig();
   httpClientConfig.setSocketTimeoutMillis(60000);
  ```
* 请求协议
  ```
  ImageV5SyncCheckRequest checkRequest = new ImageV5SyncCheckRequest();
  checkRequest.setProtocol(ProtocolEnum.HTTPS);
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
* http请求各项参数配置

  ```
   ClientProfile clientProfile = AntispamRequester.createDefaultProfile("SecretId", "SecretKey");
   // 按照需求设置http请求的多个参数配置
   HttpClientConfig httpClientConfig = clientProfile.getHttpClientConfig();
   httpClientConfig.setSocketTimeoutMillis(60000);
  ```
* 请求协议

  ```
  ImageV5SyncCheckRequest checkRequest = new ImageV5SyncCheckRequest();
  checkRequest.setProtocol(ProtocolEnum.HTTPS);
  ```
* 熔断配置

  ```
  // 按照需求设置固定窗口的多个熔断参数配置
  FixedWindowBreakStrategy.Config breakerConfig = clientProfile.getBreakerConfig();
  breakerConfig.statWindowMillis(300000);
  ```
* 同步重试

  ```
  // 最大10次
  clientProfile.setMaxRetryCount(2);
  ```
* 故障恢复

  ```
    // 创建文件恢复的执行器，这个对象全局是单例的
    DefaultRequestRecover requestRecover = DefaultRequestRecover.createRecover("恢复文件所在的目录");
    // 注册故障恢复的handler，用于接口请求失败，异步重试成功后的处理逻辑，每个接口对应一个，否则对应接口不开启故障恢复
    // 如果多个接口都需要开启故障恢复，则需要register多个handler
    requestRecover.registerRecoverHandler(new AbstractRequestRecoverHandler<ImageV5CheckResponse>() {
        @Override
        public void handle(ImageV5CheckResponse response) {
            // 请求异步恢复成功后，处理请求结果
        }
    });

    // 注册请求失败后的fallback，用于接口请求失败，返回默认值，选填（不指定时，默认返回code为200的fallback对象）
    ImageV5CheckResponse fallbackResp = new ImageV5CheckResponse();
    fallbackResp.setCode(100);
    fallbackResp.setMsg("fallback response");

    requestRecover.registerFallback(fallbackResp);

    // 指定故障恢复的recover
    clientProfile.setRequestRecover(requestRecover);
  ```

#### 5. 详细文档
- [wiki链接](https://github.com/yidun/yidun-java-sdk/wiki)
