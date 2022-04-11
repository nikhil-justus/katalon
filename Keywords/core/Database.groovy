package core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.db.DatabaseConnection
import com.kms.katalon.core.testdata.DBData


public class Database extends CoreUtils{

	@Keyword
	def getQuery(String query) {
		DBData data = new DBData(mokamDBConnection(), query)
		return dataAsList(data)
	}

	@Keyword
	def fetchDB(DBData data) {
		data.fetchedData = data.fetchData()
	}

	@Keyword
	def mokamDBConnection() {
		String sourceUrl = 'jdbc:mysql://uat-pub.vnksrvc.com'
		String user = 'vnksho'
		String password = 'Vnkshop@65'
		String driverClassName = 'com.mysql.cj.jdbc.Driver'
		return new DatabaseConnection(sourceUrl, user, password, driverClassName)
	}
}