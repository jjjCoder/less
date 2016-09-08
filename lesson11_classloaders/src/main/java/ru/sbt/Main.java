package ru.sbt;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
//        Person person=new Person();
        //Object o = Main.class.getClassLoader().loadClass("ru.sbt.Person").newInstance();

        MyUrlClassLoader myUrlClassLoader=new MyUrlClassLoader(new URL[]{new URL("file:///C:/Users/SBTJavastudent/tmp/")});
        Object obj=myUrlClassLoader.loadClass("ru.sbt.Person").newInstance();
        Person person=(Person)obj;
    }
    static class MyUrlClassLoader extends URLClassLoader{


        public MyUrlClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public MyUrlClassLoader(URL[] urls) {
            super(urls);
        }

        public MyUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
            super(urls, parent, factory);
        }

//        @Override
//        public Class<?> loadClass(String name) throws ClassNotFoundException {
//            if("ru.sbt.Person".equals(name)){
//                return findClass(name);
//            }else{
//                return super.loadClass(name);
//            }
//        }
    }
}
