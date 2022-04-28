package api.paywell

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable



public class Login {

	@Keyword
	def loginInit(String phone) {
		println WS.sendRequest(findTestObject('API/PAYWELL/CDS/Login/LoginInit', [('phone') : phone]))
	}

	@Keyword
	def login(String phone, String otp) {
		ResponseObject response =  WS.sendRequest(findTestObject('API/PAYWELL/CDS/Login/Login', [('phone') : phone, ('otp') : otp]))
		println response
		String cookie = response.headerFields.get("Set-Cookie").get(0).split(";")[0]
		GlobalVariable.PAYWELL_COOKIE = cookie
	}
}
