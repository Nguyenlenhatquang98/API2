package method;
import Constant.Constant;
import io.restassured.http.ContentType;
import oauth.Oauth2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Contacts {

    JSONParser parser = new JSONParser();


    public String  sendRequestToCreateContact(String givenname,String familyname,int statusCode){
        try {
            //path file name
            Object obj = parser.parse(new FileReader("src\\main\\java\\bodyRequest\\Create_Contact.json"));
            JSONObject jsonObject =  (JSONObject) obj;
            String body = String.format(jsonObject.toString(),givenname,familyname);
            System.out.println(body);

            String response= given().auth().oauth2(Oauth2.getAccessToken())
                    .contentType("application/json")
                    .urlEncodingEnabled(false)
                    .body(body).when()
                    .post(Constant.pathURLCreateContact)
                    .then()
                    .statusCode(200).extract().asString();
            return response;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
