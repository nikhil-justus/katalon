package core

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.driver.MobileDriverType
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class AppUtils {

	@Keyword
	def waitForElement(TestObject object) {
		Mobile.waitForElementPresent(object, GlobalVariable.G_Timeout)
	}

	/**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */
	@Keyword
	def isElementPresent_Mobile(TestObject to, int timeout){
		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			WebElement element = MobileElementCommonHelper.findElement(to, timeout)
			if (element != null) {
				KeywordUtil.markPassed("Object " + to.getObjectId() + " is present")
			}
			return true
		} catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
		return false;
	}

	@Keyword
	def setAndroidCapabilities(String appId) {
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

		MobileDriverFactory.startRemoteMobileDriver('https://tech-automation:2NiPJtjYF464L8Z6p03HYmyUPNILaxHMNZAV86PghgTo57OnPr@beta-hub.lambdatest.com/wd/hub', desiredCapabilities, MobileDriverType.ANDROID_DRIVER, 'lambda123456')
	}
}
