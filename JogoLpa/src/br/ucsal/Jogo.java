package br.ucsal;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


public class Jogo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao;
		int opt = 0;
		String[] vetUsuarios = new String[2];
		String respo;
		int players;
		String acesso;
		
		if(vetUsuarios[0] == null) {
			// Identifica os usuarios retornando um vetor de nomes
			
			tracoHorizontal();
			tracoVertical();
			imprimir("------ Bem-Vindo ao Jogos Divertidos! ------");
			tracoVertical();
			enter();
			tracoHorizontal();
			imprimirln("Identifique-se com seu Nome:");
			vetUsuarios[0] = input.next();
			
			imprimirln("Informe o seu código de acesso:");
			acesso = input.next();
			
			imprimirln("Existe outro jogador? (sim | nao)");
			respo = input.next();
			switch (respo.toLowerCase().trim()) {
			case "sim":
				imprimirln("Identifique o nome do segundo jogador:");
				vetUsuarios[1] = input.next();
				break;
			case "nao":
				imprimirln("Apenas um jogador selecionado.");
				break;
			default:
				imprimirln("Opção inválida. Apenas um jogador será selecionado.");
			}
			if (vetUsuarios[1] != null) {
				
				imprimirln("## Bem-Vindos(as) " + vetUsuarios[0] + " e " + vetUsuarios[1] + " ##");
			} else {
				imprimirln("## Bem-Vindo(a) " + vetUsuarios[0] + " ##");
			}
						
		}
		// mostra o Menu de Jogos e recebe a opção escolhida pelo usuario
		do {
		escolhaMenu();
		opcao = input.nextInt();
		iniciandoJogos(opcao);
		}while (opcao < 1 || opcao > 4);

		
	}

	/*
	 * Printa na tela o menu opções escolhidas pelo usuario e retorna o numero
	 * digitado para a classe principal
	 */

	public static void escolhaMenu() {

			imprimirln("##-------- Este é o menu de jogos! --------##");
			tracoHorizontal();
			tracoVertical();
			imprimir("(1) Jogo da Forca                           ");
			tracoVertical();
			enter();
			tracoVertical();
			imprimir("(2) Batalha Naval                           ");
			tracoVertical();
			enter();
			tracoVertical();
			imprimir("(3) Campo Minado                            ");
			tracoVertical();
			enter();
			tracoVertical();
			imprimir("(4) Sair                                    ");
			tracoVertical();
			enter();
			tracoHorizontal();
	
			imprimirln("Escolha uma opção");

		// Leva o usuário para a execussão do jogo escolhido

		imprimirln("##--- Fim! Esperamos que tenha se divertido! :) ---##");
	}

	public static void iniciandoJogos(int opt) {
		// acesso aos jogos
		if (opt == 1) {
			
			imprimirln("\nJogo da Forca selecionado\n");
			JogoForca.main(null);
		}
		if (opt == 2) {
			imprimirln("\nBatalha Naval selecionado.\n");
			
		}
		
		if (opt == 3) {
			
			imprimirln("\nCampo Minado selecionado\n");
			
		}

	}

	// Printa os traços VERTICAIS do menu
	public static void tracoVertical() {
		imprimir("|");
	}

	// Printa os traços HORIZONTAIS do menu
	public static void tracoHorizontal() {
		imprimirln("|--------------------------------------------|");
	}

	// Enter para exibição das opções do menu
	public static void enter() {
		imprimir("\n");
	}
	public static void imprimir(String txt) {
		System.out.print(txt);
	}
	public static void imprimirln(String txt) {
		System.out.println(txt);
	}
	public static void cls()
    {
        for(int i = 0; i < 25; i++)
        System.out.println("");
    }
}
