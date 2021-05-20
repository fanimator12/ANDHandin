package com.example.initialapp.RemoteSource.WebAPI.Model;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class Token {

    @SerializedName("token")
    private String token = null;

    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getToken() {
        return token;
    }
}
