
public class Termo {
	private int num;
	private String termo;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTermo() {
		return termo;
	}
	public void setTermo(String termo) {
		this.termo = termo;
	}
	public Termo(String termo,int num) {
		this.termo=termo;
		this.num=num;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Termo [num=" + num + ", termo=" + termo + "]";
	}
	
}
