# 技术方案 — T-185（yidun-java-sdk / 点播音视频解决方案回调 SDK）

## 需求概述

REQ-153 要求点播音视频解决方案回调的 `failUnit` 增加英文 `message` 字段。本仓库为 **SDK 侧对称改造**：
在 `VideoSolutionAntispamCallbackV2Response` 的 `failUnit.audio` / `failUnit.video` / `failUnit.images[]` 增加 `message` 字段，供接入方直接反序列化读取。

## 前置澄清记录

### 澄清时间: 2026-09-24
### 澄清要点:
- Q: 交付范围？ → A: 服务仓库 + SDK（本仓库 + `yidun-golang-sdk`），各自独立 MR。
- Q: 是否同步改造通用 `*FailReasonEnum`？ → A: 本次只增加回调响应 DTO 的 `message` 字段；服务端为文案唯一来源，通用枚举（其英文语义与点播老接口/解决方案存在差异）暂不改动，避免歧义。

## 知识库参考

> 检索时间: 2026-09-24 | 检索键: sdk, videosolution, failUnit | 命中: 0 条（无检索键，非阻断）

<!-- RETRIEVAL-META
  timestamp: 2026-09-24T08:35:00Z
  keys: [sdk, videosolution, failUnit]
  total_hits: 0
  high_relevance: 0
  influenced_decisions: 1
-->

## 技术方案

### 涉及模块

| 模块 | 改动类型 | 说明 |
|------|---------|------|
| yidun-java-sdk | 修改 | `VideoSolutionTargetFailUnitResponse`、`VideoSolutionImageFailUnitResponse` 增加 `message` |

### 详细设计

`VideoSolutionAntispamCallbackV2Response.java`：
- `VideoSolutionTargetFailUnitResponse`（`:120`）增加 `private String message;`（audio/video 共用）；
- `VideoSolutionImageFailUnitResponse`（`:127`，非继承）增加 `private String message;`。

字段名与服务端 JSON `message` 对齐，Lombok `@Data` 自动生成 getter/setter。

## 实施计划

### STEP-01: 回调响应 DTO 增加 message
- **目标**：SDK 可反序列化 `failUnit.*.message`。
- **范围**：`yidun-java-sdk/src/main/java/com/netease/yidun/sdk/antispam/videosolution/callback/v2/response/VideoSolutionAntispamCallbackV2Response.java`
- **依赖**：无
- **验收标准**：JSON 反序列化后 `getMessage()` 返回服务端文案。
- **测试证据**：TD-001
- **提交边界**：单个 DTO 文件

## 测试设计

### Current Coverage Snapshot
- 当前已有测试层：SDK 含 demo 模块；回调 DTO 无专门单测。

### Gap Analysis
- 高风险缺口：反序列化 `message` 无断言。

| # | 测试场景 | 类型 | 覆盖点 | 涉及文件 | required | red_required | 状态 |
|---|---------|------|--------|---------|----------|--------------|------|
| TD-001 | 反序列化含 message 的 failUnit JSON | 单元 | DTO 字段 | VideoSolutionCallbackV2ResponseTest.java | true | false | ⏳ |

**覆盖率目标**：≥ 80%

## 影响分析

### 变更影响范围

| 影响维度 | 说明 |
|---------|------|
| 数据库/消息队列/配置/前端 | 无 |
| API 接口 | SDK DTO 新增字段，向后兼容 |

### 风险评估

| 风险 | 概率 | 影响 | 缓解措施 |
|------|------|------|---------|
| 字段名不一致导致丢失 | 低 | message 为 null | 字段名严格对齐 `message` |

### 回滚方案

回滚本仓库分支（纯新增字段）。
