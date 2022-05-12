package com.letscode.fiftycars.config;

import com.letscode.fiftycars.domain.imposto.ICMS;
import com.letscode.fiftycars.domain.imposto.IPI;
import com.letscode.fiftycars.domain.imposto.Imposto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @Qualifier("ipi")
    public Imposto ipi(){
        return new IPI();
    }

    @Bean
    @Qualifier("icms")
    public Imposto icms(){
        return new ICMS();
    }

}
