import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ResponseCodes {
	
	@BeforeTest
	public void bt() {

		RestAssured.baseURI = "https://restcountries.eu/rest/v2";
		
	}
	@Test 
	void getDetails() {
			
			RequestSpecification httprequest = RestAssured.given();
			Response response = httprequest.request(Method.GET, "/name/eesti");
			
			
			response.getBody().prettyPrint();
			//String responsebody = response.getBody().asString();
			//System.out.println(responsebody);
			
			Assert.assertEquals(response.getStatusCode(), 200);
			System.out.println(response.statusCode());
		}
	
	@Test 
	void getDetails2() {
			
			RequestSpecification httprequest = RestAssured.given();
			Response response = httprequest.request(Method.GET, "/names/eesti");
			
			
			response.getBody().prettyPrint();
			//String responsebody = response.getBody().asString();
			//System.out.println(responsebody);
			
			Assert.assertEquals(response.getStatusCode(), 404);
			System.out.println(response.statusCode());
		}
	
	@Test 
	void getDetails3() {
			
			RequestSpecification httprequest = RestAssured.given();
			Response response = httprequest.request(Method.GET, "/name%eesti");
			
			
			response.getBody().prettyPrint();
			//String responsebody = response.getBody().asString();
			//System.out.println(responsebody);
			
			Assert.assertEquals(response.getStatusCode(), 400);
			System.out.println(response.statusCode());
		}
	


	@Test 
	void putDetails() {
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestparam = new JSONObject();
		
		requestparam.put("name", "Americas");
		
		httprequest.contentType("application/json");
		httprequest.body(requestparam.toJSONString());
		
		Response response = httprequest.request(Method.POST, "/name/united");
		
		response.getBody().prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 405);
		System.out.println(response.statusCode());
}
}