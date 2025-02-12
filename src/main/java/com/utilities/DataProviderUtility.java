package com.utilities;

import java.util.ArrayList;

public class DataProviderUtility {

	static ExcelReader excel = new ExcelReader("Registration page.xls", "Registration details");

	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		for (int i = 1; i <= excel.getrowcount(); i++)

		{
			String firstName = excel.getdata("First Name", i);
			String lastName = excel.getdata("Last Name", i);
			String email = excel.getdata("E-Mail", i);
			String telephone = excel.getdata("Telephone", i);
			String password = excel.getdata("Password", i);
			String confirmPassword = excel.getdata("Password Confirm", i);
			// regpage.enterFirstName(excel.getdata("First Name", i));
			String subscribe = excel.getdata("Newsletter", i);

			Object[] obj = { firstName, lastName, email, telephone, password, confirmPassword, subscribe };
			myData.add(obj);

		}
		
		return myData;

	}

}
