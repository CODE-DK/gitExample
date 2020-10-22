package root.lesson_7;

import org.junit.Test;
import root.lesson_7.out.Worker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CodeReaderTest {

    private static final String SOURCE = "src/main/resources/lesson_7/text.txt";
    private static final String JAVA_FILE = "src/main/java/root/lesson_7/out/SomeClass.java";
    private static final String JAVA_CLASS = "src/target/java/root/lesson_7/out/SomeClass.class";

    @Test
    public void readFromFile() throws Throwable {
        Class<?> workerImpl = Class.forName("root.lesson_7.CodeReaderTest$WorkerImpl");
        InvocationHandler handler = (proxy, method, args) -> method.invoke(proxy, args);
        handler.invoke(
                workerImpl.getDeclaredConstructor().newInstance(),
                workerImpl.getMethod("doIt"), null
        );
        Worker worker = (Worker) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{Worker.class},
                handler
        );
        worker.doWork();
    }

    public static class WorkerImpl {

        public void doIt() {
            System.out.println("HELLO!!!");
        }
    }
}