<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Gets items to display in the tasks page/ timeline.</description>
   <name>GetTimeLineData</name>
   <tag></tag>
   <elementGuidId>4e9da9e9-2435-4703-8fc1-bcdd25bf3e5c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>sumtauth-header</name>
      <type>Main</type>
      <value>GlobalVariable.g_esb</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https:///cl08sales.sumtotaldevelopment.net/Services/api/Common/GetTimeLineData?forceRefresh=true</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
