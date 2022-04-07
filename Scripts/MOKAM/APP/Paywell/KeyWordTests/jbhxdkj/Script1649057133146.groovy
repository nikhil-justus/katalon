import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.DBData as DBData

DBData dbTestData = findTestData('Data Files/db')

println(dbTestData.columnNames)

dbTestData.query = dbTestData.query.replace('shopup_oms.pincodes', 'shopup_cmt.products')

dbTestData.fetchedData = dbTestData.fetchData()

println(dbTestData.allData)