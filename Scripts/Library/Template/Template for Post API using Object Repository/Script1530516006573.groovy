
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
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


// construct url from object repository with required variables if any present
def request = ((findTestObject('<object repository test name>',[('variable1') : <variable1 value>,('variable2'):<variable2 value>])) as RequestObject)

// Add header properties
TestObjectProperty esbToken = new TestObjectProperty()
esbToken.setName('sumtauth-header')
esbToken.setValue(<esb token>)
TestObjectProperty contentType = new TestObjectProperty()
contentType.setName('Content-Type')
contentType.setValue('<type of content>')
List<TestObjectProperty> headers = new ArrayList<TestObjectProperty>()
headers.add(esbToken)
headers.add(contentType)
request.setHttpHeaderProperties(headers)

// Update request body of object repository with dynamic data 
ResponseObject reponse
String vsRequestBody = '';
vsRequestBody = request.getHttpBody();
vsRequestBody = vsRequestBody.replace('<varible>',"\""<value>"\"");
request.setHttpBody(vsRequestBody);

// Seding the request
response = WS.sendRequest(request)

// Verifying successful status code as 200[first level validation]
WSBuiltInKeywords.verifyResponseStatusCode(response, 200)

// Verifying resonse data with community name[second level validation]
WSBuiltInKeywords.containsString(response, <value to be checked>, false)




