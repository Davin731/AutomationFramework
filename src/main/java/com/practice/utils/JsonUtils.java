package com.practice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Map.Entry;

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
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static String get(ConfigProperties key) throws Exception{
		
		if (Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property Name " + key + " is not found. Please check config.properties");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
