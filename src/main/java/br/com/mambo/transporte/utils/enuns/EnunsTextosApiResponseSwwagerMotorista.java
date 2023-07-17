package br.com.mambo.transporte.utils.enuns;

public enum EnunsTextosApiResponseSwwagerMotorista {
	
	MENSAGEM_RESPONSE_ERRO_200("Motorista foi adicionado com sucesso."),
	MENSAGEM_RESPONSE_ERRO_403("Entre em contato com a equipe de T.I para obter o acesso."),
	MENSAGEM_RESPONSE_ERRO_500("Falha no código fonte, reporte a equipe de T.I para dar a devida manutenção.");
	
	private String descricao;

	private EnunsTextosApiResponseSwwagerMotorista(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}
