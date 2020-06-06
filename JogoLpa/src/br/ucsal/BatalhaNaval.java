package br.ucsal;

import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opt;
		String[] vetUsuarios = new String[2]; 
		/*---- BATALHA NAVAL ----*/
		String[][] tabuleiroPlay1 = new String[10][10];
		String[][] tabuleiroPlay2 = new String[10][10];
		int [] jogada = new int[2];
		int[] numeroDeBarcos = new int[4];
		int lin, col, posicao, barco = 0, quantBarco = 0, cont = 0;
		
		//Identifica os usuarios retornando um vetor de nomes
		vetUsuarios = identificaUsuario();
		
		// Leva o usu�rio para a execuss�o do jogo escolhido
		do {
			// Recebe a op��o escolhida pelo usuario
			opt = escolhaMenu(vetUsuarios);
			//Verifica se o usuario digitou numeros negativos
			if(opt < 0) {
				
				System.out.println("Opi��o incorreta!");
			}
			if(opt == 1) {
				
				System.out.println("Jogo da Forca");
			}
			if(opt == 2) {
				
				//Esta condi��o garante que o jogador1 so ter� 4 barcos
				while(quantBarco < 4) {
					exibirTabuleiro(tabuleiroPlay1);
					System.out.println("##- Jogador 1 (escolha a posi��o dos barcos) -##");
					tracoHorizontal();
					tracoVertical();
					System.out.print("(1) Porta avi�es                           ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(2) Navio Tanque                           ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(3) Contratorpedeiros                      ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(4) Submarinos                             ");
					tracoVertical();
					enter();
					tracoHorizontal();
					System.out.println("Escolha um BARCO:");
					if(barco != 0) {
						barco = 0;
					}
					barco = input.nextInt();
					
					/*Verifica se o barco ja foi adicionado	ao tabuleiro, sen�o ele � adicionado 
					 * ao vetor de barcos do jogador e adicionado ao tabuleiro usando o processo de empilhamento
					
					for (int i = 0; i < numeroDeBarcos.length; i++) {
						if(barco == numeroDeBarcos[i]) {
							cont = 1;
						}
						if(i != 0) {
							//se o barco ja tiver sido add ent�o n�o passa pelo processo de empilhamento
							if(cont != 1) {
								
								//se o vetor na posi��o anterior a posi��o atual � 'vazio' para poder add o barco
								if(numeroDeBarcos[i-1] == 0) {
									numeroDeBarcos[i-1] = barco;
								}else if(numeroDeBarcos[i] == 0){
									//se o vetor na posi��o atual � 'vazio' para poder add o barco
									numeroDeBarcos[i] = barco;
								}else if(numeroDeBarcos[i+1] == 0) {
									//se o vetor na posi��o a frente a posi��o atual � 'vazio' para poder add o barco
									numeroDeBarcos[i+1] = barco;
								}
							}
						}else {
							if(numeroDeBarcos[i] == 0){
								numeroDeBarcos[i] = barco;
							}
						}
					}
					
					if(cont == 1) {
						
						System.out.println("Este barco ja foi escolhido!");	
					}else {
					 * */
						
						System.out.println("Escolha a LINHA e a COLUNA:");
						lin = input.nextInt();
						col = input.nextInt();
						System.out.println("Escolha (1)VERTICAL e (2)HORIZONTAL:");
						posicao = input.nextInt();
						if(posicao == 1) {
							posicaoDosBarcosVertical(lin, col, barco, tabuleiroPlay1);
						}else if(posicao == 2) {
							posicaoDosBarcosHorizontal(lin, col, barco, tabuleiroPlay1);
						}
					
					
					quantBarco++;
					
				}
					
				//Esta condi��o garante que o jogador2 so ter� 4 barcos

				for (int i = 0; i < numeroDeBarcos.length; i++) {
					exibirTabuleiro(tabuleiroPlay2);
					System.out.println("##- Jogador 2 (escolha a posi��o dos barcos) -##");
					tracoHorizontal();
					tracoVertical();
					System.out.print("(1) Porta avi�es                           ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(2) Navio Tanque                           ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(3) Contratorpedeiros                      ");
					tracoVertical();
					enter();
					tracoVertical();
					System.out.print("(4) Submarinos                             ");
					tracoVertical();
					enter();
					tracoHorizontal();
					System.out.println("Escolha um BARCO:");
					if(barco != 0) {
						barco = 0;
					}
					barco = input.nextInt();
					//Verifica se o barco ja foi adicionado	
					if(barco != numeroDeBarcos[i]) {
						System.out.println("Escolha a LINHA e a COLUNA:");
						lin = input.nextInt();
						col = input.nextInt();
						System.out.println("Escolha (1)VERTICAL e (2)HORIZONTAL:");
						posicao = input.nextInt();
						if(posicao == 1) {
							posicaoDosBarcosVertical(lin, col, barco, tabuleiroPlay2);
						}else if(posicao == 2) {
							posicaoDosBarcosHorizontal(lin, col, barco, tabuleiroPlay2);
						}
								
								
					}else {
						System.out.println("Este barco ja foi escolhido!");
								
					}
					
						
				}
				
				
				
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
	
	/*Printa na tela o menu junto com as op��es escolhidas pelo usuario
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
		System.out.println("##-------- Este � o menu de jogos! --------##");
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
		System.out.println("Escolha uma op��o:");
		opcao = input.nextInt();
		return opcao;
	}
	//Printa os tra�os VERTICAIS do menu
	public static void tracoVertical() {
		System.out.print("|");
	}
	//Printa os tra�os HORIZONTAIS do menu
	public static void tracoHorizontal() {
		System.out.println("|--------------------------------------------|");
	}
	//Enter para exibi��o das op��es do menu
	public static void enter() {
		System.out.print("\n");
	}
	
	/*-------------------------------------- BATALHA NAVAL (( INICIO )) --------------------------------------------*/
	
	//Verifica se o numero de jogadores � valido para executar o jogo e retorna um valor booleano
	public static boolean definirJogadores(String[] vet) {
		if(vet.length == 2) {
			return true;
		}
		return false;
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
	
	//Verifica se a posi��o indicada pelo oponente existe algum navio e mostra ao jogador
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
					
					/*Se a posi��o indicada pelo jogador na matriz tiver um barco ele retorna o valor
					 * se n�o, ele retorna 0 indicando que n�o tem barco*/
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

	//Metodo � chamado apos usuario identificar se deseja posicionar o barco na HORIZONTAL
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
				System.out.println("Op��o inv�lida!");
				break;
		}
	}
	
	//Metodo � chamado apos usuario identificar se deseja posicionar o barco na VERTICAL
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
				System.out.println("Op��o inv�lida!");
				break;
		}
	}
	
	
	
	/*-------------------------------------- BATALHA NAVAL (( FINAL )) --------------------------------------------*/
	

}
