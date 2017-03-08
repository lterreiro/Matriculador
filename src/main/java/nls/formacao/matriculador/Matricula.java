package nls.formacao.matriculador;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Matricula {
    
    /**
     * separador do formato da matricula
     */
    private static final String SEPARADOR = "/";
    
    /**
     * identificador univoco de uma matricula.
     * O identificador é gerado internamente, sendo 
     * composto pelo prefixo do curso, codigo empregado e um numero aleatório.
     */
    private String id;

    /**
     * Codigo do empregado que efetuou o registo.
     */
    private int codEmp;

    /**
     * curso da matricula.
     */
    private String curso;
    
    /**
     * LOGGER
     */
    private static final Log LOG = LogFactory.getLog(Matricula.class.getName());
    
    /**
     * 
     * @param curso
     * @param codEmp
     */
    public Matricula(String curso, int codEmp) {
        this.codEmp = codEmp;
        this.curso = curso;
        try {
            this.id = genRanId();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro a criar matricula", ex);
        }
    }

    public String getId() {
        return id;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public String getCurso() {
        return curso;
    }
    
    /**
     * 
     * @return
     * @throws NoSuchAlgorithmException 
     */
    private String genRanId() throws NoSuchAlgorithmException {
        SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
        //generate a random number
        return Integer.toString(Math.abs(prng.nextInt()));
    }

    /**
     * Indica o código da matrícula criado.
     * @return String representando a matrícula.
     */
    public String matriculaCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.curso).append(SEPARADOR)
          .append(this.codEmp).append(SEPARADOR)
          .append(this.id);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", codEmp=" + codEmp + ", curso=" + curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + this.codEmp;
        hash = 31 * hash + Objects.hashCode(this.curso);
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
        final Matricula other = (Matricula) obj;
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    
    
}
