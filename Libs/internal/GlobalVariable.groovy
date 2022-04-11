package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object timeOut
     
    /**
     * <p></p>
     */
    public static Object testDataSet
     
    /**
     * <p></p>
     */
    public static Object currentTestCaseId
     
    /**
     * <p></p>
     */
    public static Object currentTestSuiteId
     
    /**
     * <p></p>
     */
    public static Object G_Timeout
     
    /**
     * <p></p>
     */
    public static Object G_NotificationMessage
     
    /**
     * <p></p>
     */
    public static Object G_AndroidApp
     
    /**
     * <p></p>
     */
    public static Object G_ShortTimeOut
     
    /**
     * <p></p>
     */
    public static Object paywellBaseUrl
     
    /**
     * <p></p>
     */
    public static Object PAYWELL_COOKIE
     
    /**
     * <p></p>
     */
    public static Object valueg
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            timeOut = selectedVariables['timeOut']
            testDataSet = selectedVariables['testDataSet']
            currentTestCaseId = selectedVariables['currentTestCaseId']
            currentTestSuiteId = selectedVariables['currentTestSuiteId']
            G_Timeout = selectedVariables['G_Timeout']
            G_NotificationMessage = selectedVariables['G_NotificationMessage']
            G_AndroidApp = selectedVariables['G_AndroidApp']
            G_ShortTimeOut = selectedVariables['G_ShortTimeOut']
            paywellBaseUrl = selectedVariables['paywellBaseUrl']
            PAYWELL_COOKIE = selectedVariables['PAYWELL_COOKIE']
            valueg = selectedVariables['valueg']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
