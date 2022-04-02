package com.Login.RiseApi;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.RiseApi.BaseTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginApisTest extends BaseTest {

	String ConvertedResponse = null;
	String pm_token = null;
	String AuthToken = null;
	String user_id = null;
	JsonObject jObject = null;
	JsonObject childObject = null;
	RequestSpecification httpRequest = null;
	Response response = null;
	String responseMessage = null;
	int statusCode;

	@Test(priority = 1, enabled = true)
	public void Login_WEBPM() {

		httpRequest = RestAssured.given();
		httpRequest.queryParam("email", prop.getProperty("PM_username"));
		httpRequest.queryParam("password", prop.getProperty("PM_password"));
		response = httpRequest.given().contentType("application/json").when().post("/api/login");
		ConvertedResponse = response.getBody().asString();
		jObject = new Gson().fromJson(ConvertedResponse, JsonObject.class);
		childObject = jObject.getAsJsonObject("data"); // get data object
		pm_token = childObject.get("token").getAsString(); // get token
		user_id = childObject.get("user_id").getAsString();
		statusCode = response.getStatusCode();
		responseMessage = jObject.get("msg").getAsString();
		// System.out.println(responseMessage);
		Assert.assertEquals(statusCode /* actual value */, 200/* expected value */, "Correct status code returned");
		// Validating successful response message.
		Assert.assertEquals(responseMessage, "Login Successfully.", "Correct response message returned");
	}

	@Test(priority = 2, enabled = false)
	public void Login_WEBSTAFFPM() {

	}

}
