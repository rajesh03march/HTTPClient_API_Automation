import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseUrl {

    protected static final String BASE_ENDURL = "https://api.github.com/";
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
}
