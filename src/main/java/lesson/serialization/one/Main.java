package lesson.serialization.one;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        read();
    }

    private static void read() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("serial.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        SerializableClass obj= (SerializableClass) ois.readObject();
        fis.close();
    }

    private static void write() throws IOException {
        FileOutputStream fos=new FileOutputStream("serial.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        SerializableClass obj=new SerializableClass();
        oos.writeObject(obj);
//        System.out.println(obj.superData);
        fos.close();
    }
}

class SerializableClass implements Serializable{
    private static final long serialVersionUID=1;
    String superData;
    public SerializableClass() {
        superData="!";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(superData);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        superData=in.readUTF();
    }
}
