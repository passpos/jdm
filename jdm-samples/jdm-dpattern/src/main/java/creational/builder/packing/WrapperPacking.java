/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creational.builder.packing;

import creational.builder.PackingInterface;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class WrapperPacking implements PackingInterface {

    @Override
    public String pack() {
        return "夹层";
    }

}
