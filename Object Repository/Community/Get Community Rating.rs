<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Get the rating of an existing Community</description>
   <name>Get Community Rating</name>
   <tag></tag>
   <elementGuidId>eddf91a7-a60f-4c44-91da-241c664116fa</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${host}/Services/api/sumtSocial/user/${communityID}/rating</restUrl>
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
