//package tools.manager.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
//@Configuration
//@EnableSwagger2
//public class Swagger {
//    @Value("${swagger.title}")
//    private String TITLE;
//
//    @Value("${swagger.description}")
//    private String DESCRIPTION;
//
//    @Value("${swagger.version}")
//    private String VERSION;
//
//    @Value("${swagger.terms-of-service-url}")
//    private String TERMS_OF_SERVICE_URL;
//
//    @Value("${swagger.contact}")
//    private String CONTACT;
//
//    @Value("${swagger.licence}")
//    private String LICENCE;
//
//    @Value("${swagger.licence-url}")
//    private String LICENCE_URL;
//
//    @Value("${swagger.package}")
//    private String PACKAGE;
//
//    @Value("${swagger.url}")
//    private String URL;
//
//    @Bean
//    public Docket apis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                TITLE,
//                DESCRIPTION,
//                VERSION,
//                TERMS_OF_SERVICE_URL,
//                contact(),
//                LICENCE,
//                LICENCE_URL,
//                new ArrayList<>()
//        );
//    }
//
//    private Contact contact(){
//        return new Contact(
//                "Luiz Fernandes",
//                "https://luizfernandesoliveiraoficial.herokuapp.com",
//                "luizfernandesoliveiraoficial@gmail.com"
//        );
//    }
//}
