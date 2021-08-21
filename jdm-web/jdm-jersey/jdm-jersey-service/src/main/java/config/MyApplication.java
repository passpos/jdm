/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import resource.HelloController;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(HelloController.class);
        return s;
    }

}
