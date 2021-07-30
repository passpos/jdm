/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern.creational.abstractfactory;

import dpattern.creational.factory.AbstractFactory;
import dpattern.creational.factory.color.ColorInterface;
import dpattern.creational.factory.shape.ShapeInterface;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class AbstractFactoryTest {

    public AbstractFactoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getColorShape method, of class AbstractFactory.
     */
    @Test
    public void testGetColorShape() {
        System.out.println("getColorShape");
        String colorStr = "red";
        String shapeStr = "circle";
        AbstractFactory instance = new AbstractFactoryImpl();
        String expResult = "red - circle";
        String result = instance.getColorShape(colorStr, shapeStr);
        assertEquals(expResult, result);
    }

    public class AbstractFactoryImpl extends AbstractFactory {

        @Override
        public ColorInterface getColor(String color) {
            return null;
        }

        @Override
        public ShapeInterface getShape(String shape) {
            return null;
        }
    }

}
