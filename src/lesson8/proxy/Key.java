package lesson8.proxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by SBTJavastudent on 27.08.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Key {
    Language[] value();
}

