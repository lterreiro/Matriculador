/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import nls.formacao.matriculador.descarregador.DesCarregador;

/**
 *
 * @author lterreiro
 */
public interface Matriculador {

    /**
     * Insere um registo na coleção de matriculas.
     *
     * @param reg registo a inserir.
     * @return true se insere, false se não insere.
     */
    boolean inserir(Registo reg);

    /**
     * Lista os registos existentes no matriculador.
     *
     * @return String com a informacao das matriculas.
     */
    String listar();

    /**
     * Pesquisa uma matricula no registo de matriculas.
     *
     * @param id Identificador da matrícula a pesquisar.
     * @return instancia de {@link Registo} se encontrada. Null caso contrário.
     */
    Registo pesquisar(String id);

    /**
     * Retorna o numero de matriculados.
     *
     * @return inteiro representando o numero de matriculados.
     */
    int numMatriculados();

    /**
     * Descarrega a informacao para determinado meio.
     *
     * @param d
     */
    void descarregar(DesCarregador d);

    /**
     * Elimina um registo.
     * 
     * @param r 
     */
    void eliminar(Registo r);
    
    void limpar();
}
