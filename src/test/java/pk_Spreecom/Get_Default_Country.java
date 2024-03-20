package pk_Spreecom;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Default_Country {
  @Test
  public void getDefaultCountry() 
  {
	  RestAssured.baseURI = "https://demo.spreecommerce.org";
	  RequestSpecification httpRequest = RestAssured.given();
	  //Response response = httpRequest.get();
	  Response response = httpRequest.request(Method.GET,"/api/v2/storefront/countries/default");
	  
		// Now let us print the body of the message to see what response
	   // we have received from the server
	  //String responseBody = response.getBody().asString();
	  //System.out.println("Response Body is =>  " + responseBody);
	  String res_output = response.prettyPrint();
	  System.out.println("Response Body is =>  " + res_output);
	  // Status Code Validation
	  int statusCode = response.getStatusCode();
	  System.out.println("Status code is =>  " + statusCode);
	  Assert.assertEquals(200, statusCode);
 
	  // First get the JsonPath object instance from the Response interface
	  Assert.assertEquals(res_output.contains("UNITED STATES") /*Expected value*/, true /*Actual Value*/);
	 
	  
  }
}
