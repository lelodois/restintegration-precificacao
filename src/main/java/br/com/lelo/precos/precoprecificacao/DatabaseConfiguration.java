package br.com.lelo.precos.precoprecificacao;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.lelo.precos.precoprecificacao.dao.PrecificacaoRepository;

@Component
public class DatabaseConfiguration {

	@Value("${myproperties.server.couchbase.databasename}")
	private String databaseName;

	@Value("${myproperties.server.couchbase.url}")
	private String databaseUrl;

	@Autowired
	private PrecificacaoRepository repository;

	@PostConstruct
	public void inicializar() throws ClientProtocolException, IOException {
		repository.createDatabase(getDatabaseFullName());
	}

	public String getDatabaseFullName() {
		return StringUtils.join(databaseUrl, databaseName);
	}

}
