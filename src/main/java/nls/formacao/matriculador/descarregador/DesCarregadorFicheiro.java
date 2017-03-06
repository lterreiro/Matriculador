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
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.Registo;

/**
 *
 * @author Formação
 */
public class DesCarregadorFicheiro implements DesCarregador {

    private final SecureRandom random = new SecureRandom();
    
    private static final Logger LOG = Logger.getLogger(DesCarregadorFicheiro.class.getName());
    
    @Override
    public void escrever(String info) {
        String nome = obtemNomeFicheiro();
        try {
            Path p = Paths.get(nome);
            Files.write(p, info.getBytes(Charset.forName("UTF-8")));
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Erro a descarregar registos para o ecrã.", ex);
            System.err.println("Erro a descarregar informação para o ecrã.");
        }
        System.out.println(String.format("Criado o ficheiro %s.", nome));
    }

    @Override
    public void escrever(Registo[] info) {
        String nome = obtemNomeFicheiro();
        for (Registo registo : info) {
            if(registo == null){
                continue;
            }
            try {
                Path p = Paths.get(nome);
                Files.write(p, registo.prettyPrint().getBytes(Charset.forName("UTF-8")));
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Erro a descarregar registo para o ecrã.", ex);
            System.err.println("Erro a descarregar registo para o ecrã.");
            }
        }
    }

    private String obtemNomeFicheiro() {
        String nome = new BigInteger(130, random).toString(32) + ".txt";
        LOG.log(Level.FINE, "gerado nome ficheiro: {0}", nome);
        return nome;
    }

    @Override
    public void ler(String meio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
