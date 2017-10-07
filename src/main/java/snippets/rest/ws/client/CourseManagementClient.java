package snippets.rest.ws.client;

import javax.ws.rs.client.Client;

/**
 * This is a simple test class for invoking REST web service
 * using JAX-RS clinet APIs
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

    }
}
