<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Creates a community</description>
   <name>Create Community</name>
   <tag></tag>
   <elementGuidId>79ff7754-4ca0-420b-b8f1-e2f4bebb9dae</elementGuidId>
   <selectorCollection>
      <entry>
         <key>BASIC</key>
      </entry>
      <entry>
         <key>XPATH</key>
      </entry>
   </selectorCollection>
   <selectorMethod>XPATH</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;allowDiscussionBoards\&quot;: true,\&quot;allowBlogPosts\&quot;: true,\&quot;allowFileUploads\&quot;: true,\&quot;name\&quot;: ${CommunityName},\&quot;description\&quot;: \&quot;CommunityDesc\&quot;,\&quot;communityCode\&quot;: \&quot;Mcode\&quot;,\&quot;isPrivate\&quot;: true,\&quot;hidden\&quot;:${hidden},\&quot;members\&quot;: [{\&quot;userName\&quot;: \&quot;admin\&quot;,\&quot;userId\&quot;: 1,\&quot;role\&quot;: 1,\&quot;userStatus\&quot;: \&quot;Joined\&quot;}]}&quot;,
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
