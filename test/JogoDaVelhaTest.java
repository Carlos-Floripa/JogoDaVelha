import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
public class JogoDaVelhaTest {
	
	@Test
	public void deveInicializarJogoVazio() {
		String[][] tabuleiroEsperado = new String[][] {{"", "", ""}, 
										  			   {"", "", ""}, 
										  			   {"", "", ""}};		
		String[][] tabuleiroEncontrado = JogoDaVelha.inicializar();
		assertArrayEquals(tabuleiroEsperado, tabuleiroEncontrado);
	}
	
	@Test
	public void deveAlterarPosicaoZeroZeroDoTabuleiroComJogadorBola() throws Exception {
		String[][] tabuleiroEsperado = new String[][] {{new String("O"), "", ""}, 
										  			   {"", "", ""}, 
										  			   {"", "", ""}};
		String[][] tabuleiro = new String[][] {{"", "", ""}, 
										  	   {"", "", ""}, 
										  	   {"", "", ""}};
		JogoDaVelha.jogar(tabuleiro, 0, 0, "O");
		assertArrayEquals(tabuleiroEsperado, tabuleiro);
	}

	@Test
	public void deveAlterarPosicaoZeroDoisDoTabuleiroComJogadorXis() throws Exception {
		String[][] tabuleiroEsperado = new String[][] {{"", "",new String("X")}, 
										  			   {"", "", ""}, 
										  			   {"", "", ""}};
		String[][] tabuleiro = new String[][] {{"", "", ""}, 
										  	   {"", "", ""}, 
										  	   {"", "", ""}};
		JogoDaVelha.jogar(tabuleiro, 0, 2, "X");
		assertArrayEquals(tabuleiroEsperado, tabuleiro);
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDeveAlterarPosicaoUmDoisJaOcupadaPeloJogadorBola() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "",new String("O")}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 1, 2, "X");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDeveAlterarPosicaoDoisDoisJaOcupadaPeloJogadorXis() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "",new String("X")}};
		JogoDaVelha.jogar(tabuleiroInicial, 2, 2, "O");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDeveAlterarPosicaoUmUmJaOcupadaPeloProprioJogador() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"",new String("O"), ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 1, 1, "O");
	}
	
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoTresUmForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 3, 1, "O");
	}
	
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoCincoUmForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 5, 1, "O");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoDoisSeisForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 2, 6, "O");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoDoisTresForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 2, 3, "O");
	}
	
	@Test
	public void deveConfirmarGanhadorXisPrimeiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{new String("X"),new String("X"),new String("X")}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");	
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorXisSegundaLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {new String("X"),new String("X"),new String("X")}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorXisTerceiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {new String("X"),new String("X"),new String("X")}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaPrimeiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{new String("O"),new String("O"),new String("O")}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaSegundaLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {new String("O"),new String("O"),new String("O")}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaTerceiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {new String("O"),new String("O"),new String("O")}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisTabuleiroVazio() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");		
		assertFalse(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisPrimeiraLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{new String("X"), "", new String("X")}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisSegundaLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {new String("X"), new String("X"), ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisTerceiraLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", new String("X"),new String("X")}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorXisDiagonal() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"","", new String("X")}, 
										  			  {"", new String("X"), ""}, 
										  			  {new String("X"), "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaDiagonal() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{new String("O"), "", ""}, 
										  			  {"", new String("O"), ""}, 
										  			  {"", "",new String("O")}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertTrue(existeGanhador);
	}
	@Test
	public void naodeveConfirmarGanhadorBolaDiagonal() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{new String("O"), "", ""}, 
										  			  {"", new String("O"), ""}, 
										  			  {"", "",""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	@Test
	public void naodeveConfirmarGanhadorXisDiagonal() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", new String("X")}, 
										  			  {"", new String("X"), ""}, 
										  			  {"", "",""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	@Test
	public void deveConfirmarGanhadorXisPrimeiraColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{new String("X"), "", ""}, 
										  			  {new String("X"), "", ""}, 
										  			  {new String("X"), "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");		
		assertTrue(existeGanhador);
	}
	@Test
	public void deveConfirmarTabuleiroCheio() throws Exception {
		String[][] tabuleiro = new String[][] {{new String("X"), new String("O"), new String("O")}, 
										  		{new String("O"), new String("X"), new String("X")}, 
										  		{new String("X"), new String("X"),new String("O")}};
		boolean existeGanhador = JogoDaVelha.tabuleiroCheio(tabuleiro);	
		assertTrue(existeGanhador);
	}		

	@Test	
	public void deveInterpretarJogada() throws Exception{
		Vector jogadaPassada = new Vector();
		jogadaPassada.add(new String("X"));
		jogadaPassada.add(1);
		jogadaPassada.add(2);
		Vector jogadaEsperada = JogoDaVelha.interpretrarJogada("X 1 2");
		assertEquals(jogadaPassada,jogadaEsperada);
	}
}
