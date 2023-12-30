package com.practice.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.constants.FrameworkConstants;
import com.practice.enums.ConfigProperties;

public class JsonUtils {
	
	private JsonUtils() {
		
	}
	
	private static Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.jsonConfigFilePath());
			CONFIGMAP = new ObjectMapper().readValue(file, new TypeReference<HashMap<String, String>>() {} );
		} 
		catch(FileNotFoundException e) {
			throw new RuntimeException();
		}
		catch (IOException e) {
			throw new RuntimeException();
		}
		
	}

	public static String get(ConfigProperties key) {
		
		if (Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new RuntimeException("Property Name " + key + " is not found. Please check config.properties");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
