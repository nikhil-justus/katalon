import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

println('TestCase B is being called')

ArrayList<HashMap<String, Object>> arr =  CustomKeywords.'core.utils.Helper.getSlaveFileData'()

println arr

CustomKeywords.'app.cds.LoginPage.inputLoginNumber'('1638300361')

