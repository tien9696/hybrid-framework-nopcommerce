package com.hrm.datatest;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class EmployeeData {

	public static EmployeeData getEmployee() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(
					new File(GlobalConstants.getGlobalConstants().getProjectPath() + "\\testdata\\com\\hrm\\data\\Employee.json"),
					EmployeeData.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;

		}
	}

	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("fullname")
	private String fullname;

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	@JsonProperty("editEmployeeFirstName")
	private String editEmployeeFirstName;

	@JsonProperty("editEmployeeLastName")
	private String editEmployeeLastName;

	@JsonProperty("editEmployeeGender")
	private String editEmployeeGender;

	@JsonProperty("editEmpMaritalStatus")
	private String editEmpMaritalStatus;
	@JsonProperty("editNationality")
	private String editNationality;
	@JsonProperty("adminUserName")
	private String adminUserName;
	@JsonProperty("adminPassword")
	private String adminPassword;

	public String getEditEmployeeFirstName() {
		return editEmployeeFirstName;
	}

	public String getEditEmployeeLastName() {
		return editEmployeeLastName;
	}

	public String getEditEmployeeGender() {
		return editEmployeeGender;
	}

	public String getEditEmpMaritalStatus() {
		return editEmpMaritalStatus;
	}

	public String getEditNationality() {
		return editNationality;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	
	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getFullname() {
		return fullname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@JsonProperty("ContactDetail")
	ContactDetail contactDetail;
	
	
	public static class ContactDetail{
		@JsonProperty("editFirstName")
		private String editFirstName;
	
		@JsonProperty("editLastName")
		private String editLastName;
	}
	
	
	
	
}
