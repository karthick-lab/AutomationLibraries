package com.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProperties {
	
	public static Properties prop;
	
	public String getProperties(String propfilename, String key)
	{
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\"+propfilename);
		try
		{
		      FileInputStream fis=new FileInputStream(file);
		      prop=new Properties();
		      prop.load(fis);
		      return prop.getProperty(key);
		      
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
