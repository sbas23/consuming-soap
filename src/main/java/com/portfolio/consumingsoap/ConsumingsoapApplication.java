package com.portfolio.consumingsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.portfolio.consumingsoap.client.ArticleClient;
import com.portfolio.consumingsoap.client.ValidateSBNClient;
import com.portfolio.consumingsoap.config.SoapClientConfig;

@SpringBootApplication
public class ConsumingsoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingsoapApplication.class, args);
        @SuppressWarnings("resource")
		
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        
        ValidateSBNClient validateSBNClient = annotationConfigApplicationContext.getBean(ValidateSBNClient.class);
        System.out.println(validateSBNClient.getValid("9789059650886").isIsValidISBN13Result());
        
        ArticleClient articleClient = annotationConfigApplicationContext.getBean(ArticleClient.class);
        System.out.println(articleClient.getArticle(2).getArticle().getName());
        
	}

}
