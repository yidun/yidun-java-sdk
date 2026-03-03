# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.5.0] - 2026-03-03

### Added - 图片检测响应字段补齐

#### ImageV5AntispamResp 新增字段
- `suggestionLevel` (Integer) - 建议级别
- `censor` (Integer) - 审核结果
- `overAllMarkDesc` (String) - 整体标记描述
- `detailMarks` (List<String>) - 详细标记列表
- `remark` (String) - 备注信息
- `censorExtension` (String) - 审核扩展信息
- `hitSource` (Integer) - 命中来源
- `strategyType` (Integer) - 策略类型
- `hitResult` (String) - 命中结果详情

#### CensorLabelInfo 新增字段
- `parentLabelId` (String) - 父标签 ID
- `depth` (Integer) - 标签深度

#### ImageV5OcrResp 新增字段
- `frameSize` (Integer) - OCR 分帧数

### Fixed
- 修复 Java SDK 响应字段与 API 不一致的问题 (#SF-166-261)

## [1.4.2-148859-SNAPSHOT] - Previous Version

历史版本...
