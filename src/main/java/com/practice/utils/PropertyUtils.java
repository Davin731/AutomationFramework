package com.practice.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.practice.constants.FrameworkConstants;
import com.practice.enums.ConfigProperties;
import com.practice.exceptions.InvalidPathForPropertyFileException;
import com.practice.exceptions.PropertyFileUsageException;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static Properties property = new Properties();
	
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

	static {

		FileInputStream file;
		try {
			file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);
			
			for(Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			
			//property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String get(ConfigProperties key) {
		
		if (Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property Name " + key + " is not found. Please check config.properties");
			//throw new RunTimeException("Property Name " + key + " is not found. Please check config.properties");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
//	public static String getValue(String key) throws Exception {
//	
//		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
//			throw new Exception("Property Name " + key + " is not found. Please check config.properties");
//		}
//
//		return property.getProperty(key);
//	}
}
