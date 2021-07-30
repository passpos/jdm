/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.builder;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface ItemInterface {

    public String name();

    public PackingInterface packing();

    public float price();
}
