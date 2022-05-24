package com.filipe.serviceinfo.dominian.enums;

public enum Estado {

	DEVENDO(0, "DEVENDO"), PAGO(1, "PAGO");

	private Integer cod;
	private String desc;

	private Estado(Integer cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}


	public static Estado toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Estado x : Estado.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Estado  Inválido!" + cod);
	}
}
