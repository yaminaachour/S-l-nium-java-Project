package com.qacart.todo.api;


import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
     Task task = new Task("henda",true);// object Task

    public  void addTask(String token){//عملنا متغير (variable) من نوع String باش نحطو فيه التوكن.
        Response response =  given()
              //  .baseUri("https://todo.qacart.com")
                     .baseUri(ConfigUtils.getInstance().getBaseUrl())
                     .header("Content-Type","application/json")
                .auth().oauth2(token)// pour prouver l'identité de l'utilisateur et accéder à l'API.


                .body(task)
                     .log().all()// bch y5rej tt request bch kna 8la nfi9
                .when()
                    // .post("/api/v1/tasks")
                .post(EndPoint.API_TASK_ENDPOINT)

                .then()
                    .log().all()// bch y5rej tt reponse  bch kna 8la nfi9
                    .extract().response(); // n3ml extrat
        if(response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }

    }

}/* Code الأول ( RegisterApi ) هوّا للتسجيل في التطبيق.
كيما تعرف، كي تسجّل في تطبيق جديد لأول مرة، ما يكونش عندك token باهي!
التسجيل هوّا باش تحصل على token و حساب جديد.
        Code الثاني ( TasksApi ) هوّا لإضافة مهمة في To-Do List.
باش تعمل هذا، لازم تكون مسجّل قبل و عندك token.
        لهذا، نستعملو .auth().oauth2(token) باش نقولو للتطبيق "أنا فلان، و هذي الـ token متاعي الي تثبت هويتي".
بإختصار:

في التسجيل ما نستعملوش token خاطر ما عندناش واحد في الأول.
في إضافة مهمة (أو أي عملية أخرى بعد التسجيل) لازمنا نستعملو token باش نثبتو هويتنا.
*/

