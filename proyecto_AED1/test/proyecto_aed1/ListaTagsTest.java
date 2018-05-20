/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francisco
 */
public class ListaTagsTest {
    ListaTags instance;
    
    Libro l1 = new Libro("a", 1, (short)1990, 0, 0);
    Libro l2 = new Libro("b", 2, (short)2018, 0, 0);
    Libro l3 = new Libro("c", 3, (short)2005, 0, 0);
    Libro l4 = new Libro("d", 4, (short)1996, 0, 0);
    Libro l5 = new Libro("e", 5, (short)1998, 0, 0);
    Libro l6 = new Libro("f", 6, (short)1985, 0, 0);
    
    Tag t1 = new Tag("Suspenso");
    Tag t2 = new Tag("Comedia");
    Tag t3 = new Tag("Terror");
    Tag t4 = new Tag("Fantasia");
    Tag t5 = new Tag("Biografia");
    
    public ListaTagsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        instance = new ListaTags();
        
        instance.insertar(new Nodo(1, t1));
        instance.insertar(new Nodo(2, t2));
        instance.insertar(new Nodo(3, t3));
        instance.insertar(new Nodo(4, t4));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mostrarPorTag method, of class ListaTags.
     */
    @Test
    public void testMostrarPorTag() {
        System.out.println("mostrarPorTag");
        
        l1.insertarTag(1, t1);
        l1.insertarTag(2, t2);
        l2.insertarTag(1, t1);
        l3.insertarTag(1, t1);
        l4.insertarTag(2, t2);
        l5.insertarTag(2, t2);
        l6.insertarTag(3, t3);
        
        t1.insertarLibro(1, l1);
        t1.insertarLibro(2, l2);
        t1.insertarLibro(3, l3);
        t2.insertarLibro(1, l1);
        t2.insertarLibro(4, l4);
        t2.insertarLibro(5, l5);
        t3.insertarLibro(6, l6);
        
        //
        
        Lista<Libro> result1 = instance.mostrarPorTag("Biografia");
        
        assertNull(result1);
        
        //
        
        Lista<Libro> expResult2 = new Lista<>();
        
        Lista<Libro> result2 = instance.mostrarPorTag("Fantasia");
        
        assertTrue(expResult2.equals(result2));
        
        //
        
        Lista<Libro> expResult3 = new Lista<>();
        
        expResult3.insertar(new Nodo(1, l1));
        expResult3.insertar(new Nodo(2, l2));
        expResult3.insertar(new Nodo(3, l3));
        
        Lista<Libro> result3 = instance.mostrarPorTag("Suspenso");
        
        assertTrue(expResult3.equals(result3));
    }
    
}
