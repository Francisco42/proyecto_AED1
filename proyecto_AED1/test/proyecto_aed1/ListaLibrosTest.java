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
public class ListaLibrosTest {
    static ListaLibros instance = new ListaLibros();
    
    public ListaLibrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Libro libro1 = new Libro("a", "autor1", 111111111, 1990, "Suspenso");
        instance.insertar(new Nodo<>(libro1, libro1.getISBN()));
        
        Libro libro2 = new Libro("b", "autor2", 222222222, 1991, "Drama");
        instance.insertar(new Nodo<>(libro2, libro2.getISBN()));
        
        Libro libro3 = new Libro("c", "autor3", 333333333, 1989, "Drama");
        instance.insertar(new Nodo<>(libro3, libro3.getISBN()));
        
        Libro libro4 = new Libro("d", "autor3", 444444444, 1992, "Suspenso");
        instance.insertar(new Nodo<>(libro4, libro4.getISBN()));
        
        Libro libro5 = new Libro("e", "autor4", 555555555, 1993, "Suspenso");
        instance.insertar(new Nodo<>(libro5, libro5.getISBN()));
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
     * Test of buscarPorNombre method, of class ListaLibros.
     */
    @Test
    public void testBuscarPorNombre() {
        
        System.out.println("buscarPorNombre");
        
        String nombre = "d";

        ListaLibros expResult = new ListaLibros();
        
        Libro libro4 = new Libro("d", "autor3", 444444444, 1992, "Suspenso");
        expResult.insertar(new Nodo<>(libro4, libro4.getISBN()));
        
        ListaLibros result = instance.buscarPorNombre(nombre);
        
        result.imprimirDatos();
        expResult.imprimirDatos();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPorAutor method, of class ListaLibros.
     */
    @Test
    public void testBuscarPorAutor() {
        System.out.println("buscarPorAutor");
        String autor = "";
        ListaLibros instance = new ListaLibros();
        ListaLibros expResult = null;
        ListaLibros result = instance.buscarPorAutor(autor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorGenero method, of class ListaLibros.
     */
    @Test
    public void testBuscarPorGenero() {
        System.out.println("buscarPorGenero");
        String genero = "";
        ListaLibros instance = new ListaLibros();
        ListaLibros expResult = null;
        ListaLibros result = instance.buscarPorGenero(genero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorAño method, of class ListaLibros.
     */
    @Test
    public void testBuscarPorAño() {
        System.out.println("buscarPorA\u00f1o");
        int año = 0;
        ListaLibros instance = new ListaLibros();
        ListaLibros expResult = null;
        ListaLibros result = instance.buscarPorAño(año);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAPartirDel method, of class ListaLibros.
     */
    @Test
    public void testBuscarAPartirDel() {
        System.out.println("buscarAPartirDel");
        int año = 0;
        ListaLibros instance = new ListaLibros();
        ListaLibros expResult = null;
        ListaLibros result = instance.buscarAPartirDel(año);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
