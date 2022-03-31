
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import com.kms.katalon.core.testobject.ResponseObject



def static "core.AppUtils.waitForElement"(
    	TestObject object	) {
    (new core.AppUtils()).waitForElement(
        	object)
}

 /**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */ 
def static "core.AppUtils.isElementPresent_Mobile"(
    	TestObject to	
     , 	int timeout	) {
    (new core.AppUtils()).isElementPresent_Mobile(
        	to
         , 	timeout)
}


def static "core.AppUtils.start"() {
    (new core.AppUtils()).start()
}


def static "core.AppUtils.stop"() {
    (new core.AppUtils()).stop()
}

 /**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */ 
def static "core.GetDriverFromCore.getMobileDriver"() {
    (new core.GetDriverFromCore()).getMobileDriver()
}


def static "core.GetDriverFromCore.setAndroidCapabilities"() {
    (new core.GetDriverFromCore()).setAndroidCapabilities()
}


def static "core.CoreFileUtils.readExcel"(
    	String path	
     , 	String sheetName	) {
    (new core.CoreFileUtils()).readExcel(
        	path
         , 	sheetName)
}


def static "core.CoreFileUtils.readExcelWithEachRowAsList"(
    	String path	
     , 	String sheetName	) {
    (new core.CoreFileUtils()).readExcelWithEachRowAsList(
        	path
         , 	sheetName)
}


def static "core.CoreFileUtils.getStaticJsonData"(
    	String fileName	) {
    (new core.CoreFileUtils()).getStaticJsonData(
        	fileName)
}


def static "core.CoreFileUtils.parseResponseToMap"(
    	ResponseObject response	) {
    (new core.CoreFileUtils()).parseResponseToMap(
        	response)
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


def static "com.kms.katalon.keyword.draganddrop.DragAndDropKeywords.dragAndDrop"(
    	TestObject sourceObject	
     , 	TestObject destinationObject	) {
    (new com.kms.katalon.keyword.draganddrop.DragAndDropKeywords()).dragAndDrop(
        	sourceObject
         , 	destinationObject)
}


def static "com.kms.katalon.keyword.draganddrop.DragAndDropKeywords.dragAndDropBy"(
    	TestObject sourceObject	
     , 	TestObject destinationObject	
     , 	int xOffset	
     , 	int yOffset	) {
    (new com.kms.katalon.keyword.draganddrop.DragAndDropKeywords()).dragAndDropBy(
        	sourceObject
         , 	destinationObject
         , 	xOffset
         , 	yOffset)
}


def static "com.kms.katalon.keyword.draganddrop.DragAndDropKeywords.dragAndDropJquery"(
    	TestObject sourceObject	
     , 	TestObject destinationObject	) {
    (new com.kms.katalon.keyword.draganddrop.DragAndDropKeywords()).dragAndDropJquery(
        	sourceObject
         , 	destinationObject)
}


def static "com.kms.katalon.keyword.draganddrop.DragAndDropKeywords.dragAndDropHtml5"(
    	TestObject sourceObject	
     , 	TestObject destinationObject	) {
    (new com.kms.katalon.keyword.draganddrop.DragAndDropKeywords()).dragAndDropHtml5(
        	sourceObject
         , 	destinationObject)
}
