package RestWebApp.RestClient;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import junit.framework.TestCase;
import model.Category;
import model.Comment;
import model.Media;
import model.User;

public class RestClientTest {
    private RestClient client = new RestClient();
 
    @Test
    public void testGetUser() {
    	System.out.println("Getting user 1");
    	User u = client.getJsonUser(1);
    	assertNotNull(u);
    }
    
    @Test
    public void testGetComment() {
    	System.out.println("Getting comment 1");
    	Comment c = client.getJsonComment(1);
    	assertNotNull(c);
    }
    
    @Test
    public void testGetCategory() {
    	System.out.println("Getting user 1");
    	Category c = client.getJsonCategory(1);
    	assertNotNull(c);
    }
    
    @Test
    public void testGetMedia() {
    	System.out.println("Getting media 3");
    	Media m = client.getJsonMedia(3);
    	assertNotNull(m);
    }
    
    @Test
    public void testCreateUser() {
    	System.out.println("Creating user");
        User user = new User();
        user.setCity("JunitCity");
        user.setName("JunitUser");
        user.setPassword("JunitPassword");
        System.out.println("User created");
        
        Response response = client.createJsonUser(user);
        int status = response.getStatus();
        System.out.println(" Method done status obtained : " + status);
 
        assertEquals( 201, status);
    }
    
    
}
