import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import javax.persistence.Convert
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

// edit community by passing Diff name
def editResponse = ((findTestObject('Community/Edit Community', [('host') : GlobalVariable.g_URL,('communityID'):communityID])) as RequestObject)
editResponse.setHttpHeaderProperties(CustomKeywords.'requestHeaders.Headers.AddHeaders'(GlobalVariable.g_ModeratorToken))

ResponseObject reponse
String vsRequestBody = '';
vsRequestBody = editResponse.getHttpBody();
vsRequestBody = vsRequestBody.replace('${communityID}',communityID);
vsRequestBody = vsRequestBody.replace('${communityName}',communityName);
editResponse.setHttpBody(vsRequestBody);
response = WS.sendRequest(editResponse)
WSBuiltInKeywords.verifyResponseStatusCode(response, 200)
Boolean boolVal=WSBuiltInKeywords.verifyElementPropertyValue(response, "name", communityName,FailureHandling.STOP_ON_FAILURE)
return boolVal

