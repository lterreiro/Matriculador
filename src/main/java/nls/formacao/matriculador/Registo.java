package nls.formacao.matriculador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 */
public class Registo {

    /**
     * representa o formato da data esperado pelo registo.
     */
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDataNascimentoStr() {
        return df.format(dataNascimento);
    }
    
    /**
     * 
     * @return 
     */
    public String prettyPrint(){
        StringBuilder sb = new StringBuilder();
        sb.append("==============================================\n");
        sb.append("Nome: ").append(this.getNome().nomeCompleto()).append("\n");
        sb.append("Endereço: ").append(this.getEndereco().enderecoCompleto()).append("\n");
        sb.append("Data Nascimento: ").append(this.getDataNascimentoStr()).append("\n");
        sb.append("Email: ").append(this.getEmail()).append("\n");
        sb.append("Matricula: ").append(this.getMatricula().getMatricula()).append("\n");
        sb.append("==============================================\n");
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Registo{" + "matricula=" + matricula + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.matricula);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.dataNascimento);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.df);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registo other = (Registo) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
       
        return true;
    }
    
    
    

}
