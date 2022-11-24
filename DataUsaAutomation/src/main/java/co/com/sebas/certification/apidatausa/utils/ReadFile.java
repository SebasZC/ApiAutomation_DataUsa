package co.com.sebas.certification.apidatausa.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.Scanner;

import static co.com.sebas.certification.apidatausa.utils.Constants.ASSERT_READ_FILE;

public class ReadFile {

    public static final Logger LOGGER = Logger.getLogger(ReadFile.class);

    public ReadFile() {
        throw new IllegalStateException("Utility class");
    }

    public static String returnFile(String route){
        String line = "";
        try{
            Scanner input = new Scanner(new File(route));
            while (input.hasNextLine()){
                line = line + input.nextLine();
            }
        }catch (Exception e){
            LOGGER.error(ASSERT_READ_FILE, e);
        }
        return line;
    }
}
