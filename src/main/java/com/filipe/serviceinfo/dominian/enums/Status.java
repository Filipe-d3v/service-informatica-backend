package com.filipe.serviceinfo.dominian.enums;

public enum Status {
	
	ANDAMENTO(0, "ANDAMENTO"), PRONTO(1, "PRONTO");

	private Integer cod;
	private String desc;

	private Status(Integer cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}


	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status Inválido!" + cod);
	}

}
