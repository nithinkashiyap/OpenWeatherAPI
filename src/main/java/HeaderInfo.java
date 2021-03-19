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
public class HeaderInfo {
	@Test
	void getDetails() {
		
		RestAssured.baseURI = "https://restcountries.eu/rest/v2";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/name/eesti");
		
		
		response.getBody().prettyPrint();
		//String responsebody = response.getBody().asString();
		//System.out.println(responsebody);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
		
		Headers allHeaders = response.headers();
		 
		 // Iterate over all the Headers
		 for(Header header : allHeaders)
		 {
		 System.out.println("Key: " + header.getName() + ", Value: " + header.getValue());
		 }

}
}
