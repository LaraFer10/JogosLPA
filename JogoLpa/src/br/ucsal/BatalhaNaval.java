package br.ucsal;

import java.io.Console;
import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		/*---- BATALHA NAVAL ----*/
		String[][] tabuleiroPlay1 = new String[10][10];
		String[][] tabuleiroPlay2 = new String[10][10];
		int [] jogada = new int[2];
		int[] numeroDeBarcos1 = new int[4];
		int[] numeroDeBarcos2 = new int[4];
		int lin, col, posicao, barco = 0, quantBarco = 0, cont = 0;
		
		
				
				//Esta condição garante que o jogador1 so terá 4 barcos
				while(quantBarco < 4) {
					
					exibirTabuleiro(tabuleiroPlay1);
					System.out.println("##- Jogador 1 (escolha a posição dos barcos) -##");
					tracoHorizontal();
					tracoVertical();
					System.out.print("(1) Porta aviões (5 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(2) Navio Tanque (4 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(3) Contratorpedeiros (3 quadrados);        ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(4) Submarinos (2 quadrados);               ");
					tracoVertical();
					enter();
					tracoHorizontal();
					System.out.println("Escolha um BARCO:");
					
					barco = input.nextInt();
					
					System.out.println("Escolha a LINHA e a COLUNA:");
					lin = input.nextInt();
					col = input.nextInt();
					System.out.println("Escolha (1)VERTICAL e (2)HORIZONTAL:");
					posicao = input.nextInt();
					
					quantBarco = adicionaBarcos(posicao, barco, col, lin, quantBarco, tabuleiroPlay1, numeroDeBarcos1);
						
						
				}
					
				//Esta condição garante que o jogador2 so terá 4 barcos
				quantBarco = 0;
				while(quantBarco < 4) {
					exibirTabuleiro(tabuleiroPlay2);
					System.out.println("##- Jogador 2 (escolha a posição dos barcos) -##");
					tracoHorizontal();
					tracoVertical();
					System.out.print("(1) Porta aviões (5 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(2) Navio Tanque (4 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(3) Contratorpedeiros (3 quadrados);        ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(4) Submarinos (2 quadrados);               ");
					tracoVertical();
					enter();
					tracoHorizontal();
					System.out.println("Escolha um BARCO:");
					
					barco = input.nextInt();
					
					
					System.out.println("Escolha a LINHA e a COLUNA:");
					lin = input.nextInt();
					col = input.nextInt();
					System.out.println("Escolha (1)VERTICAL e (2)HORIZONTAL:");
					posicao = input.nextInt();
					
					quantBarco = adicionaBarcos(posicao, barco, col, lin, quantBarco, tabuleiroPlay2, numeroDeBarcos2);
					
						
				}
				
				
				
			
			
		
	}
	
	//Printa os traços VERTICAIS do menu
	public static void tracoVertical() {
		System.out.print("|");
	}
	//Printa os traços HORIZONTAIS do menu
	public static void tracoHorizontal() {
		System.out.println("|--------------------------------------------|");
	}
	//Enter para exibição das opções do menu
	public static void enter() {
		System.out.print("\n");
	}
	
	/*-------------------------------------- BATALHA NAVAL (( INICIO )) --------------------------------------------*/
	
	//Verifica se o numero de jogadores é valido para executar o jogo e retorna um valor booleano
	public static boolean definirJogadores(String[] vet) {
		if(vet[1] != null) {
			return true;
		}
		return false;
	}
	
	public static int adicionaBarcos(int posicao, int barco, int col, int lin, int quantBarco, String[][] tabuleiro, int[] numeroDeBarcos) {
		
		if(posicao == 1) {
			//Verifica se a posição indicada pelo jogador é compativel com o tamanho do barco
			if(verificaPosicaoVertical(col, tabuleiro, barco)) {
				//Verifica se na posição indicada ja existe um barco para que não tenha sobreescrita
				if(verificaSobreescrita(barco, lin, col, tabuleiro)) {
					// Verifica se um barco ja existe no tabuleiro
					if(verificaBarcoExiste(barco, numeroDeBarcos)) {
					
						posicaoDosBarcosVertical(lin, col, barco, tabuleiro);
						quantBarco++;
						
					}else {
						System.out.println("Este barco já foi escolhido!");
					}
					
				}else {
					System.out.println("Já existe um barco nesta posição!");
				}
				
			}else {
				System.out.println("Posição inválida, verifique a posição digitada!");
			}
		}else if(posicao == 2) {
			if(verificaPosicaoHorizontal(col, tabuleiro, barco)) {
				if(verificaSobreescrita(barco, lin, col, tabuleiro)) {
					
					posicaoDosBarcosHorizontal(lin, col, barco, tabuleiro);
					quantBarco++;
					
				}else {
					System.out.println("Já existe um barco nesta posição!");
				}
			}else {
				System.out.println("Posição inválida, verifique a posição digitada!");
			}
		}
		
		return quantBarco;
	}
	
	public static boolean verificaBarcoExiste(int barco, int[] barcos) {
		int valida=0, posicao;
		for (int i = 0; i < barcos.length; i++) {
			if(barcos[i] == 0) {
				valida++;
			}else if(barcos[i] != barco) {
				valida++;
			}else if(barcos[i] == barco) {
				
				return false;
			}
			
		}
	
			posicao = 4 - valida;
			barcos[posicao] = barco;
			return true;

		
	}
	
	//exibi o tabuleiro para posicionar os barcos ou efetuar jogada
	public static void exibirTabuleiro(String[][] vet) {
		System.out.print("     ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print(i+"   ");
		}
		enter();
		for (int lin = 0; lin < vet.length; lin++) {
			System.out.println("   -----------------------------------------");
			System.out.print(lin+"  ");
			tracoVertical();				
			for(int col = 0; col < vet.length; col++ ) {
				if(vet[lin][col] != null) {
					System.out.print(" "+vet[lin][col]+" ");
				}else {
					
					System.out.print("   ");
				}
				tracoVertical();
			}
			enter();
		}
		System.out.println("   -----------------------------------------");
		
		
	}
	
	//Verifica se a posição indicada pelo oponente existe algum navio e mostra ao jogador
	public static void efetuarJogada(String[][] vet, int[] jogada ) {
		int valido = 0;
		if(vet[jogada[0]][jogada[1]] != null) {
			valido = 1;
		}
		System.out.println("     ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print(i+"   ");
		}
		enter();
		for (int lin = 0; lin < vet.length; lin++) {
			System.out.println("   -----------------------------------------");
			System.out.print(lin+"  ");
			for(int col = 0; col < vet.length; col++ ) {
				tracoVertical();
				if(jogada[0] == lin && jogada[1] == col) {
					
					/*Se a posição indicada pelo jogador na matriz tiver um barco ele retorna o valor
					 * se não, ele retorna 0 indicando que não tem barco*/
					if(valido == 1) {
						
						System.out.print(" "+vet[lin][col]+" ");
					}else {
						vet[lin][col] = "0";
						System.out.print(" "+vet[lin][col]+" ");
					}
				}else {
					System.out.print("   ");
				}
				tracoVertical();
			}
			enter();
			
		}
		System.out.println("   -----------------------------------------");
		
		
	}
	
	// Verifica se o barco vai sobreescrever a posicao de um outro barco no tabuleiro
	
	public static boolean verificaSobreescrita(int tipoBarco, int lin, int col, String[][] vet) {
		int validaV=0, validaH=0;
		if(tipoBarco == 1) {
			for (int i = 0; i < 5; i++) {
				
				if(vet[lin][col]!= null) {
					validaH++;
				}
				col++;
			}
			for (int i = 0; i < 5; i++) {
				
				if(vet[lin][col]!= null) {
					validaV++;
				}
				lin++;
			}
			if(validaH <= 5 && validaH!=0 || validaV <= 5 && validaV!=0) {
				return false;
			}else {
				return true;
			}
			
		}else if(tipoBarco == 2) {
			
			for (int i = 0; i < 4; i++) {
				
				if(vet[lin][col]!= null) {
					validaH++;
				}
				col++;
			}
			for (int i = 0; i < 4; i++) {
				
				if(vet[lin][col]!= null) {
					validaV++;
				}
				lin++;
			}
			if(validaH <= 4 && validaH!=0 || validaV <= 4 && validaV!=0) {
				return false;
			}else {
				return true;
			}
			
			
		}else if(tipoBarco == 3) {
			for (int i = 0; i < 3; i++) {
				
				if(vet[lin][col]!= null) {
					validaH++;
				}
				col++;
			}
			for (int i = 0; i < 3; i++) {
				
				if(vet[lin][col]!= null) {
					validaV++;
				}
				lin++;
			}
			if(validaH <= 3 && validaH!=0 || validaV <= 3 && validaV!=0) {
				return false;
			}else {
				return true;
			}
			
			
		}else if(tipoBarco == 4) {
			for (int i = 0; i < 2; i++) {
				
				if(vet[lin][col]!= null) {
					validaH++;
				}
				col++;
			}
			for (int i = 0; i < 2; i++) {
				
				if(vet[lin][col]!= null) {
					validaV++;
				}
				lin++;
			}
			if(validaH <= 2 && validaH!=0 || validaV <= 2 && validaV!=0) {
				return false;
			}
				return true;
			
			
		}
		return false;
		
	}
	
	public static boolean verificaPosicaoHorizontal(int col, String[][] vet, int barco) {
		
		int verificaCol = col;
		if(barco ==1 ) {
			for (int i = 0; i <= 5; i++) {
				verificaCol++;
			}
			if(verificaCol < vet.length-1) {
				return true;
			}
			return false;
		}else if(barco == 2) {
			for (int i = 0; i <= 4; i++) {
				verificaCol++;
			}
			if(verificaCol < vet.length-1) {
				return true;
			}
			return false;
		}else if(barco == 3) {
			for (int i = 0; i <= 3; i++) {
				verificaCol++;
			}
			if(verificaCol < vet.length-1) {
				return true;
			}
			return false;
		}
		for (int i = 0; i <= 2; i++) {
			verificaCol++;
		}
		if(verificaCol < vet.length-1) {
			return true;
		}
		return false;
		
	}
	

	//Metodo é chamado apos usuario identificar se deseja posicionar o barco na HORIZONTAL
	public static void posicaoDosBarcosHorizontal(int lin, int col, int tipoBarco, String[][] vet) {
		switch(tipoBarco) {
			case 1:
				for (int i = 0; i < 5; i++) {
					
					vet[lin][col] = "X";
					col++;
				}
				break;
			case 2:
				for (int i = 0; i < 4; i++) {
					vet[lin][col] = "X";
					col++;
				}
				break;
			case 3:
				for (int i = 0; i < 3; i++) {
					vet[lin][col] = "X";
					col++;
				}
				break;
			case 4:
				for (int i = 0; i < 2; i++) {
					vet[lin][col] = "X";
					col++;
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}
	
	public static boolean verificaPosicaoVertical(int lin, String[][] vet, int barco) {
		
		int verificaLin = lin;
		if(barco == 1) {
			for (int i = 0; i <= 5; i++) {
				verificaLin++;
			}
			if(verificaLin < vet.length) {
				return true;
			}
			return false;
		}else if(barco == 2) {
			for (int i = 0; i <= 4; i++) {
				verificaLin++;
			}
			if(verificaLin < vet.length) {
				return true;
			}
			return false;
		}else if(barco == 3) {
			for (int i = 0; i <= 3; i++) {
				verificaLin++;
			}
			if(verificaLin < vet.length) {
				return true;
			}
			return false;
		}
		for (int i = 0; i <= 2; i++) {
			verificaLin++;
		}
		if(verificaLin < vet.length) {
			return true;
		}
		return false;
		
	}
	
	//Metodo é chamado apos usuario identificar se deseja posicionar o barco na VERTICAL
	public static void posicaoDosBarcosVertical(int lin, int col, int tipoBarco, String[][] vet) {
		
		switch(tipoBarco) {
			case 1:
				
				for (int i = 0; i <= 5; i++) {
					vet[lin][col] = "X";
					lin++;
				}
				break;
			case 2:
				for (int i = 0; i <= 4; i++) {
					vet[lin][col] = "X";
					lin++;
				}
				break;
			case 3:
				for (int i = 0; i <= 3; i++) {
					vet[lin][col] = "X";
					lin++;
				}
				break;
			case 4:
				for (int i = 0; i <= 2; i++) {
					vet[lin][col] = "X";
					lin++;
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}
	
	
	
	/*-------------------------------------- BATALHA NAVAL (( FINAL )) --------------------------------------------*/
	

}
