package nls.formacao.matriculador;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Matriculador {

    /**
     * Número máximo de matrículas permitido.
     */
    public static final int MAX_MATRICULAS = 50;
    
    private static final Logger LOG = Logger.getLogger(Matriculador.class.getName());
    
    /**
     *
     */
    private Registo[] registo;
    
    /**
     * 
     */
    private DesCarregador descarregador;

    /**
     * 
     */
    public Matriculador() {
        super();
        registo = new Registo[MAX_MATRICULAS];
        Arrays.fill(registo, null);
    }

    /**
     * 
     */
    public void listar() {
        // TODO implement me
    }

    /**
     * 
     */
    public void inserir(Registo reg) {
        if(registo == null){
            LOG.log(Level.WARNING, "Registo inválido. Não inserido.");
            return;
        }
        for (int i = 0; i < registo.length; i++) {
            if(registo[i] == null){
                registo[i] = reg;
                LOG.log(Level.INFO, "Registo inserido com sucesso.");
                break;
            }
        }
    }

    /**
     * 
     */
    public Registo pesquisar(String id) {
        // TODO implement me
        return null;
    }

    /**
     * 
     */
    public void descarregar() {
        // TODO implement me
    }

    /**
     * Retorna o numero de matriculados.
     * @return inteiro representando o numero de matriculados.
     */
    public int numMatriculados(){
        int count = 0;
        for (int i = 0; i < registo.length; i++) {
            if(registo[i] != null){
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * @return 
     */
    public Registo[] getRegisto() {
        return registo;
    }
    
    
}
