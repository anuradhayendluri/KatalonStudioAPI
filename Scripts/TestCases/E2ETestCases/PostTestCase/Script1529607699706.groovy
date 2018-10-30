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

// get all the community
/*int beforeCommunityCreationCount=WebUI.callTestCase(findTestCase('TestCases/Community/Get All Community'),[:])
WebUI.comment('community Count is '+beforeCommunityCreationCount)*/

// create community
String communityId=WebUI.callTestCase(findTestCase('TestCases/Community/CreateCommunityold'), null)
WebUI.comment('Community ID '+communityId)
GlobalVariable.g_CommunityID=communityId

// get community by ID
boolean communityDetails=WebUI.callTestCase(findTestCase('TestCases/Community/Get Community By ID'), null)

// get owner count
int ownerCount=WebUI.callTestCase(findTestCase('TestCases/Community/Get Owner Count'), null)
	
	// get community Memebers
WebUI.callTestCase(findTestCase('TestCases/Community/Get Community Members'), [:])	
	
// get community rating
WebUI.callTestCase(findTestCase('TestCases/Community/Get Community Rating'), null)

// delete community
boolean deleteCommunity=WebUI.callTestCase(findTestCase('TestCases/Community/Delete Community'), null)
	
	// check for the deleted community
	int afterCommunityCreationCount=WebUI.callTestCase(findTestCase('TestCases/Community/Get All Community'),[:])
	WebUI.comment('community Count is '+afterCommunityCreationCount)