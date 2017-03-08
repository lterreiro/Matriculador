/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador.descarregador;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.Menu;
import nls.formacao.matriculador.Registo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Formação
 */
public class DesCarregadorFicheiro implements DesCarregador {


    private static final Log LOG = LogFactory.getLog(DesCarregadorFicheiro.class);

    @Override
    public void escrever(String info) {
        String nome = Utils.obtemNomeFicheiro("txt");
        try {
            Path p = Paths.get(nome);
            Files.write(p, info.getBytes(Charset.forName("UTF-8")), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            LOG.error("Erro a descarregar registos para o ecrã.", ex);
            System.err.println("Erro a descarregar informação para o ecrã.");
        }
        System.out.println(String.format("Criado o ficheiro %s.", nome));
    }

    @Override
    public void escrever(Registo[] info) {
        String nomeFicheiro = Utils.obtemNomeFicheiro("txt");
        for (Registo registo : info) {
            if (registo == null) {
                continue;
            }
            try {
                Path p = Paths.get(nomeFicheiro);
                Files.write(p, registo.prettyPrint().getBytes(Charset.forName("UTF-8")), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                LOG.error("Erro a descarregar registo para o ecrã.", ex);
                System.err.println("Erro a descarregar registo para o ficheiro.");
            }
        }
        LOG.info(String.format("Informação descarregada com sucesso para o ficheiro '%s'", nomeFicheiro));
        System.out.println(String.format("Criado o ficheiro %s.", nomeFicheiro)); 
    }

    @Override
    public void ler(String meio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
