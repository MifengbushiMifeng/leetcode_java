package practices.transi;

import java.io.*;

public class ExternalizableTest implements Externalizable {

    private transient String content = " Will be serialized!";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableTest eTest = new ExternalizableTest();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File("test")));
        out.writeObject(eTest);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File("test")));

        ExternalizableTest inETest = (ExternalizableTest) in.readObject();
        System.out.print(inETest.content);

    }


}
