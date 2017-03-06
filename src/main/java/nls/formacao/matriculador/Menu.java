/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        LOG.setLevel(Level.FINE);
        LOG.addHandler(consoleHandler);
        Scanner sc = new Scanner(System.in);
        String opcao;
        System.out.println("Bem vindo à aplicação de matriculação de alunos!");
        do {
            System.out.printf("Estão matriculados %d alunos em %d possiveis.\n", matriculador.numMatriculados(), Matriculador.MAX_MATRICULAS);
            System.out.println("Selecione uma opção: (A)uto Inserir; (I)nserir; (L)istar; (P)esquisar; (D)escarregar; (S)air");
            opcao = sc.nextLine();
            switch (opcao.toUpperCase()) {
                case "A":
                    inserirRegistos();
                    break;
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

    /**
     * 
     */
    private static void inserir() {
        Scanner sc = new Scanner(System.in);
        UserInput ui = new UserInput(sc);
        Registo registo = new Registo();
        //nome
        Nome nome = new Nome();
        nome.setPrimeiro(ui.askInputString("Indique o primeiro nome : "));
        nome.setMeio(ui.askInputString("Indique o nome do meio: "));
        nome.setUltimo(ui.askInputString("Indique o último nome : "));
        registo.setNome(nome);
        //endereco
        Endereco endereco = new Endereco();
        endereco.setRua(ui.askInputString("Indique a rua: "));
        endereco.setLote(ui.askInputString("Indique o lote: "));
        endereco.setAndar(ui.askInputString("Indique o andar: "));
        endereco.setCodPostal(ui.askInputCodPostal("Indique o código postal (NNNN-NNN): "));
        endereco.setLocalidade(ui.askInputString("Indique a Localidade: "));
        registo.setEndereco(endereco);
        //matricula
        String curso = ui.askInputString("Indique o curso: ");
        int codEmp = 1; 
        Matricula matricula = new Matricula(curso, codEmp);
        registo.setMatricula(matricula);
        //email
        registo.setEmail(ui.askInputEmail("Indique o email: "));
        //data nascimento
        registo.setDataNascimento(ui.askInputDateWithFormat("Indique a data nascimento: ", Registo.FORMATO_DATA));
        LOG.log(Level.FINE, "Registo introduzido: {0}", registo.toString());
        matriculador.inserir(registo);
        System.out.println("Registo inserido com sucesso.");
    }

    /**
     * 
     */
    private static void listar() {
        System.out.println(matriculador.listar());
    }

    /**
     * 
     */
    private static void pesquisar() {
        Scanner sc = new Scanner(System.in);
        UserInput ui = new UserInput(sc);
        String id = Integer.toString(ui.askInputInt("Indique o id a pesquisar: "));
        matriculador.pesquisar(id)
    }

    /**
     * 
     */
    private static void descarregar() {
        matriculador.descarregar();
    }
    
    /**
     * 
     */
    private static void sair() {
        System.out.println("Obrigado por utilizar a aplicação. Adeus.");
        System.exit(0);
    }

    /**
     * 
     */
    private static void inserirRegistos() {
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        matriculador.inserir(new Registo(new Matricula("LEIC", 1), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        matriculador.inserir(new Registo(new Matricula("LEIC", 1), new Nome("Lenny", "Kravitz"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        matriculador.inserir(new Registo(new Matricula("LEEC", 2), new Nome("Britney", "Middle", "Spears"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        matriculador.inserir(new Registo(new Matricula("LEEC", 1), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        matriculador.inserir(new Registo(new Matricula("LEIC", 2), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
    }
}
