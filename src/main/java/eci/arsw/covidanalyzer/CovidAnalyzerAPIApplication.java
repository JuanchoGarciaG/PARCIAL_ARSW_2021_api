package eci.arsw.covidanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Covid analyzer api application.
 */
@SpringBootApplication
public class CovidAnalyzerAPIApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CovidAnalyzerAPIApplication.class, args);
    }

}
