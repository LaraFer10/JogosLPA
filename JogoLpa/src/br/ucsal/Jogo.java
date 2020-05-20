package br.ucsal;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		int opt;
		
		// Recebe a op��o escolhida pelo usuario
		opt = escolhaMenu();
		
		// Leva o usu�rio para a execuss�o do jogo escolhido
		switch(opt) {
		case 1:
			System.out.println("Jogo da Forca");
			break;
		case 2:
			System.out.println("Batalha Naval");
			break;
		case 3:
			System.out.println("Campo Minado");
			break;
		case 4:
			System.out.println("##--- Fim! Esperamos que tenha se divertido! :) ---##");
			break;
		default:
			System.out.println("Opi��o incorreta!");
			break;
		}
	}
	
	/*Printa na tela o menu junto com as op��es escolhidas pelo usuario
	* e retorna o numero digitado para a classe principal
	*/
	public static int escolhaMenu() {
		Scanner input = new Scanner(System.in);
		int opcao;
		System.out.println("##--- Bem-Vindo ao Escolhas divertidas! ---##");
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

}
