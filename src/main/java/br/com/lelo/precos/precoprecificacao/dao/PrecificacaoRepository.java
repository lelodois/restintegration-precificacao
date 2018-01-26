package br.com.lelo.precos.precoprecificacao.dao;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lelo.precos.precoprecificacao.DatabaseConfiguration;
import br.com.lelo.precos.precoprecificacao.model.JsonResult;
import br.com.lelo.precos.precoprecificacao.model.Precificacao;

@Repository
public class PrecificacaoRepository {

	@Autowired
	private DatabaseConfiguration configuration;

	public void createDatabase(String name) throws ClientProtocolException, IOException {
		Request.Put(name).execute();
	}

	public JsonResult inserir(Precificacao precificacao) throws ClientProtocolException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(precificacao);
		String asString = PrecificacaoRequest.Post(configuration.getDatabaseFullName(), json);
		return objectMapper.readValue(asString, JsonResult.class);
	}

}
