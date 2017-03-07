/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador.descarregador;

import nls.formacao.matriculador.Registo;

/**
 *
 * @author Formação
 */
public class DesCarregadorEcra implements DesCarregador {

    @Override
    public void escrever(String info) {
        System.out.println(info);
    }

    @Override
    public void escrever(Registo[] info) {
        for (Registo registo : info) {
            if (registo != null) {
                System.out.println(registo.prettyPrint());
            }
        }
    }

    @Override
    public void ler(String meio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
