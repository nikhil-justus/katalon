package core.utils

import com.kms.katalon.core.annotation.Keyword

import core.constants.FileConstants
import core.constants.FileRouteConstants
import internal.GlobalVariable


public class Helper {
	@Keyword
	void addGlobalVariable(String name, def value) {
		GroovyShell shell = new GroovyShell()
		MetaClass mc = shell.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}
	
	@Keyword
	def getMasterFilePath() {
		return GlobalVariable.currentTestSuiteId.replace(FileRouteConstants.TEST_SUITES_PATH, '/' + FileRouteConstants.TEST_SUITE_MASTER_FILES_PATH) + FileConstants.XLSX_FILE_FORMAT
	}
}
