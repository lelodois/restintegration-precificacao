package br.com.lelo.precos.precoprecificacao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.precos.precoprecificacao.model.Precificacao;

@RestController
@RequestMapping("precos-precificacao")
public class PrecificacaoController {

	@Autowired
	private PrecificacaoBusiness business;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "inserir")
	public String inserir(@RequestBody Precificacao precificacao) throws Exception {
		log.info(" \n*********** inicio *************\n");

		String id = business.inserir(precificacao);

		log.info(id);
		log.info(" \n************** fim *************\n");
		return id;
	}

}
