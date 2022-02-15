package com.portfolio.consumingsoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.portfolio.consumingsoap.client.ArticleClient;
import com.portfolio.consumingsoap.client.ValidateSBNClient;

@Configuration
public class SoapClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPaths("com.soap.ws.valid","com.soap.ws.article");
		return jaxb2Marshaller;
	}

	@Bean
	public ArticleClient articleClient(Jaxb2Marshaller jaxb2Marshaller) {
		ArticleClient articleClient = new ArticleClient();
		articleClient.setDefaultUri("http://localhost:8080/ws/article");
		articleClient.setMarshaller(jaxb2Marshaller);
		articleClient.setUnmarshaller(jaxb2Marshaller);
		return articleClient;
	}
	
	@Bean
	public ValidateSBNClient validateClient(Jaxb2Marshaller jaxb2Marshaller) {
		ValidateSBNClient validateSBNClient = new ValidateSBNClient();
		validateSBNClient.setDefaultUri("http://webservices.daehosting.com/services/isbnservice.wso");
		validateSBNClient.setMarshaller(jaxb2Marshaller);
		validateSBNClient.setUnmarshaller(jaxb2Marshaller);
		return validateSBNClient;
	}
}
