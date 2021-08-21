/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.UriConnegFilter;

/**
 * 项目的资源配置
 *
 * @author passpos <paiap@outlook.com>
 */
@ApplicationPath("api")
public class MyResourceConfig extends ResourceConfig {

    public MyResourceConfig() {
        // 资源包扫描
        packages("resource");

        // 跨域支持
        register(CORSFilter.class);

        // 文件上传功能
        register(MultiPartFeature.class);

        register(UriConnegFilter.class);

        // Bean Validation
        register(ValidationConfigurationContextResolver.class);
        // property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);

        // 数据库
    }

    public static <T> void ol(T t) {
        System.out.println(t);
    }
}
