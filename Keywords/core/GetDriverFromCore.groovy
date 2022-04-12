package core
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.driver.MobileDriverType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import core.constants.FileRouteConstants
import core.constants.RemoteConstants


class GetDriverFromCore {

	/**
	 * Set web driver capabilities before start of session
	 * @return web driver desired capabilities for current session
	 */
	@Keyword
	def setWebDriverCapabilities() {
		String dir = System.getProperty("user.dir")
		String filePath = dir + "/" + FileRouteConstants.DOWNLOAD_FILES_PATH

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
	 * Stop the current mobile driver session
	 */
	@Keyword
	def stopWebDriver() {
		WebUI.closeBrowser()
		println "Appium Remote Service has been stopped"
	}

	/**
	 * Set mobile driver capabilities before start of session
	 */
	@Keyword
	def setAndroidCapabilities() {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.android()
		desiredCapabilities.setCapability(RemoteConstants.VISUAL_KEY, true)
		desiredCapabilities.setCapability(RemoteConstants.IS_REAL_MOBILE_KEY, true)
		desiredCapabilities.setCapability(RemoteConstants.PLATFORM_VERSION_KEY, '10')
		desiredCapabilities.setCapability(RemoteConstants.PLATFORM_NAME_KEY, RemoteConstants.ANDROID_PLATFORM_NAME)
		desiredCapabilities.setCapability(RemoteConstants.BUILD_KEY, 'CDSApp')
		desiredCapabilities.setCapability(RemoteConstants.NAME_KEY, 'CDSAppRun')
		desiredCapabilities.setCapability(RemoteConstants.VIDEO_KEY, true)
		desiredCapabilities.setCapability(RemoteConstants.NETWORK_KEY, true)
		desiredCapabilities.setCapability(RemoteConstants.CONSOLE_KEY, true)
		desiredCapabilities.setCapability(RemoteConstants.DEVICE_NAME_KEY, 'Galaxy S10')
		desiredCapabilities.setCapability(RemoteConstants.APP_WAIT_ACTIVITY_KEY, '*')
		desiredCapabilities.setCapability(RemoteConstants.USER_KEY, RemoteConstants.LAMBDA_TEST_USER_NAME)
		desiredCapabilities.setCapability(RemoteConstants.ACCESS_KEY_KEY, RemoteConstants.LAMBDA_TEST_ACCESS_KEY)
		return desiredCapabilities
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
		MobileDriverFactory.startRemoteMobileDriver(RemoteConstants.LAMBDA_TEST_REMOTE_URL, setAndroidCapabilities(), MobileDriverType.ANDROID_DRIVER, appId)
		println "Appium Remote Service has been started"
	}

	/**
	 * Stop the current mobile driver session
	 */
	@Keyword
	def stopAppDriver() {
		Mobile.closeApplication()
		println "Appium Remote Service has been stopped"
	}
}