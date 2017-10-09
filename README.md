## Creating a Java client for the REST GET web service
> You could invoke a REST web service by using java.net.HttpURLConnection or other external HTTP client libraries, but the JAX-RS client APIs makes this task a lot easier.

## Writing a Java client for the REST POST web service
> We need to send input data (the Course information) in the JSON format. Although we have hardcoded JSON in our example, you could use JAXB or any other library that converts a Java object into JSON.

> Note that we have used the post method (webTarget.request().post(…)). We have also set the content type of the request to "application/JSON" (because our web service to add Course consumes the JSON format). This is done by creating an entity and setting its content type to JSON:

```java
        //Execute HTTP post method
        Response response = webTarget.request().post(Entity.entity(courseJSON, MediaType.APPLICATION_JSON_TYPE));
```

## Creating a Java client for the form-encoded REST web service
## 用java代码，向服务器发送form表单组装的数据
```java

    //Test addCourse method (Form-Encoded version) of CourseService
    public static void testAddCourseForm() {

        //create JAX-RS client
        Client client = ClientBuilder.newClient();

        //Get WebTarget for a URL
        WebTarget webTarget = client.target("http://localhost:8080/CourseManagementREST/services/course/add");

        //Create form object and populate fields
        Form form = new Form();
        form.param("name", "Course-5");
        form.param("credits", "5");

        //Execute HTTP post method
        Response response = webTarget.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));

        //check response code. 200 is OK
        if (response.getStatus() != 200) {
            //Print error message
            System.out.println("Error invoking REST Web Service - " + response.getStatusInfo().getReasonPhrase() + ", Error Code : " + response.getStatus());
            //Also dump content of response message
            System.out.println(response.readEntity(String.class));
            return;
        }

        //REST call was successful. Print the response
        System.out.println(response.readEntity(String.class));
    }
```