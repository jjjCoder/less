import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.lang.reflect.*;

/**
 * Created by SBTJavastudent on 13.08.2016.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
//        Class<String> classString = String.class;
//        for (Constructor constructor1 : classString.getConstructors()) {
//            System.out.println(constructor1);
//        }
        Class<Test> testClass= (Class<Test>) Class.forName("Main$Test");
        printConstructors(testClass);
//        printMethods(testClass);
//        printSuperclasses(testClass);
        //printFields(testClass);


    }

    private static void printFields(Class<?> testClass) {
        for(Field field:testClass.getDeclaredFields()){
            System.out.println(field);
            int modifiers = field.getModifiers();
            if(Modifier.isPublic(modifiers)){
                System.out.print("Public ");
            }
            System.out.println(field.getName());
        }
    }

    //hometask. вывести в обратном порядке со стрелочкой как в UML.
    private static void printSuperclasses(Class<?> testClass) {
        Class<?> currentClass=testClass;
        while(currentClass!=null){
            System.out.println(currentClass.getSuperclass());
            currentClass=currentClass.getSuperclass();
        }
    }

    private static void printMethods(Class<?> testClass) {
        for(Method method:testClass.getDeclaredMethods()){
            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers)) {
                System.out.println("public " + modifiers);
            }

        }
    }

    private static void printConstructors(Class<Test> testClass) {
        for(Constructor constructor:testClass.getConstructors()){
            System.out.println(constructor);
            System.out.println(constructor.isSynthetic());
        }
    }
    static class GrandParentTest{}
    static class ParentTest<T>{}
    static class Test extends ParentTest<String>{
        private String fio;
        public Test(String fio){this.fio=fio;}
        public int add(int a, int b){
            return 0;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "fio='" + fio + '\'' +
                    '}';
        }
    }
}
