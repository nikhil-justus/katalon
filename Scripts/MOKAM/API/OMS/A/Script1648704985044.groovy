import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//CustomKeywords.'core.utils.Helper.addGlobalVariable'('testDataSet', 'Valid')

HashMap<String, Object> data = CustomKeywords.'core.utils.Helper.getSlaveFileData'()
//get slave file data as hashMap [testData:[phone:1638300361, otp:6666], testCase:[TestCase:kdhiudgyidg, BusinessFlow:ygteuygtuygs, TestCaseId:15432]]

println(data.testData)

println(data.testCase)

println('TestCase A is being called')

WebUI.navigateToUrl('https://docs.katalon.com/katalon-studio/docs/console-mode-execution.html')



