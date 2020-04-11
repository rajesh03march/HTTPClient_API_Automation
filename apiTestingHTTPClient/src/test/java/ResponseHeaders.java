import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResponseHeaders extends BaseUrl {
    CloseableHttpResponse response;
    CloseableHttpClient client;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }
    @AfterMethod
    public void end() throws IOException {
        response.close();
        client.close();
    }

    @Test
    public void content() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDURL);
        response = client.execute(get);
        String headerValue = ResponseUtils.getHeader(response,"server");
        //Header contentType = response.getEntity().getContentType();
        Assert.assertEquals(headerValue,"application/json; charset=utf-8");
    }
}
