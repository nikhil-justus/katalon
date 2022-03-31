package app.cds

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable



public class LoginPage {

	//	Mobile mobile = new Mobile();

	//Elements

	@Keyword
	def TestObject loginInputField() {
		return findTestObject('Object Repository/App/CDSApp/LoginScreenPageObjects/loginInputField')
	}

	//CustomKeywords.'app.cds.LoginPage.loginInputField'()

	@Keyword
	def TestObject sendSMSClickableButton() {
		return findTestObject('App/CDSApp/LoginScreenPageObjects/SendSMSClickableButton')
	}




	//Functions

	@Keyword
	def inputLoginNumber(String text) {
		Mobile.setText(loginInputField(), text, GlobalVariable.G_Timeout)
	}

	@Keyword
	def clickSendSMSButton() {
		Mobile.tap(sendSMSClickableButton(), GlobalVariable.G_Timeout)
	}


}
