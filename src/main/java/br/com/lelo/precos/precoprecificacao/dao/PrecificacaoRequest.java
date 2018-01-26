package br.com.lelo.precos.precoprecificacao.dao;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class PrecificacaoRequest {

	private PrecificacaoRequest() {
	}

	public static int Put(String url) throws ClientProtocolException, IOException {
		return Request.Put(url).execute().returnResponse().getStatusLine().getStatusCode();
	}

	public static String Put(String url, String json) throws ClientProtocolException, IOException {
		return Request.Put(url).bodyString(json, APPLICATION_JSON).execute().returnContent().asString();
	}

	public static String Post(String url, String json) throws ClientProtocolException, IOException {
		return Request.Post(url).bodyString(json, APPLICATION_JSON).execute().returnContent().asString();
	}

	public static String Get(String url) throws ClientProtocolException, IOException {
		return Request.Get(url).execute().returnContent().asString();
	}

}
