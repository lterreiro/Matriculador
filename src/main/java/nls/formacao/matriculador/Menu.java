/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.util.Scanner;

/**
 *
 * @author lterreiro
 */
public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("Selecione uma opção: (I)nserir; (L)istar; (P)esquisar; (S)air");
            opcao = sc.nextLine();
            switch (opcao) {
                case "I":
                    System.out.println("inserir");
                    break;
                case "L":
                    System.out.println("listar");
                    break;
                case "P":
                    System.out.println("pesquisar");
                    break;
                case "S":
                    System.exit(0);
                    break;
                default:
                    System.err.println("Opção Inválida.");
            }
        } while (true);
    }
    
}
