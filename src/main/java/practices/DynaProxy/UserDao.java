package practices.DynaProxy;

import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUserDao {


    @Override
    public void save() {
        System.out.println("DB : save user info");
    }
}
