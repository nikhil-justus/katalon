package core

import com.kms.katalon.core.annotation.Keyword


public class Helper {
	@Keyword
	void addGlobalVariable(String name, def value) {
		GroovyShell shell = new GroovyShell()
		MetaClass mc = shell.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}
}
