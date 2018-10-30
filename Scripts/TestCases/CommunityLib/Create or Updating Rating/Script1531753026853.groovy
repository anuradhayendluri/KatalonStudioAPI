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

ResponseObject response=WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') : 'blogComm', ('CommunityDesc') : 'DescblogComm', ('allowDiscussionBoards') : true
        , ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'blogCode', ('isPrivate') : true, ('userName') : ''
        , ('userId') : GlobalVariable.g_UserID, ('role') : '1', ('userStatus') : 'Joined'], FailureHandling.STOP_ON_FAILURE)
String CommunityId=CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).id
def response1=WebUI.callTestCase(findTestCase('Library/Community/Create or Update Rating'), [('rating') : 4, ('userID') : GlobalVariable.g_UserID
        , ('communityID') : CommunityId], FailureHandling.STOP_ON_FAILURE)
WSBuiltInKeywords.verifyResponseStatusCode(response1, 200)
