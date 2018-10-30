<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Getting the version of application</description>
   <name>GetVersion</name>
   <tag></tag>
   <elementGuidId>bfb21226-f12e-46a4-929d-c81c5eb62939</elementGuidId>
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
      <value>eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC93d3cuc3VtdG90YWxzeXN0ZW1zLmNvbVwvY29yZXVpIiwic3ViIjoiYWRtaW5pc3RyYXRvciIsImF1ZCI6IkNEMTRfSU5UX1RFU1QiLCJleHAiOjYzNjcxMjQyMTUzMjcwMzA0MCwibmJmIjowLCJpYXQiOjYzNjcxMjIwNTUzNTgyODExMiwiYnNlc3Npb25pZCI6IjA0OTE5YTJhMGRkZTQ3MDA4N2NiYmRlNzAxMmQwMDdkIiwiZXVzcmlkIjpudWxsLCJldXNybiI6bnVsbCwiY3VsIjoiZW4tVVMiLCJ1c2VyaWQiOiJBZG1pbmlzdHJhdG9yIiwiZ3Vlc3RhY2NvdW50IjowLCJwZXJzb25pZCI6LTEsImlzZXh0ZXJuYWwiOmZhbHNlLCJycGtleSI6IkVMSVhIUlVJIn0.618D51F9B0C6DF5A7BFEDDEEF7843F8A5BEDB3E83F925450563B7A9D7A9E18B1</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https:///cd14int.sumtotaldevelopment.net/broker/public/MobileVersion.ashx?wtrealm=https://cd14int.sumtotaldevelopment.net/</restUrl>
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
