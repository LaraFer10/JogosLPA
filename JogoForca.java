package br.ucsal;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class JogoForca {

	public static void main(String[] args) {
		// Linha 9: criaçao da variavel que conta os erros durante as tentativas do usuário, linha 10: declaraçao da palavra, linha 11-13: alterando as letras da palavra por "_".
		int numErros = 0;
		String[] palavra = obterPalavraOculta(); 
		String[] ultimoResultado = new String[palavra.length]; 
		for(int i = 0; i < palavra.length; i++) {
			ultimoResultado[i] = "_";
		}
		
		construirForca(ultimoResultado, numErros);
		
		String A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
		imprimir("\n\n<<< JOGO DA FORCA >>>\n" + 
				"\n" + 
				"Voce deverá acertar a palavra em 9 tentativas para vencer o jogo.\n");
		Scanner sc = new Scanner(System.in);
		// Linha 24: numero de tentativas que o usuário terá, linha 26-27: for que vai rodar todo o jogo, onde pede a letra, a transforma em maiúscula.
		int numTentativa = 9;
		for (int i = 0; i < numTentativa; i++) { 
			imprimir("\n\nInforme a letra da " + (i+1) + "ª tentativa: ");
			String letra = sc.next().toUpperCase(); 
		// Linha 29-32: Chama o método contem letra, caso tenha, o "_" é substituido pela letra, se nao, começa a contagem dos erros para implementaçao da forca.
			if (contemLetra(palavra, letra)) {
				ultimoResultado = validarJogada(letra, palavra, ultimoResultado);
			} else {
				numErros++;
			}
			
		/* A partir da chamada da forca, linha 38-40: verifica se a quantidade de erros é igual ou maior a 6 (que é o limite da forca) o que significa que o usuario perdeu. 
		 * O break encerra a execuçao do loop. Linha 42-44: chama o método e imprime o resultado de vencedor da jogada.  */
			construirForca(ultimoResultado, numErros);
			if (numErros >= 6) {
				System.out.println("\n\nPerdeu, playboy!");
				break;
			}
			if (ganhouJogo(ultimoResultado)) {
				System.out.println("\n\nO jogo terminou. Você é o grande vencedor!");
				break;
			}
		}
		System.out.println("\n\nFIM DE JOGO");
	}
	
	// Construçao da forca por array, linha 52: Parametro de espaço para separar os "_", linha 96: impressao da forca quando for chamado.
	public static void construirForca(String[] letras, int numErros) {
		String resultado = String.join(" ", letras); 
		String[] passos = new String[7]; 
		passos[0] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |\n" +
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ——--\n\n" + resultado);
		passos[1] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |" + "	 0\n" + 
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ————\n\n" + resultado);
		passos[2] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |" + "	 0\n" + 
				"   |" + "     |\n" +
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ————\n\n" + resultado);
		passos[3] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |" + "	 0\n" + 
				"   |" + "   --|\n" +
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ————\n\n" + resultado);
		passos[4] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |" + "	 0\n" + 
				"   |" + "   --|--\n" +
				"   |\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ————\n\n" + resultado);
		passos[5] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |" + "	 0\n" + 
				"   |" + "   --|--\n" +
				"   |" + "    /\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ————\n\n" + resultado);
		passos[6] = ("    _____\n" + 
				"   |	 |	\n" + 
				"   |" + "	 0\n" + 
				"   |" + "   --|--\n" +
				"   |" + "    / \\"  + "\n" + 
				"   |\n" + 
				"   |\n" + 
				"  ————\n\n" + resultado);
		imprimir(passos[numErros]);
	} 
	
	// O método está verificando se contem a letra informada na palavra.
	public static boolean contemLetra(String[] palavra, String letra) {
		return Arrays.asList(palavra).contains(letra); 
	}
	
	// O método apresenta: Vetor com as palavras, escolha aleatória atráves do Random, a transformaçao da palavra em maiuscula e a quebra da mesma com o split.
	public static String[] obterPalavraOculta() {
		String[] palavras = {"cobra", "FELIZ", "CHUVA", "esgoto", "VERAO", "BRASIL", "comida"};
		Random escolher = new Random ();
		int n = new Random().nextInt(palavras.length);
		String[] palavraselecionada = palavras[n].toUpperCase().split(""); 
		return palavraselecionada;
	}
	// Metodo onde, caso tenha a letra informada pelo usuário exista na palavra, o "_" é substituido por ela.
	public static String[] validarJogada(String letra, String[] palavra, String[] ultimoResultado) {
		for (int i = 0; i < palavra.length; i++) {
			if (palavra[i].equals(letra)) {
				ultimoResultado[i] = letra;
			} 
		}
		return ultimoResultado;
	}

	// O método verifica se contem "_" em ultimoResultado para informar no método main quem foi o vencedor. 
	public static boolean ganhouJogo(String[] ultimoResultado) {
		if (!Arrays.asList(ultimoResultado).contains("_")) {
			return true;
		} else {
			return false;
		}
	} 
	
	public static void imprimir(String txt) {
		System.out.print(txt);
	}
}
