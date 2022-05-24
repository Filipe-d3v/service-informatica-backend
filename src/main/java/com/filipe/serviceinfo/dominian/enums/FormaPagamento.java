package com.filipe.serviceinfo.dominian.enums;

public enum FormaPagamento {

	DINHEIRO(0, "DINHEIRO"), CARTAO(1, "CARTÃO"), PIX(2, "PIX");

	private Integer cod;
	private String desc;

	private FormaPagamento(Integer cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}


	public static FormaPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(FormaPagamento x : FormaPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Forma de pagamento Inválida!" + cod);
	}
}
