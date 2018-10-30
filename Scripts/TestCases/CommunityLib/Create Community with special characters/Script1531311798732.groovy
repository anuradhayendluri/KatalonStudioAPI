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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

def data = findTestData('TestData')

ResponseObject response = WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') : 'CommunityName', ('CommunityDesc') : 'Com123', ('allowDiscussionBoards') : true, ('allowBlogPosts') : true
        , ('allowFileUploads') : true, ('communityCode') : 'communityCode', ('isPrivate') : true, ('userName') : 'admin'
        , ('userId') : '1', ('role') : '1', ('userStatus') : 'Joined'], FailureHandling.STOP_ON_FAILURE)

//String name=CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).name
WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)
WebUI.comment("Community id is :"+CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).id)
WS.containsString(response, 'CommunityName', false)

WS.verifyElementPropertyValue(response, 'name','CommunityName')