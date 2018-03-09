package practices.JCiP.Sample1.Donot;

public class LazyInitRace {


    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

    class ExpensiveObject {

    }
}
