
public class objetoDados {
	private String nome;
	private String plataforma;
	private String ano;
	private String genero;
	private String publisher;
	private String vendas_NA;
	private String vendas_EU;
	private String vendas_JP;
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getVendas_NA() {
		return vendas_NA;
	}


	public void setVendas_NA(String vendas_NA) {
		this.vendas_NA = vendas_NA;
	}


	public String getVendas_EU() {
		return vendas_EU;
	}


	public void setVendas_EU(String vendas_EU) {
		this.vendas_EU = vendas_EU;
	}


	public String getVendas_JP() {
		return vendas_JP;
	}


	public void setVendas_JP(String vendas_JP) {
		this.vendas_JP = vendas_JP;
	}


	public String getOutras_Vendas() {
		return outras_Vendas;
	}


	public void setOutras_Vendas(String outras_Vendas) {
		this.outras_Vendas = outras_Vendas;
	}


	public String getVendas_Globais() {
		return vendas_Globais;
	}


	public void setVendas_Globais(String vendas_Globais) {
		this.vendas_Globais = vendas_Globais;
	}


	private String outras_Vendas;
	private String vendas_Globais;
	@Override
	public String toString() {
		return "objetoDados [nome="+nome+ ", plataforma=" + plataforma + ", ano=" + ano + ", genero=" + genero + ", publisher="
				+ publisher + ", vendas_NA=" + vendas_NA + ", vendas_EU=" + vendas_EU + ", vendas_JP=" + vendas_JP
				+ ", outras_Vendas=" + outras_Vendas + ", vendas_Globais=" + vendas_Globais + "]";
	}
	
	
	public objetoDados(String[] vecLine) {
		nome=vecLine[1];
		plataforma=vecLine[2];
		
		ano=vecLine[3];
		genero=vecLine[4];
		publisher=vecLine[5];
		vendas_NA=vecLine[6];
		vendas_EU=vecLine[7];
		vendas_JP=vecLine[8];
		outras_Vendas=vecLine[9];
		vendas_Globais=vecLine[10];
	}

}
