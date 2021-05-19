/**
 * Bucketlist API
 * This is a Python-Flask based RESTful API application that allows users to log and catalog all the stuff they want to accomplish before they expire  
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.example.initialapp.RemoteSource.BucketListGenerator.WebAPI.Auth;

import android.util.Base64;

import com.example.initialapp.RemoteSource.BucketListGenerator.WebAPI.Pair;

import java.util.Map;
import java.util.List;

public class HttpBasicAuth implements Authentication {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
    String str = (username == null ? "" : username) + ":" + (password == null ? "" : password);
    headerParams.put("Authorization", "Basic " + Base64.encodeToString(str.getBytes(), Base64.DEFAULT));
  }
}
