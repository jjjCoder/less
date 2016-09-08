import java.lang.reflect.*;

/**
 * Created by SBTJavastudent on 20.08.2016.
 */
public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> testClass= Class.forName("Main$Test");
        System.out.println(testClass);
        Constructor constructor = testClass.getConstructor(String.class);
        Main.Test testInstance= (Main.Test) constructor.newInstance("Ivan");
        System.out.println(testInstance);
        Field fio = testClass.getDeclaredField("fio");
        System.out.println(fio);
        fio.setAccessible(true);
        System.out.println(fio.get(testInstance));
        fio.set(testInstance, "Vanya");
        System.out.println(fio.get(testInstance));

        Method method = testClass.getMethod("add", int.class, int.class);
        Object result = method.invoke(testInstance, 1, 2);
        System.out.println(result);


        ParameterizedType genericSuperclass = (ParameterizedType) testClass.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());

    }
}
