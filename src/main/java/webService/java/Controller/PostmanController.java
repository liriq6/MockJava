package webService.java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


@RestController
public class PostmanController {
    @Autowired
    Utils utils;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @PostMapping("/greeting")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody(required = false) String body) throws Exception {
        Context context = new Context();
        String a = utils.getSubstring(body, "<Type>", "</Type>");
        context.setVariable("name",a);
        context.setVariable("stock","false");
        context.setVariable("stocx","true");
        context.setVariable("base","int");
        String responseBody = springTemplateEngine.process("XML.xml",context);
        return responseBody;
    }
}
