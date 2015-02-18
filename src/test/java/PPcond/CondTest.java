package PPcond;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by eredin on 17.02.2015.
 */

public class CondTest {

  //  File file = new File("C:\\_git\\pre-post_cond\\1.txt");



    @BeforeClass
    public void CrFile() {


        try {
            File file = new File("3.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("8.0\n");

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test1() {
        try {
            FileReader fr = new FileReader("3.txt");
            Scanner scan = new Scanner(fr);
            String s = "";
            while (scan.hasNextLine()) {
                s = scan.nextLine();
            }
            Assert.assertTrue(s.matches("^\\d+(\\.\\d+)"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    @AfterClass
    public void DelFile() {
        boolean n = new File("3.txt").delete();
    }
}

