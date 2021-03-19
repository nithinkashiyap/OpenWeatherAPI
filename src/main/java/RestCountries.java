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
public class RestCountries {

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
	}
		
	
	@Test
	void getDetails2() {
		
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/alpha?codes=col;no;ee");
		
		
		response.getBody().prettyPrint();
		//String responsebody = response.getBody().asString();
		//System.out.println(responsebody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
	}
	
	@Test
	void getDetails3() {
		
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/currency/cop");
		
		
		response.getBody().prettyPrint();
		//String responsebody = response.getBody().asString();
		//System.out.println(responsebody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
	}
	
	@Test
	void getDetails4() {
		
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/lang/es");
		
		
		response.getBody().prettyPrint();
		//String responsebody = response.getBody().asString();
		//System.out.println(responsebody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
	}
	
	@Test
	void getDetails5() {
		
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/capital/tallinn");
		
		
		response.getBody().prettyPrint();
		//String responsebody = response.getBody().asString();
		//System.out.println(responsebody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
	}
	
	
}
