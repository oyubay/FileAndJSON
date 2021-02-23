import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task {
  public static void main(String[] args){
      Task t = new Task();
      JsonObject doc = t.readJson("./resources/restaurant-data.json");
      Database db = new Database(doc);
      System.out.println(db.getRestaurant("Hometown BBQ"));
      System.out.println(db.getAvgReviews("Casa Enrique"));

  }

  public JsonObject readJson(String filename) {
      String content = readFile(filename);
      JsonObject obj = Jsoner.deserialize(content, new JsonObject());
      return obj;
      /* TODO: create a JSON object with the contents of  "filename". You can use the method below to help you read the file. */
  }

  public String readFile(String filename){
      String content = "";
      try(BufferedReader reader = new BufferedReader(new FileReader(filename)) /* Complete this using the parameter passed to this method. */){
         String s;
         while ((s=reader.readLine())!=null){
             content+=(s);
         }
          /* Put in code to read the file line by line. */
      } catch(IOException e) {
          e.printStackTrace();
          System.exit(-1);
      }
      return content; /* Put in the variable that should be returned. */
  }
}