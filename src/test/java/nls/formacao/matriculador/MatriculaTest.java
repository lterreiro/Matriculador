/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MatriculaTest {

    public MatriculaTest() {
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
     * Test of getId method, of class Matricula.
     */
    @org.junit.Test
    public void testGetId() {

        Matricula instance = null;
        try {
            instance = new Matricula("LEIC", 1);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MatriculaTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        assertNotNull(instance);
        String expResult = "";
        String result = instance.getId();
        assertNotEquals(expResult, result);
        try {
            assertNotNull(Integer.parseInt(result));
        } catch (NumberFormatException nfe) {
            Logger.getLogger(MatriculaTest.class.getName()).log(Level.SEVERE, null, nfe);
            fail();
        }
    }

    /**
     * Test of getCodEmp method, of class Matricula.
     */
    @org.junit.Test
    public void testGetCodEmp() {
        Matricula instance = null;
        try {
            instance = new Matricula("LEIC", 1);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MatriculaTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        assertNotNull(instance);
        int expResult = 1;
        int result = instance.getCodEmp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurso method, of class Matricula.
     */
    @org.junit.Test
    public void testGetCurso() {
        Matricula instance = null;
        try {
            instance = new Matricula("LEIC", 1);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MatriculaTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        assertNotNull(instance);
        String expResult = "LEIC";
        String result = instance.getCurso();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMatricula method, of class Matricula.
     */
    @org.junit.Test
    public void testGetMatricula() {
        Matricula instance = null;
        try {
            instance = new Matricula("LEIC", 1);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MatriculaTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        assertNotNull(instance);
        String expResult = instance.getCurso() + "/" + instance.getCodEmp() + "/" + instance.getId();
        String result = instance.getMatricula();
        assertEquals(expResult, result);
    }

}
