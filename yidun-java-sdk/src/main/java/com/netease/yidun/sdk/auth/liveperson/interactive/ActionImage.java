package com.netease.yidun.sdk.auth.liveperson.interactive;

public class ActionImage {

    /**
     * 动作
     */
    private String action;
    /**
     * 照片
     */
    private String image;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ActionImage(String action, String image) {
        this.action = action;
        this.image = image;
    }

    @Override
    public String toString() {
        return "ActionImage(" +
                "action=" + action +
                ", image=" + image +
                ")";
    }
}
