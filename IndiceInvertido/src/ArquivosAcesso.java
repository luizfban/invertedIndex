import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ArquivosAcesso {

	private RandomAccessFile file;
	private int numReg;
	private int tamReg;
	private int tamHead;
	private static final int STRING_MAX_TAM = 30;
	
	
	
	public ArquivosAcesso() {
		this.file = null;
		this.numReg = -1; // número de registro (-1: não há registros)
		this.tamReg = (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM +
		(Integer.SIZE / 8);
		this.tamHead = 4;
	}
	
	
	public void openFile(String path) {
		File f = new File(path);
		// se arquivo nao existe definie numReg como 0. Se o arquivo já existe, mantenha como -1
		if (!f.exists())
		this.numReg = 0;
		try {
		file = new RandomAccessFile(f, "rw");
		} catch (FileNotFoundException e) {
		System.out.println("File not found");
		System.exit(0);
		}
		// se numReg é igual a -1, há registros dentro do arquivo, então verifica a quantidade de registros
		if (this.numReg == -1)
		this.setNumReg();
	}
	
	private void setNumReg() {
		try {
		this.numReg = file.readInt();
		} catch (IOException e) {
		System.out.println("Error!");
		System.exit(0);
		}
	}
	
	public void openFileReadOnly(String path) {
		try {
		file = new RandomAccessFile(new File(path), "r");
		} catch (FileNotFoundException e) {
		System.out.println("File not found");
		System.exit(0);
		}
		this.setNumReg();
		}
	
	public int getNumReg() {
		return numReg;
	}
	
	
	public void setData(objetoDados obj) {
		int pos = this.tamHead + (this.numReg * this.tamReg); // calcula
		//ponteiro para a primeira posição vazia do arquivo
		try {
		file.seek(pos);
		file.writeInt(obj.getCodigo());
		file.writeUTF(obj.getNome());
		file.seek(pos + (Integer.SIZE / 8) + STRING_MAX_TAM);
		file.writeUTF(obj.getSobrenome());
		file.seek(pos + (Integer.SIZE / 8) + STRING_MAX_TAM +
		STRING_MAX_TAM);
		file.writeInt(obj.getIdade());
		file.seek(0);
		this.numReg += 1;
		file.writeInt(this.numReg);
		} catch (IOException e) {
		System.out.println("Error!");
		System.exit(0);
		}
	}
	
	



	

}
