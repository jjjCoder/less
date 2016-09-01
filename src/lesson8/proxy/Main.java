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
        System.out.println(ruLabels.username());
        System.out.println(ruLabels.getMyMoneyBro("Ivan"));

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
    String username();

    @Key({
        @Language(language = "ru", value = "Где деньги, $0: $1"),
        @Language(language = "en", value = "where")
    })
    String getMyMoneyBro(String bro);
}