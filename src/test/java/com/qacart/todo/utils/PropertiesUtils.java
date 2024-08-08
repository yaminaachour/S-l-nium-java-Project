package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadProperties(String filePath) {  //public static ;  ينجّم أي حد يستعملو.
                                                                    //String filePath; src file
        File file = new File(filePath);                               // fileمتاعك ويحطّهم في "صندوق" إسمه filepath
        try {                                                 //إذا صارت أي مشكلة وهو يخدم ينجّم يتصرّف و ما يخلّيش البرنامج يتسكرtry { ... } catch (FileNotFoundException e) { ... } catch (IOException e) { ... }.
            InputStream inputStream = new FileInputStream(file); //يفتح fileبإستعمال inputStream.
            Properties properties = new Properties();// يحضّر "الورقة الخارجية".
            properties.load(inputStream); ////يقرا "الكتاب" = file  و يكتب المعلومات المهمة في "الورقة الخارجية =Properties
            inputStream.close();//يسكر "الكتاب" file  بعد ما كمل قراءة.
            return properties;//رجعّلك "الورقة الخارجية" فيها المعلومات إلّي قراهم.

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found"); //ما لقاش "الكتاب"= file  بتاعك باش يقولّك "File is not found".
        } catch (IOException e) {  // صارت أي مشكلة أخرى وهو يقرا "الكتاب"= file  باش يقولّك "Error while loading the properties"
            throw new RuntimeException("Error while loading the properties");
        }

    }
}