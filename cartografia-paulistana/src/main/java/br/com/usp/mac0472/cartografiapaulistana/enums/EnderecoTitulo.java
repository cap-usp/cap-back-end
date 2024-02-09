package br.com.usp.mac0472.cartografiapaulistana.enums;

import java.util.Arrays;

public enum EnderecoTitulo {

	ABADE("Abade"), ACADEMICO("Acadêmico"), ADVOGADO("Advogado"), AGENTE("Agente"), AGRICULTOR("Agricultor"),
	AGRIMENSOR("Agrimensor"), AJUDANTE("Ajudante"), ALFERES("Alferes"), ALMIRANTE("Almirante"), APOSTOLO("Apóstolo"),
	ARCANJO("Arcanjo"), ARCEBISPO("Arcebispo"), ARCIPRESTE("Arcipreste"), ARQUITETA("Arquiteta"),
	ARQUITETO("Arquiteto"), ARQUITETO_PROFESSOR("Arquiteto Professor"), ASPIRANTE("Aspirante"), AVENIDA("Avenida"),
	AVIADOR("Aviador"), AVIADORA("Aviadora"), BACHAREL("Bacharel"), BANDEIRANTE("Bandeirante"), BANQUEIRO("Banqueiro"),
	BARAO("Barão"), BARONESA("Baronesa"), BEATA("Beata"), BEATO("Beato"), BEATO_PADRE("Beato Padre"),
	BEM_AVENTURADO("Bem Aventurado"), BENEMERITO("Benemérito"), BISPO("Bispo"), BRIGADEIRO("Brigadeiro"), CABO("Cabo"),
	CABO_PM("Cabo Policial Militar"), CADETE("Cadete"), CAMPEADOR("Campeador"), CAPITAO("Capitão"),
	CAPITAO_ALMIRANTE("Capitão Almirante"), CAPITAO_DE_FRAGATA("Capitão de Fragata"),
	CAPITAO_DE_MAR_E_GUERRA("Capitão de Mar e Guerra"), CAPITAO_GENERAL("Capitão General"), CAPITAO_MOR("Capitão-Mor"),
	CAPITAO_PM("Capitão Policial Militar"), CAPITAO_TENENTE("Capitão Tenente"), CARDEAL("Cardeal"),
	CARTEIRO("Carteiro"), CATEQUISTA("Catequista"), CAVALEIRO("Cavaleiro"), CAVALHEIRO("Cavalheiro"),
	CINEASTA("Cineasta"), COMANDANTE("Comandante"), COMEDIANTE("Comediante"), COMENDADOR("Comendador"),
	COMENDADORA("Comendadora"), COMENDADORA_PROFESSORA("Comendadora Professora"), COMISSARIA("Comissária"),
	COMISSARIO("Comissário"), COMPOSITOR("Compositor"), CONDE("Conde"), CONDESSA("Condessa"), CONEGO("Cônego"),
	CONFRADE("Confrade"), CONSELHEIRO("Conselheiro"), CONSUL("Cônsul"), CORONEL("Coronel"),
	CORONEL_PM("Coronel Policial Militar"), CORREGEDOR("Corregedor"), DELEGADO("Delegado"), DENTISTA("Dentista"),
	DEPUTADA("Deputada"), DEPUTADO("Deputado"), DEPUTADO_DOUTOR("Deputado Doutor"), DESEMBARGADOR("Desembargador"),
	DIACONO("Diácono"), DOM("Dom"), DONA("Dona"), DOUTOR("Doutor"), DOUTORA("Doutora"), DUQUE("Duque"),
	DUQUESA("Duquesa"), EDITOR("Editor"), EDUCADOR("Educador"), EDUCADORA("Educadora"), EMBAIXADOR("Embaixador"),
	EMBAIXADORA("Embaixadora"), EMPRESARIO("Empresário"), ENGENHEIRO("Engenheiro"), ENGENHEIRA("Engenheira"),
	ESCOTEIRO("Escoteiro"), ESCRAVO("Escravo"), ESCRITOR("Escritor"), EXPEDICIONARIO("Expedicionário"),
	FISICO("Físico"), FREI("Frei"), GENERAL("General"), GOVERNADOR("Governador"), GRUMETE("Grumete"),
	GUARDA_CIVIL_METROPOLITANO("Guarda Civil Metropolitano"), IMACULADA("Imaculada"), IMPERATRIZ("Imperatriz"),
	INFANTE("Infante"), INSPETOR("Inspetor"), IRMA("Irmã"), IRMAO("Irmão"), IRMAOS("Irmãos"), IRMAS("Irmãs"),
	JORNALISTA("Jornalista"), LIBERTADOR("Libertador"), LIDER_COMUNITARIO("Líder Comunitário"), LIVREIRO("Livreiro"),
	LORDE("Lorde"), MADAME("Madame"), MADRE("Madre"), MAESTRO("Maestro"), MAJOR("Major"),
	MAJOR_AVIADOR("Major Aviador"), MAJOR_BRIGADEIRO("Major Brigadeiro"), MAQUINISTA("Maquinista"),
	MARECHAL("Marechal"), MARECHAL_DO_AR("Marechal do Ar"), MARQUES("Marquês"), MARQUESA("Marquesa"), MERE("Mere"),
	MESTRAS("Mestras"), MESTRE("Mestre"), MESTRES("Mestres"), MILITANTE("Militante"), MINISTRO("Ministro"),
	MISSIONARIA("Missionária"), MISSIONARIO("Missionário"), MONGE("Monge"), MONSENHOR("Monsenhor"),
	MUNICIPAL("Municipal"), MUSICO("Músico"), NOSSA_SENHORA("Nossa Senhora"), NOSSO_SENHOR("Nosso Senhor"),
	OUVIDOR("Ouvidor"), PADRE("Padre"), PADRES("Padres"), PAI("Pai"), PAPA("Papa"), PASTOR("Pastor"),
	PASTORA("Pastora"), PATRIARCA("Patriarca"), POETA("Poeta"), POETISA("Poetisa"), PREFEITO("Prefeito"),
	PRESIDENTE("Presidente"),
	PRESIDENTE_DA_ACADEMIA_BRASILEIRA_DE_LETRAS("Presidente da Academia Brasileira de Letras"),
	PRESIDENTE_VEREADOR("Presidente Vereador"), PRIMEIRO_SARGENTO("Primeiro Sargento"),
	PRIMEIRO_SARGENTO_PM("Primeiro Sargento Policial Militar"), PRIMEIRO_TENENTE("Primeiro Tenente"),
	PRIMEIRO_TENENTE_PM("Primeiro Tenente Policial Militar"), PRINCESA("Princesa"), PRINCIPE("Príncipe"),
	PROCURADOR("Procurador"), PROFESSOR("Professor"), PROFESSOR_DOUTOR("Professor Doutor"),
	PROFESSOR_ENGENHEIRO("Professor Engenheiro"), PROFESSORA("Professora"), PROFETA("Profeta"), PROMOTOR("Promotor"),
	PROVEDOR("Provedor"), PROVEDOR_MOR("Provedor-Mor"), RABINO("Rabino"), RADIALISTA("Radialista"), RAINHA("Rainha"),
	REGENTE("Regente"), REI("Rei"), REVERENDO("Reverendo"), RUA("Rua"), SACERDOTE("Sacerdote"), SANTA("Santa"),
	SANTO("Santo"), SAO("São"), SARGENTO("Sargento"), SARGENTO_MOR("Sargento-Mor"),
	SARGENTO_PM("Sargento Policial Militar"), SEGUNDO_SARGENTO("Segundo Sargento"),
	SEGUNDO_SARGENTO_PM("Segundo Sargento Policial Militar"), SEGUNDO_TENENTE("Segundo Tenente"), SENADOR("Senador"),
	SENHOR("Senhor"), SENHORA("Senhora"), SERTANISTA("Sertanista"), SEU("Seu"), SINHA("Sinhá"), SIR("Sir"),
	SOCIOLOGO("Sociólogo"), SOLDADO("Soldado"), SOLDADO_PM("Soldado Policial Militar"), SOROR("Soror"),
	SUB_TENENTE("Subtenente"), TENENTE("Tenente"), TENENTE_AVIADOR("Tenente Aviador"),
	TENENTE_BRIGADEIRO("Tenente Brigadeiro"), TENENTE_CORONEL("Tenete Coronel"),
	TENENTE_CORONEL_PM("Tenente Coronel Policial Militar"), TEOLOGO("Teólogo"), TERCEIRO_SARGENTO("Terceiro Sargento"),
	TERCEIRO_SARGENTO_PM("Terceiro Sargento Policial Militar"), TIA("Tia"), VEREADOR("Vereador"),
	VICE_ALMIRANTE("Vice Almirante"), VICE_REI("Vice Rei"), VIGARIO("Vigário"), VISCONDE("Visconde"),
	VISCONDESSA("Viscondessa"), VOLUNTARIO("Voluntário"), VOLUNTARIOS("Voluntários");

	private String nome;

	EnderecoTitulo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public static EnderecoTitulo getByNome(String nome) {
		return Arrays.stream(EnderecoTitulo.values()).filter(status -> status.nome.equals(nome)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Endereço título não existe"));
	}
}
