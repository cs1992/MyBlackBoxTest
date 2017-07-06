package test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import util.ConstanceValue;
import util.ConstanceValue.APIs;
import util.ConstanceValue.ListType;

public class MailListRequestImpl implements MailListRequest {

    private String url = ConstanceValue.API_URL + APIs.LIST.api;

    @Override
    public ArrayList<MailList> requestAllList() {

	ArrayList<MailList> list = new ArrayList<>();
	HttpClient httpClient = HttpClientBuilder.create().build();
	URI uri;
	HttpResponse response;
	HttpEntity entity;
	JSONObject object;
	JSONParser parser = new JSONParser();
	String responseStr;
	MailList mailList = new MailList();
	ListRequestParameter listParam = new ListRequestParameter();
	try {
	    for (ListType type : ListType.values()) {
		listParam.setParam(type);
		uri = new URI(url + listParam.toString());
		System.out.println("\n" + type.name() + " : " + uri.toString() + " ##################################");
		response = httpClient.execute(new HttpGet(uri));
		entity = response.getEntity();
		responseStr = EntityUtils.toString(entity);
		object = (JSONObject) parser.parse(responseStr);
		mailList= new MailList();
		mailList.setMailList(object);
		System.out.println(mailList);
		list.add(mailList);
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

	return list;
    }

}
