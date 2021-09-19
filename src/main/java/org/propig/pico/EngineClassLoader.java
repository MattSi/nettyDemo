package org.propig.pico;

import java.net.URL;
import java.net.URLClassLoader;

public class EngineClassLoader extends URLClassLoader {
    static String fName = "d:\\temp\\202108\\nettyDemo-1.0-SNAPSHOT.jar";
    public EngineClassLoader(URL[] urls) {
        super(urls);
    }

    public EngineClassLoader(ClassLoader parent){
        super(Container2.findJars(fName), parent);
    }
}
