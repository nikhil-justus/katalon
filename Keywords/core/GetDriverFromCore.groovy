package core
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.driver.MobileDriverType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
		desiredCapabilities.setCapability('visual', true)
		desiredCapabilities.setCapability('isRealMobile', true)
		desiredCapabilities.setCapability('platformVersion', '10')
		desiredCapabilities.setCapability('platformName', 'Android')
		desiredCapabilities.setCapability('build', 'CDSApp')
		desiredCapabilities.setCapability('name', 'CDSAppRun')
		desiredCapabilities.setCapability('video', true)
		desiredCapabilities.setCapability('network', true)
		desiredCapabilities.setCapability('console', true)
		desiredCapabilities.setCapability('deviceName', 'Galaxy S10')
		desiredCapabilities.setCapability('appWaitActivity', '*')
		desiredCapabilities.setCapability('user', 'tech-automation')
		desiredCapabilities.setCapability('accessKey', '2NiPJtjYF464L8Z6p03HYmyUPNILaxHMNZAV86PghgTo57OnPr')
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
		MobileDriverFactory.startRemoteMobileDriver('https://tech-automation:2NiPJtjYF464L8Z6p03HYmyUPNILaxHMNZAV86PghgTo57OnPr@beta-hub.lambdatest.com/wd/hub', setAndroidCapabilities(), MobileDriverType.ANDROID_DRIVER, appId)
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