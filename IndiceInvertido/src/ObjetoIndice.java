
public class ObjetoIndice {
	String termo;
	@Override
	public String toString() {
		l.imprime();
		return "ObjetoIndice [termo=" + termo + ", l=";
	}
	Lista l;
	public ObjetoIndice(String termo,Lista l) {
		this.l=l;
		this.termo=termo;
		// TODO Auto-generated constructor stub
	}
	public String getTermo() {
		return termo;
	}
	public void setTermo(String termo) {
		this.termo = termo;
	}
	public Lista getL() {
		return l;
	}
	public void setL(Lista l) {
		this.l = l;
	}

}
