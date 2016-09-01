package com.carvendy.inteceptor;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

import com.ctc.wstx.api.InvalidCharHandler;

public class CharFilterXMLStreamWriter extends DelegatingXMLStreamWriter { 

        private String currentElementName; 
        
        private static String regex = "";
        
        static{
        	for(int i=0; i<32; i++){
        		regex += ((char)i);
        	}
        	regex = "["+regex+"]";
        }

        public CharFilterXMLStreamWriter(XMLStreamWriter del) { 
                super(del); 
        } 

        @Override 
        public void writeCharacters(String text) throws XMLStreamException { 
        	/*String tmp = text;
        	for(char c :text.toCharArray()){
        		if(c < 0x0020){
        			tmp = tmp.replaceAll(c+"", " ");
        		}
        	}
        	text = tmp;*/
        	text = text.replaceAll(regex, " ");
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
        
        
        public static void main(String[] args) {
			String text = "00123456789a/\\非法字符////118079";
			System.out.println("regex:"+regex);
        	text = text.replaceAll(regex, " ");
        	System.out.println(text);
		}
} 