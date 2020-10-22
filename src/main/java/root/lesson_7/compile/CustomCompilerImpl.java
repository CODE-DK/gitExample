package root.lesson_7.compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class CustomCompilerImpl implements CustomCompiler {

    @Override
    public boolean compileClassByName(String className) {
        final JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        final JavaCompiler.CompilationTask compilerTask = javaCompiler.getTask(
                null,
                null,
                null,
                null,
                null,
                null
        );
        return compilerTask.call();
    }
}
