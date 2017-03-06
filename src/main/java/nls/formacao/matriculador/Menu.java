/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import nls.formacao.matriculador.descarregador.DesCarregador;
import nls.formacao.matriculador.descarregador.DesCarregadorExcel;
import nls.formacao.matriculador.descarregador.DesCarregadorEcra;
import nls.formacao.matriculador.descarregador.DesCarregadorFicheiro;

/**
 *
 * @author lterreiro
 */
public class Menu {

    private final static Matriculador MATRICULADOR = new Matriculador();
    
    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
   
    
    public static void main(String[] args) {
        Handler handler = null;
        try {
            //handler = new ConsoleHandler();
            handler = new FileHandler("log.txt");
            handler.setFormatter(new SimpleFormatter());
        } catch (IOException | SecurityException ex) {
            LOG.log(Level.SEVERE, "Erro a definir file handler", ex);
            System.err.println("Erro a configurar logger. A sair.");
            System.exit(1);
        }

        handler.setLevel(Level.FINE);
        LOG.setLevel(Level.FINE);
        LOG.addHandler(handler);
        LOG.setUseParentHandlers(false);
        Scanner sc = new Scanner(System.in);
        String opcao;
        System.out.println("Bem vindo à aplicação de matriculação de alunos!");
        LOG.info("START");
        do {
            System.out.printf("Estão matriculados %d alunos em %d possiveis.\n", MATRICULADOR.numMatriculados(), Matriculador.MAX_MATRICULAS);
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
        MATRICULADOR.inserir(registo);
        System.out.println("Registo inserido com sucesso.");
    }

    /**
     * 
     */
    private static void listar() {
        System.out.println(MATRICULADOR.listar());
    }

    /**
     * 
     */
    private static void pesquisar() {
        Scanner sc = new Scanner(System.in);
        UserInput ui = new UserInput(sc);
        String id = Integer.toString(ui.askInputInt("Indique o id a pesquisar: "));
        MATRICULADOR.pesquisar(id);
    }

    /**
     * 
     */
    private static void descarregar() {
        DesCarregador descarregador = null;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Selecione uma opção de descarregamento: (E)crã; Ficheirob(T)XT; Ficheiro (X)LS; (V)oltar;");
            String opcao = sc.nextLine();
            switch(opcao){
                case "E":
                    descarregador = new DesCarregadorEcra();
                    break;
                case "T":
                    descarregador = new DesCarregadorFicheiro();
                    break;
                case "X":
                    descarregador = new DesCarregadorExcel();
                    break;
                case "V":
                    return;
                default:
                    descarregador = null;
                    System.err.println("Opção inválida");
            }
            if(descarregador != null){
                LOG.log(Level.FINE, "A escrever informação");
                MATRICULADOR.descarregar(descarregador);
            }
        } while (true);
        
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
        MATRICULADOR.inserir(new Registo(new Matricula("LEIC", 1), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        MATRICULADOR.inserir(new Registo(new Matricula("LEIC", 1), new Nome("Lenny", "Kravitz"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        MATRICULADOR.inserir(new Registo(new Matricula("LEEC", 2), new Nome("Britney", "Middle", "Spears"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        MATRICULADOR.inserir(new Registo(new Matricula("LEEC", 1), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
        MATRICULADOR.inserir(new Registo(new Matricula("LEIC", 2), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf));
    }
}
