package nls.formacao.matriculador;

public class Matricula
{
        /**
         * identificador univoco de uma matricula.
         * Possui o formato          */
	private String id;

	/**
	 * <p>Codigo do empregado que efetuou o registo.</p>
	 */
	private int codEmp;
        
	public Matricula(){
		super();
	}

    public Matricula(String id, int codEmp, Registo registo) {
        this.id = id;
        this.codEmp = codEmp;
    }

        
}

