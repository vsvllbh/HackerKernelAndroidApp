
package com.sample.hackerkernelandroidapp.Page3_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gender {

    @SerializedName("femaleConfidence")
    @Expose
    private Double femaleConfidence;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("maleConfidence")
    @Expose
    private Double maleConfidence;

    public Double getFemaleConfidence() {
        return femaleConfidence;
    }

    public void setFemaleConfidence(Double femaleConfidence) {
        this.femaleConfidence = femaleConfidence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaleConfidence() {
        return maleConfidence;
    }

    public void setMaleConfidence(Double maleConfidence) {
        this.maleConfidence = maleConfidence;
    }

}
