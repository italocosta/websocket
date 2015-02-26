package com.br.websocket;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint("/server")
public class MyServerEndpoint {
	 @OnMessage
	    public void server(String text, Session client) throws InterruptedException {
	        for(int i=0; i<5; i++){
	            client.getAsyncRemote().sendText(text.toUpperCase() + " - " + i);
	            Thread.sleep(2000);
	    }
	 }
	 
	 @OnOpen
	 public void open(Session session, EndpointConfig conf) throws InterruptedException {
		 server("Mensagem para o Browser", session);
	 }
}
