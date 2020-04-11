import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;


import java.io.IOException;

import static entities.User.ID;
import static entities.User.LOGIN;

public class BodyTestWithMap extends BaseUrl {
    @Test
    public void returnCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDURL+"/users/andrejss88");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);
        String Value= (String)getValueFor(jsonObject, LOGIN);
    }
    private Object getValueFor(JSONObject jsonObject, String key){
        return jsonObject.get(key);

    }
    @Test
    public void returnCorrectID() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDURL+"/users/andrejss88");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);
        Integer Value1= (Integer) getValueFor(jsonObject, ID);
    }
    @Test
    public void userNotFound() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDURL+"/nonexistinguser");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        NotFound notFound = responeu

        JSONObject jsonObject = new JSONObject(jsonBody);
        Integer Value1= (Integer) getValueFor(jsonObject, ID);
    }
}
