package nls.formacao.matriculador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.descarregador.*;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 */
public class MatriculadorBD implements Matriculador {

    
    private static final Log LOG = LogFactory.getLog(MatriculadorBD.class.getName());

    private PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
    
    /**
     *
     */
    public MatriculadorBD() {
        super();
    
        try {
            pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
            pds.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
            pds.setUser("nls");
            pds.setPassword("nls");
            pds.setInitialPoolSize(5);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param size numero maximo de matriculas.
     */
    public MatriculadorBD(int size) {
        super();
    }

    /**
     * Pesquisa uma matricula no registo de matriculas.
     *
     * @param id Identificador da matrícula a pesquisar.
     * @return instancia de {@link Registo} se encontrada. Null caso contrário.
     */
    @Override
    public Registo pesquisar(String id) {

        return null;
    }

    /**
     * Descarrega a informacao para determinado meio.
     *
     * @param d
     */
    public void descarregar(DesCarregador d) {
        //d.escrever(registo);
    }

    /**
     * Retorna o numero de matriculados.
     *
     * @return inteiro representando o numero de matriculados.
     */
    public int numMatriculados() {
        int count = 0;
     
        return count;
    }

    /**
     *
     */
    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Operação por criar.");
    }

    /**
     * inicializa base de dados e cria uma ligação
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = pds.getConnection();
        } catch (SQLException e) {
            System.err.println("Erro a obter ligacao BD.");
            LOG.error("Erro a obter ligacao BD.", e);
            return null;
        }

        if (connection != null) {
            System.out.println("Ligação obtida com sucesso.");
            LOG.info("Ligação obtida.");
        } else {
            System.err.println("Erro a obter ligação à BD.");
            LOG.error("Erro a obter ligação BD.");
        }
        return connection;
    }

    
    /**
     * Lista os registos existentes no matriculador.
     *
     * @return String com a informacao das matriculas.
     */
    @Override
    public String listar() {
        PreparedStatement stmt = null;
        String s = "";
        String query = "SELECT IDMAT, CODEMP, NOME, APELIDO, DATANASC, EMAIL "
                + "FROM REGISTO INNER JOIN ENDERECO "
                + "ON REGISTO.IDEND = ENDERECO.IDEND WHERE IDMAT = ?";
        Connection connection = getConnection();
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, "2");
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                LOG.warn("Não foram encontrados resultados.");
                System.err.println("Não foram encontrados resultados.");
                return null;
            }

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
            LOG.error("Erro a obter registos da BD.", ex);
            System.out.println("Erro a obter registos. ");
        } finally {

            if (stmt != null) {
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

    /**
     * Insere um registo na coleção de matriculas.
     *
     * @param reg registo a inserir.
     * @return true se insere, false se não insere.
     */
    @Override
    public boolean inserir(Registo reg) {
        PreparedStatement stmt = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String query = "INSERT INTO REGISTO(IDMAT, CODEMP, NOME, APELIDO, DATANASC, EMAIL, IDEND) "
                + "VALUES (?,?,?,?,?,?,?) ";
        Connection connection = getConnection();
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, reg.getMatricula().getId());
            stmt.setInt(2, reg.getMatricula().getCodEmp());
            stmt.setString(3, reg.getNome().getPrimeiro());
            stmt.setString(4, reg.getNome().getUltimo());
            stmt.setDate(5, Date.valueOf(sdf.format(reg.getDataNascimento())));
            stmt.setString(6, reg.getEmail());
            stmt.setInt(7, 2);

            int ret = stmt.executeUpdate();
            if (ret <= 0) {
                LOG.warn("Não foi inserida a informação.");
                System.err.println("Não foi inserida a informação.");
                return false;
            }
            LOG.info("Informação inserida com sucesso.");
        } catch (SQLException ex) {
            LOG.error("Erro a inserir registo da BD.", ex);
            System.out.println("Erro a inserir registo");
        } finally {

            if (stmt != null) {
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
        return true;
    }

    @Override
    public void eliminar(Registo r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
