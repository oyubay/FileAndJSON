import json_simple.JsonArray;
import json_simple.JsonObject;
import json_simple.Jsoner;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"i="+ingredients);
        String contents="";
        try{
            Scanner urlScanner = new Scanner(url.openStream());
            while (urlScanner.hasNextLine()){
                contents+=urlScanner.nextLine();
            }
            urlScanner.close();
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.toString());
        }
        JsonObject obj = Jsoner.deserialize(contents, new JsonObject());

/* TODO 
You have to use the url to retrieve the contents of the website. 
This will be a String, but in JSON format. */
        return obj; /* TODO
Remember to return a JSON object.*/
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {
        URL url = new URL(baseUrl+"q="+dish);
        String contents="";
        try{
            Scanner urlScanner = new Scanner(url.openStream());
            while (urlScanner.hasNextLine()){
                contents+=urlScanner.nextLine();
            }
            urlScanner.close();
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.toString());
        }
        JsonObject obj = Jsoner.deserialize(contents, new JsonObject());
        return obj;
        //Getting the things ready to connect to the web
        /* TODO 
Fill in this data type (Object) URl url = new URL()/* TODO
Fill in this datatype (Object) (baseUrl+"q="+dish);*/

       /* TODO
Read the information coming from the web
 */
         /* TODO
return the appropriate result.
*/
    }


    public String formatRecipeAsString(JsonObject doc){
        String results = "";
        JsonArray result =(JsonArray) doc.get("results");
        for (int i=0; i<result.size(); i++){
            JsonObject res = (JsonObject) result.get(i);
            results+=" title:"+res.get("title")+"\n"
                    +" link:"+res.get("href")
                    +" ingredients:"+res.get("ingredients");
        }
        /* TODO 
This should return a String with each recipe in three lines:
Title:the title of the recipe
Link:the link to the recipe
Ingredients:The ingredients of teh recipe.*/
        return results;
    }

    public void saveRecipes(String text, String outfile){
        try{
            FileWriter fw = new FileWriter(outfile);
            fw.write(text);
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        /* TODO
Given a String with some text in it, write that text to a file. 
The name of the file is given in outfile */
    }

}
