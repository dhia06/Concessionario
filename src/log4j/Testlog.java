package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import java.io.*;
import java.sql.SQLException;



public class Testlog {


    /* Get the class nam to be printed on */
//    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger (Testlog.class.getName ());
   static Logger logger = Logger.getLogger(Testlog.class.getName ());



    public static void main(String[] args) throws IOException, SQLException {
        BasicConfigurator.configure();
        logger.info ("Hello this is an info message");
        logger.warn ("yess it work finally");
        logger.error ("this is an error");
    }
}


