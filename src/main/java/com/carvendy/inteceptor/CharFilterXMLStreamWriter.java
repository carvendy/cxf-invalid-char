package com.carvendy.inteceptor;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

import com.ctc.wstx.api.InvalidCharHandler;
import com.ctc.wstx.api.InvalidCharHandler.FailingHandler;

public class CharFilterXMLStreamWriter extends DelegatingXMLStreamWriter { 

        private String currentElementName; 

        public CharFilterXMLStreamWriter(XMLStreamWriter del) { 
                super(del); 
        } 

        @Override 
        public void writeCharacters(String text) throws XMLStreamException { 
        	String tmp = text;
        	for(char c :text.toCharArray()){
        		if(c < 0x0020){
        			tmp = tmp.replaceAll(c+"", " ");
        		}
        	}
        	text = tmp;
        	super.writeCharacters(text); 
        } 
        
        public boolean filterChar(char c){
        	InvalidCharHandler failingHandler = InvalidCharHandler.FailingHandler.getInstance();
        	try {
				failingHandler.convertInvalidChar(c);
			} catch (IOException e) {
				return true;
			}
        	
        	return false;
        }

        public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException { 
                currentElementName = local; 
                super.writeStartElement(prefix, local, uri); 
        } 
} 