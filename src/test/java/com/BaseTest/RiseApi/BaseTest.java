package com.BaseTest.RiseApi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {

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
