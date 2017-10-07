package snippets.rest.ws.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This is a simple test class for invoking REST web service
 * using JAX-RS client APIs
 */
public class CourseManagementClient {

    public static void main (String[] args) {
        testGetCourseJSON();
    }

    //Test getCourse method (XML or JSON) of CourseService
    public static void testGetCourseJSON() {
        //Create JAX-RS client
        Client client = ClientBuilder.newClient();

        //Get WebTarget for a URL
        WebTarget webTarget = client.target("http://localhost:8080/CourseManagementREST/services/course");
        //Add paths to RUL
        webTarget = webTarget.path("get").path("10");

        //Execute HTTP get method
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

        //Check responses code. 200 is OK
        if (response.getStatus() != 200) {
            System.out.println("Error invoking REST Web  Service - " + response.getStatusInfo().getReasonPhrase());
            return;
        }

        //REST call was successful. Print the response
        System.out.println(response.readEntity(String.class));
    }
}
