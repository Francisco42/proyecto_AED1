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
 * @author usuario
 */
public class BibliotecaTest {
    Biblioteca instance;
    Libro l1 = new Libro("a", 1, (short)1990, 0, 0);
    Libro l2 = new Libro("b", 2, (short)2018, 0, 0);
    Libro l3 = new Libro("c", 3, (short)2005, 0, 0);
    Libro l4 = new Libro("d", 4, (short)1996, 0, 0);
    Libro l5 = new Libro("e", 5, (short)1998, 0, 0);
    Libro l6 = new Libro("f", 6, (short)1985, 0, 0);
    
    public BibliotecaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Biblioteca();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of mostrarUltimasEdiciones method, of class Biblioteca.
     */
    @Test
    public void testMostrarUltimasEdiciones() {
        System.out.println("mostrarUltimasEdiciones");
        

        
        Biblioteca instance = new Biblioteca();
        
        instance.mostrarUltimasEdiciones(año);
        
        assertEquals(result, expResult);
    }

    /**
     * Test of mostrarPorTitulo method, of class Biblioteca.
     */
    @Test
    public void testMostrarPorTitulo() {
        System.out.println("mostrarPorTitulo");
        String titulo = "";
        Biblioteca instance = new Biblioteca();
        instance.mostrarPorTitulo(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPorAño method, of class Biblioteca.
     */
    @Test
    public void testMostrarPorAño() {
        System.out.println("mostrarPorA\u00f1o");
        int año = 0;
        Biblioteca instance = new Biblioteca();
        instance.mostrarPorAño(año);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPorISBN method, of class Biblioteca.
     */
    @Test
    public void testMostrarPorISBN() {
        System.out.println("mostrarPorISBN");
        long isbn = 0L;
        Biblioteca instance = new Biblioteca();
        instance.mostrarPorISBN(isbn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPorAutor method, of class Biblioteca.
     */
    @Test
    public void testMostrarPorAutor() {
        System.out.println("mostrarPorAutor");
        String autor = "";
        Biblioteca instance = new Biblioteca();
        instance.mostrarPorAutor(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPorTag method, of class Biblioteca.
     */
    @Test
    public void testMostrarPorTag() {
        System.out.println("mostrarPorTag");
        String tag = "";
        Biblioteca instance = new Biblioteca();
        instance.mostrarPorTag(tag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarDetalles method, of class Biblioteca.
     */
    @Test
    public void testMostrarDetalles() {
        System.out.println("mostrarDetalles");
        String nombre = "";
        Biblioteca instance = new Biblioteca();
        instance.mostrarDetalles(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAutor method, of class Biblioteca.
     */
    @Test
    public void testEliminarAutor() {
        System.out.println("eliminarAutor");
        String autor = "";
        Biblioteca instance = new Biblioteca();
        instance.eliminarAutor(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
