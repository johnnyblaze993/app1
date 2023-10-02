package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpRequest;
import jakarta.inject.Inject;
import io.micronaut.http.client.HttpClient; 

@Controller("/App1")
public class App1Controller {

    @Inject
    private HttpClient httpClient;

    @Get("/")
    public String index() {
        return "Hello from App1!";
    }
    @Get("/callApp2")
    public String callApp2() {
        HttpRequest<String> request = HttpRequest.GET("http://localhost:8080/App2");
        String body = httpClient.toBlocking().retrieve(request);
        return body;
    }
}