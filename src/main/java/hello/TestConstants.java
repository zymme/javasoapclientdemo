package hello;

public class TestConstants {
	
	public static String securityHostedUser = "<sec:AMA_SecurityHostedUser xmlns:sec=\"http://xml.amadeus.com/2010/06/Security_v1\">\n" + 
			"  <sec:UserID POS_Type=\"1\" PseudoCityCode=\"YMQAC0820\" AgentDutyCode=\"SU\" RequestorType=\"U\">\n" + 
			"    <typ:RequestorID xmlns:typ=\"http://xml.amadeus.com/2010/06/Types_v1\">\n" + 
			"      <iat:CompanyName xmlns:iat=\"http://www.iata.org/IATA/2007/00/IATA2010.1\">AC</iat:CompanyName>\n" + 
			"    </typ:RequestorID>\n" + 
			"  </sec:UserID>\n" + 
			"</sec:AMA_SecurityHostedUser>";
	
	
	public static String security = "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" + 
			"  <wsse:UsernameToken>\n" + 
			"    <wsse:Username>WSACQBY</wsse:Username>\n" + 
			"    <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest\">MWbx0P8Ix2yIgtlOvySTht3xtG4=</wsse:Password>\n" + 
			"    <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">fRzoosC57n4/qY5BUW1q3w==</wsse:Nonce>\n" + 
			"    <wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2019-03-09T13:07:00.122Z</wsu:Created>\n" + 
			"  </wsse:UsernameToken>\n" + 
			"</wsse:Security>";
	
	
	
	public static String testSoapBody = "<?xml version='1.0' encoding='UTF-8'?>\n" + 
			"<Queue_List xmlns=\"http://xml.amadeus.com/QDQLRQ_11_1_1A\">\n" + 
			"  <targetOffice>\n" + 
			"    <sourceType>\n" + 
			"      <sourceQualifier1>4</sourceQualifier1>\n" + 
			"    </sourceType>\n" + 
			"    <originatorDetails>\n" + 
			"      <inHouseIdentification1>YULAC0980</inHouseIdentification1>\n" + 
			"    </originatorDetails>\n" + 
			"  </targetOffice>\n" + 
			"  <queueNumber>\n" + 
			"    <queueDetails>\n" + 
			"      <number>01</number>\n" + 
			"    </queueDetails>\n" + 
			"  </queueNumber>\n" + 
			"  <categoryDetails>\n" + 
			"    <subQueueInfoDetails>\n" + 
			"      <identificationType>C</identificationType>\n" + 
			"      <itemNumber>14</itemNumber>\n" + 
			"    </subQueueInfoDetails>\n" + 
			"  </categoryDetails>\n" + 
			"</Queue_List>";

}
