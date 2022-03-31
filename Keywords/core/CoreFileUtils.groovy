package core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.testobject.ResponseObject

import groovy.json.JsonSlurper

public class CoreFileUtils {


	/**
	 * Read excel file
	 * @param path Excel File Path
	 * @param sheetName excel sheet for usage
	 * @return Hashmap [String,List<Object>] with header as key and rows as list
	 */
	@Keyword
	def readExcel(String path, String sheetName) {
		String filePath = RunConfiguration.getProjectDir() + path
		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(filePath, sheetName, true)

		List<List<Object>>data = excelData.getAllData()
		int columnNumbers = excelData.getColumnNumbers()
		String[] headers = excelData.getColumnNames()

		HashMap<String,List<Object>> map = new HashMap<String,List<Object>>()
		for (int i=0; i<columnNumbers; i++) {
			ArrayList<Object> list = new ArrayList()
			for(line in data) {
				String value = line[i]
				Object parsedValue;
				if (value == null) {
					continue
				}
				else if (value.isInteger()) {
					parsedValue = Integer.parseInt(value)
				}
				else if (value.isDouble()) {
					parsedValue = Double.parseDouble(value)
				}
				else {
					parsedValue = value
				}
				list.add(parsedValue)
			}
			map.put(headers[i], list)
		}
		return map
	}

	
	@Keyword
	def readExcelWithEachRowAsList(String path, String sheetName) {
		String filePath = RunConfiguration.getProjectDir() + path
		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(filePath, sheetName, true)

		List<List<Object>>data = excelData.getAllData()
		println data
		int rowNumbers = excelData.getRowNumbers()
		println rowNumbers
		String[] headers = excelData.getColumnNames()
		println headers
		
//		ArrayList<HashMap<String, Object>> arr = new ArrayList()
//		for(line in data) {
//			HashMap<String, Object> map = new HashMap()
//			
//		}
		
	}
	
	@Keyword
	def Object getStaticJsonData(String fileName) {
		def jsonSlurper = new JsonSlurper()
		Object data = jsonSlurper.parse(new File(fileName))
		return data;
	}

	@Keyword
	def HashMap<String,Object> parseResponseToMap(ResponseObject response) {
		def jsonSlurper = new JsonSlurper()
		HashMap<String,Object> map = new HashMap<String,Object>()
		Object data = jsonSlurper.parseText(response.getResponseBodyContent());
		map.put("responseBody", data);
		return map;
	}
}
