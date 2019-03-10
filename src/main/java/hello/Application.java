package hello;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


import hello.wsdl.AddResponse;


@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Value ("${LSS_User}")
	private String lssUser;
    
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    	
    }
    
    
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, CalculatorClient ccClient) {
    	
    	return args -> {
    		System.out.println("Let's inspect the beans provided by Spring Boot");
    		
    		String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            
            this.testToConsole();
            this.testSpringAppProperties();
            this.testCallToWebService(ccClient);
    	};
    }
    
    @Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("hello.wsdl");
		return marshaller;
	}

	@Bean
	public CalculatorClient countryClient(Jaxb2Marshaller marshaller) {
		CalculatorClient client = new CalculatorClient();
		client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
    
    private void testToConsole() {
    	System.out.println("Output to console .........");
    }
    
    private void testSpringAppProperties() {
    	
    	log.info("testing access to app properties, user:" + this.lssUser);
    }
    
    
    
    private void testCallToWebService(CalculatorClient ccClient) {
    	
    	log.info("Entered testCallToWebService method ..........");
    	
    	
    	AddResponse addResp = ccClient.getAddResponse(1, 2);
    	
    	log.info("Returned from soap service response of adding 1+2 = " + addResp.getAddResult());
    	
    	
    }

}
