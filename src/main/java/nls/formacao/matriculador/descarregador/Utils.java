/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador.descarregador;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Formação
 */
public class Utils {
    
    private static final SecureRandom RANDOM = new SecureRandom();
    
    private static final Log LOG = LogFactory.getLog(Utils.class);

    /**
     * Gera 
     * @param extensao
     * @return
     */
    public static String obtemNomeFicheiro(String extensao) {
        
        if (extensao == null || "".equals(extensao)) {
            extensao = "txt";
        }
        
        StringBuilder nome = new StringBuilder();
        nome.append(new BigInteger(130, RANDOM).toString(32)).append(".").append(extensao);
        LOG.debug(String.format("gerado nome ficheiro: {0}", nome));
        return nome.toString();
    }
}
