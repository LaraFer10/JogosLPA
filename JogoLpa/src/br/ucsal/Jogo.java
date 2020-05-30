package br.ucsal;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Jogo {

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

}

