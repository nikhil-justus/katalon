package core
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory


class GetDriverFromCore {

	/**
	 * Set web driver capabilities before start of session
	 * @return web driver desired capabilities for current session
	 */
	@Keyword
	def setWebDriverCapabilities() {
		String dir = System.getProperty("user.dir")
		String filePath = dir + "/Test Files/Downloads"

		ChromeOptions chromeOptions = new ChromeOptions()
		chromeOptions.addArguments("--disable-plugins", "--disable-extensions",
				"--disable-popup-blocking","--disable-notifications")
		chromeOptions.addArguments("--disable-web-security")
		chromeOptions.addArguments("--no-sandbox")
		chromeOptions.addArguments("--disable-dev-shm-usage")
		chromeOptions.addArguments("--window-size=1920,1080")
		chromeOptions.setAcceptInsecureCerts(true)

		Map<String,Object> prefs = new HashMap<>()
		prefs.put("download.default_directory", filePath)
		prefs.put("download.prompt_for_download", false)
		chromeOptions.setExperimentalOption("prefs",prefs)

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome()
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions)
		return desiredCapabilities
	}

	/**
	 * Set web driver capabilities and start a driver
	 * @return web driver
	 */
	@Keyword
	def startWebDriver() {
		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		DesiredCapabilities desiredCapabilities = setWebDriverCapabilities()
		WebDriver driver = new ChromeDriver(desiredCapabilities)
		DriverFactory.changeWebDriver(driver)
	}

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getWebDriverInstance() {
		return DriverFactory.getWebDriver()
	}

	/**
	 * Set mobile driver capabilities before start of session
	 */
	@Keyword
	def setAndroidCapabilities(String appId) {
		RunConfiguration.setDriverPreferencesProperty('Remote', 'app', appId)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'visual', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'isRealMobile', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'platformVersion', '10')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'platformName', 'Android')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'build', 'CDSApp')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'name', 'CDSAppRun')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'video', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'network', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'console', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'deviceName', 'Galaxy S10')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'appWaitActivity', '*')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'user', 'tech-automation')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'accessKey', '2NiPJtjYF464L8Z6p03HYmyUPNILaxHMNZAV86PghgTo57OnPr')
		println RunConfiguration.getDriverPreferencesProperties()
	}

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getMobileDriver() {
		return MobileDriverFactory.getDriver()
	}

	/**
	 * Start mobile driver 
	 * Accepts the custom Id of the app uploaded in Lambda Test
	 */
	@Keyword
	def startAppDriver(String appId) {
		setAndroidCapabilities(appId)
		Mobile.startApplication(appId, true)
	}

	/**
	 * Stop the current mobile driver session
	 */
	@Keyword
	def stopAppDriver() {
		Mobile.closeApplication()
		println "Appium Remote Service is stopped"
	}
}