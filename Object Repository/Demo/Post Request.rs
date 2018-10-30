<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Post Request</name>
   <tag></tag>
   <elementGuidId>c81c1698-bc5b-4dfd-933d-cc1f12c5e945</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;allowDiscussionBoards\&quot;: true,\&quot;allowBlogPosts\&quot;: true,\&quot;allowFileUploads\&quot;: true,\&quot;name\&quot;: \&quot;DemoTest909\&quot;,\&quot;description\&quot;: \&quot;Community Desc\&quot;,\&quot;communityCode\&quot;: \&quot;Mcode\&quot;,\&quot;isPrivate\&quot;: true,\&quot;members\&quot;: [{\&quot;userName\&quot;: \&quot;admin\&quot;,\&quot;userId\&quot;: 1,\&quot;role\&quot;: 1,\&quot;userStatus\&quot;: \&quot;Joined\&quot;}]}&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>text/plain</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://cl08sales.sumtotaldevelopment.net/Services/api/sumtSocial/communities</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
