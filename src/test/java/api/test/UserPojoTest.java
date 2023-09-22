package api.test;


import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.UserPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserPojoTest {

Faker faker;
UserPojo userPayload;
public  Logger logger;
    @BeforeClass
    public void setupData(){

        faker=new Faker();
        userPayload=new UserPojo();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUserName(faker.name().username());
        userPayload.setFirstNanme(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
       userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

     //logs
        logger= LogManager.getLogger(this.getClass());


    }
    @Test(priority = 1)
    public void testPostuser()
    {
        logger.info("********* User is ctreated **********");

        Response response= UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("********* User is displayed **********");
    }
@Test(priority = 2)
    public void testGetUserByName()
    {
        logger.info("********* get user info **********");
        Response response=UserEndPoints.readUser(this.userPayload.getUserName());
        response.then().log().all();
        response.statusCode();
        Assert.assertEquals(response.getStatusCode(),404);
    }
      @Test(priority = 3)
         public void testUpdateUserName()
      {
        // updaate data using payload
          userPayload.setFirstNanme(faker.name().firstName());
          userPayload.setLastName(faker.name().lastName());
          userPayload.setEmail(faker.internet().safeEmailAddress());
          logger.info("********* User is updated**********");
            Response response=UserEndPoints.updateUser(this.userPayload.getUserName(),userPayload);
            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(),200);

          Response responseAfterUpdate=UserEndPoints.readUser(this.userPayload.getUserName());

          Assert.assertEquals(response.getStatusCode(),200);
          logger.info("********* update User is displayed **********");
      }

        @Test(priority = 4)
    public void deleteUserByNmae(){

            logger.info("********* User is deleted **********");
        Response response =UserEndPoints.deleteUser(this.userPayload.getUserName());
        Assert.assertEquals(response.getStatusCode(),404);
        }
}
