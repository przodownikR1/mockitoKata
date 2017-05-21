package pl.java.scalatech;

import org.junit.Test;
import org.slf4j.MDC;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Snippet {

    @Test
    public void test() {

        log.info("Starting app.");

        String username = "przodownik";
        MDC.put("username", username);
        log.debug("Hello {}", username);
        MDC.remove("username");

        username = "Fred";
        MDC.put("username", username);
        log.debug("Hello {}", username);
        MDC.remove("username");

        log.info("Finishing app.");
    }

    @Test
    public void test2() {

        MDC.put("first", "Dorothy");
        MDC.put("last", "Parker");

        log.info("Check enclosed.");
        log.debug("The most beautiful two words in English.");

        MDC.put("first", "Richard");
        MDC.put("last", "Nixon");
        log.info("I am not a crook.");
        log.info("Attributed to the former US president. 17 Nov 1973.");

    }
}
