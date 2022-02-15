package com.portfolio.consumingsoap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.soap.ws.valid.IsValidISBN13;
import com.soap.ws.valid.IsValidISBN13Response;


public class ValidateSBNClient extends WebServiceGatewaySupport{
	public IsValidISBN13Response getValid(String sisbn) {
		IsValidISBN13 isValidISBN13 = new IsValidISBN13();
		isValidISBN13.setSISBN(sisbn);
		return (IsValidISBN13Response) getWebServiceTemplate().marshalSendAndReceive(isValidISBN13);
	}
}

