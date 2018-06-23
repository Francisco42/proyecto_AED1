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
public class ArbolTagsTest {
    ArbolTags instance;
    
    Libro l1 = new Libro(1, "a", 1, (short)1990, 0, 0);
    Libro l2 = new Libro(2, "b", 2, (short)2018, 0, 0);
    Libro l3 = new Libro(3, "c", 3, (short)2005, 0, 0);
    Libro l4 = new Libro(4, "d", 4, (short)1996, 0, 0);
    Libro l5 = new Libro(5, "e", 5, (short)1998, 0, 0);
    Libro l6 = new Libro(6, "f", 6, (short)1985, 0, 0);
    
    Tag t1 = new Tag(1, "Suspenso");
    Tag t2 = new Tag(2, "Comedia");
    Tag t3 = new Tag(3, "Terror");
    Tag t4 = new Tag(4, "Fantasia");
    Tag t5 = new Tag(5, "Biografia");
    
    public ArbolTagsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        instance = new ArbolTags();
        
        instance.insertar(new TElementoAB("Suspenso", t1));
        instance.insertar(new TElementoAB("Comedia", t2));
        instance.insertar(new TElementoAB("Terror", t3));
        instance.insertar(new TElementoAB("Fantasia", t4));
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
        
        l1.insertarTag(t1);
        l1.insertarTag(t2);
        l2.insertarTag(t1);
        l3.insertarTag(t1);
        l4.insertarTag(t2);
        l5.insertarTag(t2);
        l6.insertarTag(t3);
        
        t1.insertarLibro(l1);
        t1.insertarLibro(l2);
        t1.insertarLibro(l3);
        t2.insertarLibro(l1);
        t2.insertarLibro(l4);
        t2.insertarLibro(l5);
        t3.insertarLibro(l6);
        
        //
        
        Lista<Libro> result1 = instance.mostrarPorTag("Biografia");
        
        assertNull(result1);
        
        //
        
        Lista<Libro> expResult2 = new Lista<>();
        
        Lista<Libro> result2 = instance.mostrarPorTag("Fantasia");
        
        assertTrue(expResult2.equals(result2));
        
        //
        
        Lista<Libro> expResult3 = new Lista<>();
        
        expResult3.insertar(new Nodo("a", l1));
        expResult3.insertar(new Nodo("b", l2));
        expResult3.insertar(new Nodo("c", l3));
        
        Lista<Libro> result3 = instance.mostrarPorTag("Suspenso");
        
        assertTrue(expResult3.equals(result3));
    }
    
}
