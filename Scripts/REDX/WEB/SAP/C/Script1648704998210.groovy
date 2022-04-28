import com.kms.katalon.core.testdata.DBData

import internal.GlobalVariable

println "TestCase C is being called"

println GlobalVariable.testDataSet

HashMap<String, Object> arr =  CustomKeywords.'core.utils.Helper.getSlaveFileData'()

println arr
