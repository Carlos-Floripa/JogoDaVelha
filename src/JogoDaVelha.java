public class JogoDaVelha {
	public static void main(String[] args){}
	public static String[][] inicializar() {
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
				if(tabuleiro[i][j]==jogador){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}
			vencedor=0;
		}
		//Verifica Ganhador Coluna
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if(tabuleiro[j][i]==jogador){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}
			vencedor=0;
		}
		//Verifica Ganhador Diagonal Principal
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if((tabuleiro[i][j]==jogador)&&(i==j)){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}			
		}
		//Verifica Ganhador Diagonal Secundaria
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				if((tabuleiro[i][j]==jogador)&&(i+j==tabuleiro.length-1)){
					vencedor++;
				}
			}
			if(vencedor==3){
				return true;
			}			
		}		
		return false;
	}
}