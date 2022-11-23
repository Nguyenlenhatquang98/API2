package oauth;

import org.json.JSONObject;


import static io.restassured.RestAssured.given;


public class Oauth2 {

    private static final String CLIENT_ID = "547645804417-htc0j97c3fkjvhksj0vp0jqou51l5gpr.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "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";
    private static final String REFRESH_TOKEN = "1//06rjT1KhF9w7qCgYIARAAGAYSNwF-L9IrCpgrzxhStZrIrZxI0ThbdZ05uZqiLalwG3EEJK9c-6MM8coqDEFF0SVxQdiDNwp0gcM";

    public static String getAccessToken() {
        String response= given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "    \"client_id\": \""+CLIENT_ID+"\",\n" +
                        "    \"client_secret\": \""+CLIENT_SECRET+"\",\n" +
                        "    \"refresh_token\":\""+REFRESH_TOKEN+"\",\n" +
                        "    \"grant_type\": \"refresh_token\"\n" +
                        "}")
                .post("https://accounts.google.com/o/oauth2/token").then()
                .statusCode(200).extract().asString();
        JSONObject jsonObject = new JSONObject(response);
        System.out.println("Access token: "+ jsonObject.get("access_token"));
        return (String) jsonObject.get("access_token");
    }

}
