package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.Add;
import hello.wsdl.AddResponse;


public class CalculatorClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);
	
	
	public AddResponse getAddResponse(int a, int b) {
			
		try {
    		
    		Add addRequest = new Add();
        	addRequest.setIntA(a);
        	addRequest.setIntB(b);
        	
        	log.info("Request for addition .....");
        	
        	AddResponse addResp = (AddResponse) getWebServiceTemplate()
        			.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", 
        					addRequest, 
        					new SoapActionCallback("http://tempuri.org/Add"));
        	
        	return addResp;
    	}
    	catch(Exception e) {
    		log.error("ERROR in Calculator SOAP service call: " + e.getMessage());
    		throw e;
    	}
		
		
	}

}
