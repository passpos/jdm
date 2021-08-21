/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

/**
 * 支持跨域的过滤器
 *
 * @author passpos <paiap@outlook.com>
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle(
                "Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle(
                "Access-Control-Allow-Methods",
                "OPTIONS, HEAD, GET, POST, PUT, DELETE");
        response.getHeaders().putSingle(
                "Access-Control-Allow-Headers",
                "Content-Type");
    }

}
