import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def res = WebUI.callTestCase(findTestCase('Library/Community/New Test Case of jira'), [('communityName') : '', ('CommunityDesc') : 'abc desc'
        , ('allowDiscussionBoards') : true, ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'abc'
        , ('isPrivate') : false, ('role') : '1', ('userName') : 'admin', ('userId') : '-1', ('userStatus') : 'Joined', ('isHidden') : false
        , ('disableJoinRequest') : false], FailureHandling.STOP_ON_FAILURE)

WS.verifyResponseStatusCode(res, 200)
WS.callTestCase(findTestCase('Library/Community/New Test Case of jira'), [('communityName') : '', ('CommunityDesc') : ''
        , ('allowDiscussionBoards') : true, ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : ''
        , ('isPrivate') : false, ('role') : '', ('userName') : '', ('userId') : '', ('userStatus') : '', ('isHidden') : false
        , ('disableJoinRequest') : false], FailureHandling.STOP_ON_FAILURE)

