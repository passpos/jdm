/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@ApplicationPath("api")
public class MyResourceConfig extends ResourceConfig {

    public MyResourceConfig() {
        register(FreemarkerMvcFeature.class);
        property(FreemarkerMvcFeature.TEMPLATE_BASE_PATH, "templates");

        // 资源包扫描
        packages("resource");
    }

}
