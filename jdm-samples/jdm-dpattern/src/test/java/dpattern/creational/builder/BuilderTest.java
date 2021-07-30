/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern.creational.builder;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class BuilderTest {

    public BuilderTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of useBuilder method, of class Builder.
     */
    @Test
    public void testUseBuilder() {
        System.out.println("useBuilder");
        Builder.useBuilder();
    }

    /**
     * Test of prepareVegMeal method, of class Builder.
     */
    @Test
    public void testPrepareVegMeal() {
        System.out.println("prepareVegMeal");
        Builder builder = new Builder();
        AMeal vegMeal = builder.prepareVegMeal();
        System.out.println("素餐");
        vegMeal.showItems();
        System.out.println("总消费：" + vegMeal.getCost());
    }

    /**
     * Test of prepareNonVegMeal method, of class Builder.
     */
    @Test
    public void testPrepareNonVegMeal() {
        System.out.println("prepareNonVegMeal");
        Builder builder = new Builder();
        AMeal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("\n\n非素");
        nonVegMeal.showItems();
        System.out.println("总消费：" + nonVegMeal.getCost());
    }

}
