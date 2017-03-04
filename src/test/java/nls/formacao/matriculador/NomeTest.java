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
public class NomeTest {
    
    public NomeTest() {
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
    
    @Test
    public void testConstructor(){
        Nome instance = new Nome();
        assertEquals("", instance.getPrimeiro());
        assertEquals("", instance.getMeio());
        assertEquals("", instance.getUltimo());
        assertEquals("", instance.nomeCompleto());
    }
    
    @Test
    public void testConstructorTwoParams(){
        Nome instance = new Nome("John", "Doe");
        assertEquals("John", instance.getPrimeiro());
        assertEquals("", instance.getMeio());
        assertEquals("Doe", instance.getUltimo());
        assertEquals("John Doe", instance.nomeCompleto());
    }
    
    @Test
    public void testConstructorThreeParams(){
        Nome instance = new Nome("John", "Middle", "Doe");
        assertEquals("John", instance.getPrimeiro());
        assertEquals("Middle", instance.getMeio());
        assertEquals("Doe", instance.getUltimo());
        assertEquals("John Middle Doe", instance.nomeCompleto());
    }

    /**
     * Test of getPrimeiro method, of class Nome.
     */
    @Test
    public void testGetPrimeiro() {
        Nome instance = new Nome("John", "Doe");
        String expResult = "John";
        String result = instance.getPrimeiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrimeiro method, of class Nome.
     */
    @Test
    public void testSetPrimeiro() {
        String primeiro = "John";
        Nome instance = new Nome();
        instance.setPrimeiro(primeiro);
        assertEquals(primeiro, instance.getPrimeiro());
    }

    /**
     * Test of getMeio method, of class Nome.
     */
    @Test
    public void testGetMeio() {
        Nome instance = new Nome("John", "Middle", "Doe");
        String expResult = "Middle";
        String result = instance.getMeio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeio method, of class Nome.
     */
    @Test
    public void testSetMeio() {
        String meio = "Middle";
        Nome instance = new Nome();
        instance.setMeio(meio);
        assertEquals(meio, instance.getMeio());
    }

    /**
     * Test of getUltimo method, of class Nome.
     */
    @Test
    public void testGetUltimo() {
        Nome instance = new Nome("John", "Doe");
        String expResult = "Doe";
        String result = instance.getUltimo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUltimo method, of class Nome.
     */
    @Test
    public void testSetUltimo() {
        String ultimo = "Dow";
        Nome instance = new Nome();
        instance.setUltimo(ultimo);
        assertEquals(ultimo, instance.getUltimo());
    }

    /**
     * Test of nomeCompleto method, of class Nome.
     */
    @Test
    public void testNomeCompleto() {
        Nome instance = new Nome("John", "Middle", "Doe");
        String expResult = "John Middle Doe";
        String result = instance.nomeCompleto();
        assertEquals(expResult, result);
        
        instance = new Nome("John", "Doe");
        expResult = "John Doe";
        result = instance.nomeCompleto();
        assertEquals(expResult, result);
        
        instance = new Nome();
        expResult = "";
        result = instance.nomeCompleto();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Nome.
     */
    @Test
    public void testToString() {
        Nome instance = new Nome("John", "Middle", "Doe");
        String expResult = "Nome{primeiro=John, meio=Middle, ultimo=Doe}";
        String result = instance.toString();
        assertEquals(expResult, result);        
    }

    /**
     * Test of hashCode method, of class Nome.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Nome instance = new Nome();
        int expResult = 148955;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Nome.
     */
    @Test
    public void testEquals() {
        
        Object obj = new Nome("John", "Doe");
        Nome instance = new Nome("John", "Doe");
        boolean result = instance.equals(obj);
        assertTrue(result);
        
        obj = new Nome("John", "Middle", "Doe");
        instance = new Nome("John", "Doe");
        result = instance.equals(obj);
        assertFalse(result);
        
        obj = new Nome();
        instance = new Nome();
        result = instance.equals(obj);
        assertTrue(result);
    }
    
}
