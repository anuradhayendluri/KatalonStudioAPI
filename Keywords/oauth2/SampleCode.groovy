package oauth2

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import javax.net.ssl.HttpsURLConnection;

import java.net.URL;
import java.util.Base64;
public class SampleCode {
	private static final String clientId = "e3a99198eaa6678";//clientId
	private static final String callBackUrl = "https://www.getpostman.com/oauth2/callback";//The url defined in WSO2
	private static final String authorizeUrl = "https://api.imgur.com/oauth2/authorize";
	String authorizationRedirect = AuthCode()
	@Keyword
	def AuthCode() 
	{
		String value= authorizeUrl + "?response_type=code&client_id=" + clientId + "&redirect_uri=" + callBackUrl + "&scope=openid";
		return authorizeUrl + "?response_type=code&client_id=" + clientId + "&redirect_uri=" + callBackUrl + "&scope=openid";
    }
	@Keyword
	def UserBearerToken(String bearerToken)
	{
		BufferedReader reader = null;
	}
}
