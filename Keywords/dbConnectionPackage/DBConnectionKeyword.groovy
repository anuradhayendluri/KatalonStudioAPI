package dbConnectionPackage

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.PreparedStatement
import com.kms.katalon.core.annotation.Keyword
import java.sql.Statement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.net.InetAddress
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.io.File;
import java.io.IOException;
public class DBConnectionKeyword {

	/**
	 * Send request and verify status code
	 * @param request request object, must be an instance of RequestObject
	 * @param expectedStatusCode
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
	private static Connection connection = null;
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";
	String path="C:\\Program Files (x86)\\Cisco\\Cisco AnyConnect Secure Mobility Client";
	String dir="cd /d C:"
	//String path="D:\\KatalonAPI\\KatalonAPITesting\\Data Files";
	/**
	 * Ping host to check  VPN connection is established or not
	 * @param no parameters
	 * @return nothing
	 */
	@Keyword
	def boolean pingHost() {
		boolean reachable = InetAddress.getByName("192.168.1.22").isReachable(10)
		if(reachable) {
			WebUI.comment("The VPN connection is successfull")
		}
		return reachable
	}
	/**
	 * Dis Connect VPN connection
	 * @param no parameters required
	 * nothing
	 */
	@Keyword
	def DisconnectVPN() {

		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "VPNDisconnect.bat");
		File dir = new File(path);
		pb.directory(dir);
		Process p = pb.start();
	}
	/**
	 * Connect VPN 
	 * @param no parameters
	 * @return nothing
	 */
	@Keyword
	def ConnectVPN() {
		/*File file=new File(path)
		 //String  s="cmd /c start cmd.exe /K "+path+"\nvpncli.exe -s connect 14.142.215.70"+"\ny"+"\nHyd-DevLab"+"\nnabodempudi"+"\nSumT#235@"
		 String  s="cmd /c start cmd.exe /K "+path
		 println (s)
		 Process proc=Runtime.getRuntime().exec(s)*/
		/*Scanner kb=new Scanner(proc.getInputStream())
		 println (kb)*/
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "VPNConnect.bat");
		File dir = new File(path);
		pb.directory(dir);
		Process p = pb.start();
		WebUI.delay(15)
		pingHost()
	}

	@Keyword
	def boolean isProcessRunning(String processName){
		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			if (line.contains(processName)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Kill the specified process
	 * @param ProcessName , name of the process
	 * @return nothing
	 */
	@Keyword
	def KillProcess(String ProcessName){
		if(isProcessRunning(ProcessName)){
			Runtime.getRuntime().exec(KILL + ProcessName);
		}
	}
	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */
	@Keyword
	def connectDB(){
		String con = "jdbc:sqlserver://"+GlobalVariable.g_DBServerName+":"+GlobalVariable.g_DBPortNumber+";databaseName="+GlobalVariable.g_DBName
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection=DriverManager.getConnection(con,'readonly','titan#12')
		return connection
	}
	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */
	@Keyword
	def ResultSet executeQuery(String queryString) {
		try {
			KillProcess('vpncli.exe')
			KillProcess('vpnui.exe')
			ConnectVPN()
			connectDB()
			Statement stm = connection.createStatement()
			ResultSet rs = stm.executeQuery(queryString)

			return rs
		}
		catch(Exception ex)
		{throw ex;}
		finally
		{
			//CloseConnections()
		}
	}
	/**
	 * Close DB connection
	 * @param no parameters
	 * @return nothing
	 */
	@Keyword
	def closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */
	@Keyword
	def execute(String queryString) {
		try{
			KillProcess('vpncli.exe')
			KillProcess('vpnui.exe')
			ConnectVPN()
			connectDB()

			Statement stm = connection.createStatement()
			boolean result = stm.execute(queryString)
			return result
		}
		catch(Exception ex)
		{
			CloseConnections()
			throw ex;

		}
		finally
		{

		}
	}
	/**
	 * Disconnecting DB,VPN connections once query returns set
	 * @param no parameters
	 * @return nothing
	 */
	@Keyword
	def CloseConnections() {
		closeDatabaseConnection()
		DisconnectVPN()
		WebUI.delay(10)
	}
	@Keyword
	def Object getObject(ResultSet set,String query,String ColumnName) {
		Object value=''
		try{
			def recordset =executeQuery(query)
			while (recordset.next()) {
				value = recordset.getObject(ColumnName)
			}
			return value
		}
		catch(Exception ex)
		{throw ex;}
		finally
		{
			//CloseConnections()
		}
	}

}