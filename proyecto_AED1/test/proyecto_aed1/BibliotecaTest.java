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
    
    Autor a1 = new Autor(1, "Juan");
    Autor a2 = new Autor(2, "Pedro");
    Autor a3 = new Autor(3, "Pablo");
    Autor a4 = new Autor(4, "Lucas");
    Autor a5 = new Autor(5, "Jose");
    
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
        
        instance.insertarLibro(1, l1);
        instance.insertarLibro(2, l2);
        instance.insertarLibro(3, l3);
        instance.insertarLibro(4, l4);
        instance.insertarLibro(5, l5);
        instance.insertarLibro(6, l6);
        
        instance.insertarAutor(1, a1);
        instance.insertarAutor(2, a2);
        instance.insertarAutor(3, a3);
        instance.insertarAutor(4, a4);
        

    }
    @After
    public void tearDown() {
    }

    /**
     * Test of eliminarAutor method, of class Biblioteca.
     */
    @Test
    public void testEliminarAutor() {
        System.out.println("eliminarAutor");
        
        l1.insertarAutor(1, a1);
        l1.insertarAutor(2, a2);
        l2.insertarAutor(1, a1);
        l3.insertarAutor(1, a1);
        l4.insertarAutor(2, a2);
        l5.insertarAutor(2, a2);
        l6.insertarAutor(3, a3);
        
        a1.insertarLibro(1, l1);
        a1.insertarLibro(2, l2);
        a1.insertarLibro(3, l3);
        a2.insertarLibro(1, l1);
        a2.insertarLibro(4, l4);
        a2.insertarLibro(5, l5);
        a3.insertarLibro(6, l6);
        
        //
        
        Biblioteca expResult1 = new Biblioteca();
        
        expResult1.insertarLibro(1, l1);
        expResult1.insertarLibro(2, l2);
        expResult1.insertarLibro(3, l3);
        expResult1.insertarLibro(4, l4);
        expResult1.insertarLibro(5, l5);
        expResult1.insertarLibro(6, l6);
        
        expResult1.insertarAutor(1, a1);
        expResult1.insertarAutor(2, a2);
        expResult1.insertarAutor(3, a3);
        expResult1.insertarAutor(4, a4);
        
        instance.eliminarAutor("Jose");
        
        assertTrue(instance.getListaAutores().equals(expResult1.getListaAutores()));
        assertTrue(instance.getListaLibros().equals(expResult1.getListaLibros()));
        
        //
        
        Biblioteca expResult2 = new Biblioteca();
        
        expResult2.insertarLibro(1, l1);
        expResult2.insertarLibro(2, l2);
        expResult2.insertarLibro(3, l3);
        expResult2.insertarLibro(4, l4);
        expResult2.insertarLibro(5, l5);
        expResult2.insertarLibro(6, l6);
        
        expResult2.insertarAutor(1, a1);
        expResult2.insertarAutor(2, a2);
        expResult2.insertarAutor(3, a3);
        
        instance.eliminarAutor("Lucas");
        
        assertTrue(instance.getListaAutores().equals(expResult2.getListaAutores()));
        assertTrue(instance.getListaLibros().equals(expResult2.getListaLibros()));
        
        //
        
        Biblioteca expResult3 = new Biblioteca();
        
        expResult3.insertarLibro(4, l4);
        expResult3.insertarLibro(5, l5);
        expResult3.insertarLibro(6, l6);
        
        expResult3.insertarAutor(2, a2);
        expResult3.insertarAutor(3, a3);
        
        instance.eliminarAutor("Juan");
        
        assertTrue(instance.getListaAutores().equals(expResult3.getListaAutores()));
        assertTrue(instance.getListaLibros().equals(expResult3.getListaLibros()));
    }
}
