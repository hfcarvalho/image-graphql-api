package hfcarvalho.image;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping
    @RequestMapping("/")
    public String index() {
        return "Acesse /graphiql ou /playground para testar a API.";
    }

    @GetMapping
    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello World";
    }
}
