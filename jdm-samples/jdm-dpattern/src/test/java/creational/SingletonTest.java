/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational;

import creational.Singleton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class SingletonTest {

    public SingletonTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of getInstance method, of class Singleton.
     */
    @Test
    public void testGetInstance() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("getInstance");
        Singleton insrance1 = Singleton.getInstance();
        Singleton insrance2 = Singleton.getInstance();
        assertEquals(insrance1, insrance2);
    }

    @Disabled
    @Test
    public void testSerializableBug() {
        Singleton s = Singleton.getInstance();

        //写
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("学习Java的小姐姐"))) {
            oos.writeObject(s);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SingletonTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSerializableException ex) {
            System.out.println("Singleton 未实现序列化接口");
        } catch (IOException ex) {
            Logger.getLogger(SingletonTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //读
        Singleton s1 = null;
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("学习Java的小姐姐"))) {
            s1 = (Singleton) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SingletonTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SingletonTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(s, s1);
    }
}
