package practices.dynaProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp2 {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("application.xml");

        IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");

        System.out.println(iUserDao.getClass());

        iUserDao.save();

    }
}
