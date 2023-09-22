package api.endpoints;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {

    static ResourceBundle getURL(){
    ResourceBundle resourceBundle=ResourceBundle.getBundle("Routes");
    return resourceBundle;
}



    public static Response createUser(UserPojo payload) throws IOException {
        String post_url= getURL().getString("post_url");
        Response response =   given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;
    }
    public static Response readUser(String userName){

       String get_url=getURL().getString("get_url");
        Response response=given()
                .pathParam("username",userName)
                .when()
                .get(get_url);

        return response;
    }
    public static Response updateUser(String userName, UserPojo payload)
    {
        String put_url=getURL().getString("put_url");
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)

                .when()
                .put(put_url);
        return response;


    }
    public static Response deleteUser(String userName)
    {
        String delete_url=getURL().getString("delete_url");
        Response response = given()
                .pathParam("username",userName)
                .when()
                .delete(delete_url);
        return response;
    }


}
