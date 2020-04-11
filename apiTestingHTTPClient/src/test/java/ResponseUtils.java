import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Arrays;
import java.util.List;

public class ResponseUtils {


    public static String getHeader(CloseableHttpResponse response, String headerName) {
        //get all headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";
        for (Header header : httpHeaders) {
            if (headerName.equalsIgnoreCase(header.getName())) {
                returnHeader = header.getValue();
            }
            if (returnHeader.isEmpty()) {
                throw new RuntimeException("did not find the headrs" + headerName);
            }

        }

return headerName;
    }
}

