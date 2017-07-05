package temp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestClass2 {

	public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list";
	public static JSONParser parser = new JSONParser();
	
	public static String[] PARAM = {"Message", "Result", "currentTime", "folderName", "lastOffset", "lastPage", "listCount", "mailData", "pageSize", "totalCount", "unreadCount"};

	public static void main(String[] args) {
		try {
			URI uri = new URI(url);

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse response = httpClient.execute(new HttpGet(uri));
			HttpEntity entity = response.getEntity();

			String content = EntityUtils.toString(entity);
			System.out.println(content);
			JSONObject object = (JSONObject) parser.parse(content);

			int size = PARAM.length;
			
			for(int i = 0; i < size; i++) {
				System.out.println(PARAM[i] + " : " + object.get(PARAM[i]));
			}


		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
