package br.ucsal;

import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		int opt;
		String[] vetUsuarios = new String[2]; 
		
		//Identifica os usuarios retornando um vetor de nomes
		vetUsuarios = identificaUsuario();
		
		// Leva o usuário para a execussão do jogo escolhido
		do {
			// Recebe a opção escolhida pelo usuario
			opt = escolhaMenu(vetUsuarios);
			//Verifica se o usuario digitou numeros negativos
			if(opt < 0) {
				
				System.out.println("Opição incorreta!");
			}
			if(opt == 1) {
				
				System.out.println("Jogo da Forca");
			}
			if(opt == 2) {
				
				System.out.println("Batalha Naval");
			}
			if(opt == 3) {
				
				System.out.println("Campo Minado");
			}
			
			
		}while(opt < 4);
		System.out.println("##--- Fim! Esperamos que tenha se divertido! :) ---##");
		
	}
	
	//Identifica os Usuarios que vao jogar e retorna um vetor com nomes para o main
	public static String[] identificaUsuario() {
		String[] usuarios = new String[2];
		String respo;
		Scanner input = new Scanner(System.in);
		tracoHorizontal();
		tracoVertical();
		System.out.print("------ Bem-Vindo ao Jogos Divertidos! ------");
		tracoVertical();
		enter();
		tracoHorizontal();
		System.out.println("Identifique-se com seu Nome:");
		usuarios[0] = input.next();
		System.out.println("Existe outro jogador? (sim | nao)");
		respo = input.next();
		if(respo == "sim") {
			System.out.println("Identifique o outro jogador com o Nome:");
			usuarios[1] = input.next();
		}else {
			return usuarios;
		}
		return usuarios;
	}
	
	/*Printa na tela o menu junto com as opções escolhidas pelo usuario
	* e retorna o numero digitado para a classe principal
	*/
	public static int escolhaMenu(String[] usuarios) {
		Scanner input = new Scanner(System.in);
		int opcao;
		if(usuarios[1]!= null) {
			
			System.out.println("## Bem-Vindos(as) "+usuarios[0]+" e "+usuarios[1]+" ##");
		}else {
			System.out.println("## Bem-Vindo(a) "+usuarios[0]+" ##");
		}
		System.out.println("##-------- Este é o menu de jogos! --------##");
		tracoHorizontal();
		tracoVertical();
		System.out.print("(1) Jogo da Forca                           ");
		tracoVertical();
		enter();
		tracoVertical();
		System.out.print("(2) Batalha Naval                           ");
		tracoVertical();
		enter();
		tracoVertical();
		System.out.print("(3) Campo Minado                            ");
		tracoVertical();
		enter();
		tracoVertical();
		System.out.print("(4) Sair                                    ");
		tracoVertical();
		enter();
		tracoHorizontal();
		System.out.println("Escolha uma opção:");
		opcao = input.nextInt();
		return opcao;
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
		if(vet.length == 2) {
			return true;
		}
		return false;
	}
	
	//exibi o tabuleiro para posicionar os barcos ou efetuar jogada
	public static void exibirTabuleiro(String[][] vet, int[] numero ) {
		for (int i = 0; i < vet.length; i++) {
			System.out.print(i+" ");
		}
		enter();
		for (int lin = 0; lin < vet.length; lin++) {
			System.out.println("------------------------------------------------------------");
			System.out.print(lin+" ");
			for(int col = 0; col < vet.length; col++ ) {
				tracoVertical();				
				System.out.println("   ");
				tracoVertical();
			}
			
		}
		
		
	}
	
	//Verifica se a posição indicada pelo oponente existe algum navio e mostra ao jogador
	public static void efetuarJogada(String[][] vet, int[] jogada ) {
		int valido = 0;
		if(vet[jogada[0]][jogada[1]] != null) {
			valido = 1;
		}
		for (int i = 0; i < vet.length; i++) {
			System.out.print(i+" ");
		}
		enter();
		for (int lin = 0; lin < vet.length; lin++) {
			System.out.println("------------------------------------------------------------");
			System.out.print(lin+" ");
			for(int col = 0; col < vet.length; col++ ) {
				tracoVertical();
				if(jogada[0] == lin && jogada[1] == col && valido == 1) {
					System.out.println(vet[lin][col]);
				}else {
					System.out.println(" ");
				}
				tracoVertical();
			}
			
		}
		
		
	}

	//Metodo é chamado apos usuario identificar se deseja posicionar o barco na HORIZONTAL
	public static void posicaoDosBarcosHorizontal(int lin, int col, int tipoBarco, String[][] vet) {
		switch(tipoBarco) {
			case 1:
				for (int i = col; i < 5; i++) {
					vet[lin][i] = "X";
				}
				break;
			case 2:
				for (int i = col; i < 4; i++) {
					vet[lin][i] = "X";
				}
				break;
			case 3:
				for (int i = col; i < 3; i++) {
					vet[lin][i] = "X";
				}
				break;
			case 4:
				for (int i = col; i < 2; i++) {
					vet[lin][i] = "X";
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}
	
	//Metodo é chamado apos usuario identificar se deseja posicionar o barco na VERTICAL
	public static void posicaoDosBarcosVertical(int lin, int col, int tipoBarco, String[][] vet) {
		switch(tipoBarco) {
			case 1:
				for (int i = lin; i <= 5; i++) {
					vet[i][col] = "X";
				}
				break;
			case 2:
				for (int i = lin; i <= 4; i++) {
					vet[i][col] = "X";
				}
				break;
			case 3:
				for (int i = lin; i <= 3; i++) {
					vet[i][col] = "X";
				}
				break;
			case 4:
				for (int i = lin; i <= 2; i++) {
					vet[i][col] = "X";
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}
	
	
	
	/*-------------------------------------- BATALHA NAVAL (( FINAL )) --------------------------------------------*/
	

}
