/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.factory;

import creational.factory.shape.ShapeFactory;
import creational.factory.shape.ShapeInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ShapeFactoryTest {

    public ShapeFactoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getShape method, of class ShapeFactory.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        String shapeType = "CIRCLE";
        ShapeFactory factory = new ShapeFactory();
        ShapeInterface s = factory.getShape(shapeType);
        assertEquals("circle", s.draw());
    }

    /**
     * Test of startFactory method, of class ShapeFactory.
     */
    @Test
    public void testStartFactory() {
        System.out.println("startFactory");
        ShapeFactory instance = new ShapeFactory();
        instance.startFactory();
        // TODO review the generated test code and remove the default call to fail.
    }

}
