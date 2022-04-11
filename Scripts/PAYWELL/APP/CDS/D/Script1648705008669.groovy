import com.kms.katalon.core.testdata.DBData

import internal.GlobalVariable

println "TestCase D is being called"

println GlobalVariable.testDataSet

ArrayList<HashMap<String, Object>> hash = CustomKeywords.'core.Database.getQuery'('select * from shopup_cmt.products order by id desc limit 100')

println hash

