package practices.dynaProxy;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println(" User adding...");
    }
}
