package practices.DynaProxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPTest {

    @Before("execution(* practices.DynaProxy.*.*(..))")
    public void begin() {
        System.out.println("Transaction begin");

    }

    @After("execution(* practices.DynaProxy.*.*(..))")
    public void after() {
        System.out.println("Close Transaction");
    }

}
