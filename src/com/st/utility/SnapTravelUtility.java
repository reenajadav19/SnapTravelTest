package com.st.utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SnapTravelUtility {

	final private static String PROPERTIES_FILE_PATH="src/resources/SnapTravelConfig.properties";
	
	public static String getValueByKey(String key) {
		String value = null;
		Properties properties = new Properties();

		// using java 8 try-with-resources structure
		// so the input stream will be closed automatically
		try(InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)){

			properties.load(inputStream);;
			value = properties.getProperty(key);

			return value;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}

}
