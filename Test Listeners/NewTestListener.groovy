import com.kms.katalon.core.annotation.*
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import constants.FileConstants
import constants.FileRouteConstants
import internal.GlobalVariable


class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		CustomKeywords.'core.Helper.addGlobalVariable'('currentTestCaseId', testCaseContext.testCaseId)
		HashMap<String, Object> map = GlobalVariable.masterData[GlobalVariable.currentRowId]
		
		String testCaseId = "Test Cases/"+map.Module+"/"+map.App+"/"+map.Service+"/"+map.TestCase

		if (testCaseContext.getTestCaseId() == (testCaseId)) {
			if (map.Execution == 'N') {
				println "The test case" + testCaseId + "has been skipped"
				testCaseContext.skipThisTestCase()
			}
			CustomKeywords.'core.Helper.addGlobalVariable'('testDataSet', map.TestData)
		}
		CustomKeywords.'core.Helper.addGlobalVariable'('currentRowId', GlobalVariable.currentRowId + 1)	
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		CustomKeywords.'core.Helper.addGlobalVariable'('currentTestSuiteId', testSuiteContext.testSuiteId)
		CustomKeywords.'core.Helper.addGlobalVariable'('currentRowId', 0)
		
		String excelPath = GlobalVariable.currentTestSuiteId.replace(FileRouteConstants.TEST_SUITES_PATH, '/' + FileRouteConstants.TEST_SUITE_MASTER_FILES_PATH) + FileConstants.XLSX_FILE_FORMAT
		ArrayList<HashMap<String, Object>> masterData = CustomKeywords.'core.FileUtils.readExcelWithEachRowAsList'(excelPath, FileConstants.DEFAULT_EXCEL_SHEET)
		CustomKeywords.'core.Helper.addGlobalVariable'('masterData', masterData)
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
	}
}