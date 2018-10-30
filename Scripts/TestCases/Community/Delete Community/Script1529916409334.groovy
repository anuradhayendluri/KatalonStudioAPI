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
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import junit.framework.Assert as Assert
import com.kms.katalon.core.testobject.RequestObject as RequestObject

/*Random rand = new Random();

int  n = rand.nextInt(9999) + 1;
String communityName="Community"+n;*/
// create community
ArrayList<String> communityDatalist = WebUI.callTestCase(findTestCase('TestCases/Community/CreateCommunityold'), null)

WebUI.comment('Community ID ' + (communityDatalist[0]))

// get community by id
//boolean communityDetails = WebUI.callTestCase(findTestCase('TestCases/Community/Get Community By ID'), null)
// delete community
def deleteCommunity = ((findTestObject('Community/Delete Community', [('host') : GlobalVariable.g_URL, ('communityID') : communityDatalist[
            0]])) as RequestObject)

deleteCommunity.setHttpHeaderProperties(CustomKeywords.'requestHeaders.Headers.AddHeaders'())

def deleteCommunityRes = WSBuiltInKeywords.sendRequest(deleteCommunity)

WSBuiltInKeywords.verifyResponseStatusCode(deleteCommunityRes, 200)

WebUI.delay(10)

// check for the community which should not exist in response
RequestObject reqObj = new RequestObject()

reqObj.setHttpHeaderProperties(CustomKeywords.'requestHeaders.Headers.AddHeaders'())

reqObj.setRestRequestMethod('GET')

reqObj.setRestUrl((GlobalVariable.g_URL + '/Services/api/sumtSocial/communities/') + (communityDatalist[0]))

def getResponse = WSBuiltInKeywords.sendRequest(reqObj)

WSBuiltInKeywords.verifyResponseStatusCode(getResponse, 200)

WebUI.comment('delete response body ' + getResponse.getResponseText())

Boolean response = getResponse.getResponseText().equalsIgnoreCase('null')

assert response == true

