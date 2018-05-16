package practices.DynaProxy;

public class TestApp {

    public static void main(String[] args) {


        UserDao userDao = new UserDao();
        UserDao factory = (UserDao) new ProxyFactory(userDao).getProxyInstance();

        factory.save();

    }

    private static class UserDao {

        public UserDao() {

        }

        public void save() {
            System.out.println("save data!");
        }
    }
}
