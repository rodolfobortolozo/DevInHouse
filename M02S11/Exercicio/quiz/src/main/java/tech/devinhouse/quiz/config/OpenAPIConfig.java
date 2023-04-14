package tech.devinhouse.quiz.config;

import java.util.List;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
@Configuration
public class OpenAPIConfig {
  @Value("${openapi.dev-url}")
  private String devUrl;

  @Value("${openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
    contact.setEmail("rodolfobortolozo@gmail.com");
    contact.setName("Rodolfo Bortolozo");
    contact.setUrl("https://github.com/rodolfobortolozo");

    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
            .title("Tutorial Quiz Api")
            .version("1.0")
            .contact(contact)
            .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
            .license(mitLicense)
            .summary("asdasdasd");

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}