package com.netease.yidun.sdk.antispam.grammarfix.v1.submit;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 文本纠错检测响应
 */
public class GrammarfixSubmitResponse extends CommonResponse {

    private GrammarfixSubmitResult result;

    public GrammarfixSubmitResult getResult() {
        return result;
    }

    public void setResult(GrammarfixSubmitResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GrammarfixSubmitResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class GrammarfixSubmitResult {

        private String taskId;
        private Integer level;
        private Detail details;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Detail getDetails() {
            return details;
        }

        public void setDetails(Detail details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "GrammarfixSubmitResult("
                    + "taskId=" + taskId
                    + ", level=" + level
                    + ", details=" + details
                    + ")";
        }
    }

    public static class Detail {

        private String correctContent;
        private List<Fragment> fragments;

        public String getCorrectContent() {
            return correctContent;
        }

        public void setCorrectContent(String correctContent) {
            this.correctContent = correctContent;
        }

        public List<Fragment> getFragments() {
            return fragments;
        }

        public void setFragments(List<Fragment> fragments) {
            this.fragments = fragments;
        }

        @Override
        public String toString() {
            return "Detail("
                    + "correctContent=" + correctContent
                    + ", fragments=" + fragments
                    + ")";
        }
    }

    public static class Fragment {

        private String oriWord;
        private String correctWord;
        private String headWord;
        private String label;
        private String subLabel;
        private String inspectType;
        private Integer modifiedType;
        private Integer startPos;
        private Integer endPos;
        private Integer headStartPos;
        private Integer headEndPos;
        private String correctSuggestion;

        public String getOriWord() {
            return oriWord;
        }

        public void setOriWord(String oriWord) {
            this.oriWord = oriWord;
        }

        public String getCorrectWord() {
            return correctWord;
        }

        public void setCorrectWord(String correctWord) {
            this.correctWord = correctWord;
        }

        public String getHeadWord() {
            return headWord;
        }

        public void setHeadWord(String headWord) {
            this.headWord = headWord;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public String getInspectType() {
            return inspectType;
        }

        public void setInspectType(String inspectType) {
            this.inspectType = inspectType;
        }

        public Integer getModifiedType() {
            return modifiedType;
        }

        public void setModifiedType(Integer modifiedType) {
            this.modifiedType = modifiedType;
        }

        public Integer getStartPos() {
            return startPos;
        }

        public void setStartPos(Integer startPos) {
            this.startPos = startPos;
        }

        public Integer getEndPos() {
            return endPos;
        }

        public void setEndPos(Integer endPos) {
            this.endPos = endPos;
        }

        public Integer getHeadStartPos() {
            return headStartPos;
        }

        public void setHeadStartPos(Integer headStartPos) {
            this.headStartPos = headStartPos;
        }

        public Integer getHeadEndPos() {
            return headEndPos;
        }

        public void setHeadEndPos(Integer headEndPos) {
            this.headEndPos = headEndPos;
        }

        public String getCorrectSuggestion() {
            return correctSuggestion;
        }

        public void setCorrectSuggestion(String correctSuggestion) {
            this.correctSuggestion = correctSuggestion;
        }

        @Override
        public String toString() {
            return "Fragment("
                    + "oriWord=" + oriWord
                    + ", correctWord=" + correctWord
                    + ", headWord=" + headWord
                    + ", label=" + label
                    + ", subLabel=" + subLabel
                    + ", modifiedType=" + modifiedType
                    + ", startPos=" + startPos
                    + ", endPos=" + endPos
                    + ", headStartPos=" + headStartPos
                    + ", headEndPos=" + headEndPos
                    + ", correctSuggestion=" + correctSuggestion
                    + ")";
        }
    }
}
