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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType

def ScopeToProject=((findTestObject('Object Repository/aouth2tests/New Request')) as RequestObject)
ArrayList<TestObjectProperty> HTTPHeader = new ArrayList<TestObjectProperty>()
TestObjectProperty bearerToken = new TestObjectProperty()
bearerToken.setName('Authorization')
bearerToken.setValue('Bearer d8ddd6ddc23bd2a17637b07951763a9849542854')
HTTPHeader.add(bearerToken)
ScopeToProject.setHttpHeaderProperties(HTTPHeader)
response = WS.sendRequest(ScopeToProject)
WS.verifyResponseStatusCode(response, 200)
WS.comment(response.getResponseText())