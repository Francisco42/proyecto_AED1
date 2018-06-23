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
public class ArbolAutoresTest {
    ArbolAutores instance;
    
    Libro l1 = new Libro(1, "a", 1, (short)1990, 0, 0);
    Libro l2 = new Libro(2, "b", 2, (short)2018, 0, 0);
    Libro l3 = new Libro(3, "c", 3, (short)2005, 0, 0);
    Libro l4 = new Libro(4, "d", 4, (short)1996, 0, 0);
    Libro l5 = new Libro(5, "e", 5, (short)1998, 0, 0);
    Libro l6 = new Libro(6, "f", 6, (short)1985, 0, 0);
    
    Autor a1 = new Autor(1, "Juan");
    Autor a2 = new Autor(2, "Pedro");
    Autor a3 = new Autor(3, "Pablo");
    Autor a4 = new Autor(4, "Lucas");
    Autor a5 = new Autor(5, "Jose");
    
    public ArbolAutoresTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        instance = new ArbolAutores();
        
        instance.insertar(new TElementoAB("Juan", a1));
        instance.insertar(new TElementoAB("Pedro", a2));
        instance.insertar(new TElementoAB("Pablo", a3));
        instance.insertar(new TElementoAB("Lucas", a4));
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

        l1.insertarAutor(a1);
        l1.insertarAutor(a2);
        l2.insertarAutor(a1);
        l3.insertarAutor(a1);
        l4.insertarAutor(a2);
        l5.insertarAutor(a2);
        l6.insertarAutor(a3);
        
        a1.insertarLibro(l1);
        a1.insertarLibro(l2);
        a1.insertarLibro(l3);
        a2.insertarLibro(l1);
        a2.insertarLibro(l4);
        a2.insertarLibro(l5);
        a3.insertarLibro(l6);
        
        //
        
        Lista<Libro> result1 = instance.mostrarPorAutor("Jose");
        
        assertNull(result1);
        
        //
        
        Lista<Libro> expResult2 = new Lista<>();
        
        Lista<Libro> result2 = instance.mostrarPorAutor("Lucas");
        
        assertTrue(expResult2.equals(result2));
        
        //
        
        Lista<Libro> expResult3 = new Lista<>();
        
        expResult3.insertar(new Nodo("a", l1));
        expResult3.insertar(new Nodo("b", l2));
        expResult3.insertar(new Nodo("c", l3));
        
        Lista<Libro> result3 = instance.mostrarPorAutor("Juan");
        
        assertTrue(expResult3.equals(result3));
    }
    
}
