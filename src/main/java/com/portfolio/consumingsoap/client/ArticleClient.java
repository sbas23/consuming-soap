package com.portfolio.consumingsoap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.soap.ws.article.GetArticleRequest;
import com.soap.ws.article.GetArticleResponse;


public class ArticleClient extends WebServiceGatewaySupport{
   
	public GetArticleResponse getArticle(int id) {
        GetArticleRequest getArticleRequest = new GetArticleRequest();
        getArticleRequest.setId(id);
        return (GetArticleResponse) getWebServiceTemplate().marshalSendAndReceive(getArticleRequest);
    }
	
}
