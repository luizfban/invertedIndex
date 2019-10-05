import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file_name = "C:\\Users\\AntunesLuiz\\eclipse-workspace\\IndiceInvertido\\src\\dados.csv";
		try {
			RandomAccessFile file = new RandomAccessFile(file_name,"r");
			
			int qtdLinhas=0;
			while((file.readLine()) != null) {
				qtdLinhas++;
			}
			qtdLinhas+=2;
			objetoDados[] vetArqDados=new objetoDados[qtdLinhas];
			file.seek(0);
			int contador=0;
			String line=file.readLine();
			//System.out.println(line);
			String[] vecLine = line.split(",");
			String[] space;
			Lista lista = new Lista();
			while((line=file.readLine()) != null) {
			//line=file.readLine();
				vecLine=line.split(",");
				vetArqDados[new Integer(vecLine[0])]=new objetoDados(vecLine);
				space=vecLine[1].split(" ");
				for(int i =0;i<space.length;i++) {
					if(space[i].length()>=3) {
					int num=new Integer(vecLine[0]);
					Termo termo=new Termo(space[i],num);
					lista.insere(termo);
					contador++;
					}
				}
			/*	line=file.readLine();
				vecLine=line.split(",");
				vetArqDados[new Integer(vecLine[0])]=new objetoDados(vecLine);
				space=vecLine[1].split(" ");
				for(int i =0;i<space.length;i++) {
					int num=new Integer(vecLine[0]);
					Termo termo=new Termo(space[i],num);
					lista.insere(termo);
					contador++;}*/
			}
			/*for(int i=1;i<3;i++) {
				System.out.println(vetArqDados[i].toString());	
			}*/
			ObjetoIndice[] indiceInvertido=new ObjetoIndice[contador];
			int cont=0;
			//lista.imprime();
			for(int i =0;i<contador;i++) {
					Termo termo=(Termo)lista.retiraPrimeiro();
					String str=termo.getTermo();
					int valor=termo.getNum();
					if(cont==0) {
						Lista l=new Lista();
						l.insere((Integer) valor);
						indiceInvertido[0]=new ObjetoIndice(str,l);
						//System.out.println(indiceInvertido[0].toString());
						cont++;
					}else {
					boolean b=false;
					for(int j=0;j<cont;j++) {
						if(indiceInvertido[j].getTermo().compareTo(str)==0) {
							Lista l=new Lista();
							l=indiceInvertido[j].getL();
							l.insere((Integer) valor);
							indiceInvertido[j].setL(l);
							b=true;
							break;		
						}
					}
					if(b==false) {
						Lista l=new Lista();
						l.insere((Integer) valor);
						indiceInvertido[cont]=new ObjetoIndice(str,l);
//						System.out.println(indiceInvertido[0].toString());
						cont++;
					}
					
				}
			}
			HashTermo[] vetorHash=new HashTermo[70271];
			//Cálcula código e índice da HASH
			for(int i=0;i<cont;i++) {
				int cod=1;
				String str=indiceInvertido[i].getTermo();
				for(int j=0;j<3;j++) {
				char c=str.charAt(j);
				cod *=c;
				}
				int chave=cod%vetorHash.length;
				if(vetorHash[chave]==null) {
					vetorHash[chave]=new HashTermo(cod,i,-1);
				}else {
					int j=0;
					for(j=chave+1;j<vetorHash.length;j++) {
						if(vetorHash[j]==null) {
							vetorHash[chave].setProximo(j);
							vetorHash[j]=new HashTermo(cod,i,-1);
							break;
						}
					}

				}
				
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite uma string:");
			String entrada = in.readLine();
			while(entrada.compareTo("-1")!=0) {
			int[] contArquivos=new int[qtdLinhas];
			String[] vetPalavras=entrada.split(" ");
			entrada=" ";
			for(int k=0;k<vetPalavras.length;k++) {
			int cod=1;
			for(int j=0;j<3;j++) {
				char c=vetPalavras[k].charAt(j);
				cod *=c;
				}
				int chave=cod%vetorHash.length;
				if(vetorHash[chave]!=null) {
					while(chave!=-1 && cod!=vetorHash[chave].getCodigo()) {
						int valor=vetorHash[chave].getProximo();
						chave=valor;
					}
					if(chave!=-1) {
					int end;
					end=vetorHash[chave].getIndTabela();
					Lista l,aux;
					l=indiceInvertido[end].getL();
					aux=l;
					int[] elemLista =aux.getVetorLista();
					for(int i = 0; i<elemLista.length;i++) {
						int index = elemLista[i];
						//System.out.println(index);
						contArquivos[index]++;
					}
					}else {
						System.out.println("Palavra não existente");
					}	
				}else {
					System.out.println("Palavra não existente");
				}
			}
			for(int i=0;i<contArquivos.length;i++) {
				if(contArquivos[i]==vetPalavras.length) {
					System.out.println(" "+vetArqDados[i].toString());
				}
			}
			entrada = in.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Arquivo não encontrado");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
