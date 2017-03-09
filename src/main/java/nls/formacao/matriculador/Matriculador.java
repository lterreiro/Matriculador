package nls.formacao.matriculador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.descarregador.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 */
public class Matriculador {

    /**
     * Número máximo de matrículas permitido.
     */
    public static final int MAX_MATRICULAS = 50;

    private static final Log LOG = LogFactory.getLog(Matriculador.class.getName());

    private Connection connection = null;
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
     *
     * @return String com a informacao das matriculas.
     */
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
    public void eliminarRegistos() {
        Arrays.fill(registo, null);
    }

    /**
     * inicializa base de dados e cria uma ligação
     */
    private void getBDConnection() {

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "nls", "nls");
        } catch (SQLException e) {
            System.err.println("Erro a obter ligacao BD.");
            LOG.error("Erro a obter ligacao BD.", e);
            return;
        }

        if (connection != null) {
            System.out.println("Ligação obtida com sucesso.");
        } else {
            System.err.println("Erro a obter ligação à BD.");
            LOG.error("Erro a obter ligação BD.");
        }
    }

    public String listarBD() {
        PreparedStatement stmt = null;
        String s = null;
        String query = "SELECT IDMAT, CODEMP, NOME, APELIDO, DATANASC, EMAIL FROM REGISTO";

        try {
            getBDConnection();
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idMat = rs.getString("IDMAT");
                int codEmp = rs.getInt("CODEMP");
                String nome = rs.getString("NOME");
                String apelido = rs.getString("APELIDO");
                Date datNasc = rs.getDate("DATANASC");
                String email = rs.getString("EMAIL");

                s += String.format("Mat: %s/%s\nNome: %s %s\nData Nasc: %s\nEmail: %s", idMat, codEmp, nome, apelido, datNasc, email);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Matriculador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                   LOG.error(ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                   LOG.error(ex);
                }
            }
        }

        return s;
    }
}
