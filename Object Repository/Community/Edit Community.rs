<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Edit the community</description>
   <name>Edit Community</name>
   <tag></tag>
   <elementGuidId>c64a5592-e738-4afb-91db-846c07e63a5d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;$type\&quot;: \&quot;SumTotal.Services.DataContracts.Core.Social.CommunityDTO, SumTotal.Services.DataContracts\&quot;,\n    \&quot;id\&quot;: \&quot;${communityID}\&quot;,\n    \&quot;name\&quot;: \&quot;${communityName}\&quot;,\n    \&quot;description\&quot;: \&quot;Community Desc\&quot;,\n    \&quot;communityType\&quot;: 0,\n    \&quot;communityCode\&quot;: null,\n    \&quot;entityId\&quot;: null,\n    \&quot;logo\&quot;: null,\n    \&quot;logoIdentifier\&quot;: null,\n    \&quot;isHidden\&quot;: false,\n    \&quot;isPrivate\&quot;: true,\n    \&quot;allowDiscussionBoards\&quot;: true,\n    \&quot;allowBlogPosts\&quot;: true,\n    \&quot;allowFileUploads\&quot;: true,\n    \&quot;isActive\&quot;: true,\n    \&quot;disableJoinRequest\&quot;: false,\n    \&quot;avgRating\&quot;: 0,\n    \&quot;memberCount\&quot;: 1,\n    \&quot;blogCount\&quot;: 0,\n    \&quot;discussionCount\&quot;: 0,\n    \&quot;fileCount\&quot;: 0,\n    \&quot;recentActivity\&quot;: null,\n    \&quot;userMembership\&quot;: null,\n    \&quot;modifiedDate\&quot;: \&quot;2018-06-26T13:20:59.282Z\&quot;,\n    \&quot;modifiedBy\&quot;: \&quot;-1\&quot;,\n    \&quot;imageName\&quot;: null,\n    \&quot;permissions\&quot;: 239,\n    \&quot;communityValidations\&quot;: {\n        \&quot;$type\&quot;: \&quot;System.Collections.Generic.Dictionary`2[[System.String, mscorlib],[System.String, mscorlib]], mscorlib\&quot;\n    }\n}&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${host}/Services/api/sumtSocial/communities/${communityID}/update</restUrl>
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
