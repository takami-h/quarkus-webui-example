package com.natswell.examples.quarkus;

import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.providers.html.Renderable;

@Path("/greeting")
public class GreetingResource {
    private ThymeleafViews views;

    @Inject
    public GreetingResource(ThymeleafViews views) {
        this.views = views;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Renderable helloHtml(@QueryParam("to") String someone) {
        String message = String.format("hello %s!", Objects.toString(someone, "WORLD"));

        return views.view("/templates/greeting.html").with("greeting", message);
    }
}