package dmit2015.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8080/dmit2015-instructor-jaxrs-demo/webapi")
@Path("/TodoItems")
public interface TodoItemService {

    @GET
    List<TodoItem> findAll();

    @GET
    @Path("{id}")
    TodoItem findOneById(@PathParam("id") Long id);

    @POST
    String create(TodoItem newTodoItem);

    @PUT
    @Path("{id}")
    void update(@PathParam("id") Long id, TodoItem updatedItem);

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") Long id);

}
