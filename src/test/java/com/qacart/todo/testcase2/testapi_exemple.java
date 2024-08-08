package com.qacart.todo.testcase2;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class testapi_exemple {
        //                            TEST API  MAIS FORME JSON T5REJ
   public static void main(String[] args) {
   //     Given (ay 7aja 3ndha 3l9a bel request
    ///    When ( methode de request et endpoint)
    //    then(7jet tb3a reponse zay)
     /*   String requestBody ="{\n" +
                "    \"email\": \"Yminchour@gmail.com\",\n" +
             ///   "    \"firstName\": \"henda\",\n" +
             //   "    \"lastName\": \"ach\",\n" +
             ////   "    \"password\": \"essat12548\"\n" +
             //   "}";*/
      // --> n3ml object user mech ma n8ltiich fel code w njm nst.mlhom  twwli :
     //   User user = new User ("atef","ach","nourhoyda @gmail.com","esat32541");
        User user = UserUtils.generateRandomUser();
         Response response= given()
                   .baseUri("https://todo.qacart.com")
                   .header("Content-Type","application/json")
                  // .body(requestBody)
                 .body(user)

                .when()
                      .post("/api/v1/users/register")
               .then()
                        .extract().response();// jusy extract 7ja mo3yna eli bch nst79ou mb3ed
     String accessToken = response.path("accessToken"); // n7eb n5rej acces token
     System.out.println(accessToken);
     // or :String accessToken = response.path("UserID"); // 3NHA MEN  Response njeb ay 7aja
       // response.cookies();
   user.getEmail();// si n7eb nib email
              //then() .log().cookies();
             //  .log().all();


//Status code: باش تتأكد إذا العملية تمت بنجاح أو لا /(مثلاً 200 يعني نجاح، 400 يعني مشكلة في الطلب...).
        //Body:JSON اللي هو عادةً يكون حنسون و فيه معلومات على نتيجة العملية.
        //Headers: فيها معلومات إضافية على الرد.



    }    }
/* cette methode pas praifirable njem nkteb code 8let  */

// njeme nl8i kol w nstd3i register api :
// public static void main(String[] args) {
// RegisterApi registerApi = new RegisterApi();
 //registerApi.register();
//registerApi.gettoken()
//System.out.println(registerApi.gettoken()); // kna n7eb ntb3ha
//System.out.println(registerApi.getfirstname());