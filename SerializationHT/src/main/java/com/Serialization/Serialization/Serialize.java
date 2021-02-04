package com.Serialization.Serialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Serialize {
    public static void save(Object object,String filename,boolean isZip){
        File file=new File(filename);
        try (ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(object);
        }catch (IOException e){
            System.out.println("Failed to save data");
        }
        if(isZip){
            ZipEntry zipEntry=new ZipEntry(filename);
            try (ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream(filename+".zip"));
                    FileInputStream fileInputStream=new FileInputStream(file))
                {
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] buffer = new byte[fileInputStream.available()];//file to bytes
                    zipOutputStream.write(buffer);//adding the content to the archive
                    zipOutputStream.closeEntry();//end save thread
                } catch (IOException e) {
                System.out.println("Failed to save data");
            }
        }
    }

    public static Map<Object, Object> load(String filepath,boolean isZip){
        File file = new File(filepath.substring(0,filepath.indexOf(".")));// from first symbol to extension
        Map<Object, Object> map = null;

        if(isZip){
            try (ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream(filepath))){

                while (zipInputStream.getNextEntry()!=null){
                    FileOutputStream fileOutputStream=new FileOutputStream(filepath);
                    int c;
                    while((c = zipInputStream.read())!=-1){
                        fileOutputStream.write(c);
                    }

                    //End write threads
                    zipInputStream.closeEntry();
                    fileOutputStream.close();
                }
            }catch (IOException e){
                System.out.println("Something went wrong");
            }
        }

        try {
            //write to map content
            map = (Map<Object, Object>) new ObjectInputStream(new FileInputStream(file)).readObject();
        } catch (IOException e) {
            //else create new
            map = new HashMap<>();
        } catch (ClassNotFoundException e) {
            /*
            add description to this case
             */
            e.printStackTrace();
        }
        return map;

    }
}
