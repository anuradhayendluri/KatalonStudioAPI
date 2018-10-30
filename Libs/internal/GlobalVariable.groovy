package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_Timeout
     
    /**
     * <p></p>
     */
    public static Object G_SiteURL
     
    /**
     * <p></p>
     */
    public static Object G_ShortTimeOut
     
    /**
     * <p></p>
     */
    public static Object g_esb
     
    /**
     * <p>Profile default : application version</p>
     */
    public static Object g_version
     
    /**
     * <p></p>
     */
    public static Object g_CommunityID
     
    /**
     * <p></p>
     */
    public static Object g_CommunityName
     
    /**
     * <p></p>
     */
    public static Object g_UserID
     
    /**
     * <p></p>
     */
    public static Object g_mgrID
     
    /**
     * <p></p>
     */
    public static Object g_userName
     
    /**
     * <p></p>
     */
    public static Object g_DBServerName
     
    /**
     * <p></p>
     */
    public static Object g_DBPortNumber
     
    /**
     * <p></p>
     */
    public static Object g_DBName
     
    /**
     * <p></p>
     */
    public static Object g_DBUserName
     
    /**
     * <p></p>
     */
    public static Object g_DBPassword
     
    /**
     * <p></p>
     */
    public static Object g_DBJumboBoxIP
     
    /**
     * <p></p>
     */
    public static Object UserName
     
    /**
     * <p></p>
     */
    public static Object Password
     
    /**
     * <p></p>
     */
    public static Object g_ModeratorToken
     
    /**
     * <p></p>
     */
    public static Object g_NameTemp
     
    /**
     * <p></p>
     */
    public static Object g_PassTemp
     
    /**
     * <p></p>
     */
    public static Object ModeratorUser
     
    /**
     * <p></p>
     */
    public static Object ModeratorPwd
     
    /**
     * <p></p>
     */
    public static Object ContributerUser
     
    /**
     * <p></p>
     */
    public static Object ContributerPsw
     
    /**
     * <p></p>
     */
    public static Object ContributerToken
     
    /**
     * <p></p>
     */
    public static Object ContributerID
     
    /**
     * <p></p>
     */
    public static Object CommunityID
     
    /**
     * <p></p>
     */
    public static Object G_19872BoolValue
     
    /**
     * <p></p>
     */
    public static Object g_lmesbtoken
     
    /**
     * <p></p>
     */
    public static Object g_URL
     
    /**
     * <p></p>
     */
    public static Object g_lmurl
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['G_Timeout' : 10, 'G_SiteURL' : 'http://demoaut.katalon.com', 'G_ShortTimeOut' : 5, 'g_esb' : '', 'g_version' : 'v18.2.1.0', 'g_CommunityID' : '', 'g_CommunityName' : '', 'g_UserID' : '', 'g_mgrID' : '', 'g_userName' : '', 'g_DBServerName' : 'CL-UUD08', 'g_DBPortNumber' : '1433', 'g_DBName' : 'UUD_CL08_SALES_TEST', 'g_DBUserName' : 'AAYENDLURI', 'g_DBPassword' : 'DevLab#123', 'g_DBJumboBoxIP' : '192.168.1.22', 'UserName' : 'admin', 'Password' : 'Think|Demo', 'g_ModeratorToken' : '', 'g_NameTemp' : '', 'g_PassTemp' : '', 'ModeratorUser' : 'Moderator', 'ModeratorPwd' : 'p', 'ContributerUser' : 'Contributer', 'ContributerPsw' : 'p', 'ContributerToken' : '', 'ContributerID' : '', 'CommunityID' : '', 'G_19872BoolValue' : false, 'g_lmesbtoken' : '', 'g_URL' : 'https://cl08sales.sumtotaldevelopment.net', 'g_lmurl' : 'https://cl08sales.sumtotaldevelopment.net'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        G_Timeout = selectedVariables['G_Timeout']
        G_SiteURL = selectedVariables['G_SiteURL']
        G_ShortTimeOut = selectedVariables['G_ShortTimeOut']
        g_esb = selectedVariables['g_esb']
        g_version = selectedVariables['g_version']
        g_CommunityID = selectedVariables['g_CommunityID']
        g_CommunityName = selectedVariables['g_CommunityName']
        g_UserID = selectedVariables['g_UserID']
        g_mgrID = selectedVariables['g_mgrID']
        g_userName = selectedVariables['g_userName']
        g_DBServerName = selectedVariables['g_DBServerName']
        g_DBPortNumber = selectedVariables['g_DBPortNumber']
        g_DBName = selectedVariables['g_DBName']
        g_DBUserName = selectedVariables['g_DBUserName']
        g_DBPassword = selectedVariables['g_DBPassword']
        g_DBJumboBoxIP = selectedVariables['g_DBJumboBoxIP']
        UserName = selectedVariables['UserName']
        Password = selectedVariables['Password']
        g_ModeratorToken = selectedVariables['g_ModeratorToken']
        g_NameTemp = selectedVariables['g_NameTemp']
        g_PassTemp = selectedVariables['g_PassTemp']
        ModeratorUser = selectedVariables['ModeratorUser']
        ModeratorPwd = selectedVariables['ModeratorPwd']
        ContributerUser = selectedVariables['ContributerUser']
        ContributerPsw = selectedVariables['ContributerPsw']
        ContributerToken = selectedVariables['ContributerToken']
        ContributerID = selectedVariables['ContributerID']
        CommunityID = selectedVariables['CommunityID']
        G_19872BoolValue = selectedVariables['G_19872BoolValue']
        g_lmesbtoken = selectedVariables['g_lmesbtoken']
        g_URL = selectedVariables['g_URL']
        g_lmurl = selectedVariables['g_lmurl']
        
    }
}
