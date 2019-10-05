
public class HashTermo {
	int codigo;
	int indTabela;
	int proximo;
	@Override
	public String toString() {
		return "HashTermo [codigo=" + codigo + ", indTabela=" + indTabela + ", proximo=" + proximo + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIndTabela() {
		return indTabela;
	}
	public void setIndTabela(int indTabela) {
		this.indTabela = indTabela;
	}
	public int getProximo() {
		return proximo;
	}
	public void setProximo(int proximo) {
		this.proximo = proximo;
	}
	public HashTermo(int cod,int indice,int proximo) {
		// TODO Auto-generated constructor stub
		this.codigo=cod;
		this.indTabela=indice;
		this.proximo=proximo;
	}


}
