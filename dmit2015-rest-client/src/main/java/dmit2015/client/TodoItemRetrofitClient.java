package dmit2015.client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TodoItemRetrofitClient {

    @GET("webapi/TodoItems")
    Call<List<TodoItem>> findAll();

    @GET("webapi/TodoItems/{id}")
    Call<TodoItem> findOneById(@Path("id") Long todoItemId);

    @POST("webapi/TodoItems")
    Call<ResponseBody> create(@Body TodoItem newTodoItem);

    @PUT("webapi/TodoItems/{id}")
    Call<ResponseBody> update(@Path("id") Long todoItemId, TodoItem updatedTodoItem);

    @DELETE("webapi/TodoItems/{id}")
    Call<ResponseBody> delete(@Path("id") Long todoItemId);

}
