package com.ingconti;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    static Boolean FIRST_TOO = true;
    static Boolean FIX_BUG = false;
    //static Boolean FIX_BUG = true;


    public static void main(String[] args) {
        String filename = "time.ser";
        Person p = new Person("John", "Doe");

        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);

            if (FIRST_TOO) {
                out.writeObject(p);
            }

            if (FIX_BUG)
                out.reset();

            p.setFirstName("JANE");
            out.writeObject(p);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        String temp = "";

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);

            Person p1 = (Person) in.readObject();
            System.out.println(p1.toString());

            if(FIRST_TOO)  {
                Person p2 = (Person) in.readObject();
                System.out.println(p2.toString());
            }

            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}