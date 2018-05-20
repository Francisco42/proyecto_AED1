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
public class ListaAutoresTest {
    ListaAutores instance;
    
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
    
    public ListaAutoresTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        instance = new ListaAutores();
        
        instance.insertar(new Nodo(1, a1));
        instance.insertar(new Nodo(2, a2));
        instance.insertar(new Nodo(3, a3));
        instance.insertar(new Nodo(4, a4));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mostrarPorAutor method, of class ListaAutores.
     */
    @Test
    public void testMostrarPorAutor() {
        System.out.println("mostrarPorAutor");

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
        
        Lista<Libro> result1 = instance.mostrarPorAutor("Jose");
        
        assertNull(result1);
        
        //
        
        Lista<Libro> expResult2 = new Lista<>();
        
        Lista<Libro> result2 = instance.mostrarPorAutor("Lucas");
        
        assertTrue(expResult2.equals(result2));
        
        //
        
        Lista<Libro> expResult3 = new Lista<>();
        
        expResult3.insertar(new Nodo(1, l1));
        expResult3.insertar(new Nodo(2, l2));
        expResult3.insertar(new Nodo(3, l3));
        
        Lista<Libro> result3 = instance.mostrarPorAutor("Juan");
        
        assertTrue(expResult3.equals(result3));
    }
    
}
