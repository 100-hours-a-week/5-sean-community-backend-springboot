package org.example;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// AppConfig.java
@Configuration
@ComponentScan(basePackages = "org.example")
// org.example 패키지를 스캔해서 @Component 어노테이션이 붙은 클래스를 빈으로 등록

public class AppConfig {}