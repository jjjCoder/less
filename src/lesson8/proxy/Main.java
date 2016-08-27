package lesson8.proxy;

import com.sun.deploy.net.proxy.ProxyUtils;

import java.lang.reflect.Proxy;


interface LabelsDao{//так в sprinf через proxy.
    //select count(1) from person where person.name like '%:name%'
    int getCountOfPersonsWithNameLike(String name);
}

public class Main {
    public static void main(String[] args) {
        Labels ruLabels = getLabels("ru");
        System.out.println(ruLabels);
    }
    private static Labels getLabels(String language){
        return (Labels) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class<?>[] {Labels.class}, new LabelsInvocationHandler(language));
    }
}
interface Labels{
    @Key({
        @Language(language="ru", value="Логин"),
        @Language(language="en", value="Login")
    })
    int username();
}