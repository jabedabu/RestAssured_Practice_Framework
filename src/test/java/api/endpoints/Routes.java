package api.endpoints;


//https://petstore.swagger.io/v2/swagger.json



public class Routes
{
public static String base_url="https://petstore.swagger.io/v2";

// -> User module -> //
    public static String post_url=base_url+"/user";
    public static String get_url=base_url+"/user/{username}";
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";

    // --> Store Module -->//
    // here we will keep store module Urls


    // Pet module //
    // here we keep pet module


}
