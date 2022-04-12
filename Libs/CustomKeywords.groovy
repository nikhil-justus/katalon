
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.testdata.DBData

import com.kms.katalon.core.testobject.ResponseObject

import com.applitools.eyes.selenium.Eyes

import org.openqa.selenium.WebElement

import com.applitools.eyes.RectangleSize


 /**
	 * Set web driver capabilities before start of session
	 * @return web driver desired capabilities for current session
	 */ 
def static "core.GetDriverFromCore.setWebDriverCapabilities"() {
    (new core.GetDriverFromCore()).setWebDriverCapabilities()
}

 /**
	 * Set web driver capabilities and start a driver
	 * @return web driver
	 */ 
def static "core.GetDriverFromCore.startWebDriver"() {
    (new core.GetDriverFromCore()).startWebDriver()
}

 /**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */ 
def static "core.GetDriverFromCore.getWebDriverInstance"() {
    (new core.GetDriverFromCore()).getWebDriverInstance()
}

 /**
	 * Stop the current mobile driver session
	 */ 
def static "core.GetDriverFromCore.stopWebDriver"() {
    (new core.GetDriverFromCore()).stopWebDriver()
}

 /**
	 * Set mobile driver capabilities before start of session
	 */ 
def static "core.GetDriverFromCore.setAndroidCapabilities"() {
    (new core.GetDriverFromCore()).setAndroidCapabilities()
}

 /**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */ 
def static "core.GetDriverFromCore.getMobileDriver"() {
    (new core.GetDriverFromCore()).getMobileDriver()
}

 /**
	 * Start mobile driver 
	 * Accepts the custom Id of the app uploaded in Lambda Test
	 */ 
def static "core.GetDriverFromCore.startAppDriver"(
    	String appId	) {
    (new core.GetDriverFromCore()).startAppDriver(
        	appId)
}

 /**
	 * Stop the current mobile driver session
	 */ 
def static "core.GetDriverFromCore.stopAppDriver"() {
    (new core.GetDriverFromCore()).stopAppDriver()
}


def static "core.Helper.addGlobalVariable"(
    	String name	
     , 	Object value	) {
    (new core.Helper()).addGlobalVariable(
        	name
         , 	value)
}

 /**
	 * Read excel file
	 * @param path Excel File Path
	 * @param sheetName excel sheet for usage
	 * @return HashMap [String,List<Object>] with each row as List
	 */ 
def static "core.FileUtils.readExcelWithEachRowAsList"(
    	String path	
     , 	String sheetName	) {
    (new core.FileUtils()).readExcelWithEachRowAsList(
        	path
         , 	sheetName)
}


def static "app.cds.LoginPage.loginInputField"() {
    (new app.cds.LoginPage()).loginInputField()
}


def static "app.cds.LoginPage.sendSMSClickableButton"() {
    (new app.cds.LoginPage()).sendSMSClickableButton()
}


def static "app.cds.LoginPage.inputLoginNumber"(
    	String text	) {
    (new app.cds.LoginPage()).inputLoginNumber(
        	text)
}


def static "app.cds.LoginPage.clickSendSMSButton"() {
    (new app.cds.LoginPage()).clickSendSMSButton()
}


def static "core.AppBaseClass.waitForElement"(
    	TestObject object	) {
    (new core.AppBaseClass()).waitForElement(
        	object)
}

 /**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */ 
def static "core.AppBaseClass.isElementPresent_Mobile"(
    	TestObject to	
     , 	int timeout	) {
    (new core.AppBaseClass()).isElementPresent_Mobile(
        	to
         , 	timeout)
}


def static "core.AppBaseClass.xpathSetter"(
    	String path	) {
    (new core.AppBaseClass()).xpathSetter(
        	path)
}


def static "core.Database.getQuery"(
    	String query	) {
    (new core.Database()).getQuery(
        	query)
}


def static "core.Database.fetchDB"(
    	DBData data	) {
    (new core.Database()).fetchDB(
        	data)
}


def static "core.Database.mokamDBConnection"() {
    (new core.Database()).mokamDBConnection()
}

 /**
	 * Parse json file and return as a json object for validation 
	 * @param json file path
	 * @return json object
	 */ 
def static "core.CoreUtils.getStaticJsonData"(
    	String fileName	) {
    (new core.CoreUtils()).getStaticJsonData(
        	fileName)
}

 /**
	 * Parse the json response and return as a map of the response
	 * @param ResponseObject from API call
	 * @return HashMap
	 */ 
def static "core.CoreUtils.parseResponseToMap"(
    	ResponseObject response	) {
    (new core.CoreUtils()).parseResponseToMap(
        	response)
}


def static "api.paywell.Login.loginInit"(
    	String phone	) {
    (new api.paywell.Login()).loginInit(
        	phone)
}


def static "api.paywell.Login.login"(
    	String phone	
     , 	String otp	) {
    (new api.paywell.Login()).login(
        	phone
         , 	otp)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}
