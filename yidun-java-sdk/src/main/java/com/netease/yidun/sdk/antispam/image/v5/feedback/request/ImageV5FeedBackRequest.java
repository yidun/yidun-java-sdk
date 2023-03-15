package com.netease.yidun.sdk.antispam.image.v5.feedback.request;

import com.netease.yidun.sdk.antispam.image.v5.common.ImageV5Request;
import com.netease.yidun.sdk.antispam.image.v5.feedback.response.ImageV5FeedBackResponse;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Valid;

import java.io.Serializable;
import java.util.List;

public class ImageV5FeedBackRequest extends ImageV5Request<ImageV5FeedBackResponse> {

    @Valid
    @NotEmpty(message = "feedbacks不能为空")
    private List<ImageFeedbackBeanRequest> feedbacks;

    public ImageV5FeedBackRequest() {
        super();
        productCode = "imageCommon";
    }

    public List<ImageFeedbackBeanRequest> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<ImageFeedbackBeanRequest> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    protected String requestUriPath() {
        return "/v2/image/feedback";
    }

    @Override
    public Class<ImageV5FeedBackResponse> getResponseClass() {
        return ImageV5FeedBackResponse.class;
    }

    public static class ImageFeedbackBeanRequest implements Serializable {
        private static final long serialVersionUID = 1656528668193976110L;
        @NotEmpty(message = "taskId不能为空")
        private String taskId;
        @NotNull(message = "level不能为空")
        private Integer level;
        private Integer label;

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

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }
    }
}
