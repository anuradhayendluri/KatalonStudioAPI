import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.nio.charset.Charset as Charset
import internal.GlobalVariable as GlobalVariable
import com.google.gson.JsonObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64 as Base64
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import java.io.UnsupportedEncodingException as UnsupportedEncodingException
import javax.xml.bind.DatatypeConverter as DatatypeConverter
import org.apache.commons.lang.StringUtils as StringUtils
import groovy.json.JsonParser
import groovy.json.JsonSlurper
import com.google.gson.Gson
CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.CloseConnections'()
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.g_URL)

WebUI.setText(findTestObject('EsbToken/Page_Sign In/input_ctl00ctl00ctl00BodyConte'), GlobalVariable.ContributerUser)

WebUI.setText(findTestObject('EsbToken/Page_Sign In/input_ctl00ctl00ctl00BodyConte_1'), GlobalVariable.ContributerPsw)

WebUI.click(findTestObject('EsbToken/Page_Sign In/input_ctl00ctl00ctl00BodyConte_2'))

//WebUI.click(findTestObject('EsbToken/Page_Home - SumTotal/i_fa fa-user'))


WebUI.waitForPageLoad(30)

WebUI.waitForElementPresent(findTestObject('EsbToken/Page_Home - SumTotal/i_fa fa-user'), 10)

String s = ((WebUI.executeJavaScript('return document.documentElement.innerHTML;', null)) as String)



WebUI.comment(s)

WebUI.comment('printing string anuadha')

int startString = (s.lastIndexOf('esbApiToken') + 'esbApiToken'.length()) + 1

String substring = s.substring(startString)

WebUI.comment('substring' + substring)

int lenght = substring.indexOf(',')

WebUI.comment('length' + lenght)

String esb = substring.substring(0, lenght)

WebUI.comment('esb' + esb)

String esbapitoken = esb.subSequence(2, esb.length() - 1)

WebUI.comment('esb api token ' + esbapitoken)

GlobalVariable.ContributerToken = esbapitoken

String decoded = new String(DatatypeConverter.parseBase64Binary(esbapitoken))
decoded=decoded.substring(decoded.indexOf("}{")+1)
WebUI.comment('ESB DECRYPTED ' + decoded)

def jsonSlurper = new JsonSlurper()
		def object = jsonSlurper.parseText(decoded.toString())
String userId=object.personid
String userName=object.sub

GlobalVariable.ContributerID = userId
GlobalVariable.ContributerUser=userName

WebUI.click(findTestObject('Login/Page_Home - SumTotal/fa fa-user'))

WebUI.closeBrowser()

/*String mgrID = WebUI.callTestCase(findTestCase('TestCases/UserDetails/GetUserDetails'), null)

WebUI.comment('mgrID is = ' + GlobalVariable.g_mgrID)*/

