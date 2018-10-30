import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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
def data = findTestData('TestData')
Object personpk= data.getValue("Contributer", 23)
String pk = ('\'' + personpk) + '\''
Object userid=''
/*ResponseObject response= WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') :  data.getValue('CommunityName', 23), ('CommunityDesc') : data.getValue('CommunityDesc', 23), ('allowDiscussionBoards') : true
	, ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'code', ('isPrivate') : false, ('userName') : GlobalVariable.g_userName
	, ('userId') : GlobalVariable.g_UserID, ('role') : '1', ('userStatus') : 'Joined', ('isHidden') : false, ('disableJoinRequest') : false], FailureHandling.STOP_ON_FAILURE)

WebUI.comment(response.getResponseText())
String CommunityId = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).id*/
def recordset=CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.executeQuery'('select * from PERSON where FirstName=' + pk)
while(recordset.next()) {
	userid = recordset.getObject("PersonPK")
}
CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.CloseConnections'()
ResponseObject response1 = WebUI.callTestCase(findTestCase('Library/Contributer/Create or Update Rating'), [('rating') : 5, ('userID') : userid
        , ('communityID') : GlobalVariable.CommunityID], FailureHandling.STOP_ON_FAILURE)
//WS.delay(5)
WSBuiltInKeywords.verifyResponseStatusCode(response1, 200)
/*ResponseObject communityDetailsRes= WebUI.callTestCase(findTestCase('Library/Contributer/Get Community details by ID'), [('communityID') : GlobalVariable.CommunityID], FailureHandling.STOP_ON_FAILURE)
WSBuiltInKeywords.verifyResponseStatusCode(communityDetailsRes, 200)*/

String s1=CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response1).rating
//float s=float.parseFloat(s1) 
//float getRating = float.valueOf(s) //CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(communityDetailsRes).avgRating
//int rating = Math.round(s)
if (s1 == "5.0") {
	println('if conditions has to pass')
	assert true==true
} else if (!(s1) == "5.0") {
	println('if conditions has to fail')
	assert true==false
} else {
	println('if conditions shold not execute')
	assert true==false
}
//Boolean res=WebUI.callTestCase(findTestCase('Library/Community/Delete Community'), [('communityID') : CommunityId], FailureHandling.STOP_ON_FAILURE)


