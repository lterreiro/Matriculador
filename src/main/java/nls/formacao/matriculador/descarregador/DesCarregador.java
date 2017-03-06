package nls.formacao.matriculador.descarregador;

import nls.formacao.matriculador.Registo;

/**
 * Classes que implementem esta interface podem des/carregar informação
 * para um determinado meio.
 */
public interface DesCarregador {

    /**
     * Escreve a informação para um determinado meio.
     * @param info informação a escrever.
     */
    public void escrever(String info);
    
    /**
     * Escreve a informação para um determinado meio.
     * @param info coleção de {@link Registo} como informação a escrever.
     */
    public void escrever(Registo[] info);

    /**
     * Permite ler determinada informação de um meio.
     * @param meio
     */
    public void ler(String meio);

}
