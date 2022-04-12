import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import constants.FileConstants
import internal.GlobalVariable


class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		CustomKeywords.'core.Helper.addGlobalVariable'('currentTestCaseId', testCaseContext.testCaseId)
		String currentTestSuiteId = GlobalVariable.currentTestSuiteId
		currentTestSuiteId = currentTestSuiteId.replace(FileConstants.TEST_SUITES_PATH, '/Test Files/testSuiteMasterFiles/') + '.xlsx'
		println currentTestSuiteId
		ArrayList<HashMap<String, Object>> arr = CustomKeywords.'core.FileUtils.readExcelWithEachRowAsList'(currentTestSuiteId, "Sheet1")
		for (map in arr) {
			String testCaseId = "Test Cases/"+map.Module+"/"+map.App+"/"+map.Service+"/"+map.TestCase
			if (testCaseContext.getTestCaseId() == (testCaseId)) {
				if (map.Execution == 'N') {
					println "The test case has been skipped"
					testCaseContext.skipThisTestCase()
				}
				CustomKeywords.'core.Helper.addGlobalVariable'('testDataSet', map.TestData)
			}
		}
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
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
	}
}