package core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.DBData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.testobject.ResponseObject

import groovy.json.JsonSlurper

public class CoreFileUtils {
	/**
	 * Read excel file
	 * @param path Excel File Path
	 * @param sheetName excel sheet for usage
	 * @return Hashmap [String,List<Object>] with each row as List
	 */
	@Keyword
	def readExcelWithEachRowAsList(String path, String sheetName) {
		String filePath = RunConfiguration.getProjectDir() + path
		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(filePath, sheetName, true)
		return dataAsList(excelData)
	}
	
	@Keyword
	def readDBDataWithEachRowAsList(DBData dbData) {
		return dataAsList(dbData)
	}

	/**
	 * Convert All Data File Components as list
	 * @param file data
	 * @param columnNumbers
	 * @param headers
	 * @return Hashmap [String,List<Object>] with each row as List
	 */
	def dataAsList(TestData fileData) {		
		List<List<Object>>data = fileData.allData
		int columnNumbers = fileData.columnNumbers
		String[] headers = fileData.columnNames
		
		ArrayList<HashMap<String, Object>> arr = new ArrayList()
		for(line in data) {
			HashMap<String, Object> map = new HashMap();
			for (int i=0; i<columnNumbers; i++) {
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
				map.put(headers[i], parsedValue)
			}
			arr.add(map)
		}
		return arr
	}

	/**
	 * Parse json file and return as a json object for validation 
	 * @param json file path
	 * @return json object
	 */
	@Keyword
	def Object getStaticJsonData(String fileName) {
		def jsonSlurper = new JsonSlurper()
		Object data = jsonSlurper.parse(new File(fileName))
		return data;
	}

	/**
	 * Parse the json response and return as a map of the response
	 * @param ResponseObject from API call
	 * @return HashMap
	 */
	@Keyword
	def HashMap<String,Object> parseResponseToMap(ResponseObject response) {
		def jsonSlurper = new JsonSlurper()
		HashMap<String,Object> map = new HashMap<String,Object>()
		Object data = jsonSlurper.parseText(response.getResponseBodyContent());
		map.put("responseBody", data);
		return map;
	}
}
