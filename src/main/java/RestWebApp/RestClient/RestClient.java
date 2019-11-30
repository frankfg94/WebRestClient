package RestWebApp.RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Category;
import model.Comment;
import model.Media;
import model.User;

public class RestClient {

    private static final String REST_URI = "http://localhost:8080/RestWebApp/rest";
    
    private static final String REST_Users = REST_URI + "/users";
    private static final String REST_Media = REST_URI + "/media";
    private static final String REST_Comments = REST_URI +"/comments";
    private static final String REST_Categories = REST_URI +"/category";

    // We create the client that will instantiate the queries
    private Client client = ClientBuilder.newClient();
    
    public  User getJsonUser(int id) {
        return client
          .target(REST_Users)
          .path(String.valueOf(id))
          .request(MediaType.APPLICATION_JSON)
          .get(User.class);
    }
    
    public Response createJsonUser(User user) {
    	System.out.println("Post : " + REST_Users);
        return client
          .target(REST_Users)
          .request(MediaType.APPLICATION_JSON)
          .post(Entity.entity(user, MediaType.APPLICATION_JSON));
    }

	public Comment getJsonComment(int id) {
        return client
                .target(REST_Comments)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Comment.class);
        }

	public Category getJsonCategory(int id) {
        return client
                .target(REST_Categories)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Category.class);
	}

	public Media getJsonMedia(int id) {
        return client
                .target(REST_Media)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Media.class);
	}
}
