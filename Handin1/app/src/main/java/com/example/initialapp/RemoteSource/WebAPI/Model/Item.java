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
public class Item {

    @SerializedName("name")
    private String name = null;

    /**
     **/
    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return (this.name == null ? item.name == null : this.name.equals(item.name));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");

        sb.append("  name: ").append(name).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
