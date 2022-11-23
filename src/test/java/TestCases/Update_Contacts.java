package TestCases;

import Constant.Constant;
import method.Contacts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class Update_Contacts {

    private static final Contacts CONTACTS = new Contacts();

    @Test(description = "User send request to create and update CONTACTS")
    public void sendAPostRequestUpdateComment() {

        String responseCreate= CONTACTS.sendRequestToCreateContact("Nguyen","Quang",200);

        Reporter.log("Step 2. Convert response from string to jsonobject to verify CONTACTS");
        JSONObject jsonObjectCreate = new JSONObject(responseCreate);
        System.out.println("Response: \n"+jsonObjectCreate);
        String a = "5";

    }
}
