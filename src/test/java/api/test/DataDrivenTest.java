package api.test;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.UserPojo;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDrivenTest {
@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testPostUser(String userID,String userName,String fname, String lname,String useremail, String pwd,String ph) throws IOException {
    UserPojo userPayload =new UserPojo();
    userPayload.setId(Integer.parseInt(userID));
    userPayload.setUserName(userName);
    userPayload.setFirstNanme(fname);
    userPayload.setLastName(lname);
    userPayload.setEmail(useremail);
    userPayload.setPassword(pwd);
    userPayload.setPhone(ph);

    Response response= UserEndPoints.createUser(userPayload);
    Assert.assertEquals(response.getStatusCode(),200);

}
//    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
//    public void testGetUser(String userName){
//        Response response=UserEndPoints.readUser(userName);
//        Assert.assertEquals(response.getStatusCode(),200);
//
//    }


@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
   public void testDeleteUser(String userName){
    Response response= UserEndPoints.deleteUser(userName);
    Assert.assertEquals(response.getStatusCode(),200);

   }



}
