package files.HW.HW82.utils;

import java.io.*;


public class FileUtils {

    public String readTextFromFile(String filePath, String textCoding){
        StringBuffer buffer = new StringBuffer();
        try (
                FileInputStream myFile = new FileInputStream(filePath);
                InputStreamReader inputStreamReader =
                        new InputStreamReader(myFile, textCoding);
                Reader reader = new BufferedReader(inputStreamReader);){
            int ch;
            while ((ch = reader.read()) > -1) {
                buffer.append((char)ch);
            }
        } catch (IOException e) {

            System.out.println("Unable to read from file " + filePath);
        }

        return buffer.toString();
    }

    public void saveTextToFile(String stringToWrite, String filePath, String textCoding){
        try (FileOutputStream myFile = new FileOutputStream(filePath);
             Writer out = new BufferedWriter(
                     new OutputStreamWriter(myFile, textCoding));) {
            out.write(stringToWrite);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getApplicationPath(){
        String result = "N/A";
        try {
            result = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean fileExists(String filePathString){
        File f = new File(filePathString);
        if(f.exists() && !f.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    public void createFile(String filePathString) throws IOException {
        File f = new File(filePathString);
        f.getParentFile().mkdirs();
        f.createNewFile();
    }

}
