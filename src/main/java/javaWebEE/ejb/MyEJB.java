package javaWebEE.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;



@WebService
class MyWebService {
	@WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }	
}

@Stateless
public class MyEJB {
	
	private MyWebService myWebService = new MyWebService();
	/*
  		@WebServiceRef(wsdlLocation="http://localhost:8080/javaWebEE/MyWebService?wsdl")
  		private MyWebService myWebService;
  	*/
      
    public String sayHello(String name) {
    	System.out.println("sayHello method:" + name);
        return myWebService.sayHello(name);
    }
}
