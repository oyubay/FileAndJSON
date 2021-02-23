import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class Database {
    JsonObject obj;
    JsonArray rest;
    /* TODO 
Declare a member variable that can 
be EASILY set from the constructor. */

    public Database(JsonObject data){
        this.obj = data;
        rest = (JsonArray) obj.get("restaurants");
        /* TODO 
set the memebr variable declared above.*/
    }

    public JsonObject getRestaurant(String name){
        JsonObject restObject = new JsonObject();
        for (int i=0; i<rest.size(); i++){
            JsonObject temp = (JsonObject) rest.get(i);
            if (name.equals(temp.get("name"))){
                restObject =  temp;
            }
        }
        return restObject;
        /* TODO 
Complete this method as specified. */
    }

    public double getAvgReviews(String name){
        double avgReview =0;
        JsonObject restObj = getRestaurant(name);
        JsonArray reviews =(JsonArray) restObj.get("reviews");
        for (int i=0; i<reviews.size(); i++){
            JsonObject obj = (JsonObject) reviews.get(i);
            Double temp = Double.parseDouble(String.valueOf(obj.get("rating")));
            avgReview+=temp;
        }
        return avgReview/reviews.size();
        /* TODO 
Complete this method as specified.
 The previous method may be of help. 
*/
    }
}
