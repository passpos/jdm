/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2ee.srvlocator;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class Service1 implements Service {

    @Override
    public void execute() {
        System.out.println("Executing Service1");
    }

    @Override
    public String getName() {
        return "Service1";
    }

}
