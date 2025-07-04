package com.nk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {

    static String url = "http://localhost:8081/ticket/{ticketNum}";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


        WebClient webClient = WebClient.create();

        System.out.println("request sending start .....");

        webClient.get()
                .uri(url, 4)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(Application::handleResponse);

        System.out.println("request sending end .....");

        /* Example of sync call using block method */
        /*System.out.println("request sending start.......");
        String response = webClient.get()
                                    .uri( url, 4)
                                    .retrieve()
                                    .bodyToMono(String.class)
                                    .block();

        System.out.println("request sending end......");
        System.out.println(response);*/



    }

    public static void handleResponse(String response){
        System.out.println(response);
    }

}
