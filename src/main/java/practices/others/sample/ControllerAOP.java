package practices.others.sample;


import com.sun.xml.internal.ws.api.model.CheckedException;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class ControllerAOP {

    private static final Logger logger = Logger.getLogger(ControllerAOP.class);

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long stratTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>) pjp.proceed();

            logger.info(pjp.getSignature() + "use time : " + (System.currentTimeMillis() - stratTime));
        } catch (Throwable throwable) {
            result = handlerException(pjp, throwable);
        }
        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable throwable) {

        ResultBean<?> result = new ResultBean<>();


        if (throwable instanceof CheckedException) {
            result.setMsg(throwable.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        } else {
            logger.error(pjp.getSignature() + "error ", throwable);

            result.setMsg(throwable.toString());
            result.setCode(ResultBean.FAIL);
        }
        return null;
    }
}
