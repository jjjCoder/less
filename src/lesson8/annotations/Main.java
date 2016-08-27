package lesson8.annotations;


import com.sun.tracing.dtrace.Attributes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by SBTJavastudent on 27.08.2016.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Truck truck=new Truck(1, 500);
        new A().print(truck);
    }
}

class A{
    @Format(value = "value", fieldName = "capacity")
    public void print(Object truck) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method printMethod = A.class.getMethod("print", Object.class);
        Format annotation = printMethod.getAnnotation(Format.class);
        System.out.println(annotation);
        String fieldName = annotation.fieldName();
        Method getter=truck.getClass().getMethod(getGetterNameForField(fieldName));
        Object value= getter.invoke(truck);
        System.out.println("Printer: ");
        if(value == null){
            throw new IllegalArgumentException("");
        }
        System.out.println(value.toString());
//        System.out.println(truck.getCapacity());
    }
    private String getGetterNameForField(String fieldName){
        return "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
    }
}
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)//можно без value= , компилятор сам поймет.
@interface Format{
    /**
     * Formatter class name
     * @return
     */
    String value();
    /**
     * Имя поля, которое нужно распечатать.
     * @return
     */
    String fieldName();
    boolean fullDescription() default true;
}
class Truck {
    private long id;
    private String type;//kamaz, maz...
    private int capacity;
    public Truck(long id, int capacity){
        this.id = id;
        this.capacity=capacity;
    }

    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                '}';
    }
}
/*
<person name 'ivan' phone '123'>
    <children>
        <person name='Maria' phone='12'/>
        <person name='Maria' phone='12'/>
    </children>
</person>

*/
@Element(name="person")
class Person{
    @Arrribute("name")
    String name;
    @Arrribute
    String phone;
    @Element(name="children")
    List<Person> children;
}
@interface Element{String name();}
@interface Arrribute{String value() default "";}