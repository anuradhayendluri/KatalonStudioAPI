<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Create a discussion thread</description>
   <name>Create a discussion thread</name>
   <tag></tag>
   <elementGuidId>9d2ad3f4-8f9a-4a1e-80ef-00b8ca04215c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;Id\&quot;:null,\&quot;DiscussionId\&quot;:${DiscussionID},\&quot;ParentId\&quot;:\&quot;\&quot;,\&quot;rootId\&quot;:null,\&quot;Description\&quot;:\&quot;\u003cp\u003e${Comment}\u003cbr/\u003e\u003c/p\u003e\&quot;,\&quot;objectReferences\&quot;:[]}&quot;,
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
   <restUrl>${host}/Services/api/social/discuss/reply</restUrl>
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
