import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/All')

suiteProperties.put('name', 'All')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("D:\\KatalonAPI\\KatalonAPITesting\\Reports\\All\\20181029_152046\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/All', suiteProperties, [new TestCaseBinding('Test Cases/Common/ContributerEsbToken', 'Test Cases/Common/ContributerEsbToken',  null), new TestCaseBinding('Test Cases/Common/ModeratorEsbToken', 'Test Cases/Common/ModeratorEsbToken',  null), new TestCaseBinding('Test Cases/Common/EsbToken', 'Test Cases/Common/EsbToken',  null), new TestCaseBinding('Test Cases/Library/SetUp/Community', 'Test Cases/Library/SetUp/Community',  null), new TestCaseBinding('Test Cases/TestCases/MD-2552 AdhocCommunity_MOB-3482/TC-19851Check by default all users or groups who are invited to the communitees will be contributor', 'Test Cases/TestCases/MD-2552 AdhocCommunity_MOB-3482/TC-19851Check by default all users or groups who are invited to the communitees will be contributor',  null)])
