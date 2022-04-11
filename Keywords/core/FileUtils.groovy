package core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.reader.ExcelFactory


public class FileUtils extends CoreUtils{
	/**
	 * Read excel file
	 * @param path Excel File Path
	 * @param sheetName excel sheet for usage
	 * @return HashMap [String,List<Object>] with each row as List
	 */
	@Keyword
	def readExcelWithEachRowAsList(String path, String sheetName) {
		String filePath = RunConfiguration.getProjectDir() + path
		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(filePath, sheetName, true)
		return dataAsList(excelData)
	}
}
