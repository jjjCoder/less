package lesson7.jit;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

//-XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining //flags VM
public class JitExamole {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz=Class.forName("Truck");
        printMember(clazz.getConstructors());
    }
    static void printMember(Member[] members){
        for(Member member:members){
            System.out.println(member.getName());
            int modifiers=member.getModifiers();

        }
    }
}
