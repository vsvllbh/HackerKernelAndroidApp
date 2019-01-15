
package com.sample.hackerkernelandroidapp.Page3_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("lips")
    @Expose
    private String lips;
    @SerializedName("asian")
    @Expose
    private Double asian;
    @SerializedName("gender")
    @Expose
    private Gender gender;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("hispanic")
    @Expose
    private Double hispanic;
    @SerializedName("other")
    @Expose
    private Double other;
    @SerializedName("black")
    @Expose
    private Double black;
    @SerializedName("white")
    @Expose
    private Integer white;
    @SerializedName("glasses")
    @Expose
    private String glasses;

    public String getLips() {
        return lips;
    }

    public void setLips(String lips) {
        this.lips = lips;
    }

    public Double getAsian() {
        return asian;
    }

    public void setAsian(Double asian) {
        this.asian = asian;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHispanic() {
        return hispanic;
    }

    public void setHispanic(Double hispanic) {
        this.hispanic = hispanic;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getBlack() {
        return black;
    }

    public void setBlack(Double black) {
        this.black = black;
    }

    public Integer getWhite() {
        return white;
    }

    public void setWhite(Integer white) {
        this.white = white;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

}
