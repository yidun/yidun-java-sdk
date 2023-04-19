package com.netease.yidun.sdk.auth.ocr.licenseplate.v1;

import java.util.List;

/**
 * 车牌OCR所得信息
 */
public class LicensePlateInfo {

    /** 车牌颜色：支持blue、green、yellow、white */
    private String color;

    /** 车牌号码 */
    private String number;

    /** 前7个数字为车牌中每个字符的置信度，第8个数字为平均置信度，区间为0-1 */
    private List<Double> probability;

    /** 返回文字外接多边形顶点位置 */
    private List<Point> vertexesLocation;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Double> getProbability() {
        return probability;
    }

    public void setProbability(List<Double> probability) {
        this.probability = probability;
    }

    public List<Point> getVertexesLocation() {
        return vertexesLocation;
    }

    public void setVertexesLocation(List<Point> vertexesLocation) {
        this.vertexesLocation = vertexesLocation;
    }

    @Override
    public String toString() {
        return "LicensePlateInfo(" +
                "color=" + color +
                ", number=" + number +
                ", probability=" + probability +
                ", vertexesLocation=" + vertexesLocation +
                ")";
    }

    /** 坐标点 */
    public static class Point {

        /** 水平坐标（坐标0点为左上角） */
        private int x;
        /** 垂直坐标（坐标0点为左上角） */
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point(" +
                    "x=" + x +
                    ", y=" + y +
                    ")";
        }
    }
}
