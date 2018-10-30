<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create Community</name>
   <tag></tag>
   <elementGuidId>e784d7b1-8288-43d7-a42f-6d8045e330c2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;allowDiscussionBoards\&quot;: true,\n\&quot;allowBlogPosts\&quot;: true,\n\&quot;allowFileUploads\&quot;: \&quot;true\&quot;,\n\&quot;name\&quot;: ${CommunityName},\n\&quot;description\&quot;: ${CommunityDesc},\n\&quot;communityCode\&quot;: \&quot;code\&quot;,\n\&quot;isPrivate\&quot;: false,\n\&quot;members\&quot;: [{\&quot;userName\&quot;: \&quot;admin\&quot;,\&quot;userId\&quot;: -1,\&quot;role\&quot;: 1,\&quot;userStatus\&quot;: \&quot;Joined\&quot;\n            }\n           ]\n}\n&quot;,
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>sumtauth-header</name>
      <type>Main</type>
      <value>eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC93d3cuc3VtdG90YWxzeXN0ZW1zLmNvbVwvY29yZXVpIiwic3ViIjoiYWRtaW5pc3RyYXRvciIsImF1ZCI6IkNEMTRfSU5UX1RFU1QiLCJleHAiOjYzNjcxMjMwOTU2MjI4NDAxOSwibmJmIjowLCJpYXQiOjYzNjcxMjA5MzU2NDk0MDM0NywiYnNlc3Npb25pZCI6IjVlMGI2MGM3Zjk5MDRkMzNiMDBkY2QxNTA2NmZkMzZhIiwiZXVzcmlkIjpudWxsLCJldXNybiI6bnVsbCwiY3VsIjoiZW4tVVMiLCJ1c2VyaWQiOiJBZG1pbmlzdHJhdG9yIiwiZ3Vlc3RhY2NvdW50IjowLCJwZXJzb25pZCI6LTEsImlzZXh0ZXJuYWwiOmZhbHNlLCJycGtleSI6IkVMSVhIUlVJIn0.9E19212140EBE99D01083320C180F2F7CB5C3B08B16BE6E30EB64E7097811CFB</value>
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
