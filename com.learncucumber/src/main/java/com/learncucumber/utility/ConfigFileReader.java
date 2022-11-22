package com.learncucumber.utility;

import java.util.Properties;

public class ConfigFileReader {
	Properties pro;
	public String getReportConfigPath(){
		String reportConfigPath = pro.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

}
