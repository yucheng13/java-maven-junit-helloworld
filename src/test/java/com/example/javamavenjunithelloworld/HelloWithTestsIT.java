package com.example.javamavenjunithelloworld;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class HelloWithTestsIT {

    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();

    @Test
    public void doesItSayHelloTest() {
        String[] args = {"1"};
        HelloApp.main(args);

        assertThat(out.getLog(), is(equalTo(Hello.HELLO + "\n")));
    }

    @Test
    public void doesItSayHelloTest3() {
        String[] args = {"3"};
        HelloApp.main(args);

        String thrice = Hello.HELLO + "\n" + Hello.HELLO + "\n" + Hello.HELLO + "\n";
        assertThat(out.getLog(), is(equalTo(thrice)));
    }
}
