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
		Assert.assertEquals(statusCode /* actual value */, 200/* expected value */, "Correct status code returned");
		Assert.assertEquals(responseMessage, "Login Successfully.", "Correct response message returned");
	}

	@Test(priority = 2, enabled = true)
	public void Login_WEBSTAFFPM() {
		httpRequest = RestAssured.given();
		httpRequest.queryParam("email", prop.getProperty("webstaff_username"));
		httpRequest.queryParam("password", prop.getProperty("webstaff_password"));
		response = httpRequest.given().contentType("application/json").when().post("/api/login");
		ConvertedResponse = response.getBody().asString();
		jObject = new Gson().fromJson(ConvertedResponse, JsonObject.class);
		childObject = jObject.getAsJsonObject("data");

		webstaff_staff_token = childObject.get("token").getAsString(); // get token
		webstaff_staff_id = childObject.get("user_id").getAsString();
		webstaff_staff_RoleId = childObject.get("StaffRoles").getAsString();

		statusCode = response.getStatusCode();
		responseMessage = jObject.get("msg").getAsString();
		Assert.assertEquals(statusCode /* actual value */, 200/* expected value */, "Correct status code returned");
		Assert.assertEquals(responseMessage, "Login Successfully.", "Correct response message returned");

	}

	@Test(priority = 3, enabled = true)
	public void Login_WEBResident() {

		httpRequest = RestAssured.given();
		httpRequest.queryParam("email", prop.getProperty("resident_username"));
		httpRequest.queryParam("password", prop.getProperty("resident_password"));
		response = httpRequest.given().contentType("application/json").when().post("/api/login");
		ConvertedResponse = response.getBody().asString();
		jObject = new Gson().fromJson(ConvertedResponse, JsonObject.class);
		childObject = jObject.getAsJsonObject("data");

		resident_token = childObject.get("token").getAsString(); // get token
		resident_id = childObject.get("user_id").getAsString();
		unit_id = childObject.get("units_id").getAsString();
		f_name = childObject.get("firstname").getAsString();
		l_name = childObject.get("lastname").getAsString();
		unit_no = childObject.get("unit_number").getAsString();
		resident_roleId = childObject.get("ResidentRoles").getAsString();

		statusCode = response.getStatusCode();
		responseMessage = jObject.get("msg").getAsString();
		Assert.assertEquals(statusCode /* actual value */, 200/* expected value */, "Correct status code returned");
		Assert.assertEquals(responseMessage, "Login Successfully.", "Correct response message returned");

	}

}
