import java.io.*;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris.data");
        System.out.println(d.getValue("s-width", 121));
    }

    public Database readCSV(String filename) {
        String contents = "";
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename)) /* TODO.
Change what needs to go here to start reading "filename" */){
            byte[] buffer = new byte[1024] /* TODO
Create a byte array of about 1024 bytes or however many bytes you want. */;
            int lengthRead;
            while ((lengthRead = in.read(buffer))>0){
                contents += new String(buffer,0, lengthRead);
            }
            /* TODO 
Create a while loop to read the contents of the file and put them in the variable "contents" declared at the beginning of the method. */
        } catch (IOException e /* TODO
Put the correct Exception here. */) {
            e.printStackTrace();
            System.exit(-1);
        }
        Database db = new Database(contents);
        return db /* TODO
Return a Databse object initialized with the contents read. */;
    }
}
