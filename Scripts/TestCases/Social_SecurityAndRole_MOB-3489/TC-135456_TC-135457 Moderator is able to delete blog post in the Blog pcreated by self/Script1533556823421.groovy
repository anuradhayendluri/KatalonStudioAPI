import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import javax.persistence.Convert
import javax.servlet.http.WebConnection
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
import junit.framework.Assert
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RequestObject
import java.util.Random;

def data = findTestData('TestData')

ResponseObject res = WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') : data.getValue(
            'CommunityName', 48), ('CommunityDesc') : data.getValue('CommunityDesc', 48), ('allowDiscussionBoards') : true
        , ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'code', ('isPrivate') : false, ('userName') : GlobalVariable.g_userName
        , ('userId') : GlobalVariable.g_UserID, ('role') : '1', ('userStatus') : 'Joined', ('isHidden') : false, ('disableJoinRequest') : false], 
    FailureHandling.STOP_ON_FAILURE)

String CommunityID = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(res).id

ResponseObject res1 = WebUI.callTestCase(findTestCase('Library/Community/Add a member to community'), [('rating') : '2', ('userID') : GlobalVariable.g_NameTemp
        , ('userName') : data.getValue('Moderator', 48), ('communityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)

WS.verifyResponseStatusCode(res1, 200, FailureHandling.STOP_ON_FAILURE)

ResponseObject res2 = WebUI.callTestCase(findTestCase('Library/Moderator/Create a blog under community'), [('blogName') : data.getValue(
            'BlogName', 48), ('blogDesc') : data.getValue('BlogDesc', 48), ('CommunityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)

WS.verifyResponseStatusCode(res2, 200, FailureHandling.STOP_ON_FAILURE)

ResponseObject res3 = WebUI.callTestCase(findTestCase('Library/Moderator/Get Blog Details'), [('CommunityID') : CommunityID], 
    FailureHandling.STOP_ON_FAILURE)

String val=CustomKeywords.'getString.GetString.GetStringFromResponse'('id', res3)

ResponseObject res4= WebUI.callTestCase(findTestCase('Library/Moderator/Delete Blog'), [('CommunityID') : CommunityID, ('BlogID') : val], FailureHandling.STOP_ON_FAILURE)

WS.verifyResponseStatusCode(res4, 200, FailureHandling.STOP_ON_FAILURE)

