package core

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class WebBaseClass {

	def waitForElement(TestObject object) {
		WebUI.waitForElementPresent(object, GlobalVariable.G_Timeout)
	}

	@Keyword
	def xpathSetter(String path) {
		waitForElement(findTestObject(path))
		return findTestObject(path)
	}

	@Keyword
	def navigateToURL(String url) {
		WebUI.navigateToUrl(url)
	}
}
