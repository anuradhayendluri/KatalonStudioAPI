import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.http.HttpEntity
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
import org.junit.After

import com.gargoylesoftware.htmlunit.util.StringUtils
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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.media.rtsp.protocol.StatusLine
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
RequestObject reqObj = new RequestObject()
reqObj.setHttpHeaderProperties(CustomKeywords.'requestHeaders.Headers.AddHeaders'())
reqObj.setRestRequestMethod('GET')
reqObj.setRestUrl(GlobalVariable.g_URL+'/Services/api/Common/GetDonutCount?langCode=end-us')
def getResponse = WSBuiltInKeywords.sendRequest(reqObj)
WSBuiltInKeywords.verifyResponseStatusCode(getResponse, 200)
String Res=getResponse.getResponseText()
String[] substring=Res.split(",")
/*for(int i=0;i<substring.count;i++){
	if(substring[i].contains(':')){
		String[] strings=substring[i].split(':')
	if(strings[i].equals("")){
	
		//assert false
    }
	}
}
*/
//response = WSBuiltInKeywords.sendRequest(findTestObject('Display/GetDonutCount'))

