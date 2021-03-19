import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.http.protocol.HTTP;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Name {
	@BeforeTest
	public void bt() {

		RestAssured.baseURI = "http://restcountries.eu/rest/v2/name/eesti";
		
	}
	@Test 
	void putDetails() {
		
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.get("Estonia");
		
		
		JsonPath jsonevaluator = response.jsonPath();
		
		String id = jsonevaluator.get("name");
		
	
				System.out.println("Country " + id);
		
	}


}
