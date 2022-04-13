import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

ArrayList<HashMap<String, Object>> arr =  CustomKeywords.'core.utils.Helper.getSlaveFileData'()

println arr

println('TestCase A is being called')

WebUI.navigateToUrl("https://docs.katalon.com/katalon-studio/docs/console-mode-execution.html")




