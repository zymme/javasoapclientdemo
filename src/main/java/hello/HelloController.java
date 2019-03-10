package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

import hello.wsdl.AddResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	
	@Autowired
	private CalculatorClient ccClient;
	
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    
    @RequestMapping("/")
    public String index() {
    	
    	try {
    		log.info("In HelloController index request ........");
    		
    		AddResponse addResp = ccClient.getAddResponse(2, 4);
    		
    		return "Greetings we added 2+4 and got : " + addResp.getAddResult();
    	}
    	catch(Exception e) {
    		log.error("ERROR in index request: " + e.getMessage());
    		return "ERROR in index request: " + e.getMessage();
    	}
       
    }
    
}
