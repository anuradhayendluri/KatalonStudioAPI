// intialize request object 
RequestObject reqObj = new RequestObject()

// Add Headers
TestObjectProperty esbToken = new TestObjectProperty()
esbToken.setName('sumtauth-header')
esbToken.setValue('<esbtoken>')
TestObjectProperty contentType = new TestObjectProperty()
contentType.setName('Content-Type')
contentType.setValue('<contenttype>')
List<TestObjectProperty> headers = new ArrayList<TestObjectProperty>()
headers.add(esbToken)
headers.add(contentType)
request.setHttpHeaderProperties(headers)

// Specify Request type
request.setRestRequestMethod('<Request Type>')

// Set URL
request.setRestUrl('<url>')

// Set Request body
String body = '<json request body>'
request.setBodyContent(new HttpTextBodyContent(body, 'UTF-8', '<contenttype>'))

// send Response
response = WS.sendRequest(request)

// Validation 
WSBuiltInKeywords.verifyResponseStatusCode(response, 200)

