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

// construct url from object repository with required variables if any present
def request = ((findTestObject('Community/POST Create Community', 
	[('host') : GlobalVariable.g_URL
		,('CommunityName') : '"' + communityName + '"'
		,('CommunityDesc') : '"' + CommunityDesc + '"'
		,('allowDiscussionBoards') : '"' + allowDiscussionBoards + '"'
		,('allowBlogPosts') : '"' + allowBlogPosts + '"'
		,('allowFileUploads') : '"' + allowFileUploads + '"'
		,('isPrivate') : '"' + isPrivate + '"'
		,('userName') : '"' + userName + '"'
		,('userId') : '"' + userId + '"'
		,('role') : '"' + role + '"'
		,('userStatus') : '"' + userStatus + '"'
		,('communityCode') : '"' + communityCode + '"'
		,('hidden') : '"' + isHidden + '"'
		])) as RequestObject)

request.setHttpHeaderProperties(CustomKeywords.'requestHeaders.Headers.AddHeaders'())

// Update request body of object repository with dynamic data 
//ResponseObject reponse

/*String vsRequestBody = ''

vsRequestBody = request.getHttpBody()

vsRequestBody = vsRequestBody.replace('${CommunityName}', ('"' + communityName) + '"')

vsRequestBody = vsRequestBody.replace('${CommunityDesc}', ('"' + CommunityDesc) + '"')

vsRequestBody = vsRequestBody.replace('${allowDiscussionBoards}', ('"' + allowDiscussionBoards) + '"')

vsRequestBody = vsRequestBody.replace('${allowBlogPosts}', ('"' + allowBlogPosts) + '"')

vsRequestBody = vsRequestBody.replace('${allowFileUploads}', ('"' + allowFileUploads) + '"')

vsRequestBody = vsRequestBody.replace('${isPrivate}', ('"' + isPrivate) + '"')

vsRequestBody = vsRequestBody.replace('${userName}', ('"' + userName) + '"')

vsRequestBody = vsRequestBody.replace('${userId}', ('"' + userId) + '"')

vsRequestBody = vsRequestBody.replace('${role}', ('"' + role) + '"')

vsRequestBody = vsRequestBody.replace('${userStatus}', ('"' + userStatus) + '"')

vsRequestBody = vsRequestBody.replace('${communityCode}', ('"' + communityCode) + '"')

vsRequestBody = vsRequestBody.replace('${hidden}', ('"' + isHidden) + '"')

request.setHttpBody(vsRequestBody)*/

// Sending the request
ResponseObject response = WS.sendRequestAndVerify(request,200)

// Verifying successful status code as 200[first level validation]
WSBuiltInKeywords.verifyResponseStatusCode(response, 200)

// Verifying resonse data with community name[second level validation]
WSBuiltInKeywords.containsString(response, communityName, false)

//WSBuiltInKeywords.verifyElementPropertyValue(response, "name",communityName, FailureHandling.STOP_ON_FAILURE)
// Extracting community id from json response
return response



