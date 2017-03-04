package nls.formacao.matriculador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 */
public class Registo {

    public static final String FORMATO_DATA = "dd-mm-yyyy";
    
    /**
     *
     */
    private Matricula matricula;

    /**
     *
     */
    private Nome nome;

    /**
     *
     */
    private Date dataNascimento;

    /**
     *
     */
    private Endereco endereco;

    /**
     *
     */
    private String email;

    /**
     * 
     */
    private DateFormat df;
    
    /**
     * 
     */
    private static final Logger LOG = Logger.getLogger(Registo.class.getName());
    
    /**
     *
     */
    public Registo() {
       super();
       this.dataNascimento = null;
       this.email = null;
       this.endereco = null;
       this.matricula = null;
       this.nome = null;
       this.df = new SimpleDateFormat(FORMATO_DATA);
    }

    public Registo(Matricula matricula, Nome nome, Date dataNascimento, Endereco endereco, String email, DateFormat df) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.df = df;
    }
    
    

}
