/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

import java.util.LinkedList;
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
public class ArbolLibrosTest {
    ArbolLibros instance;
    
    Libro l1 = new Libro(1, "a", 1, (short)1990, 0, 0);
    Libro l2 = new Libro(2, "b", 2, (short)2018, 0, 0);
    Libro l3 = new Libro(3, "c", 3, (short)2005, 0, 0);
    Libro l4 = new Libro(4, "d", 4, (short)1996, 0, 0);
    Libro l5 = new Libro(5, "e", 5, (short)1998, 0, 0);
    Libro l6 = new Libro(6, "f", 6, (short)1985, 0, 0);
    Libro l7 = new Libro(7, "c", 7, (short)1998, 0, 0);
    
    public ArbolLibrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ArbolLibros();
        
        instance.insertar(new TElementoAB("a", l1));
        instance.insertar(new TElementoAB("b", l2));
        instance.insertar(new TElementoAB("c", l3));
        instance.insertar(new TElementoAB("d", l4));
        instance.insertar(new TElementoAB("e", l5));
        instance.insertar(new TElementoAB("f", l6));
        instance.insertar(new TElementoAB("c", l7));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mostrarUltimasEdiciones method, of class ListaLibros.
     */
    @Test
    public void testMostrarUltimasEdiciones() {
        System.out.println("mostrarUltimasEdiciones");

        LinkedList<Libro> expResult1 = new LinkedList<>();
        
        expResult1.add(l2);
        expResult1.add(l3);
        expResult1.add(l4);
        expResult1.add(l5);
        
        LinkedList<Libro> result1 = instance.mostrarUltimasEdiciones(1995);
        
        assertTrue(result1.equals(expResult1));
        
        //
        
        LinkedList<Libro> expResult2 = new LinkedList<>();
        
        LinkedList<Libro> result2 = instance.mostrarUltimasEdiciones(2020);
        
        assertTrue(result2.equals(expResult2));
    }

    /**
     * Test of mostrarPorTitulo method, of class ListaLibros.
     */
    @Test
    public void testMostrarPorTitulo() {
        System.out.println("mostrarPorTitulo");
        
        Libro result1 = instance.mostrarPorTitulo("b");
        
        assertTrue(result1.getTitulo().equals(l2.getTitulo()));
        
        //
        
        Libro result2 = instance.mostrarPorTitulo("c");
        
        assertTrue(result2.getTitulo().equals(l3.getTitulo()));
        
        //
        
        Libro result3 = instance.mostrarPorTitulo("h");
        
        assertNull(result3);
    }

    /**
     * Test of mostrarPorAño method, of class ListaLibros.
     */
    @Test
    public void testMostrarPorAño() {
        System.out.println("mostrarPorA\u00f1o");
        
        LinkedList<Libro> expResult1 = new LinkedList<>();
        
        expResult1.add(l2);
        
        LinkedList<Libro> result1 = instance.mostrarPorAño(2018);
        
        assertTrue(result1.equals(expResult1));
        
        //
        
        LinkedList<Libro> expResult2 = new LinkedList<>();
        
        expResult2.add(l5);
        
        LinkedList<Libro> result2 = instance.mostrarPorAño(1998);
        
        assertTrue(result2.equals(expResult2));
        
        //
        
        LinkedList<Libro> expResult3 = new LinkedList<>();
        
        LinkedList<Libro> result3 = instance.mostrarPorAño(2020);
        
        assertTrue(result3.equals(expResult3));
    }

    /**
     * Test of mostrarPorISBN method, of class ListaLibros.
     */
    @Test
    public void testMostrarPorISBN() {
        System.out.println("mostrarPorISBN");
        
        Libro result1 = instance.mostrarPorISBN(2);
        
        assertEquals(result1, l2);
        
        //
        
        Libro result2 = instance.mostrarPorISBN(9);
        
        assertNull(result2);
    }
}
