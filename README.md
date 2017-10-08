## Creating a Java client for the REST GET web service
> You could invoke a REST web service by using java.net.HttpURLConnection or other external HTTP client libraries, but the JAX-RS client APIs makes this task a lot easier.

## Writing a Java client for the REST POST web service
> We need to send input data (the Course information) in the JSON format. Although we have hardcoded JSON in our example, you could use JAXB or any other library that converts a Java object into JSON.

> Note that we have used the post method (webTarget.request().post(…)). We have also set the content type of the request to "application/JSON" (because our web service to add Course consumes the JSON format). This is done by creating an entity and setting its content type to JSON:

```java
        //Execute HTTP post method
        Response response = webTarget.request().post(Entity.entity(courseJSON, MediaType.APPLICATION_JSON_TYPE));
```
