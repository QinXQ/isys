package springBaseJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Q on 2017/2/5.
 */
@Configuration
public class SpringConfig {
    @Bean
    public Person person(){
        return new Person();
    }
}
