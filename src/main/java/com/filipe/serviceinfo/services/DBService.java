package com.filipe.serviceinfo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.dominian.ADM;
import com.filipe.serviceinfo.dominian.Funcionario;
import com.filipe.serviceinfo.dominian.OS;
import com.filipe.serviceinfo.dominian.Produto;
import com.filipe.serviceinfo.dominian.VendaAprazo;
import com.filipe.serviceinfo.dominian.VendaAvista;
import com.filipe.serviceinfo.dominian.enums.Estado;
import com.filipe.serviceinfo.dominian.enums.FormaPagamento;
import com.filipe.serviceinfo.dominian.enums.Prioridade;
import com.filipe.serviceinfo.dominian.enums.Status;
import com.filipe.serviceinfo.repositories.ADMRepository;
import com.filipe.serviceinfo.repositories.FuncionarioRepository;
import com.filipe.serviceinfo.repositories.OSRepository;
import com.filipe.serviceinfo.repositories.ProdutoRepository;
import com.filipe.serviceinfo.repositories.VendaAprazoRepository;
import com.filipe.serviceinfo.repositories.VendaAvistaRepository;

@Service
public class DBService {

	@Autowired
	private ADMRepository admRepository;
	
	@Autowired
	private FuncionarioRepository fRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	@Autowired
	private VendaAvistaRepository vRepository;
	
	@Autowired
	private VendaAprazoRepository vAprazoRepository;
	
	@Autowired
	private ProdutoRepository pRepository;
	
	public void instanciaDB() {
		
		
		ADM adm1 = new ADM(null, "Filipe Pereira sa Silva", "12198414635", "Fazenda Trairinha", "(38) 99908-9872", "SENHA_ACESSO");
		Funcionario f1 = new Funcionario(null, "Fulano de Tal", "607.145.810-20", "Inferno da pedra", "(87) 97799-3211", "123456");
		OS os1 = new OS(null, "Nego do Borel", "(38) 999714563", "Rio de Janeiro", Prioridade.toEnum(0), Status.toEnum(0), "Formatar notebooK", 00.00);
		Produto p1 = new Produto(null, "Carregador de celular", 40.00, "Turbo power Type-C");
		VendaAvista v1 = new VendaAvista(null, f1, FormaPagamento.toEnum(2));
		VendaAprazo vp1 = new VendaAprazo(null, f1, "Cubertino Osório", "36788914536", "Vaca Preta", "38999625471", Estado.toEnum(0));
		
		
		admRepository.saveAll(Arrays.asList(adm1));
		fRepository.saveAll(Arrays.asList(f1));
		osRepository.saveAll(Arrays.asList(os1));
		pRepository.saveAll(Arrays.asList(p1));
		vRepository.saveAll(Arrays.asList(v1));
		vAprazoRepository.saveAll(Arrays.asList(vp1));
	}
}
