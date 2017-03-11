package nls.formacao.matriculador;

import java.util.Arrays;
import nls.formacao.matriculador.descarregador.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 */
public class MatriculadorArray implements Matriculador {

    /**
     * Número máximo de matrículas permitido.
     */
    public static final int MAX_MATRICULAS = 50;

    private static final Log LOG = LogFactory.getLog(MatriculadorArray.class.getName());

    /**
     *
     */
    private final Registo[] registo;

    /**
     *
     */
    public MatriculadorArray() {
        super();
        registo = new Registo[MAX_MATRICULAS];
        Arrays.fill(registo, null);
    }

    /**
     * @param size numero maximo de matriculas.
     */
    public MatriculadorArray(int size) {
        super();
        registo = new Registo[size];
        Arrays.fill(registo, null);
    }

    /**
     * Lista os registos existentes no matriculador.
     *
     * @return String com a informacao das matriculas.
     */
    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder("Listagem de matriculas\n");
        for (Registo r : registo) {
            if (r != null) {
                sb.append(r.prettyPrint());
            }
        }
        LOG.debug("Listagem terminada");
        return sb.toString();
    }

    /**
     * Insere um registo na coleção de matriculas.
     *
     * @param reg registo a inserir.
     * @return true se insere, false se não insere.
     */
    @Override
    public boolean inserir(Registo reg) {
        if (reg == null) {
            LOG.warn("Registo inválido. Não inserido.");
            return false;
        }
        boolean inserido = false;
        for (int i = 0; i < registo.length; i++) {
            if (registo[i] == null) {
                registo[i] = reg;
                LOG.info("Registo inserido com sucesso.");
                inserido = true;
                break;
            }
        }
        if (!inserido) {
            System.err.println("Registo não foi inserido. Não foi encontrado espaço.");
            LOG.error("Não foi possível inserir o registo.");
            return false;
        }
        LOG.debug("Registo inserido.");
        return true;
    }

    /**
     * Pesquisa uma matricula no registo de matriculas.
     *
     * @param id Identificador da matrícula a pesquisar.
     * @return instancia de {@link Registo} se encontrada. Null caso contrário.
     */
    @Override
    public Registo pesquisar(String id) {
        for (Registo reg : registo) {
            if (reg != null && reg.getMatricula().getId().equals(id)) {
                LOG.debug(String.format("Registo encontrado para id %s.", id));
                return reg;
            }
        }
        LOG.debug("Registo não encontrado.");
        return null;
    }

    /**
     * Descarrega a informacao para determinado meio.
     *
     * @param d
     */
    public void descarregar(DesCarregador d) {
        d.escrever(registo);
    }

    /**
     * Retorna o numero de matriculados.
     *
     * @return inteiro representando o numero de matriculados.
     */
    public int numMatriculados() {
        int count = 0;
        for (int i = 0; i < registo.length; i++) {
            if (registo[i] != null) {
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

    /**
     *
     */
    @Override
    public void limpar() {
        Arrays.fill(registo, null);
    }

    @Override
    public void eliminar(Registo r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
