package br.com.lelo.precos.precoprecificacao.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.lelo.precos.precoprecificacao.dao.PrecificacaoRepository;
import br.com.lelo.precos.precoprecificacao.dao.PrecificacaoRequest;
import br.com.lelo.precos.precoprecificacao.model.JsonResult;
import br.com.lelo.precos.precoprecificacao.model.Precificacao;
import br.com.lelo.precos.precoprecificacao.model.PrecificacaoLote;

@Service
public class PrecificacaoBusiness {

	@Autowired
	private PrecificacaoRepository repository;

	@Value("${myproperties.server.exportacao.url}")
	private String exportacaoUrl;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public List<String> inserir(PrecificacaoLote lote) throws ClientProtocolException, IOException {
		log.info("inserindo no couchdb");

		List<String> ids = Lists.newArrayList();
		for (int item = lote.getFilialInicial(); item < lote.getFilialFinal(); item++) {
			Precificacao precificacao = new Precificacao(lote, item);
			JsonResult jsonResult = repository.inserir(precificacao);

			if (jsonResult.isOk() == false) {
				throw new IllegalStateException("Erro ao inserir a precificacao");
			}

			log.info("enviando para o projeto de exportação");
			PrecificacaoRequest.Put(StringUtils.join(exportacaoUrl, jsonResult.getId()));

			ids.add(jsonResult.getId());
		}

		return ids;
	}

}
