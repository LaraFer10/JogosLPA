package br.ucsal;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opt = 0;
		String[] vetUsuarios = new String[2];

		// Identifica os usuarios retornando um vetor de nomes
		identificaUsuario();
		
		// mostra o Menu de Jogos e recebe a op��o escolhida pelo usuario
		escolhaMenu();

		
	}

	// Identifica os Usuarios que vao jogar e retorna um vetor com nomes para o main
	public static void identificaUsuario() {
		String[] usuarios = new String[2];
		String respo;
		int players;
		String acesso;
		Scanner input = new Scanner(System.in);
		tracoHorizontal();
		tracoVertical();
		imprimir("------ Bem-Vindo ao Jogos Divertidos! ------");
		tracoVertical();
		enter();
		tracoHorizontal();
		imprimirln("Identifique-se com seu Nome:");
		usuarios[0] = input.next();

		imprimirln("Informe o seu c�digo de acesso:");
		acesso = input.next();
	
		imprimirln("Existe outro jogador? (sim | nao)");
		respo = input.next();
		switch (respo.toLowerCase().trim()) {
		case "sim":
			imprimirln("Identifique o nome do segundo jogador:");
			usuarios[1] = input.next();
			break;
		case "nao":
			imprimirln("Apenas um jogador selecionado.");
			break;
		default:
			imprimirln("Op��o inv�lida. Apenas um jogador ser� selecionado.");
		}
		if (usuarios[1] != null) {

			imprimirln("## Bem-Vindos(as) " + usuarios[0] + " e " + usuarios[1] + " ##");
		} else {
			imprimirln("## Bem-Vindo(a) " + usuarios[0] + " ##");
		}

	}

	/*
	 * Printa na tela o menu op��es escolhidas pelo usuario e retorna o numero
	 * digitado para a classe principal
	 */

	public static void escolhaMenu() {
		int opcao;
		do {
			Scanner input = new Scanner(System.in);
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
			opcao = input.nextInt();
		
		// Leva o usu�rio para a execuss�o do jogo escolhido
			iniciandoJogos(opcao);
		}while (opcao < 1 || opcao > 4);

	}

	public static void iniciandoJogos(int opt) {
		// acesso aos jogos
		if (opt == 1) {

			imprimirln("\nJogo da Forca selecionado\n");
		}
		if (opt == 2) {
			imprimirln("\nBatalha Naval selecionado.\n");

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
        for(int i = 0; i < 25; i++)
        System.out.println("");
    }
}
