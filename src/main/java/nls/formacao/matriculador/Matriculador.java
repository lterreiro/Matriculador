package nls.formacao.matriculador;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.descarregador.*;

/**
 * 
 */
public class Matriculador {

    /**
     * Número máximo de matrículas permitido.
     */
    public static final int MAX_MATRICULAS = 50;
    
    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    /**
     *
     */
    private final Registo[] registo;
    
    /**
     * 
     */
    public Matriculador() {
        super();
        registo = new Registo[MAX_MATRICULAS];
        Arrays.fill(registo, null);
    }
    
    /**
     * @param size numero maximo de matriculas.
     */
    public Matriculador(int size) {
        super();
        registo = new Registo[size];
        Arrays.fill(registo, null);
    }

    /**
     * Lista os registos existentes no matriculador.
     * @return String com a informacao das matriculas.
     */
    public String listar() {
        StringBuilder sb = new StringBuilder("Listagem de matriculas\n");
        for (Registo r : registo) {
            if(r != null){
                sb.append(r.prettyPrint());
            }
        }
        LOG.log(Level.FINE, "Listagem terminada");
        return sb.toString();
    }

    /**
     * Insere um registo na coleção de matriculas.
     * @param reg registo a inserir.
     * @return true se insere, false se não insere.
     */
    public boolean inserir(Registo reg) {
        if(reg == null){
            LOG.log(Level.WARNING, "Registo inválido. Não inserido.");
            return false;
        }
        boolean inserido = false;
        for (int i = 0; i < registo.length; i++) {
            if(registo[i] == null){
                registo[i] = reg;
                LOG.log(Level.INFO, "Registo inserido com sucesso.");
                inserido = true;
                break;
            }
        }
        if(!inserido){
            System.err.println("Registo não foi inserido. Não foi encontrado espaço.");
            LOG.log(Level.SEVERE, "Não foi possível inserir o registo.");
            return false;
        }
        LOG.log(Level.FINE, "Registo inserido.");
        return true;
    }

    /**
     * Pesquisa uma matricula no registo de matriculas.
     * @param id Identificador da matrícula a pesquisar.
     * @return instancia de {@link Registo} se encontrada. Null caso contrário.
     */
    public Registo pesquisar(String id) {
        for (Registo reg : registo) {
            if(reg != null && reg.getMatricula().getId().equals(id)){
                LOG.log(Level.FINE, String.format("Registo encontrado para id %s.", id));
                return reg;
            } 
        }
        LOG.log(Level.FINE, "Registo não encontrado.");
        return null;
    }

    /**
     * Descarrega a informacao para determinado meio.
     * @param d
     */
    public void descarregar(DesCarregador d) {
        d.escrever(registo);
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
