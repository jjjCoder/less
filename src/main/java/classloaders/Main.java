package classloaders;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Person person=new Person();
        Object o = Main.class.getClassLoader().loadClass("classloaders.classloader.Person").newInstance();
    }
}
