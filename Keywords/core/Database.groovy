package core

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.db.DatabaseConnection
import com.kms.katalon.core.testdata.DBData


public class Database {
	
	DatabaseConnection connection = new DatabaseConnection()
	
	@Keyword
	def getQuery(String query) {
		
		connection.connectionUrl = ''
		DBData data = findTestData('Data Files/MokamDB')
		data.query = query
		fetchDB(data)
		return data
	}
	
	@Keyword
	def fetchDB(DBData data) {
		data.fetchedData = data.fetchData()
	}
}
