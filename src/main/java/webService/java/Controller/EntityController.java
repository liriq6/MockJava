package webService.java.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import java.util.Scanner;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
public class EntityController {
    @Autowired
    Utils utils;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    private static final Logger logger = LogManager.getLogger(EntityController.class);

    @PostMapping("/entity")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody(required = false) String body) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();//Обьявляем заголовки запроса
        httpHeaders.add("Key1", "value1");//добавляем заголовок запроса
        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader("application.properties"));
//            Scanner scan = new Scanner(br);
//            br.close();
//        } catch (IOException e) {
//            System.out.println("Error");
//        }
        PropsReader prop = new PropsReader(1000, 10000);// Создаем обьект prop(класса PropsReader) ,вызываем конструктор и добавляем два параметра
        Thread.sleep(prop.getLatency());//Добавляем задержку ответа через конструктор PropsReader
        Context context = new Context();
        String a = utils.getSubstring(body, "<Type>", "</Type>"); // использует метод utils и передает в него значения body,lb,rb
        context.setVariable("name", a); //изменяет в xml значение name на строку a
        String responseBody = springTemplateEngine.process("XML.xml", context); // отправляет все изменения обьекта context в файл XML.xml
//        logger.debug(body);
//        logger.debug(responseBody);
        return new ResponseEntity<String>(responseBody, httpHeaders, HttpStatus.OK); //200 - OK ,404 - NOT-FOUND , возвращает статус,тело и заголовки запроса
    }
}
