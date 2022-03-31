package core
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory



class GetDriverFromCore {

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getMobileDriver() {
		return MobileDriverFactory.getDriver()
	}

	@Keyword
	def setAndroidCapabilities() {
		println RunConfiguration.getDriverPreferencesProperties();
		RunConfiguration.setDriverPreferencesProperty('Remote', 'visual', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'platformVersion', '10')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'platformName', 'Android')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'build', 'CDSApp')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'name', 'CDSAppRun')
		RunConfiguration.setDriverPreferencesProperty('Remote', 'video', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'network', true)
		RunConfiguration.setDriverPreferencesProperty('Remote', 'console', true)
		println RunConfiguration.getDriverPreferencesProperties();
	}
}