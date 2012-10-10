/**
   Copyright 2012 Otavio Rodolfo Piske

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package net.orpiske.cxf.example.webservice;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import net.orpiske.examples.cxf.webservice.TimeService;

/**
 * @author Otavio R. Piske <angusyoung@gmail.com>
 *
 */
public class TimeServiceImpl implements TimeService {

	/* (non-Javadoc)
	 * @see net.orpiske.examples.cxf.webservice.TimeService#timeService(java.lang.String)
	 */
	@WebResult(name = "itIs", targetNamespace = "")
	@RequestWrapper(localName = "TimeService", targetNamespace = "http://www.orpiske.net/examples/cxf/webservice", className = "net.orpiske.examples.cxf.webservice.TimeService_Type")
	@WebMethod(operationName = "TimeService")
	@ResponseWrapper(localName = "TimeServiceResponse", targetNamespace = "http://www.orpiske.net/examples/cxf/webservice", className = "net.orpiske.examples.cxf.webservice.TimeServiceResponse")
	
	public XMLGregorianCalendar timeService(
			@WebParam(name = "whatTime", targetNamespace = "") String whatTime) {
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		try {
			XMLGregorianCalendar ret = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			
			return ret;
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
