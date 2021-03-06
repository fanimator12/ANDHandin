/**
 * Bucketlist API
 * This is a Python-Flask based RESTful API application that allows users to log and catalog all the stuff they want to accomplish before they expire
 * <p>
 * OpenAPI spec version: 1.0.0
 * <p>
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.example.initialapp.RemoteSource.WebAPI.Model;

import io.swagger.annotations.*;

import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Reset {

    @SerializedName("email")
    private String email = null;

    /**
     **/
    @ApiModelProperty(value = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reset reset = (Reset) o;
        return (this.email == null ? reset.email == null : this.email.equals(reset.email));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.email == null ? 0 : this.email.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Reset {\n");

        sb.append("  email: ").append(email).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
