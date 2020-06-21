package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class CampoMinado {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// campo para mostrar jogadas e campo com as bombas armazenadas
		String[][] campo = new String[16][16];
		// campo com as bombas no tabuleiro.
		String[][] campo2 = new String[16][16];
		int[] jogada = new int[2];
		int coluna = 0, linha = 0, resposta = 0;
		// caractere da bomba e a quantidade que será utilizada no jogo; marcação no
		// tabuleiro quando errar bombas.
		final String bomba = "¤";
		final int quantidadeBombas = 35;
		boolean ganhou = false;

		// invoca metodo para colocar bombas no tabuleiro.
		bombasNoTabuleiro(campo2, bomba, quantidadeBombas);
		posicaoNumero(campo2, bomba);
		exibirTabuleiro(campo2);

		// INICIO DO JOGO
		do {

			exibirTabuleiro(campo);
			// vai repetir caso informe numeros inválidos.
			Jogo.imprimirln("Escolha o numero da linha e coluna para fazer a sua jogada:");
			jogada[0] = input.nextInt();
			jogada[1] = input.nextInt();
			Jogo.cls();
			
			if(jogada[0] < 0 || jogada[0] > 16 || jogada[1] < 0 || jogada[1] > 16) {
				while(jogada[0] < 0 || jogada[0] > 16 || jogada[1] < 0 || jogada[1] > 16) {
					exibirTabuleiro(campo);
					Jogo.imprimirln("Opção inválida, tente de novo:");
					Jogo.imprimirln("Escolha o numero da linha e coluna para fazer a sua jogada:");
					jogada[0] = input.nextInt();
					jogada[1] = input.nextInt();
					Jogo.cls();
				}
			}

			valida(jogada, campo, campo2, bomba);
			ganhou(campo, quantidadeBombas);
		} while ((campo2[jogada[0]][jogada[1]] != bomba) && ganhou == false); // ver se funciona.
		// vitória
		if (ganhou == true) {
			Jogo.cls();
			Jogo.tracoHorizontal();
			Jogo.tracoVertical();
			Jogo.imprimirln(" Você ganhou! ");
			Jogo.tracoVertical();
			Jogo.enter();
			Jogo.tracoHorizontal();
			exibirTabuleiro(campo2);
			do {
				Jogo.imprimirln("Informe uma das opções: \n(1) Jogar novamente\n(2) Voltar ao Menu");
				resposta = input.nextInt();
			} while (resposta != 1 && resposta != 2);
			if(resposta ==1) {
				Jogo.cls();
				CampoMinado.main(args);
			} else {
				Jogo.cls();
				Jogo.escolhaMenu(args);
			}
			// derrota
		}
		if (campo2[jogada[0]][jogada[1]] == bomba) {
			Jogo.cls();
			
			Jogo.tracoHorizontal();
			Jogo.tracoVertical();
			Jogo.imprimir("Você caiu em uma bomba! Fim de Jogo");
			Jogo.tracoVertical();
			Jogo.enter();
			Jogo.tracoHorizontal();
			exibirTabuleiro(campo);
			do {
				Jogo.imprimirln("Informe uma das opções: \n(1) Jogar novamente\n(2) Voltar ao Menu");
				resposta = input.nextInt();
			} while (resposta != 1 && resposta != 2);
			if(resposta ==1) {
				Jogo.cls();
				CampoMinado.main(args);
			} else {
				Jogo.cls();
				Jogo.escolhaMenu(args);
			}

		}
	}


	public static void exibirTabuleiro(String[][] vet) {
		Jogo.imprimir("L  C ");
		for (int i = 0; i < vet.length; i++) {
			if (i < 10) {
				Jogo.imprimir(i + "   ");
			} else {
				Jogo.imprimir(i + "  ");

			}

		}
		Jogo.imprimir("\n");
		for (int lin = 0; lin < vet.length; lin++) {
			Jogo.imprimirln("   -----------------------------------------------------------------");
			if (lin < 10) {
				Jogo.imprimir(lin + "  ");
			} else {
				Jogo.imprimir(lin + " ");
				// esta parte foi colocada porque quando > 10 desalinhava o tabuleiro por ter
				// mais um numero.
			}
			Jogo.imprimir("|");
			for (int col = 0; col < vet.length; col++) {
				if (vet[lin][col] != null) {
					Jogo.imprimir(" " + vet[lin][col] + " ");
				} else {

					Jogo.imprimir("   ");
				}
				Jogo.imprimir("|");

			}
			Jogo.imprimir("\n");
		}
		Jogo.imprimir("   -----------------------------------------------------------------");

	}

	// vai espalhar as bombas aleatoriamente no tabuleiro com o Random.
	public static String[][] bombasNoTabuleiro(String[][] campo, String bomba, int quantidadeBombas) {
		Random rd = new Random();
		for (int i = 0; i < quantidadeBombas; i++) {
			int linha = rd.nextInt(15);
			int coluna = rd.nextInt(15);
			// garantir que serão 35 bombas no tabuleiro.
			if (campo[linha][coluna] != bomba) {
				campo[linha][coluna] = bomba;
			} else {
				quantidadeBombas++;

			}
		}
		return campo;
	}

	public static String[][] posicaoNumero(String[][] campo2, String bomba) {
		String v = "";
		int valor = 1;
		//colocar verif tamanho vetor.
		for (int line = 0; line < 15; line++) {
			for (int column = 0; column < 15; column++) {
				// linha 0 coluna 0
				//checar diagonais. TESTE================================================================================================
				if ((line == 0 && column == 0) || (line == 0 && column > 0) || (line > 0 && column == 0)) {
					if (line == 0 && column == 0) {
						if (campo2[line = 0][column = 0] != bomba) {
							if (campo2[line + 1][column] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
							if (campo2[line][column + 1] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
						}
					}

					// linha 0
					if (line == 0 && column > 0) {
						for (int lin = -1; lin <= 1; lin++) {

						}
						if (campo2[line = 0][column] != bomba) {
							if (campo2[line + 1][column] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
							if (campo2[line][column + 1] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
							if (campo2[line][column - 1] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
						}
					}

					// coluna 0
					if (line > 0 && column == 0) {
						if (campo2[line][column] != bomba) {
							if (campo2[line + 1][column] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
							if (campo2[line][column + 1] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
							if (campo2[line - 1][column] == bomba) {
								campo2[line][column] = v + valor++;
								valor = 1;
							}
						}

					}
				} else {
					for (int i = -1; i <= 1; i++) {

						for (int j = -1; j <= 1; j++) {

							if (campo2[line][column] != bomba)
								if (campo2[line + i][column + j] == bomba)
									campo2[line][column] = v + valor++;
						}
					}
					valor = 1;
				}
			}

		}
		return campo2;
	}

	/*
	 * public static String[][] validar (String [][] campo, String [][]
	 * campo2,String bomba){ int bombas = 0; for (int line = 0; line < 16; line++) {
	 * for (int column = 0; column < 16; column++) {
	 * 
	 * for (int i = -1; i <= 1; i++) {
	 * 
	 * for (int j = -1; j <= 1; j++) {
	 * 
	 * if (line<=15 && column <=15 && line != bombas && column != bombas) if
	 * (campo2[line + i][column + j] == bomba) campo2[line][column] = v + valor++; }
	 * }
	 * 
	 * } } return campo; }
	 */
	public static String[][] valida(int[] jogada, String[][] campo, String[][] campo2, String bomba) {
		String v = "", dica;
		int valor = 1;
		if (campo2[jogada[0]][jogada[1]] != null && campo2[jogada[0]][jogada[1]] != bomba) {

			campo[jogada[0]][jogada[1]] = campo2[jogada[0]][jogada[1]];
			//rever ============não esta inserindo o valor armazenado no campo2 para o campo1=============================
		} else {
			if (campo2[jogada[0]][jogada[1]] == null) {
				campo[jogada[0]][jogada[1]] = "-";
			} // está vazio e chama o metodo valida para cada uma das 8 posições

			//------- PARA LINHA ACIMA
			if (jogada[0] > 0) {
				//linha acima e coluna no centro
				if (campo2[jogada[0] - 1][jogada[1]] != null && campo2[jogada[0] - 1][jogada[1]] != bomba) {
					dica = campo2[jogada[0] - 1][jogada[1]];
					campo[jogada[0] - 1][jogada[1]] = dica;

				} else if (campo2[jogada[0] - 1][jogada[1]] == null) {
					campo[jogada[0] - 1][jogada[1]] = "-";
				}
				// linha acima e coluna a esquerda
				if (jogada[1] > 0) {
					if (campo2[jogada[0] - 1][jogada[1] - 1] != null && campo2[jogada[0] - 1][jogada[1] - 1] != bomba) {

						campo[jogada[0] - 1][jogada[1] - 1] = campo2[jogada[0] - 1][jogada[1] - 1];

					} else if(campo2[jogada[0] - 1][jogada[1] - 1] == null){
						campo[jogada[0] - 1][jogada[1] - 1] = "-";
					}

				}
				//linha acima e coluna a direita
				if (jogada[1] < 15) {
					if (campo2[jogada[0] - 1][jogada[1] + 1] != null && campo2[jogada[0] - 1][jogada[1] + 1] != bomba) {
						campo[jogada[0] - 1][jogada[1] + 1] = campo2[jogada[0] - 1][jogada[1] + 1];
	
					} else if(campo2[jogada[0] - 1][jogada[1] + 1] == null){
						campo[jogada[0] - 1][jogada[1] + 1] = "-";
					}
				}
					
					

			}
			
			//---------- PARA LINHA AO CENTRO
			if (jogada[1] < 15) {
				//linha no centro e coluna a direita
				if (campo2[jogada[0]][jogada[1] + 1] != null && campo2[jogada[0]][jogada[1] + 1] != bomba) {

					campo[jogada[0]][jogada[1] + 1] = campo2[jogada[0]][jogada[1] + 1];

				} else if(campo2[jogada[0]][jogada[1] + 1] == null){
					campo[jogada[0]][jogada[1] + 1] = "-";
				}
			}
			//linha no centro e coluna a esquerda
			if(jogada[1] > 0) {
				if (campo2[jogada[0]][jogada[1] - 1] != null && campo2[jogada[0]][jogada[1] - 1] != bomba) {
					
					campo[jogada[0]][jogada[1] - 1] = campo2[jogada[0]][jogada[1] - 1];
					
				} else if(campo2[jogada[0]][jogada[1] - 1] == null){
					campo[jogada[0]][jogada[1] - 1] = "-";
				}
			}
			
			
			//------- PARA LINHA ABAIXO
			if (jogada[0] < 15) {
				//abaixo linha e coluna no centro
				if ( campo2[jogada[0] + 1][jogada[1]] != null && campo2[jogada[0] + 1][jogada[1]] != bomba) {

					campo[jogada[0] + 1][jogada[1]] = campo2[jogada[0] + 1][jogada[1]];

				} else if (campo2[jogada[0] + 1][jogada[1]] == null){
					campo[jogada[0] + 1][jogada[1]] = "-";
				}
				//aabaixo linha e coluna a esquerda
				if (jogada[1] > 0) {
					if (campo2[jogada[0] + 1][jogada[1] - 1] != null && campo2[jogada[0] + 1][jogada[1] - 1] != bomba) {

						campo[jogada[0] + 1][jogada[1] - 1] = campo2[jogada[0] + 1][jogada[1] - 1];

					} else if (campo2[jogada[0] + 1][jogada[1] - 1] == null) {
						campo[jogada[0] + 1][jogada[1] - 1] = "-";
					}
					
				}
				//linha abaixo e coluna a direita
				if (jogada[1] < 15) {
					if (campo2[jogada[0] + 1][jogada[1] + 1] != null && campo2[jogada[0] + 1][jogada[1] + 1] != bomba) {
						campo[jogada[0] + 1][jogada[1] + 1] = campo2[jogada[0] + 1][jogada[1] + 1];
	
					} else if(campo2[jogada[0] + 1][jogada[1] + 1] == null){
						campo[jogada[0] + 1][jogada[1] + 1] = "-";
					}
				}
			
			}

		}
		return campo;	
	}


	public static boolean ganhou(String[][] campo, int qteBomba) {
		int valor = 1;
		int count = 256;
		for (int line = 0; line <= 15; line++)
			for (int column = 0; column < 15; column++)
				if (campo[line][column] == "-" || campo[line][column] == "" + (valor >= 1))
					count--;
		if (count == qteBomba)
			return true;
		else
			return false;
	}

}
