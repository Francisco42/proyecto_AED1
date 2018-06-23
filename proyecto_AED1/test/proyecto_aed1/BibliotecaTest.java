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
    
    Tag t1 = new Tag(1, "Suspenso");
    Tag t2 = new Tag(2, "Comedia");
    Tag t3 = new Tag(3, "Terror");
    Tag t4 = new Tag(4, "Fantasia");
    Tag t5 = new Tag(5, "Biografia");
    
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
        
        instance.insertarLibro(l1);
        instance.insertarLibro(l2);
        instance.insertarLibro(l3);
        instance.insertarLibro(l4);
        instance.insertarLibro(l5);
        instance.insertarLibro(l6);
        
        instance.insertarAutor(a1);
        instance.insertarAutor(a2);
        instance.insertarAutor(a3);
        instance.insertarAutor(a4);
        
        instance.insertarTag(t1);
        instance.insertarTag(t2);
        instance.insertarTag(t3);
        instance.insertarTag(t4);
        

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
        
        Biblioteca expResult1 = new Biblioteca();
        
        expResult1.insertarLibro(l1);
        expResult1.insertarLibro(l2);
        expResult1.insertarLibro(l3);
        expResult1.insertarLibro(l4);
        expResult1.insertarLibro(l5);
        expResult1.insertarLibro(l6);
        
        expResult1.insertarAutor(a1);
        expResult1.insertarAutor(a2);
        expResult1.insertarAutor(a3);
        expResult1.insertarAutor(a4);
        
        instance.eliminarAutor("Jose");
        
        assertTrue(instance.getArbolAutores().inOrden().equals(expResult1.getArbolAutores().inOrden()));
        assertTrue(instance.getArbolAutores().postOrden().equals(expResult1.getArbolAutores().postOrden()));
        
        assertTrue(instance.getArbolLibros().inOrden().equals(expResult1.getArbolLibros().inOrden()));
        assertTrue(instance.getArbolLibros().postOrden().equals(expResult1.getArbolLibros().postOrden()));
        
        //
        
        Biblioteca expResult2 = new Biblioteca();
        
        expResult2.insertarLibro(l1);
        expResult2.insertarLibro(l2);
        expResult2.insertarLibro(l3);
        expResult2.insertarLibro(l4);
        expResult2.insertarLibro(l5);
        expResult2.insertarLibro(l6);
        
        expResult2.insertarAutor(a1);
        expResult2.insertarAutor(a2);
        expResult2.insertarAutor(a3);
        
        instance.eliminarAutor("Lucas");
        
        assertTrue(instance.getArbolAutores().inOrden().equals(expResult2.getArbolAutores().inOrden()));
        assertTrue(instance.getArbolAutores().postOrden().equals(expResult2.getArbolAutores().postOrden()));
        
        assertTrue(instance.getArbolLibros().inOrden().equals(expResult2.getArbolLibros().inOrden()));
        assertTrue(instance.getArbolLibros().postOrden().equals(expResult2.getArbolLibros().postOrden()));
        
        //
        
        Biblioteca expResult3 = new Biblioteca();
        
        expResult3.insertarLibro(l4);
        expResult3.insertarLibro(l5);
        expResult3.insertarLibro(l6);
        
        expResult3.insertarAutor(a3);
        expResult3.insertarAutor(a2);
        
        instance.eliminarAutor("Juan");
        
        assertTrue(instance.getArbolAutores().inOrden().equals(expResult3.getArbolAutores().inOrden()));
        assertTrue(instance.getArbolAutores().postOrden().equals(expResult3.getArbolAutores().postOrden()));
        
        assertTrue(instance.getArbolLibros().inOrden().equals(expResult3.getArbolLibros().inOrden()));
        assertTrue(instance.getArbolLibros().postOrden().equals(expResult3.getArbolLibros().postOrden()));
    }

    /**
     * Test of eliminarTag method, of class Biblioteca.
     */
    @Test
    public void testEliminarTag() {
        System.out.println("eliminarTag");
        
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
        
        Biblioteca expResult1 = new Biblioteca();
        
        expResult1.insertarLibro(l1);
        expResult1.insertarLibro(l2);
        expResult1.insertarLibro(l3);
        expResult1.insertarLibro(l4);
        expResult1.insertarLibro(l5);
        expResult1.insertarLibro(l6);
        
        expResult1.insertarTag(t1);
        expResult1.insertarTag(t2);
        expResult1.insertarTag(t3);
        expResult1.insertarTag(t4);
        
        instance.eliminarTag("Biografia");
        
        assertTrue(instance.getArbolTags().inOrden().equals(expResult1.getArbolTags().inOrden()));
        assertTrue(instance.getArbolTags().postOrden().equals(expResult1.getArbolTags().postOrden()));
        
        assertTrue(instance.getArbolLibros().inOrden().equals(expResult1.getArbolLibros().inOrden()));
        assertTrue(instance.getArbolLibros().postOrden().equals(expResult1.getArbolLibros().postOrden()));
        
        //
        
        Biblioteca expResult2 = new Biblioteca();
        
        expResult2.insertarLibro(l1);
        expResult2.insertarLibro(l2);
        expResult2.insertarLibro(l3);
        expResult2.insertarLibro(l4);
        expResult2.insertarLibro(l5);
        expResult2.insertarLibro(l6);
        
        expResult2.insertarTag(t1);
        expResult2.insertarTag(t2);
        expResult2.insertarTag(t3);
        
        instance.eliminarTag("Fantasia");
        
        assertTrue(instance.getArbolTags().inOrden().equals(expResult2.getArbolTags().inOrden()));
        assertTrue(instance.getArbolTags().postOrden().equals(expResult2.getArbolTags().postOrden()));
        
        assertTrue(instance.getArbolLibros().inOrden().equals(expResult2.getArbolLibros().inOrden()));
        assertTrue(instance.getArbolLibros().postOrden().equals(expResult2.getArbolLibros().postOrden()));
        
        //
        
        Biblioteca expResult3 = new Biblioteca();
        
        expResult3.insertarLibro(l1);
        expResult3.insertarLibro(l4);
        expResult3.insertarLibro(l5);
        expResult3.insertarLibro(l6);
        
        expResult3.insertarTag(t2);
        expResult3.insertarTag(t3);
        
        instance.eliminarTag("Suspenso");
        
        assertTrue(instance.getArbolTags().inOrden().equals(expResult3.getArbolTags().inOrden()));
        assertTrue(instance.getArbolTags().postOrden().equals(expResult3.getArbolTags().postOrden()));
        
        assertTrue(instance.getArbolLibros().inOrden().equals(expResult3.getArbolLibros().inOrden()));
        assertTrue(instance.getArbolLibros().postOrden().equals(expResult3.getArbolLibros().postOrden()));
        
        assertEquals(instance.getArbolLibrosUntagged().inOrden(), "b-c");
        assertEquals(instance.getArbolLibrosUntagged().postOrden(), "c-b");
    }
}
