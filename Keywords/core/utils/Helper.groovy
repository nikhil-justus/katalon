package core.utils

import com.kms.katalon.core.annotation.Keyword

import core.constants.FileConstants
import core.constants.FileRouteConstants
import internal.GlobalVariable


public class Helper extends FileUtils{
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

	@Keyword
	def getSlaveFilePath() {
		return GlobalVariable.currentTestCaseId.replace(FileRouteConstants.TEST_CASES_PATH, '/' + FileRouteConstants.TEST_CASE_SLAVE_FILES_PATH) + FileConstants.XLSX_FILE_FORMAT
	}

	@Keyword
	def getSlaveFileData() {
		String path = getSlaveFilePath()
		println path
		HashMap<String, Object> hashMap = new HashMap()
		hashMap.put('testData', readExcelWithEachRowAsList(path, GlobalVariable.testDataSet)[0])
		hashMap.put('testCase', readExcelWithEachRowAsList(path, FileConstants.DEFAULT_EXCEL_SHEET))
		println hashMap
		return hashMap
	}
}

