package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.HttpRequest;
import jakarta.inject.Inject;
import io.micronaut.http.client.HttpClient; 
import io.micronaut.http.MediaType;

@Controller("/hello") // <1>
public class App1Controller {

        @Inject
    private HttpClient httpClient;


    @Get // <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    public String index() {
        return "Hello World"; // <4>
    }

        @Get("/callApp2")
    public String callApp2() {
        HttpRequest<String> request = HttpRequest.GET("http://localhost:9090/app2/hello");
        String body = httpClient.toBlocking().retrieve(request);
        return body;
    }
}
