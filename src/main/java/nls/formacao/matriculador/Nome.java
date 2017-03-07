package nls.formacao.matriculador;

import java.util.Objects;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Define o nome de um aluno
 */
public class Nome {

    /**
     * Primeiro Nome.
     */
    private String primeiro;

    /**
     * Nome do meio.
     */
    private String meio;

    /**
     * Ultimo nome.
     */
    private String ultimo;
    
    /**
     * LOGGER
     */
    private static final Log LOG = LogFactory.getLog(Nome.class.getName());
    
    /**
     * Constrói um nome.
     */
    public Nome() {
        super();
        this.primeiro = "";
        this.meio = "";
        this.ultimo = "";
    }

    /**
     * Constrói um nome, sendo fornecidos primeiro nome e apelido.
     *
     * @param primeiro
     * @param ultimo
     */
    public Nome(String primeiro, String ultimo) {
        this();
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }

    /**
     * Constrói um nome, sendo fornecidos todos os seus elementos.
     *
     * @param primeiro
     * @param meio
     * @param ultimo
     */
    public Nome(String primeiro, String meio, String ultimo) {
        this();
        this.primeiro = primeiro;
        this.meio = meio;
        this.ultimo = ultimo;
    }

    public String getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(String primeiro) {
        this.primeiro = primeiro;
    }

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }
    
    public String nomeCompleto(){
        StringBuilder sb = new StringBuilder();
        if(!"".equals(getPrimeiro())){
            sb.append(getPrimeiro());
        }
        
        if(!"".equals(getMeio())){
            sb.append(" ").append(getMeio());
        }
        
        if(!"".equals(getUltimo())){
            sb.append(" ").append(getUltimo());
        }
        
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "Nome{" + "primeiro=" + primeiro + ", meio=" + meio + ", ultimo=" + ultimo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.primeiro);
        hash = 31 * hash + Objects.hashCode(this.meio);
        hash = 31 * hash + Objects.hashCode(this.ultimo);
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
        final Nome other = (Nome) obj;
        if (!Objects.equals(this.primeiro, other.primeiro)) {
            return false;
        }
        if (!Objects.equals(this.meio, other.meio)) {
            return false;
        }
        if (!Objects.equals(this.ultimo, other.ultimo)) {
            return false;
        }
        return true;
    }

   

}
