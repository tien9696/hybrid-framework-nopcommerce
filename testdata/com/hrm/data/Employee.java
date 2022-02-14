package com.hrm.data;

import ubilities.DataUtil;

public class Employee {

	public static Employee getEmployee() {
		return new Employee();
	}

	
	
	

	public class Role {
		public static final String ADMIN_USER_NAME = "Admin";
		public static final String ADMIN_PASSWORD = "admin123";

	}

	public class PersonalDetail {
		public static final String FIRST_NAME = "Huyn";
		public static final String LAST_NAME = "Kim";
		public static final String USER_NAME = "Anna";
		public static final String PASSWORD = "87654321";
		public static final String FULL_NAME = "Huyn Kim";
		public  static final String STATUSVALUE = "Enable";

	}

	public class Job {

	}

	public class ContactDetail {

		public static final String EDIT_FIRST_NAME = "Lisa";
		public static final String  EDIT_LAST_NAME = "Lion";
		public static final String GENDER = "Male";
		public static final String STATuS = "Single";
		public static final String NATIONALTILY = "Vietnamese";

	}

	public class Salary {

	}

}
