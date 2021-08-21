/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import entity.Person;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Path("json")
public class JsonController {

    @GET
    @Path("string")
    @Produces(MediaType.APPLICATION_JSON)
    public String stringVal() {
        return "just string";
    }

    @GET
    @Path("char")
    @Produces(MediaType.APPLICATION_JSON)
    public char charVal() {
        return 'i';
    }

    @GET
    @Path("integer")
    @Produces(MediaType.APPLICATION_JSON)
    public int integerVal() {
        return 100;
    }

    @GET
    @Path("float")
    @Produces(MediaType.APPLICATION_JSON)
    public float floatVal() {
        return 100.33f;
    }

    @GET
    @Path("double")
    @Produces(MediaType.APPLICATION_JSON)
    public double doubleVal() {
        return 100.33d;
    }

    @GET
    @Path("boolean")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean booleanVal() {
        return true;
    }

    @GET
    @Path("array")
    @Produces(MediaType.APPLICATION_JSON)
    public int[] arrayVal() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        return arr;
    }

    @GET
    @Path("wrap/char")
    @Produces(MediaType.APPLICATION_JSON)
    public Character wrapCharVal() {
        return 'i';
    }

    @GET
    @Path("wrap/integer")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer wrapIntegerval() {
        return 100;
    }

    @GET
    @Path("wrap/boolean")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean wrapBooleanVal() {
        return true;
    }

    @GET
    @Path("object")
    @Produces(MediaType.APPLICATION_JSON)
    public Person objectToJson() {
        return new Person("老王", 55, true);
    }

    @GET
    @Path("collection")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> collectionToJson() {
        Person p1 = new Person("老王", 55, true);
        Person p2 = new Person("老李", 53, true);
        Person p3 = new Person("老张", 56, true);
        Person p4 = new Person("老赵", 47, false);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        return list;
    }

    /**
     * 浏览器提交表单数据，Content-Type经常会使用 application/x-www-form-urlencoded 或
     * MediaType.APPLICATION_FORM_URLENCODED 这种方式，直接提交键值对。
     * 而 @FormParam() 注解只与这种方式协同工作，当使用application/json时，@FormParam()
     * 直接报错；
     *
     * 所以，这种情况要求客户端以 application/x-www-form-urlencoded 方式发送表单；
     *
     * @param nickname
     * @param type
     * @param level
     * @param description
     */
    @POST
    @Path("json01")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void getJson01(
            @FormParam("nickname") String nickname,
            @FormParam("type") String type,
            @FormParam("level") String level,
            @FormParam("description") String description
    ) {
        System.out.println(nickname);
        System.out.println(type);
        System.out.println(level);
        System.out.println(description);
    }

    /**
     * 在现代Web中，application/json是一种非常流行的向服务端发送数据的方式。
     * 下面这种方式，利用Jakarta提供的接口，直接提取出用户发送的Json数据，十分方便；
     * JsonObject类表示不可变的 JSON 对象值（是零个或多个名称/值对的无序集合）。
     *
     * @param json
     */
    @POST
    @Path("json02")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void getJson02(JsonObject json) {
        System.out.println("json" + json);
    }

    /**
     * 上面的这种方式，是直接提取键值对，并转换为一个JsonObject对象。但是，有时需要直接将用户提
     * 交的数据按照我们需要的规则进行转换。
     *
     * 下面的示例就是这样的一种解决方案。
     * Jersey会自动将用户提交的Json转换到Person，但前提是用户的提交复合规范，且Person类提供了
     * 充分的 getters、setters API。
     *
     * @param p
     */
    @POST
    @Path("json03")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void getJson03(Person p) {
        System.out.println("json" + p);
    }
}
