package org.abigballofmud.flink.platform.infra.loader;

import java.io.File;
import java.io.IOException;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.CompilerConfiguration;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2020/03/24 15:22
 * @since 1.0
 */
public class GroovyCompiler {

    private GroovyCompiler() {
        throw new IllegalStateException("util class");
    }

    static GroovyClassLoader getGroovyClassLoader() {
        CompilerConfiguration config = new CompilerConfiguration();
        config.setSourceEncoding("UTF-8");
        return new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);
    }

    /**
     * Compiles Groovy code and returns the Class of the compiles code.
     */
    public static Class<?> compile(String sCode, String sName) {
        GroovyClassLoader loader = getGroovyClassLoader();
        return loader.parseClass(sCode, sName);
    }

    /**
     * Compiles groovy class from a file
     */
    public static Class<?> compile(File file) throws IOException {
        GroovyClassLoader loader = getGroovyClassLoader();
        return loader.parseClass(file);
    }

}
