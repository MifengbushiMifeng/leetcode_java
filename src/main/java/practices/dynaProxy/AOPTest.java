package practices.dynaProxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPTest {

    @Pointcut("execution(* practices.dynaProxy.*.*(..))")
    public void pt() {

    }

    @Before("pt()")
    public void begin() {
        System.out.println("Transaction begin");

    }

    @After("pt()")
    public void after() {
        System.out.println("Close Transaction");
    }

}
