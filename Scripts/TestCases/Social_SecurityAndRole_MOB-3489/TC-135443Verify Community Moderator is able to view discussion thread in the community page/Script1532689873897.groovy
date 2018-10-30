import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import javax.persistence.Convert as Convert
import javax.servlet.http.WebConnection as WebConnection
import org.apache.commons.lang.StringUtils as StringUtils
import org.junit.After as After
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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import jdk.nashorn.internal.parser.JSONParser as JSONParser
import junit.framework.Assert as Assert
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import java.util.Random as Random

def data = findTestData('TestData')

//Object userName = data.getValue("Moderator", 38)
Object userName = ('\'' + data.getValue('Moderator', 38)) + '\''

Object userid = ''

// create community
/*ResponseObject response = WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') : data.getValue(
            'CommunityName', 38), ('CommunityDesc') : data.getValue('CommunityDesc', 38), ('allowDiscussionBoards') : true
        , ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'Code', ('isPrivate') : false, ('userName') : GlobalVariable.g_userName
        , ('userId') : GlobalVariable.g_UserID, ('role') : '1', ('userStatus') : 'Joined', ('isHidden') : false, ('disableJoinRequest') : false], 
    FailureHandling.STOP_ON_FAILURE)

String CommunityID = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).id
*/
// get user id of moderator to add
/*def recordset = CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.executeQuery'('select * from PERSON where FirstName=' + 
    userName)

while (recordset.next()) {
    userid = recordset.getObject('PersonPK')
}*/
CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.CloseConnections'()

// adding moderator to the community
ResponseObject response1 = WebUI.callTestCase(findTestCase('Library/Community/Add a member to community'), [('rating') : '2'
        , ('userID') : GlobalVariable.g_NameTemp, ('userName') : data.getValue('Moderator', 38), ('communityID') : GlobalVariable.CommunityID], 
    FailureHandling.STOP_ON_FAILURE)

WSBuiltInKeywords.verifyResponseStatusCode(response1, 200)

// creating disscussion
ResponseObject responseDis = WebUI.callTestCase(findTestCase('Library/Community/Create discussion under community'), [('CommunityID') : GlobalVariable.CommunityID
        , ('DiscussionName') : data.getValue('DiscussionName', 31), ('DiscussionDesc') : data.getValue('DiscussionDesc', 
            31)], FailureHandling.STOP_ON_FAILURE)

ResponseObject res1 = WebUI.callTestCase(findTestCase('Library/Community/Get Discussions'), [('CommunityID') : GlobalVariable.CommunityID], 
    FailureHandling.STOP_ON_FAILURE)

String DiscussionId = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(res1).discussions

String ResponseText = res1.getResponseText()

String id = '"id"'

int firstIndex = ResponseText.indexOf(id) + id.length()

String name = ResponseText.substring(firstIndex)

int lastIndex = name.indexOf(',')

String finalString = name.substring(0, lastIndex).replace('"', '').replaceAll('[:]', '').trim()

// get discussion id from DB 5b5ebb5f4e6ee50e2c80e1b7
//String DiscussionID = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(responseDis).discussionId
ResponseObject disThread= WebUI.callTestCase(findTestCase('Library/Community/Create a discussion thread'), [('DiscussionID') : finalString, ('Comment') : data.getValue(
            'Comment', 31)], FailureHandling.STOP_ON_FAILURE)
WSBuiltInKeywords.verifyResponseStatusCode(disThread, 200)

ResponseObject getallDis= WebUI.callTestCase(findTestCase('Library/Moderator/Get Discussions'), [('CommunityID') : GlobalVariable.CommunityID], FailureHandling.STOP_ON_FAILURE)
WS.containsString(getallDis, data.getValue('DiscussionName', 31), false, FailureHandling.STOP_ON_FAILURE)
//Boolean res=WebUI.callTestCase(findTestCase('Library/Community/Delete Community'), [('communityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)
