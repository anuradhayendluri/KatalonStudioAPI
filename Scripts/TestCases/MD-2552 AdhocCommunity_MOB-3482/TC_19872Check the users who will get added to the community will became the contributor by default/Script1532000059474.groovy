import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.ResultSet as ResultSet
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
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

Object personpk = 'usercontrating3'

String Activity = 'NewActivity__20180719'

String ActivityName = ('\'' + Activity) + '\''

String pk = ('\'' + personpk) + '\''

Object ss = ''

def data = findTestData('TestData')
Boolean retValue=false
ResponseObject response = WebUI.callTestCase(findTestCase('Library/Community/Create Community'), [('communityName') : data.getValue(
            'CommunityName', 18), ('CommunityDesc') : data.getValue('CommunityDesc', 18), ('allowDiscussionBoards') : true
        , ('allowBlogPosts') : true, ('allowFileUploads') : true, ('communityCode') : 'Mcode', ('isPrivate') : true, ('userName') : GlobalVariable.g_userName
        , ('userId') : GlobalVariable.g_UserID, ('role') : '', ('userStatus') : 'Joined'], FailureHandling.STOP_ON_FAILURE)

String CommunityID = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(response).id

def recordset = CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.executeQuery'('select * from PERSON where FirstName=' + 
    pk)

while (recordset.next()) {
    ss = recordset.getObject('PersonPK')

    WebUI.comment('USERID IS ' + ss)
}

CustomKeywords.'dbConnectionPackage.DBConnectionKeyword.CloseConnections'()

def response1 = WebUI.callTestCase(findTestCase('Library/Community/Add a member to community'), [('rating') : '3', ('userID') : ss
        , ('userName') : personpk, ('communityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)
WSBuiltInKeywords.verifyResponseStatusCode(response1, 200)
ResponseObject communityDetailsRes= WebUI.callTestCase(findTestCase('Library/Community/Get Community details by ID'), [('communityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)
WSBuiltInKeywords.verifyResponseStatusCode(communityDetailsRes, 200)
// validation
String CommunityRole = CustomKeywords.'getAttributeValue.GetAttributeValue.GetAttribute'(communityDetailsRes).userMembership

int firstIndex = CommunityRole.indexOf('role') + 5

String name = CommunityRole.substring(firstIndex)

int lastIndex = name.indexOf(',')

String finalString = name.substring(0, lastIndex)

if(finalString=='3')
{
	println ('if conditions has to pass')
	 retValue=true
}
else if(!finalString=='3')
{
	println ('if conditions has to fail')
	assert true==false
}
else
{println ('if conditions shold not execute')
	assert true==false
}
GlobalVariable.G_19872BoolValue=retValue
//WebUI.callTestCase(findTestCase('Library/Community/Delete Community'), [('communityID') : CommunityID], FailureHandling.STOP_ON_FAILURE)

return retValue

