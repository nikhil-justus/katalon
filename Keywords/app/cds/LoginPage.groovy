package app.cds

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject

import core.AppBaseClass
import internal.GlobalVariable



public class LoginPage extends AppBaseClass{


	//Elements

	@Keyword
	def TestObject loginInputField() {
		return xpathSetter('App/CDSApp/LoginScreenPageObjects/loginField')
	}


	@Keyword
	def TestObject sendSMSClickableButton() {
		return xpathSetter('/App/CDSApp/LoginScreenPageObjects/Button')
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
