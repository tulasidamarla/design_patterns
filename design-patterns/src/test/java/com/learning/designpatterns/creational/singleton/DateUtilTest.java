package com.learning.designpatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DateUtilTest {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        DateUtil instance1 = DateUtil.getInstance();
        DateUtil instance2;
        // Serialization test
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dateutil.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dateutil.ser"))){
            oos.writeObject(instance1);
            instance2 = (DateUtil) ois.readObject();
        }
        System.out.println(instance1 == instance2);
        
        // Clone test
        DateUtil instance3 = (DateUtil) instance1.clone();
        System.out.println(instance1 == instance3);
        
        // Reflection test
        DateUtil instance4 = null;
        Constructor[] constructs = DateUtil.class.getConstructors();
        for (Constructor constructor : constructs) {
            constructor.setAccessible(true);
            instance4 = (DateUtil) constructor.newInstance();
        }
        System.out.println(instance1 == instance4);
        
    }
}
