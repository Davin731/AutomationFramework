package com.practice.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	
	
	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String JSONCONFIGFILEPATH = RESOURCESPATH + "/json/config.json";
	private static final String SCREENSHOTSPATH = RESOURCESPATH + "/screenshots";
	private static final int EXPLICITWAIT = 10;

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static int getExplicitWait()
	{
		return EXPLICITWAIT;
	}
	
	public static String jsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}
	
	public static String screenshotsPath() {
		return SCREENSHOTSPATH;
	}
}
