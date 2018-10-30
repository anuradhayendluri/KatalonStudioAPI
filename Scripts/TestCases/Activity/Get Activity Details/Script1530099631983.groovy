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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.g_URL)

WebUI.setText(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Sign In/input_ctl00ctl00ctl00BodyConte'), 'admin')

WebUI.setText(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Sign In/input_ctl00ctl00ctl00BodyConte_1'), 'p')

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Sign In/input_ctl00ctl00ctl00BodyConte_2'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Home - SumTotal/i_fa fa-admin-custom'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Home - SumTotal/span_Product Administration'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Home - SumTotal/span_Learning'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Learning Activities - Administ/div_page-loader'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Learning Activities - SumTotal/button_New Activity'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Learning Activities - SumTotal/a_Class'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_SumTotal - Learning Activity P/div_Name'))

WebUI.setText(findTestObject('APITestSuite/Activity/Create Activity Details/Page_SumTotal - Learning Activity P/input_txtActivityName'), 
    'ActivityName5')

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_SumTotal - Learning Activity P/input_btn  btn-default sumt-bt'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_SumTotal - Learning Activity P/input_btn  btn-primary'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_SumTotal - Learning Activity P/input_btn  btn-primary_1'))

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_SumTotal - Learning Activity P/input_btn  btn-default sumt-bt_1'))

WebUI.clearText(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Learning Activities - SumTotal/input_ListActivitiesSearchText'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Learning Activities - SumTotal/input_ListActivitiesSearchText'), 
    'ActivityName5')

WebUI.click(findTestObject('APITestSuite/Activity/Create Activity Details/Page_Learning Activities - SumTotal/i_fa fa-search'))

Integer ID = WebUI.getAttribute(findTestObject('//label[text()=\'ActivityName5\']'), 'for')

WebUI.comment('Activity ID is = ' + ID)

WebUI.closeBrowser()

