package lesson8.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by SBTJavastudent on 27.08.2016.
 */
public class LabelsInvocationHandler implements InvocationHandler {

    private String language;

    public LabelsInvocationHandler(String language) {
        this.language = language;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Key annotationKey = method.getAnnotation(Key.class);
        Language[] languages=annotationKey.value();
        for(Language language:languages){
            if(language.language().equals(this.language)){
                return language.value();
            }
        }
        return ""+method.getName();
    }
}
