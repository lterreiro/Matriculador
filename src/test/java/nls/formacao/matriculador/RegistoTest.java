/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class RegistoTest {
    
    private Registo instance;
    private Matricula m = null;
    private Nome n = null;
    private Endereco e = null;
    private Date d = null;
    private String em = null;
    
    public RegistoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        n = new Nome("John", "Middle", "Doe");
        m = new Matricula("LEIC", 1);      
        e = new Endereco("Rua Sésamo", "222", "8º", "1000-100", "Lisboa");
        Calendar.getInstance().add(Calendar.YEAR, -20);
        d = Calendar.getInstance().getTime();
        em = "john.doe@acme.com";
        instance = new Registo();
        instance.setDataNascimento(d);
        instance.setEmail(em);
        instance.setEndereco(e);
        instance.setMatricula(m);
        instance.setNome(n);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of matriculaCompleta method, of class Registo.
     */
    @Test
    public void testGetMatricula() {
        Matricula expResult = m;
        Matricula result = instance.getMatricula();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMatricula method, of class Registo.
     */
    @Test
    public void testSetMatricula() {
        Matricula matricula = new Matricula("LEIC", 1);
        Registo instance = new Registo();
        instance.setMatricula(matricula);
        Matricula result = instance.getMatricula();
        assertEquals(matricula, result);
    }

    /**
     * Test of getNome method, of class Registo.
     */
    @Test
    public void testGetNome() {
        Nome expResult = n;
        Nome result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Registo.
     */
    @Test
    public void testSetNome() {
        Nome nome = new Nome("John", "Middle", "Doe");
        Registo instance = new Registo();
        instance.setNome(nome);
        Nome result = instance.getNome();
        assertEquals(nome, result);
    }

    /**
     * Test of getDataNascimento method, of class Registo.
     */
    @Test
    public void testGetDataNascimento() {
        Date expResult = d;
        Date result = instance.getDataNascimento();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataNascimento method, of class Registo.
     */
    @Test
    public void testSetDataNascimento() {
        Date date = Calendar.getInstance().getTime();
        Registo instance = new Registo();
        instance.setDataNascimento(date);
        assertEquals(date, instance.getDataNascimento());
    }

    /**
     * Test of enderecoCompleto method, of class Registo.
     */
    @Test
    public void testGetEndereco() {
        Endereco expResult = e;
        Endereco result = instance.getEndereco();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndereco method, of class Registo.
     */
    @Test
    public void testSetEndereco() {
        Registo instance = new Registo();
        instance.setEndereco(e);
        Endereco endereco = instance.getEndereco();
        assertEquals(endereco, instance.getEndereco());
    }

    /**
     * Test of getEmail method, of class Registo.
     */
    @Test
    public void testGetEmail() {
        String expResult = em;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Registo.
     */
    @Test
    public void testSetEmail() {
        String email = "john.doe@acme.com";
        Registo instance = new Registo();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of getDataNascimentoStr method, of class Registo.
     */
    @Test
    public void testGetDataNascimentoStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(Registo.FORMATO_DATA);
        String expResult = sdf.format(d);
        String result = instance.getDataNascimentoStr();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Registo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Registo instance = new Registo();
        int expResult = 25583151;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
