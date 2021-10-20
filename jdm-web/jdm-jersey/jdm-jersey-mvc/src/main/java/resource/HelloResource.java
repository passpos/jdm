/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Path("/")
public class HelloResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getHello() {
        final Map<String, Object> map = new HashMap<>();
        map.put("user", "Pavel");

        final List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        map.put("items", list);

        return new Viewable("/hello.ftl", map);
    }

    @GET
    @Path("hello-default-model")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getHelloWithDefaultModel() {
        return new Viewable("/hello-default-model.ftl", "Pavel");
    }

    @GET
    @Path("autoTemplate")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getAutoTemplate() {
        final Map<String, String> map = new HashMap<>();
        map.put("user", "Pavel");

        // template name is derived from resource class name
        return new Viewable("/org/glassfish/jersey/examples/freemarker/resources/FreemarkerResource.ftl",
                map);
    }

    @GET
    @Path("helloWithoutSuffix")
    @Produces(MediaType.TEXT_HTML)
    public Viewable getHelloWithoutSuffix() {
        final Map<String, Object> map = new HashMap<>();
        map.put("user", "Pavel");
        final List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        map.put("items", list);

        return new Viewable("/hello", map);
    }
}
