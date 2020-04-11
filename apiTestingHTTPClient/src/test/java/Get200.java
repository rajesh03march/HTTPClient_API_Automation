import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class Get200 extends BaseUrl{


    CloseableHttpClient client;
    CloseableHttpResponse response;

   @BeforeMethod
   public void setUP(){
       client = HttpClientBuilder.create().build();
   }
   @AfterMethod
   public void close() throws IOException {
       client.close();
       response.close();
   }
   @DataProvider
   private Object[][] endpoints(){
       return new Object[][]{

               {"/rate_limit"},
               {"/user/followers"},
               {"/notifications"}

   };}

    @Test
    public void getBaseUrlReturn200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDURL);
        response= client.execute(get);

        int statuscode = response.getStatusLine().getStatusCode();
        assertEquals(statuscode,200);

    }
    @Test(dataProvider = "endpoints")
    public void rateLimitReturn200(String endPoints) throws IOException {
        HttpGet get = new HttpGet(BASE_ENDURL+endPoints);
        HttpResponse response= client.execute(get);
        int statuscode = response.getStatusLine().getStatusCode();
        String value = response.getStatusLine().toString();
        assertEquals(statuscode,200);
        System.out.println(value);

    }

}
