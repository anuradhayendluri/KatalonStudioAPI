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

/*// create a community
ResponseObject response = WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') : data.getValue(
            'CommunityName', 45), ('CommunityDesc') : data.getValue('CommunityDesc', 45), ('allowDiscussionBoards') : true
        , ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'Code', ('isPrivate') : false, ('userName') : GlobalVariable.g_userName
        , ('userId') : GlobalVariable.g_UserID, ('role') : '1', ('userStatus') : 'Joined', ('isHidden') : false, ('disableJoinRequest') : false], 
    FailureHandling.STOP_ON_FAILURE)

String CommunityID = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).id
*/
// add a moderator memeber
WebUI.callTestCase(findTestCase('Library/Community/Add a member to community'), [('rating') : '2', ('userID') : GlobalVariable.g_NameTemp
        , ('userName') : data.getValue('Moderator', 45), ('communityID') : GlobalVariable.CommunityID], FailureHandling.STOP_ON_FAILURE)

// provide rating
ResponseObject response1 = WebUI.callTestCase(findTestCase('Library/Moderator/Create or Update Rating'), [('rating') : '5'
        , ('userID') : GlobalVariable.g_NameTemp, ('communityID') : GlobalVariable.CommunityID], FailureHandling.STOP_ON_FAILURE)

WSBuiltInKeywords.verifyResponseStatusCode(response1, 200)

 ResponseObject com= WebUI.callTestCase(findTestCase('Library/Moderator/Get Community details by ID'), [('communityID') : GlobalVariable.CommunityID], FailureHandling.STOP_ON_FAILURE)


float getRating = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(com).avgRating
int rating = Math.round(getRating)
if (rating == '5') {
    println('if conditions has to pass')
} else if (!(rating) == '5') {
    println('if conditions has to fail')
} else {
    println('if conditions shold not execute')
}
//Boolean res=WebUI.callTestCase(findTestCase('Library/Community/Delete Community'), [('communityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)


