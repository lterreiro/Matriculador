/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.descarregador.DesCarregadorEcra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lterreiro
 */
public class MatriculadorTest {
    
    public MatriculadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listar method, of class MatriculadorArray.
     */
    @Test
    public void testListar() {
        MatriculadorArray instance = new MatriculadorArray();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date d = null;
        try {
            d = sdf.parse("01-01-1970");
        } catch (ParseException ex) {
            Logger.getLogger(MatriculadorTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        Registo reg1 = new Registo(new Matricula("LEIC", 1), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf);
        instance.inserir(reg1);
        Registo reg2 = new Registo(new Matricula("LEIC", 1), new Nome("Jane", "Middle", "Doe"), d, new Endereco("Rua Ó", "1", "8º", "0999-009", "Porto"), "jane.doe@acme.com", sdf);
        instance.inserir(reg2);
        instance.listar();
    }

    /**
     * Test of inserir method, of class MatriculadorArray.
     */
    @Test
    public void testInserir() {
        
        MatriculadorArray instance = new MatriculadorArray();
        Registo registo = null;
        instance.inserir(registo);
        int expected = 0;
        int actual = 0;
        for(Registo r : instance.getRegisto()){
            if(r != null){
                actual++;
            }
        }
        assertEquals(expected, actual);
        
        registo = new Registo();
        instance.inserir(registo);
        expected = 1;
        actual = 0;
        for(Registo r : instance.getRegisto()){
            if(r != null){
                actual++;
            }
        }
        assertEquals(expected, actual);
    }

    /**
     * Test of pesquisar method, of class MatriculadorArray.
     */
    @Test
    public void testPesquisar() {
        MatriculadorArray instance = new MatriculadorArray();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date d = null;
        try {
            d = sdf.parse("01-01-1970");
        } catch (ParseException ex) {
            Logger.getLogger(MatriculadorTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        Registo expResult = new Registo(new Matricula("LEIC", 1), new Nome("John", "Middle", "Doe"), d, new Endereco("Rua Sesamo", "220", "8º", "1000-100", "Lisboa"), "john.doe@acme.com", sdf);
        String id = expResult.getMatricula().getId();
        instance.inserir(expResult);
        Registo result = instance.pesquisar(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of descarregar method, of class MatriculadorArray.
     */
    @Test
    public void testDescarregar() {
        System.out.println("descarregar");
        MatriculadorArray instance = new MatriculadorArray();
        instance.descarregar(new DesCarregadorEcra());
    }

    /**
     * Test of numMatriculados method, of class MatriculadorArray.
     */
    @Test
    public void testNumMatriculados() {
        System.out.println("numMatriculados");
        MatriculadorArray instance = new MatriculadorArray();
        instance.inserir(new Registo());
        instance.inserir(new Registo());
        int expResult = 2;
        int result = instance.numMatriculados();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOverInsertion(){
        MatriculadorArray instance = new MatriculadorArray(2);
        assertTrue(instance.inserir(new Registo()));
        assertTrue(instance.inserir(new Registo()));
        assertFalse(instance.inserir(new Registo()));
        
    }
}
