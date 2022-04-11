import com.kms.katalon.core.testdata.DBData

import internal.GlobalVariable

println "TestCase D is being called"

println GlobalVariable.testDataSet

DBData data = CustomKeywords.'core.Database.getQuery'('select * from shopup_cmt.products order by id desc limit 100')

println data.allData

