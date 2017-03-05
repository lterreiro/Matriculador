/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

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
public class EnderecoTest {
    
    public EnderecoTest() {
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
     * Test of getRua method, of class Endereco.
     */
    @org.junit.Test
    public void testGetRua() {
        Endereco instance = new Endereco();
        String expResult = "";
        String result = instance.getRua();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRua method, of class Endereco.
     */
    @org.junit.Test
    public void testSetRua() {
        String rua = "Rua Sésamo";
        Endereco instance = new Endereco();
        instance.setRua(rua);
        assertEquals(rua, instance.getRua());
    }

    /**
     * Test of getCodPostal method, of class Endereco.
     */
    @org.junit.Test
    public void testGetCodPostal() {
        Endereco instance = new Endereco();
        String expResult = "";
        String result = instance.getCodPostal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodPostal method, of class Endereco.
     */
    @org.junit.Test
    public void testSetCodPostal() {
        String codPostal = "1800";
        Endereco instance = new Endereco();
        instance.setCodPostal(codPostal);
        assertEquals(codPostal, instance.getCodPostal());
    }

    /**
     * Test of getLocalidade method, of class Endereco.
     */
    @org.junit.Test
    public void testGetLocalidade() {
        Endereco instance = new Endereco();
        String expResult = "";
        String result = instance.getLocalidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocalidade method, of class Endereco.
     */
    @org.junit.Test
    public void testSetLocalidade() {
        String localidade = "Portela";
        Endereco instance = new Endereco();
        instance.setLocalidade(localidade);
        assertEquals(localidade, instance.getLocalidade());
    }

    /**
     * Test of getLote method, of class Endereco.
     */
    @org.junit.Test
    public void testGetLote() {

        Endereco instance = new Endereco();
        String expResult = "";
        String result = instance.getLote();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLote method, of class Endereco.
     */
    @org.junit.Test
    public void testSetLote() {
        String lote = "1";
        Endereco instance = new Endereco();
        instance.setLote(lote);
        assertEquals(lote, instance.getLote());
    }

    /**
     * Test of getAndar method, of class Endereco.
     */
    @org.junit.Test
    public void testGetAndar() {
        Endereco instance = new Endereco();
        String expResult = "";
        String result = instance.getAndar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAndar method, of class Endereco.
     */
    @org.junit.Test
    public void testSetAndar() {
        String andar = "2";
        Endereco instance = new Endereco();
        instance.setAndar(andar);
        assertEquals(andar, instance.getAndar());
    }

    /**
     * Test of toString method, of class Endereco.
     */
    @org.junit.Test
    public void testToString() {
        Endereco instance = new Endereco();
        String expResult = "Endereco{" + "rua=" + ", codPostal=" + ", localidade=" + ", lote=" + ", andar=" + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Endereco.
     */
    @org.junit.Test
    public void testHashCode() {
        Endereco instance = new Endereco();
        int expResult = 7;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Endereco.
     */
    @org.junit.Test
    public void testEquals() {
        Object obj = null;
        Endereco instance = new Endereco();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testConstrutor(){
        final String expRua = "Rua Sésamo";
        final String expLote = "nº 5";
        final String expAndar = "1º esq.";
        final String expCodPostal = "1000-160";
        final String expLocalidade = "Lisboa";
        Endereco instance = new Endereco(expRua, expLote, expAndar, expCodPostal, expLocalidade);
        assertEquals(expRua, instance.getRua());
        assertEquals(expLote, instance.getLote());
        assertEquals(expAndar, instance.getAndar());
        assertEquals(expCodPostal, instance.getCodPostal());
        assertEquals(expLocalidade, instance.getLocalidade());
        
    }
    
    @org.junit.Test
    public void testGetEndereco(){
        final String expRua = "Rua Sésamo";
        final String expLote = "nº 5";
        final String expAndar = "1º esq.";
        final String expCodPostal = "1000-160";
        final String expLocalidade = "Lisboa";
        final String expEndereco = String.format("%s %s %s %s %s", expRua, expLote, expAndar, expCodPostal, expLocalidade);
        Endereco instance = new Endereco(expRua, expLote, expAndar, expCodPostal, expLocalidade);
        assertEquals(expEndereco, instance.enderecoCompleto());   
    }
}
