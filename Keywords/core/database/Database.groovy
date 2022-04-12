package core.database

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.db.DatabaseConnection
import com.kms.katalon.core.testdata.DBData

import core.constants.DBConstants
import core.utils.CoreUtils


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
		return new DatabaseConnection(DBConstants.MOKAM_STAGING_SOURCE_URL, DBConstants.MOKAM_STAGING_USER, DBConstants.MOKAM_STAGING_PASSWORD, DBConstants.DRIVER_CLASS_NAME)
	}
}