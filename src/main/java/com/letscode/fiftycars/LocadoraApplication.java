package com.letscode.fiftycars;

import com.letscode.fiftycars.domain.imposto.Imposto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LocadoraApplication {

    @Qualifier("ipi")
    @Autowired
    private Imposto imposto;

    @PostConstruct
    public void init(){
        System.out.println(imposto);
    }

    public static void main(String[] args) {
        SpringApplication.run(LocadoraApplication.class, args);
    }
}
