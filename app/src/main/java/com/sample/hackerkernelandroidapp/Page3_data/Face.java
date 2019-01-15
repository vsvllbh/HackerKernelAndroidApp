
package com.sample.hackerkernelandroidapp.Page3_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Face {

    @SerializedName("topLeftX")
    @Expose
    private Integer topLeftX;
    @SerializedName("topLeftY")
    @Expose
    private Integer topLeftY;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("rightEyeCenterY")
    @Expose
    private Integer rightEyeCenterY;
    @SerializedName("rightEyeCenterX")
    @Expose
    private Integer rightEyeCenterX;
    @SerializedName("pitch")
    @Expose
    private Integer pitch;
    @SerializedName("quality")
    @Expose
    private Double quality;
    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("chinTipX")
    @Expose
    private Integer chinTipX;
    @SerializedName("yaw")
    @Expose
    private Integer yaw;
    @SerializedName("chinTipY")
    @Expose
    private Integer chinTipY;
    @SerializedName("eyeDistance")
    @Expose
    private Integer eyeDistance;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("leftEyeCenterY")
    @Expose
    private Integer leftEyeCenterY;
    @SerializedName("leftEyeCenterX")
    @Expose
    private Integer leftEyeCenterX;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("face_id")
    @Expose
    private Integer faceId;
    @SerializedName("roll")
    @Expose
    private Integer roll;

    public Integer getTopLeftX() {
        return topLeftX;
    }

    public void setTopLeftX(Integer topLeftX) {
        this.topLeftX = topLeftX;
    }

    public Integer getTopLeftY() {
        return topLeftY;
    }

    public void setTopLeftY(Integer topLeftY) {
        this.topLeftY = topLeftY;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getRightEyeCenterY() {
        return rightEyeCenterY;
    }

    public void setRightEyeCenterY(Integer rightEyeCenterY) {
        this.rightEyeCenterY = rightEyeCenterY;
    }

    public Integer getRightEyeCenterX() {
        return rightEyeCenterX;
    }

    public void setRightEyeCenterX(Integer rightEyeCenterX) {
        this.rightEyeCenterX = rightEyeCenterX;
    }

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Integer getChinTipX() {
        return chinTipX;
    }

    public void setChinTipX(Integer chinTipX) {
        this.chinTipX = chinTipX;
    }

    public Integer getYaw() {
        return yaw;
    }

    public void setYaw(Integer yaw) {
        this.yaw = yaw;
    }

    public Integer getChinTipY() {
        return chinTipY;
    }

    public void setChinTipY(Integer chinTipY) {
        this.chinTipY = chinTipY;
    }

    public Integer getEyeDistance() {
        return eyeDistance;
    }

    public void setEyeDistance(Integer eyeDistance) {
        this.eyeDistance = eyeDistance;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLeftEyeCenterY() {
        return leftEyeCenterY;
    }

    public void setLeftEyeCenterY(Integer leftEyeCenterY) {
        this.leftEyeCenterY = leftEyeCenterY;
    }

    public Integer getLeftEyeCenterX() {
        return leftEyeCenterX;
    }

    public void setLeftEyeCenterX(Integer leftEyeCenterX) {
        this.leftEyeCenterX = leftEyeCenterX;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Integer getFaceId() {
        return faceId;
    }

    public void setFaceId(Integer faceId) {
        this.faceId = faceId;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

}
