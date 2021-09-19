package org.propig.pico;


import java.io.IOException;
import java.io.InputStream;

public class ClassLoadTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);

                }
            }
        };

        Object obj = myLoader.loadClass("org.propig.pico.Banana").newInstance();
        Banana obj2 = new Banana();

        System.out.println(obj.getClass());
        System.out.println(obj2.getClass());

        System.out.println(obj instanceof org.propig.pico.Banana);
        System.out.println(obj2 instanceof org.propig.pico.Banana);

        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj2.getClass().getClassLoader());
    }
}

