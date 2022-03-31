import org.assertj.core.api.Assertions

import com.kms.katalon.core.testobject.ResponseObject

import internal.GlobalVariable as GlobalVariable

//Preconditions
CustomKeywords.'api.paywell.Login.loginInit'(phone)

//API Execution
ResponseObject response = CustomKeywords.'api.paywell.Login.login'(phone, otp)

//Required Loggers
println(GlobalVariable.PAYWELL_COOKIE)

//Assert Response
Assertions.assertThat(response.statusCode).isEqualTo(200)

//Assert JSON Response after parsing
