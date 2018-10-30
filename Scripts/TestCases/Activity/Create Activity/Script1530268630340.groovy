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
import java.lang.Runtime as Runtime

Random rand = new Random()

int n = rand.nextInt(9999) + 1

String Activity = 'Activity' + n

String ActivityName = ('\'' + Activity) + '\''

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.g_URL)

WebUI.setText(findTestObject('Create Activity/Page_Sign In/input_ctl00ctl00ctl00BodyConte'), GlobalVariable.UserName)

WebUI.setText(findTestObject('Create Activity/Page_Sign In/input_ctl00ctl00ctl00BodyConte_1'), GlobalVariable.Password)

WebUI.click(findTestObject('Create Activity/Page_Sign In/input_ctl00ctl00ctl00BodyConte_2'))

WebUI.click(findTestObject('Create Activity/Page_Home - SumTotal/a_admin_header'))

WebUI.click(findTestObject('Create Activity/Page_Home - SumTotal/span_Product Administration'))

WebUI.click(findTestObject('Create Activity/Page_Home - SumTotal/span_Learning'))

WebUI.click(findTestObject('Create Activity/Page_Learning Activities - Administ/section_rootViewContainer'))

WebUI.waitForPageLoad(30)

WebUI.waitForAngularLoad(30)

WebUI.waitForElementVisible(findTestObject('Create Activity/Page_Learning Activities - SumTotal/button_New Activity'), 10)

WebUI.click(findTestObject('Create Activity/Page_Learning Activities - SumTotal/button_New Activity'))

WebUI.click(findTestObject('Create Activity/Page_Learning Activities - SumTotal/a_Class'))

WebUI.clearText(findTestObject('Create Activity/Page_SumTotal - Learning Activity P/input_txtActivityName'))

WebUI.setText(findTestObject('Create Activity/Page_SumTotal - Learning Activity P/input_txtActivityName'), Activity)

WebUI.click(findTestObject('Create Activity/Page_SumTotal - Learning Activity P/input_btn  btn-default sumt-bt'))

WebUI.click(findTestObject('Create Activity/Page_SumTotal - Learning Activity P/input_btn  btn-primary'))

WebUI.click(findTestObject('Create Activity/Page_SumTotal - Learning Activity P/input_btn  btn-primary_1'))

WebUI.click(findTestObject('Create Activity/Page_SumTotal - Learning Activity P/i_fa fa-user'))

WebUI.closeBrowser()

try {
    CustomKeywords.'vpnConnectionPackage.VpnConnect.KillProcess'('vpncli.exe')
    CustomKeywords.'vpnConnectionPackage.VpnConnect.KillProcess'('vpnui.exe')
    CustomKeywords.'vpnConnectionPackage.VpnConnect.ConnectVPN'()
    CustomKeywords.'com.database.mysql.connectDB'('RC-UUD01', '1433', 'UUD_RC01_SALES_TEST', 'readonly', 'titan#12') 
    def recordset = CustomKeywords.'com.database.mysql.executeQuery'('select * from TBL_TMX_ACTIVITY where ActivityName=' + 
        ActivityName)
    while (recordset.next()) {
        'get name value of record'
        Object activityID = recordset.getObject('Activity_PK')

        WebUI.comment('Acitivity ID is ' + activityID)
    }
}
catch (Exception e) {
    WebUI.comment('ERROR: The title of the Sales Detail Page is:=' + e)

    throw new AssertionError('ERROR: The Sales Detail Page did not load correctly', e)
} 
finally { 
    CustomKeywords.'vpnConnectionPackage.VpnConnect.DisconnectVPN'()
}

