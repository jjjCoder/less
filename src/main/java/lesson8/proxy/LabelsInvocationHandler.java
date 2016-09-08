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
        Language[] languages = annotationKey.value();

            for (Language language : languages) {
                if (language.language().equals(this.language)) {
                    String messageFormat=language.value();
                    if(args!=null){
                        //доработать
                        messageFormat=applyArguments(args, messageFormat);
                    }
                    return messageFormat;
                }
            }

        return ""+method.getName();
    }

    private String applyArguments(Object[] args, String messageFormat) {
        for(int argIndex=0; argIndex<args.length; argIndex++){
            messageFormat=messageFormat.replaceAll("\\$"+argIndex, String.valueOf(args[argIndex]));
        }
        return messageFormat;
    }
}
