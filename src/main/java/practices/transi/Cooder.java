package practices.transi;

import java.io.*;

public class Cooder implements Serializable {


    private static String name;

    private transient String password;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Cooder.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cooder cooder = new Cooder();
        //System.out.println(cooder.name + "/" + cooder.password);
        cooder.setName("Jon");
        cooder.setPassword("123456");
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("C:\\Jonzhou\\obj.txt"));
        objOut.writeObject(cooder);

        cooder.name = "Xia";
        System.out.println(cooder.name + "/" + cooder.password);

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("C:\\Jonzhou\\obj.txt"));
        Cooder reCooder = (Cooder) objIn.readObject();
        System.out.println(reCooder.name + "/" + reCooder.password);

    }
}
