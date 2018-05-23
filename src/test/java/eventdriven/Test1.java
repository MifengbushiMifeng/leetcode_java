package eventdriven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import practices.eventdriven.ContentEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
public class Test1 {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testCase1() {
        applicationContext.publishEvent(new ContentEvent("First event!"));
    }

}
