package com.example.Sample.application;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SampleController {

	 @PostMapping(value ="/getJSON",produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<String> getCardDetails(@RequestBody Map< String ,Object> result) {
		 System.out.println(result); 
		 String route="";
		 String location="";
		 String pillCount="";
		 
		   JSONObject json = new JSONObject(result);
//		   JSONArray medications=json.getJSONArray("medications");
//		   for(int i=0;i<medications.length();i++) {
//			   JSONObject antianginalObj=medications.getJSONObject(i);
//			   JSONArray antianginal=antianginalObj.getJSONArray("antianginal");
//			   for(int j=0;j<antianginal.length();j++) {
//				   JSONObject routeObj=antianginal.getJSONObject(i);
//				    route=routeObj.getString("route");
//			   }
//		   }
		   
//		   JSONArray labs=json.getJSONArray("labs");
//		   for(int i=0;i<labs.length();i++) {
//			   JSONObject labobj=labs.getJSONObject(i);
//			   if (labobj.getString("location").equals("Main Hospital Lab")) {
//			   location=labobj.getString("location");
//	   }}
		  
		   JSONArray medications=json.getJSONArray("medications");
		   for(int i=0;i<medications.length();i++) {
			   JSONObject betaBlockerObj=medications.getJSONObject(i);
			   JSONArray betaBlocker=betaBlockerObj.getJSONArray("betaBlocker");
			   for(int j=0;j<betaBlocker.length();j++) {
				   JSONObject pillCountobj=betaBlocker.getJSONObject(i);
				   pillCount=pillCountobj.getString("pillCount");
			   }
		   }
		   
		   System.out.println(pillCount);
		 return ResponseEntity.status(HttpStatus.OK)
			        .body(pillCount); 
		   }	 
		 
}

