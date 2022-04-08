import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

println('TestCase B is being called')

WebUI.closeBrowser()

Mobile.waitForElementPresent(findTestObject('App/CDSApp/LoginScreenPageObjects/Button'), GlobalVariable.G_Timeout)

CustomKeywords.'app.cds.LoginPage.inputLoginNumber'('1638300361')

CustomKeywords.'core.GetDriverFromCore.stopAppDriver'()