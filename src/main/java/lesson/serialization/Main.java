package lesson.serialization;

import org.apache.commons.codec.binary.Hex;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        SerializableClass obj=new SerializableClass();
        System.out.println(obj);
        oos.writeObject(obj);
        ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        SerializableClass o= (SerializableClass) in.readObject();
        System.out.println(o);
        System.out.println(o.superData);

//        String hexString= Hex.encodeHexString(o.superData.getBytes());
    }
}
//writeReplace()
//readResolve()
class NotSerializable{

    String superData;
    int likes=50;
    static String version="1.0.1";
    public NotSerializable(){
        superData="!";
        System.out.println("super");
    }
    public NotSerializable(String superData) {
        this.superData = superData;
    }
}
class SerializableClass extends NotSerializable implements Serializable{

    public SerializableClass() {
    }

    public SerializableClass(String superData) {
        super(superData);
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(superData);
        out.writeInt(likes);
        out.writeUTF(version);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        superData=in.readUTF();
        likes=in.readInt();
        version=in.readUTF();
    }
}
