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
			
			imprimirln("Informe o seu c�digo de acesso:");
			acesso = input.next();
			cls();
			imprimirln("Existe outro jogador? (sim | nao)");
			respo = input.next();
			switch (respo.toLowerCase().trim()) {
			case "sim":
				cls();
				imprimirln("Identifique o nome do segundo jogador:");
				vetUsuarios[1] = input.next();
				break;
			case "nao":
				imprimirln("Apenas um jogador selecionado.");
				break;
			default:
				imprimirln("Op��o inv�lida. Apenas um jogador ser� selecionado.");
			}
			if (vetUsuarios[1] != null) {
				cls();
				imprimirln("## Bem-Vindos(as) " + vetUsuarios[0] + " e " + vetUsuarios[1] + " ##");
			} else {
				cls();
				imprimirln("## Bem-Vindo(a) " + vetUsuarios[0] + " ##");
			}
						
		}
		// mostra o Menu de Jogos e recebe a op��o escolhida pelo usuario
		do {
		escolhaMenu();
		opcao = input.nextInt();
		cls();
		iniciandoJogos(opcao, vetUsuarios);
		}while (opcao > 0 && opcao < 4);

		
	}
	//Verifica se o numero de jogadores � valido para executar o jogo e retorna um valor booleano
	public static boolean definirJogadoresBatalhaNaval(String[] vet) {
		if(vet[1] != null) {
			return true;
		}
		return false;
	}


	/*
	 * Printa na tela o menu op��es escolhidas pelo usuario e retorna o numero
	 * digitado para a classe principal
	 */

	public static void escolhaMenu() {
			imprimirln("##-------- Este � o menu de jogos! --------##");
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
	
			imprimirln("Escolha uma op��o");
		
		// Leva o usu�rio para a execuss�o do jogo escolhido

	}

	public static void iniciandoJogos(int opt, String[]vet) {
		// acesso aos jogos
		if (opt == 1) {

			imprimirln("\nJogo da Forca selecionado\n");
		}
		if (opt == 2) {
			imprimirln("\nBatalha Naval selecionado.\n");
			if(definirJogadoresBatalhaNaval(vet)) {
				
				BatalhaNaval.main(null);
			}else {
				System.out.println("Para jogar BATALHA NAVAL precisa de 2 jogadores logados!");
			}

		}

		if (opt == 3) {

			imprimirln("\nCampo Minado selecionado\n");
			
		}
		imprimirln("##--- Fim! Esperamos que tenha se divertido! :) ---##");

	}

	// Printa os tra�os VERTICAIS do menu
	public static void tracoVertical() {
		imprimir("|");
	}

	// Printa os tra�os HORIZONTAIS do menu
	public static void tracoHorizontal() {
		imprimirln("|--------------------------------------------|");
	}

	// Enter para exibi��o das op��es do menu
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
        for(int i = 0; i < 50; i++)
        	System.out.println("");
    }
}
