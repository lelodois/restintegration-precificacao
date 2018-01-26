package br.com.lelo.precos.precoprecificacao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.precos.precoprecificacao.model.PrecificacaoLote;

@RestController
@RequestMapping("precos-precificacao")
public class PrecificacaoController {

	@Autowired
	private PrecificacaoBusiness business;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "inserir")
	public List<String> inserir(@RequestBody PrecificacaoLote lote) throws Exception {
		log.info(" \n*********** inicio *************\n");

		List<String> ids = business.inserir(lote);

		log.info(ids.toString());
		log.info(" \n************** fim *************\n");
		return ids;
	}

}
