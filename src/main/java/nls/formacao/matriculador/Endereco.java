package nls.formacao.matriculador;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * 
 * @author lterreiro
 */
public class Endereco {

    /**
     * 
     */
    private String rua;

    /**
     * 
     */
    private String codPostal;

    /**
     * 
     */
    private String localidade;

    /**
     * 
     */
    private String lote;

    /**
     * 
     */
    private String andar;
    
    /**
     * 
     */
    private static final Logger LOG = Logger.getLogger(Endereco.class.getName());
    
    /**
     * 
     */
    public Endereco() {
        super();
        this.rua = "";
        this.codPostal = "";
        this.localidade = "";
        this.lote = "";
        this.andar = "";
    }

    /**
     * 
     * @param rua
     * @param lote
     * @param andar
     * @param codPostal
     * @param localidade 
     */
    public Endereco(String rua, String lote, String andar, String codPostal, String localidade) {
        this();
        this.rua = rua;
        this.codPostal = codPostal;
        this.localidade = localidade;
        this.lote = lote;
        this.andar = andar;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", codPostal=" + codPostal + ", localidade=" + localidade + ", lote=" + lote + ", andar=" + andar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.codPostal, other.codPostal)) {
            return false;
        }
        if (!Objects.equals(this.localidade, other.localidade)) {
            return false;
        }
        if (!Objects.equals(this.lote, other.lote)) {
            return false;
        }
        if (!Objects.equals(this.andar, other.andar)) {
            return false;
        }
        return true;
    }

    /**
     * Forma e retorna um endereço completo.
     * @return 
     * String com o endereço completo.
     */
    public String getEndereco(){
        StringBuilder sb = new StringBuilder();
        if(getRua() != null){
            sb.append(getRua());
        }
        
        if(getLote() != null){
            sb.append(" ").append(getLote());
        }
        
        if(getAndar()!= null){
            sb.append(" ").append(getAndar());
        }
        
        if(getCodPostal() != null){
            sb.append(" ").append(getCodPostal());
        }
        
        if(getLocalidade() != null)
        {
            sb.append(" ").append(getLocalidade());
        }
        
        return sb.toString();
    }
}
