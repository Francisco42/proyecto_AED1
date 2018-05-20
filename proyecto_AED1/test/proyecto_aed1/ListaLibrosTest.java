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
public class ListaLibrosTest {
    ListaLibros instance;
    
    Libro l1 = new Libro("a", 1, (short)1990, 0, 0);
    Libro l2 = new Libro("b", 2, (short)2018, 0, 0);
    Libro l3 = new Libro("c", 3, (short)2005, 0, 0);
    Libro l4 = new Libro("d", 4, (short)1996, 0, 0);
    Libro l5 = new Libro("e", 5, (short)1998, 0, 0);
    Libro l6 = new Libro("f", 6, (short)1985, 0, 0);
    Libro l7 = new Libro("c", 7, (short)1998, 0, 0);
    
    public ListaLibrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ListaLibros();
        
        instance.insertar(new Nodo(1, l1));
        instance.insertar(new Nodo(2, l2));
        instance.insertar(new Nodo(3, l3));
        instance.insertar(new Nodo(4, l4));
        instance.insertar(new Nodo(5, l5));
        instance.insertar(new Nodo(6, l6));
        instance.insertar(new Nodo(7, l7));
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

        ListaLibros expResult1 = new ListaLibros();
        
        expResult1.insertar(new Nodo(2, l2));
        expResult1.insertar(new Nodo(3, l3));
        expResult1.insertar(new Nodo(4, l4));
        expResult1.insertar(new Nodo(5, l5));
        expResult1.insertar(new Nodo(7, l7));
        
        ListaLibros result1 = instance.mostrarUltimasEdiciones(1995);
        
        assertTrue(result1.equals(expResult1));
        
        //
        
        ListaLibros expResult2 = new ListaLibros();
        
        ListaLibros result2 = instance.mostrarUltimasEdiciones(2020);
        
        assertTrue(result2.equals(expResult2));
    }

    /**
     * Test of mostrarPorTitulo method, of class ListaLibros.
     */
    @Test
    public void testMostrarPorTitulo() {
        System.out.println("mostrarPorTitulo");
        
        ListaLibros expResult1 = new ListaLibros();
        
        expResult1.insertar(new Nodo(2, l2));
        
        ListaLibros result1 = instance.mostrarPorTitulo("b");
        
        assertTrue(result1.equals(expResult1));
        
        //
        
        ListaLibros expResult2 = new ListaLibros();
        
        expResult2.insertar(new Nodo(3, l3));
        expResult2.insertar(new Nodo(7, l7));
        
        ListaLibros result2 = instance.mostrarPorTitulo("c");
        
        assertTrue(result2.equals(expResult2));
        
        //
        
        ListaLibros expResult3 = new ListaLibros();
        
        ListaLibros result3 = instance.mostrarPorTitulo("h");
        
        assertTrue(result3.equals(expResult3));
    }

    /**
     * Test of mostrarPorAño method, of class ListaLibros.
     */
    @Test
    public void testMostrarPorAño() {
        System.out.println("mostrarPorA\u00f1o");
        
        ListaLibros expResult1 = new ListaLibros();
        
        expResult1.insertar(new Nodo(2, l2));
        
        ListaLibros result1 = instance.mostrarPorAño(2018);
        
        assertTrue(result1.equals(expResult1));
        
        //
        
        ListaLibros expResult2 = new ListaLibros();
        
        expResult2.insertar(new Nodo(5, l5));
        expResult2.insertar(new Nodo(7, l7));
        
        ListaLibros result2 = instance.mostrarPorAño(1998);
        
        assertTrue(result2.equals(expResult2));
        
        //
        
        ListaLibros expResult3 = new ListaLibros();
        
        ListaLibros result3 = instance.mostrarPorAño(2020);
        
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
