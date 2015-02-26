package com.br.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/italo")
public class MeuServidorEndPoint {
	
	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnMessage
	public String onMessage(String value, Session sessao){
		//sessao.getAsyncRemote().sendText(value);
		return null;
	}
	
	@OnOpen
	public void onOpen(Session sessao){
		//onMessage("Teste", sessao);
		peers.add(sessao);
	}
	
	@OnClose
	public void onClose(Session sessao){
		peers.remove(sessao);
	}
	
	
}
