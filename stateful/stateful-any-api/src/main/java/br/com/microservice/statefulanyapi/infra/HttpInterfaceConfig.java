package br.com.microservice.statefulanyapi.infra;

import br.com.microservice.statefulanyapi.core.client.TokenClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

    @Value("${app.client.base-url}")
    private String baseUrl;

    @Bean
    public TokenClient tokenClient() {
        return HttpServiceProxyFactory
            .builder(WebClientAdapter
                .forClient(
                    WebClient
                        .builder()
                        .baseUrl(baseUrl)
                        .build()))
            .build()
            .createClient(TokenClient.class);
    }
}
