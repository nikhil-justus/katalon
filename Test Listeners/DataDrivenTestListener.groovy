import com.kms.katalon.core.annotation.*
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import core.constants.FileConstants
import core.constants.FileRouteConstants
import internal.GlobalVariable


class DataDrivenTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		CustomKeywords.'core.utils.Helper.addGlobalVariable'('currentTestCaseId', testCaseContext.testCaseId)
		HashMap<String, Object> map = GlobalVariable.masterData[GlobalVariable.currentRowId]

		String testCaseId = "Test Cases/"+map.Module+"/"+map.App+"/"+map.Service+"/"+map.TestCase

		if (testCaseContext.getTestCaseId() == (testCaseId)) {
			if (map.Execution == 'N') {
				println "The test case" + testCaseId + " has been skipped"
				testCaseContext.skipThisTestCase()
			}
			CustomKeywords.'core.utils.Helper.addGlobalVariable'('testDataSet', map.TestData)
		}
		CustomKeywords.'core.utils.Helper.addGlobalVariable'('currentRowId', GlobalVariable.currentRowId + 1)
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		CustomKeywords.'core.utils.Helper.addGlobalVariable'('currentTestSuiteId', testSuiteContext.testSuiteId)
		CustomKeywords.'core.utils.Helper.addGlobalVariable'('currentRowId', 0)

		String excelPath = CustomKeywords.'core.utils.Helper.getMasterFilePath'()
		ArrayList<HashMap<String, Object>> masterData = CustomKeywords.'core.utils.FileUtils.readExcelWithEachRowAsList'(excelPath, FileConstants.DEFAULT_EXCEL_SHEET)
		CustomKeywords.'core.utils.Helper.addGlobalVariable'('masterData', masterData)
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
	}
}