# cxf-invalid-char

hava a problem: filter invalid char

    1. use this way
    	<entry key="javax.xml.stream.XMLOutputFactory"  value-ref="xmlOutputFactory" />
     problem counld't create wsdl ,so I check source code.(found this misstake in code)
     
    2. so I find other way.use CharFilterWriterInterceptor and CharFilterXMLStreamWriter  by coustom .
    	filter  invalid char in xml.
   
