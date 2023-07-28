package br.com.mambo.transporte.utils.enuns;

public enum StatusEnum {
	
	STATUS_VIAGEM_PROGRAMADA("Programado"),
	STATUS_VIAGEM_EM_CARREGAMENTO("Em carregamento"),
	STATUS_VIAGEM_FIM_CARREGAMENTO("Carregado"),
	STATUS_VIAGEM_EM_TRANSITO_LOJA("Em transito sentido loja"),
	STATUS_VIAGEM_EM_TRANSITO_CD("Em transito sentido CD"),
	STATUS_VIAGEM_DESCARREGAMENTO_LOJA("Descarregando na loja"),
	STATUS_VIAGEM_FINALIZADA("Finlizado");
	
	private String descricao;

	private StatusEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}
