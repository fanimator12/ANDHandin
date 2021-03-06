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

package com.example.initialapp.RemoteSource.WebAPI.Auth;

import com.example.initialapp.RemoteSource.WebAPI.Pair;

import java.util.Map;
import java.util.List;

public interface Authentication {
  /** Apply authentication settings to header and query params. */
  void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
