<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST Create Community</name>
   <tag></tag>
   <elementGuidId>eb6517cf-d05f-4389-be87-30f7f6acf161</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;allowDiscussionBoards\&quot;: ${allowDiscussionBoards},\n\&quot;allowBlogPosts\&quot;: ${allowBlogPosts},\n\&quot;allowFileUploads\&quot;: ${allowFileUploads},\n\&quot;name\&quot;: ${CommunityName},\n\&quot;description\&quot;: ${CommunityDesc},\n\&quot;communityCode\&quot;: ${communityCode},\n\&quot;isPrivate\&quot;: ${isPrivate},\n\&quot;members\&quot;: [{\&quot;userName\&quot;: ${userName},\&quot;userId\&quot;: ${userId},\&quot;role\&quot;: ${role},\&quot;userStatus\&quot;: ${userStatus}\n            }\n           ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${host}/Services/api/sumtSocial/communities</restUrl>
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
