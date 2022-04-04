package com.BaseTest.RiseApi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	public static String ConvertedResponse = null;
	public static String pm_token = null;
	public static String webstaff_staff_token = null;
	public static String webstaff_staff_id = null;
	public static String webstaff_staff_RoleId = null;
	public static String AuthToken = null;
	public static String user_id = null;
	public static JsonObject jObject = null;
	public static JsonObject childObject = null;
	public static RequestSpecification httpRequest = null;
	public static Response response = null;
	public static String responseMessage = null;
	public static String resident_token = null;
	public static String resident_id = null;
	public static String unit_id = null;
	public static String f_name = null;
	public static String l_name = null;
	public static String unit_no = null;
	public static String resident_roleId = null;
	public static int statusCode;
	public static Properties prop;

	@BeforeSuite
	public void setup() {
		try {
			prop = new Properties();
			FileInputStream fin;
			fin = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");

			try {
				prop.load(fin);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		RestAssured.baseURI = prop.getProperty("baseURI");

	}
}
