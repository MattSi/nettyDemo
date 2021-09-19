package org.propig.pico;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.SecureClassLoader;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

//        Container.init();
//        System.out.println("==============================");
//        Juicer juicer1 = (Juicer) Container.getComponent("org.propig.pico.AppleBanana");
//        juicer1.peel();
//        juicer1.pool();
//
//
//        Juicer juicer2 = (Juicer) Container.getComponent("org.propig.pico.AppleOrange");
//        juicer2.peel();
//        juicer2.pool();

//        System.out.println("================================");
//        String fName = "d:\\temp\\202108\\nettyDemo-1.0-SNAPSHOT.jar";
//        URL[] urls = new URL[1];
//        File f = new File(fName);
//        urls[0] = f.getCanonicalFile().toURI().toURL();
//        URLClassLoader ucl = new EngineClassLoader(urls);



        String path = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        File target = new File(path + "nettyDemo-1.0-SNAPSHOT.jar");

        ClassLoader cl1 =  new URLClassLoader(new URL[]{target.toURI().toURL()});
        Class<?> clazz1 = cl1.loadClass(Banana.class.getCanonicalName());
        Banana b1 = (Banana) clazz1.newInstance();

        ClassLoader cl2 =  new URLClassLoader(new URL[]{target.toURI().toURL()});
        Class<?> clazz2 = cl1.loadClass(Banana.class.getCanonicalName());
        Banana b2 = (Banana) clazz2.newInstance();

        System.out.println(b1.getClass().getClassLoader().equals(b2.getClass().getClassLoader()));
        System.out.println(b1.getClass().getClassLoader().toString());
        System.out.println(b2.getClass().getClassLoader().toString());
        System.out.println(cl1.toString());
        System.out.println(cl2.toString());

        System.out.println(b2 instanceof org.propig.pico.Banana);
    }
}
