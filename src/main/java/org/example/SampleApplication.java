package org.example;// SampleApplication.java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calcBean = context.getBean(Calculator.class);

//        System.out.println(calcBean.add(10, 5));
        System.out.println(calcBean.subtract(10, 5));
        System.out.println(calcBean.multiply(10, 5));
        System.out.println(calcBean.divide(10, 5));
        // some code..
    }

    @RestController
    static class HelloSpringController {
        @GetMapping("/hello-world")
        public String helloWorld() {
            return "Hello World!";
        }
    }
}