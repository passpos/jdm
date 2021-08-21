/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Variant;
import java.net.URI;
import java.util.ArrayList;
import java.util.Locale;

/**
 * 400 Bad Request/错误的请求。由于被认为是客户端对错误（例如：畸形的请求语法、无效的请求信息帧
 * 或者虚拟的请求路由），服务器无法或不会处理当前请求。
 * 404 Not Found/未找到。源服务器未能找到目标资源的表示或者是不愿公开一个已经存在的资源表示。
 * 当没有与请求匹配的资源时。
 *
 * @author passpos <paiap@outlook.com>
 */
@Path("/response")
public class ResponseController {

    /**
     * code 200
     *
     * @return
     */
    @GET
    @Path("ok")
    public Response ok() {
        return Response.ok().build();
    }

    /**
     * code 201
     *
     * @return
     */
    @GET
    @Path("created")
    @Produces(MediaType.APPLICATION_JSON)
    public Response created() {
        return Response.created(URI.create("ok")).build();
    }

    /**
     * code 202
     *
     * @return
     */
    @GET
    @Path("accepted")
    @Produces(MediaType.APPLICATION_JSON)
    public Response accepted() {
        return Response.accepted().build();
    }

    /**
     * code 204
     *
     * @return
     */
    @GET
    @Path("no-content")
    @Produces(MediaType.APPLICATION_JSON)
    public Response noContent() {
        return Response.noContent().build();
    }

    /**
     * code 303
     * 重定向，常用于 POST 请求之后，
     *
     * @return
     */
    @GET
    @Path("see-other")
    @Produces(MediaType.APPLICATION_JSON)
    public Response seeOther() {
        return Response.seeOther(URI.create("ok")).build();
    }

    /**
     * code 304
     *
     * @return
     */
    @GET
    @Path("not-modified")
    @Produces(MediaType.APPLICATION_JSON)
    public Response notModified() {
        return Response.notModified().build();
    }

    /**
     * code 406
     *
     * @return
     */
    @GET
    @Path("not-acceptable")
    @Produces(MediaType.APPLICATION_JSON)
    public Response notAcceptable() {
        ArrayList<Variant> list = new ArrayList<>();
        Variant var = new Variant(MediaType.WILDCARD_TYPE, Locale.CANADA, "utf-8");
        list.add(var);
        return Response.notAcceptable(list).build();
    }

    /**
     * code 500
     *
     * @return
     */
    @GET
    @Path("server-error")
    @Produces(MediaType.APPLICATION_JSON)
    public Response serverError() {
        return Response.serverError().build();
    }

    /**
     * code 400
     *
     * 自定义的响应
     *
     * @return
     */
    @GET
    @Path("status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response status() {
        return Response.status(400).build();
    }

}
