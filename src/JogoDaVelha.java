import java.util.Vector;
import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main(String[] args){
		String[][] t=inicializar();
		Scanner entrada= new Scanner(System.in);
		boolean controle=true;
		while(controle){
			System.out.println("Informe Jogador, Linha e Coluna");		
			String s=entrada.nextLine();
			Vector j=interpretrarJogada(s);
			try {
				jogar(t,(Integer)j.get(1),(Integer)j.get(2),(String)j.get(0));
			} catch (JogoDaVelhaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mostraTabuleiro(t);
			if(existeGanhador(t,"X")||(existeGanhador(t,"O"))||tabuleiroCheio(t)){				
				if(existeGanhador(t,"X")){
					System.out.println("Jogador Xis Ganhou");
				}
				if(existeGanhador(t,"O")){
					System.out.println("Jogador bola Ganhou");
				}else
					System.out.println("Fim de Jogo");
				controle=false;
			}
		}
	}	
	private static void mostraTabuleiro(String[][] t) {
		for(int i=0;i<t.length;i++){
			System.out.print("|");
			for(int j=0;j<t.length;j++){
				System.out.print(t[i][j]);
				System.out.print("|");
			}
			System.out.println(" ");
		}	
	}
	public static String[][] inicializar(){
		String[][] t=new String[3][3];
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t.length;j++){
				t[i][j]="";
			}
		}
		return t;
	}
	public static void jogar(String[][] tabuleiro, int i, int j, String jogador) throws JogoDaVelhaException {
		if(i>=tabuleiro.length||i<0){
			throw new JogoDaVelhaException("Linha Inválida");
		}
		if(j>=tabuleiro.length||j<0){
			throw new JogoDaVelhaException("Coluna Inválida");
		}
		if(tabuleiro[i][j].equals("")){
			tabuleiro[i][j]=jogador;
		} else if(!tabuleiro[i][j].equals("")){
			throw new JogoDaVelhaException("Ja esta marcado!");
		}
	}
	public static boolean existeGanhador(String[][] tabuleiro, String jogador) {
		int vencedor=0;
		//Verifica Ganhador Linha
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if(tabuleiro[i][j].equals(jogador)){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}
			vencedor=0;
		}
		vencedor=0;
		//Verifica Ganhador Coluna
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if(tabuleiro[j][i].equals(jogador)){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}
			vencedor=0;
		}
		vencedor=0;
		//Verifica Ganhador Diagonal Principal
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if(tabuleiro[j][i].equals(jogador)&&(i==j)){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}			
		}
		vencedor=0;
		//Verifica Ganhador Diagonal Secundaria
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if(tabuleiro[j][i].equals(jogador)&&(i+j==tabuleiro.length-1)){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}			
		}
		return false;
	}
	public static Vector interpretrarJogada(String string) {
		String[] dados=string.split(" ");
		Vector jogada=new Vector();
		jogada.add(dados[0]);
		jogada.add(Integer.parseInt(dados[1]));
		jogada.add(Integer.parseInt(dados[2]));
		return jogada;
	}

	public static boolean tabuleiroCheio(String[][] tabuleiro) {
		int t=0;
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if((tabuleiro[i][j].equals("X"))||(tabuleiro[i][j].equals("O"))){
					t++;
				}
			}
		}			
		if(t==9){
			return true;
		}else 
			return false;
	}
}