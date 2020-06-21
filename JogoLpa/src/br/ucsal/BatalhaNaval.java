package br.ucsal;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BatalhaNaval {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*---- BATALHA NAVAL ----*/
		String[][] tabuleiroPlay1 = new String[10][10];
		String[][] tabuleiroPlay2 = new String[10][10];
		String[][] tabuleiroJog1 = new String[10][10];
		String[][] tabuleiroJog2 = new String[10][10];
		int[] jogada = new int[2];
		int[] numeroDeBarcos1 = new int[4];
		int[] numeroDeBarcos2 = new int[4];
		int[] numeroDeBarcosAfundados1 = new int[4];
		int[] numeroDeBarcosAfundados2 = new int[4];
		int lin, col, posicao, barco = 0, quantBarco = 0, cont = 0, cont2 = 0, resposta = 0, acertos = 0, acertos2 = 0;
		int retorno, quant=0, fimJogo = 0;
		

		/* |---BARCOS---|
		 * barco[0] = primeira linha que navio foi add
		 * barco[1] = primeira coluna que nabio foi add
		 * barco[2] = orientação(se foi VERTICAL-1 ou se foi HORIZONTAL-2)
		 * barco[3] = quantidade de quadrados do barco
		 * 
		 * */
		int[] portaAvioes = new int[4];
		int[] navioTanque = new int[4];
		int[] contraTorpedo = new int[4];
		int[] submarinos = new int[4];
		
		int[] portaAvioes2 = new int[4];
		int[] navioTanque2 = new int[4];
		int[] contraTorpedo2 = new int[4];
		int[] submarinos2 = new int[4];


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
			
			if(barco > 4 || barco < 0) {
				System.out.println("Opção inválida!");
				while(barco > 4 || barco < 0) {
					System.out.println("Escolha um BARCO:");

					barco = input.nextInt();
				}
			}
			
			System.out.println("Escolha a LINHA e a COLUNA:");
			lin = input.nextInt();
			col = input.nextInt();
			System.out.println("Escolha (1)VERTICAL e (2)HORIZONTAL:");
			posicao = input.nextInt();
			Jogo.cls();

			/*O metodo adicionaBarcos() recebe os parametros e verifica se o barco ja foi adicionado
				caso o barco não tenha sido adicionado, ele coloca o barco no tabuleiro e salva seu
				codigo no vetor numeroDeBarcos1[]
			*/
			if(lin > 9 || col > 9) {
				while(lin > 9 || col > 9) {
					exibirTabuleiro(tabuleiroPlay1);
					Jogo.imprimirln("##- Jogador 1 (escolha a posição dos barcos) -##");
					tracoHorizontal();
					tracoVertical();
					Jogo.imprimir("(1) Porta aviões (5 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					Jogo.imprimir("(2) Navio Tanque (4 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					Jogo.imprimir("(3) Contratorpedeiros (3 quadrados);        ");
					tracoVertical();
					enter();
					tracoVertical();
					Jogo.imprimir("(4) Submarinos (2 quadrados);               ");
					tracoVertical();
					enter();
					tracoHorizontal();
					Jogo.imprimir("Escolha um BARCO:");
	
					barco = input.nextInt();
					
					if(barco > 4 || barco < 0) {
						Jogo.imprimirln("Opção inválida!");
						while(barco > 4 || barco < 0) {
							Jogo.imprimirln("Escolha um BARCO:");
	
							barco = input.nextInt();
						}
					}
					
					Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
					lin = input.nextInt();
					col = input.nextInt();
					Jogo.imprimirln("Escolha (1)VERTICAL e (2)HORIZONTAL:");
					posicao = input.nextInt();
				}
				Jogo.cls();
			}
			
			quantBarco = adicionaBarcos(posicao, barco, col, lin, quantBarco, tabuleiroPlay1, numeroDeBarcos1);

			/*Adiciona as especificações dos barcos adicionados pelo JOGADOR 1 um para que
			 * mais tarde possa identificar se este barco foi afundado*/
			switch(barco) {
			case 1:
				portaAvioes[0] = lin;
				portaAvioes[1] = col;
				portaAvioes[2] = posicao;
				portaAvioes[3] = 5;
				break;
			case 2:
				navioTanque[0] = lin;
				navioTanque[1] = col;
				navioTanque[2] = posicao;
				navioTanque[3] = 4;
				break;
			case 3:
				contraTorpedo[0] = lin;
				contraTorpedo[1] = col;
				contraTorpedo[2] = posicao;
				contraTorpedo[3] = 3;
				
				break;
			case 4:
				submarinos[0] = lin;
				submarinos[1] = col;
				submarinos[2] = posicao;
				submarinos[3] = 2;
				break;
			}

		}

		exibirTabuleiro(tabuleiroPlay1);
		sleep();
		//Esta condição garante que o jogador2 so terá 4 barcos
		quantBarco = 0;
		Jogo.cls();
		while(quantBarco < 4) {
			exibirTabuleiro(tabuleiroPlay2);
			Jogo.imprimirln("##- Jogador 2 (escolha a posição dos barcos) -##");
			tracoHorizontal();
			tracoVertical();
			Jogo.imprimir("(1) Porta aviões (5 quadrados);             ");
			tracoVertical();
			enter();
			tracoVertical();
			Jogo.imprimir("(2) Navio Tanque (4 quadrados);             ");
			tracoVertical();
			enter();
			tracoVertical();
			Jogo.imprimir("(3) Contratorpedeiros (3 quadrados);        ");
			tracoVertical();
			enter();
			tracoVertical();
			Jogo.imprimir("(4) Submarinos (2 quadrados);               ");
			tracoVertical();
			enter();
			tracoHorizontal();
			Jogo.imprimir("Escolha um BARCO:");

			barco = input.nextInt();

			if(barco > 4 || barco < 0) {
				Jogo.imprimirln("Opção inválida!");
				while(barco > 4 || barco < 0) {
					Jogo.imprimirln("Escolha um BARCO:");

					barco = input.nextInt();
				}
			}
			Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
			lin = input.nextInt();
			col = input.nextInt();
			Jogo.imprimirln("Escolha (1)VERTICAL e (2)HORIZONTAL:");
			posicao = input.nextInt();
			Jogo.cls();

			/*O metodo adicionaBarcos() recebe os parametros e verifica se o barco ja foi adicionado
			caso o barco não tenha sido adicionado, ele coloca o barco no tabuleiro e salva seu
			codigo no vetor numeroDeBarcos1[]
		*/
			if(lin > 9 || col > 9) {
				Jogo.imprimirln("Acho que você digitou errado, tente novamente.");
				while(lin > 9 || col > 9) {
					exibirTabuleiro(tabuleiroPlay2);
					Jogo.imprimirln("##- Jogador 2 (escolha a posição dos barcos) -##");
					tracoHorizontal();
					tracoVertical();
					Jogo.imprimir("(1) Porta aviões (5 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					Jogo.imprimir("(2) Navio Tanque (4 quadrados);             ");
					tracoVertical();
					enter();
					tracoVertical();
					Jogo.imprimir("(3) Contratorpedeiros (3 quadrados);        ");
					tracoVertical();
					enter();
					tracoVertical();
					Jogo.imprimir("(4) Submarinos (2 quadrados);               ");
					tracoVertical();
					enter();
					tracoHorizontal();
					Jogo.imprimirln("Escolha um BARCO:");

					barco = input.nextInt();

					if(barco > 4 || barco < 0) {
						Jogo.imprimirln("Opção inválida!");
						while(barco > 4 || barco < 0) {
							Jogo.imprimirln("Escolha um BARCO:");

							barco = input.nextInt();
						}
					}
					Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
					lin = input.nextInt();
					col = input.nextInt();
					Jogo.imprimirln("Escolha (1)VERTICAL e (2)HORIZONTAL:");
					posicao = input.nextInt();
				}
				Jogo.cls();

			}
			quantBarco = adicionaBarcos(posicao, barco, col, lin, quantBarco, tabuleiroPlay2, numeroDeBarcos2);
			
			/*Adiciona as especificações dos barcos adicionados pelo JOGADOR 1 um para que
			 * mais tarde possa identificar se este barco foi afundado*/
			switch(barco) {
			case 1:
				portaAvioes2[0] = lin;
				portaAvioes2[1] = col;
				portaAvioes2[2] = posicao;
				portaAvioes2[3] = 5;
				break;
			case 2:
				navioTanque2[0] = lin;
				navioTanque2[1] = col;
				navioTanque2[2] = posicao;
				navioTanque2[3] = 4;
				break;
			case 3:
				contraTorpedo2[0] = lin;
				contraTorpedo2[1] = col;
				contraTorpedo2[2] = posicao;
				contraTorpedo2[3] = 3;
				
				break;
			case 4:
				submarinos2[0] = lin;
				submarinos2[1] = col;
				submarinos2[2] = posicao;
				submarinos2[3] = 2;
				break;
			}

		}
		exibirTabuleiro(tabuleiroPlay2);
		sleep();
		
		//Inicia o jogo com as rodadas alternadas 
		while (fimJogo == 0) { 
			if (cont == 3) {
				cont = 0;
			} else if (cont == 1) {
				Jogo.cls();
				Jogo.imprimir("\n   -------------Vez do Jogador 1------------\n");
				exibirTabuleiro(tabuleiroJog2);
				do {
					if (cont2 > 0) {
						Jogo.imprimirln("Essa jogada já foi realizada.Informe uma posição válida.\n");
					}
					Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
					jogada[0] = input.nextInt();
					jogada[1] = input.nextInt();
					if(jogada[0] > 9 || jogada[1] > 9) {
						Jogo.imprimirln("Acho que você digitou errado, tente novamente.");
						while(jogada[0] > 9 || jogada[1] > 9) {
							Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
							jogada[0] = input.nextInt();
							jogada[1] = input.nextInt();
						}
					}
					cont2++;
				} while (tabuleiroJog2[jogada[0]][jogada[1]] == "x" || tabuleiroJog2[jogada[0]][jogada[1]] == "~");
				Jogo.cls();
				//Chama o metodo para efetuar jogadas e retorna o incremento de acertos
				acertos = efetuarJogada(tabuleiroPlay2, tabuleiroJog2, jogada, acertos);
				if(acertos == 14) {
					fimJogo = 1;
				}
				//Esta condição verifica se o JOGADOR 1 conseguiu afundar algum barco inimigo
				for (int i = 0; i < 4; i++) {
					quant = 0;
					if(i==0) {
						
						if(numeroDeBarcosAfundados1[i] == 0) {
							
							retorno=verificaBarco(portaAvioes2, tabuleiroJog2);
							for (int j = 0; j < numeroDeBarcos2.length; j++) {
								if(retorno == numeroDeBarcos2[j]) {
									numeroDeBarcosAfundados1[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um PORTA AVIÕES inimigo!");
							}
						}
						
					}
					if(i ==1) {
						if(numeroDeBarcosAfundados1[i] == 0) {
							
							retorno = verificaBarco(navioTanque2, tabuleiroJog2);
							for (int j = 0; j < numeroDeBarcos2.length; j++) {
								if(retorno == numeroDeBarcos2[j]) {
									numeroDeBarcosAfundados1[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um NAVIO TANQUE inimigo!");
							}
						}
					}
					if(i == 2) {
						if(numeroDeBarcosAfundados1[i] == 0) {
							
							retorno = verificaBarco(contraTorpedo2, tabuleiroJog2);
							for (int j = 0; j < numeroDeBarcos2.length; j++) {
								if(retorno == numeroDeBarcos2[j]) {
									numeroDeBarcosAfundados1[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um CONTRATORPEDO inimigo!");
							}
						}
					}
					if(i == 3) {
						if(numeroDeBarcosAfundados1[i] == 0) {
								
							retorno = verificaBarco(submarinos2, tabuleiroJog2);
							for (int j = 0; j < numeroDeBarcos2.length; j++) {
								if(retorno == numeroDeBarcos2[j]) {
									numeroDeBarcosAfundados1[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um SUBMARINO inimigo!");
							}
						}
					}
				}
				exibirTabuleiro(tabuleiroJog2);
				sleep();
				cont2 = 0;
			} else if (cont == 2) {
				Jogo.cls();
				Jogo.imprimir("\n   -------------Vez do Jogador 2------------\n");
				exibirTabuleiro(tabuleiroJog1);
				do {
					if (cont2 > 0) {
						Jogo.imprimirln("Essa jogada já foi realizada.Informe uma posição válida.\n");
					}
					Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
					jogada[0] = input.nextInt();
					jogada[1] = input.nextInt();
					if(jogada[0] > 9 || jogada[1] > 9) {
						Jogo.imprimirln("Acho que você digitou errado, tente novamente.");
						while(jogada[0] > 9 || jogada[1] > 9) {
							Jogo.imprimirln("Escolha a LINHA e a COLUNA:");
							jogada[0] = input.nextInt();
							jogada[1] = input.nextInt();
						}
					}
					cont2++;// talvez não funcione. rever boolean.
				} while (tabuleiroJog1[jogada[0]][jogada[1]] == "x" || tabuleiroJog1[jogada[0]][jogada[1]] == "~");
				Jogo.cls();
				//Chama o metodo para efetuar jogadas e retorna o incremento de acertos
				acertos2 = efetuarJogada(tabuleiroPlay1, tabuleiroJog1, jogada, acertos2);
				if(acertos2 == 14) {
					fimJogo = 1;
				}
				//Esta condição verifica se o JOGADOR 2 conseguiu afundar algum barco inimigo
				for (int i = 0; i < 4; i++) {
					quant = 0;
					if(i==0) {
						if(numeroDeBarcosAfundados2[i] == 0) {
							retorno=verificaBarco(portaAvioes, tabuleiroJog1);
							for (int j = 0; j < numeroDeBarcos1.length; j++) {
								if(retorno == numeroDeBarcos1[j]) {
									numeroDeBarcosAfundados2[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								System.out.println("Afundou um PORTA AVIÕES inimigo!");
							}
						}
						
					}
					if(i ==1) {
						if(numeroDeBarcosAfundados2[i] == 0) {
							retorno = verificaBarco(navioTanque, tabuleiroJog1);
							for (int j = 0; j < numeroDeBarcos1.length; j++) {
								if(retorno == numeroDeBarcos1[j]) {
									numeroDeBarcosAfundados2[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um NAVIO TANQUE inimigo!");
							}
						}
					}
					if(i == 2) {
						if(numeroDeBarcosAfundados2[i] == 0) {
							retorno = verificaBarco(contraTorpedo, tabuleiroJog1);
							for (int j = 0; j < numeroDeBarcos1.length; j++) {
								if(retorno == numeroDeBarcos1[j]) {
									numeroDeBarcosAfundados2[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um CONTRATORPEDO inimigo!");
							}
						}
					}
					if(i == 3) {
						if(numeroDeBarcosAfundados2[i] == 0) {
							retorno = verificaBarco(submarinos, tabuleiroJog1);
							for (int j = 0; j < numeroDeBarcos1.length; j++) {
								if(retorno == numeroDeBarcos1[j]) {
									numeroDeBarcosAfundados2[i] = retorno;
									quant++;
								}
							}
							if(quant > 0) {
								Jogo.imprimirln("Afundou um SUBMARINO inimigo!");
							}
						}
					}
				}
				exibirTabuleiro(tabuleiroJog1);
				sleep();
			}
			cont++;
			cont2 = 0;
		}

		if (acertos > acertos2) {
			Jogo.cls();
			tracoHorizontal();
			tracoVertical();
			Jogo.imprimir("-------------Jogador 1 VENCEU!--------------");
			tracoVertical();
			enter();
			tracoHorizontal();
			exibirTabuleiro(tabuleiroJog2);
		} else {
			tracoHorizontal();
			tracoVertical();
			Jogo.imprimir("-------------Jogador 2 VENCEU!--------------");
			tracoVertical();
			enter();
			tracoHorizontal();
			exibirTabuleiro(tabuleiroJog1);
		}

		do {
			Jogo.imprimirln("Informe uma das opções: \n(1) Jogar novamente\n(2) Voltar ao Menu");
			resposta = input.nextInt();
		} while (resposta != 1 && resposta != 2);
		if(resposta ==1) {
			Jogo.cls();
			BatalhaNaval.main(args);
		} else {
			Jogo.cls();
			Jogo.escolhaMenu(args);
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
	
	public static void sleep() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Timer timer = new Timer();
        timer.schedule(null, 3000);;*/
	}

	/*-------------------------------------- BATALHA NAVAL (( INICIO )) --------------------------------------------*/

	/*Verifica no tabuleiro inimigo se algum barco ja foi afundado
	 * recebendo um barco inimigo com suas especificações e comparando 
	 * com o tabuleiro*/
	public static int verificaBarco(int[] barco, String[][] tabuleiro) {
		int validador = 0, col = barco[1], lin = barco[0];

		//PORTA AVIÕES
		if(barco[3] == 5) {
			//Barco na VERTICAL
			if(barco[2] == 1) {
				for (int i = 0; i < 5; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					lin++;
				}
				if(validador == 5) {
					return 1;
				}

			}
			//Barco na HORIZONTAL
			if(barco[2] == 2) {
				for (int i = 0; i < 5; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					col++;
				}
				if(validador == 5) {
					return 1;
				}

			}
		}

		//NAVIO TANQUE
		if(barco[3] == 4) {
			//Barco na VERTICAL
			if(barco[2] == 1) {
				for (int i = 0; i < 4; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					lin++;
				}
				if(validador == 4) {
					return 2;
				}

			}
			//Barco na HORIZONTAL
			if(barco[2] == 2) {
				for (int i = 0; i < 4; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					col++;
				}
				if(validador == 4) {
					return 2;
				}

			}
		}

		//CONTRATORPEDOS
		if(barco[3] == 3) {
			//Barco na VERTICAL
			if(barco[2] == 1) {
				for (int i = 0; i < 3; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					lin++;
				}
				if(validador == 3) {
					return 3;
				}

			}
			//Barco na HORIZONTAL
			if(barco[2] == 2) {
				for (int i = 0; i < 3; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					col++;
				}
				if(validador == 3) {
					return 3;
				}

			}
		}

		//SUBMARINO
		if(barco[3] == 2) {
			//Barco na VERTICAL
			if(barco[2] == 1) {
				for (int i = 0; i < 2; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					lin++;
				}
				if(validador == 2) {
					return 4;
				}

			}
			//Barco na HORIZONTAL
			if(barco[2] == 2) {
				for (int i = 0; i < 2; i++) {

					if(tabuleiro[lin][col] != null) {
						validador++;
					}
					col++;
				}
				if(validador == 2) {
					return 4;
				}
	
			}
		}
		
		return 0;
	}


	//Verifica se o numero de jogadores é valido para executar o jogo e retorna um valor booleano
	public static boolean definirJogadores(String[] vet) {
		if(vet[1] != null) {
			return true;
		}
		return false;
	}

	/*Metodo para adicionar os barcos ao tabuleiro do jogador*/
	public static int adicionaBarcos(int posicao, int barco, int col, int lin, int quantBarco, String[][] tabuleiro, int[] numeroDeBarcos) {

		if(posicao == 1) {
			//Verifica se a posição indicada pelo jogador é compativel com o tamanho do barco
			if(verificaPosicaoVertical(lin, tabuleiro, barco)) {
				//Verifica se na posição indicada ja existe um barco para que não tenha sobreescrita
				if(verificaSobreescrita(barco, lin, col, tabuleiro)) {
					// Verifica se um barco ja existe no tabuleiro
					if(verificaBarcoExiste(barco, numeroDeBarcos)) {

						posicaoDosBarcosVertical(lin, col, barco, tabuleiro);
						quantBarco++;

					}else {
						Jogo.imprimirln("Este barco já foi escolhido!");
					}

				}else {
					Jogo.imprimirln("Já existe um barco nesta posição!");
				}

			}else {
				Jogo.imprimirln("Posição inválida, verifique a posição digitada!");
			}
		}else if(posicao == 2) {
			if(verificaPosicaoHorizontal(col, tabuleiro, barco)) {
				if(verificaSobreescrita(barco, lin, col, tabuleiro)) {
					if(verificaBarcoExiste(barco, numeroDeBarcos)) {

						posicaoDosBarcosHorizontal(lin, col, barco, tabuleiro);
						quantBarco++;

					}else {
						Jogo.imprimirln("Este barco já foi escolhido!");
					}

				}else {
					Jogo.imprimirln("Já existe um barco nesta posição!");
				}
			}else {
				Jogo.imprimirln("Posição inválida, verifique a posição digitada!");
			}
		}

		return quantBarco;
	}

	//Verifica se o barco ja foi adicionado ao tabuleiro para evitar que o usuario adicione o mesmo barco 2x
	public static boolean verificaBarcoExiste(int barco, int[] barcos) {
		int valida=0, posicao;
		for (int i = 0; i < barcos.length; i++) {
			if(barcos[i] == 0) {
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
			Jogo.imprimir(i+"   ");
		}
		enter();
		for (int lin = 0; lin < vet.length; lin++) {
			Jogo.imprimirln("   -----------------------------------------");
			Jogo.imprimir(lin+"  ");
			tracoVertical();				
			for(int col = 0; col < vet.length; col++ ) {
				if(vet[lin][col] != null) {
					Jogo.imprimir(" "+vet[lin][col]+" ");
				}else {

					Jogo.imprimir("   ");
				}
				tracoVertical();
			}
			enter();
		}
		Jogo.imprimir("   -----------------------------------------");

	}

	//Verifica se a posição indicada pelo oponente existe algum navio e mostra ao jogador
	public static int efetuarJogada(String[][] vet, String[][] vet2, int[] jogada, int acerto) {

		// o (vet) se refe ao tabuleiro onde os valores dos barcos estão guardados. O
		// vet2 é o tabuleiro que armazenará os acertos

		if (vet[jogada[0]][jogada[1]] != null)// ou == "x", ou int x = "x"<- reconsiderar em x dos barcos tbm(caso
			// necessite);
		{
			vet2[jogada[0]][jogada[1]] = "x";
			Jogo.imprimir("\nVocê acertou!\n");
				
			acerto++;

		} else {
			vet2[jogada[0]][jogada[1]] = "~";
			Jogo.imprimir("\nVocê errou!\n");
			return acerto;
		}

		return acerto;
	}

	// Verifica se o barco vai sobreescrever a posicao de um outro barco no tabuleiro

	public static boolean verificaSobreescrita(int tipoBarco, int lin, int col, String[][] vet) {
		int validaV=0, validaH=0, c = col, l = lin;
		if(tipoBarco == 1) {
			if(col < 9) {

				for (int i = 0; i < 5; i++) {
					if(c <=9) {
						
						if(vet[lin][c]!= null) {
							validaH++;
						}
						c++;
					}
				}
			}
			if(lin < 9) {

				for (int i = 0; i < 5; i++) {
					if(l<= 9) {
						if(vet[l][col]!= null) {
							validaV++;
						}
						l++;
					}
				}
			}
			if(validaH <= 5 && validaH!=0 || validaV <= 5 && validaV!=0) {
				return false;
			}else {
				return true;
			}

		}else if(tipoBarco == 2) {
			if(col < 9) {

				for (int i = 0; i < 4; i++) {
					if(c <=9) {
						
						if(vet[lin][c]!= null) {
							validaH++;
						}
						c++;
					}
				}
			}

			if(lin < 9) {
				for (int i = 0; i < 4; i++) {
					if(l<= 9) {
						if(vet[l][col]!= null) {
							validaV++;
						}
						l++;
					}
				}
			}

			if(validaH <= 4 && validaH!=0 || validaV <= 4 && validaV!=0) {
				return false;
			}else {
				return true;
			}


		}else if(tipoBarco == 3) {
			if(col < 9) {
				for (int i = 0; i < 3; i++) {
					if(c <=9) {
						
						if(vet[lin][c]!= null) {
							validaH++;
						}
						c++;
					}
				}
			}

			if(lin < 9) {
				for (int i = 0; i < 3; i++) {
					if(l<= 9) {
						if(vet[l][col]!= null) {
							validaV++;
						}
						l++;
					}
				}
			}

			if(validaH <= 3 && validaH!=0 || validaV <= 3 && validaV!=0) {
				return false;
			}else {
				return true;
			}


		}else if(tipoBarco == 4) {
			if(col < 9) {
				for (int i = 0; i < 2; i++) {
					if(c <=9) {
						
						if(vet[lin][c]!= null) {
							validaH++;
						}
						c++;
					}
				}
			}

			if(lin < 9) {
				for (int i = 0; i < 2; i++) {
					if(l<= 9) {
						if(vet[l][col]!= null) {
							validaV++;
						}
						l++;
					}
				}
			}
			if(validaH <= 2 && validaH!=0 || validaV <= 2 && validaV!=0) {
				return false;
			}
			return true;


		}
		return false;

	}

	/*Verifica se na posição HORIZONTAL informada pelo usuario tem espaço
	 * para adicionar o barco*/
	public static boolean verificaPosicaoHorizontal(int col, String[][] vet, int barco) {

		int verificaCol = col-1;
		if(barco ==1 ) {
			for (int i = 0; i < 5; i++) {
				verificaCol++;
			}
			if(verificaCol < vet.length) {
				return true;
			}
			return false;
		}else if(barco == 2) {
			for (int i = 0; i < 4; i++) {
				verificaCol++;
			}
			if(verificaCol < vet.length) {
				return true;
			}
			return false;
		}else if(barco == 3) {
			for (int i = 0; i < 3; i++) {
				verificaCol++;
			}
			if(verificaCol < vet.length) {
				return true;
			}
			return false;
		}
		for (int i = 0; i < 2; i++) {
			verificaCol++;
		}
		if(verificaCol < vet.length) {
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
			Jogo.imprimirln("Opção inválida!");
			break;
		}
	}

	/*Verifica se na posição VERTICAL informada pelo usuario tem espaço
	 * para adicionar o barco*/
	public static boolean verificaPosicaoVertical(int lin, String[][] vet, int barco) {

		int verificaLin = lin-1;
		if(barco == 1) {
			for (int i = 0; i < 5; i++) {
				verificaLin++;
			}
			if(verificaLin < vet.length) {
				return true;
			}
			return false;
		}else if(barco == 2) {
			for (int i = 0; i < 4; i++) {
				verificaLin++;
			}
			if(verificaLin < vet.length) {
				return true;
			}
			return false;
		}else if(barco == 3) {
			for (int i = 0; i < 3; i++) {
				verificaLin++;
			}
			if(verificaLin < vet.length) {
				return true;
			}
			return false;
		}
		for (int i = 0; i < 2; i++) {
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

			for (int i = 0; i < 5; i++) {
				vet[lin][col] = "X";
				lin++;
			}
			break;
		case 2:
			for (int i = 0; i < 4; i++) {
				vet[lin][col] = "X";
				lin++;
			}
			break;
		case 3:
			for (int i = 0; i < 3; i++) {
				vet[lin][col] = "X";
				lin++;
			}
			break;
		case 4:
			for (int i = 0; i < 2; i++) {
				vet[lin][col] = "X";
				lin++;
			}
			break;
		default:
			Jogo.imprimirln("Opção inválida!");
			break;
		}
	}
	/*-------------------------------------- BATALHA NAVAL (( FINAL )) --------------------------------------------*/
}
