/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lterreiro
 */
public class Menu {

    private final static Matriculador matriculador = new Matriculador();
    
    private static final Logger LOG = Logger.getLogger(Menu.class.getName());
   
    
    public static void main(String[] args) {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        LOG.addHandler(consoleHandler);
        Scanner sc = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("Selecione uma opção: (I)nserir; (L)istar; (P)esquisar; (D)escarregar; (S)air");
            opcao = sc.nextLine();
            switch (opcao) {
                case "I":
                    inserir();
                    break;
                case "L":
                    listar();
                    break;
                case "P":
                    pesquisar();
                    break;
                case "D":
                    descarregar();
                    break;
                case "S":
                    sair();
                    break;
                default:
                    System.err.println("Opção Inválida.");
            }
        } while (true);
    }


    private static void inserir() {
        Registo registo = null;
        Scanner sc = new Scanner(System.in);
        UserInput ui = new UserInput(sc);
        //nome
        Nome nome = new Nome();
        nome.setPrimeiro(ui.askInputString("Indique o primeiro nome :"));
        nome.setMeio(ui.askInputString("Indique o nome do meio:"));
        nome.setUltimo(ui.askInputString("Indique o último nome :"));
        LOG.log(Level.FINE, "Nome introduzido: {0}", nome.toString());
        matriculador.inserir(registo);
    }

    private static void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void pesquisar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void descarregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static void sair() {
        System.out.println("Obrigado por utilizar a aplicação. Adeus.");
        System.exit(0);
    }
}
