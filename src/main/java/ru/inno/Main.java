package ru.inno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by RuAV on 09.12.2016.
 */

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

//        String str = "dsghw";
//        Pattern pattern = Pattern.compile("[a-zA-Z]+");
//        Matcher matcher = pattern.matcher(str);
//        System.out.println(str.matches("[a-zA-Z]+"));


        String[] filesToParse = {
                "-f", "/home/ruav/test.file",
                "-f", "/home/ruav/test1.file"
//                 "-f", "/media/ruav/8064B61E64B6173E/resources/7.txt",
//                 "-f", "/media/ruav/8064B61E64B6173E/resources/8.txt",
//                 "-f", "/media/ruav/8064B61E64B6173E/resources/12.txt",
//                 "-u", "http://cdimage.debian.org/debian-cd/8.6.0/amd64/iso-cd/MD5SUMS"
        };

        Controller controller = new Controller();

        controller.start(filesToParse);


    }

}
