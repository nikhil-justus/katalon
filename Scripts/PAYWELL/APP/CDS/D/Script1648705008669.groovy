import com.kms.katalon.core.testdata.DBData

import internal.GlobalVariable

println "TestCase D is being called"


println GlobalVariable.testDataSet

HashMap<String, Object> arr =  CustomKeywords.'core.utils.Helper.getSlaveFileData'()

println arr

ArrayList<HashMap<String, Object>> hash = CustomKeywords.'core.database.Database.getQuery'('select id from shopup_cmt.products order by id desc limit 100')

println hash

