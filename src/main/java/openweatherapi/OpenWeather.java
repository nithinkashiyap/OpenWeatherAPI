package openweatherapi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenWeather {

	@BeforeTest
	public void bt()
	{
		RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";
	}
	
	@Test
	void test1()
	{
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/stations");
		
		
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 401);
		System.out.println(response.statusCode());
	}
	
	@Test
	void test2()
	{
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject json = new JSONObject();
		json.put("external_id","Interview1");
		json.put("name","Interview Station 3");
		json.put("longitude",-12.44);
		json.put("latitude",33.34);
		
		json.put("altitude",444);
	
		httprequest.body(json.toJSONString());
		
		Response response = httprequest.post("/stations?APPID=7764028be3eb9c837014b41c27bde1c6");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(response.statusCode());
		
	}
	
	@Test
	void test3()
	{
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject json = new JSONObject();
		json.put("external_id","DEMO_TEST001");
		json.put("name","Interview Station 2");
		json.put("longitude",-111.43);
		json.put("latitude",33.33);
		
		json.put("altitude",444);
	
		httprequest.body(json.toJSONString());
		
		Response response = httprequest.post("/stations?APPID=7764028be3eb9c837014b41c27bde1c6");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(response.statusCode());
		
	}
	
	
	@Test
	void test4()
	{
		RequestSpecification httprequest = RestAssured.given();
		//httprequest.header("Content-Type","application/json");
		Response response = httprequest.request(Method.GET, "/stations?APPID=7764028be3eb9c837014b41c27bde1c6");
		
		
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.statusCode());
		
	}
	
	@Test
	void test5() 
	{
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.delete("/stations/604ef3a809e7430001b9e192?APPID=7764028be3eb9c837014b41c27bde1c6");
		
		Assert.assertEquals(response.getStatusCode(), 204);
		System.out.println(response.statusCode());
		
	}
	
	@Test
	void test6() 
	{
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.delete("/stations/604ef67609e7430001b9e193?APPID=7764028be3eb9c837014b41c27bde1c6");
		
		Assert.assertEquals(response.getStatusCode(), 204);
		System.out.println(response.statusCode());
		
	}
	
	@Test
	void test7() 
	{
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.delete("/stations/604ef3a809e7430001b9e193?APPID=7764028be3eb9c837014b41c27bde1c6");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 404);
		System.out.println(response.statusCode());
		
	}
	
}

