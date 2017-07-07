package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import util.ConstanceValue.FromToListParam;
import util.ConstanceValue.MailDataParam;
import util.ConstanceValue.MailListParam;

public class TestClass {

//    public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list?folderSN=1&";
    public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list";
//    public static String url = "testapi.mail.naver.com/external/testapi?url=/json/list";
    // public static String url =
    // "https://cc.naver.com/cc?a=cfb_rds.backbasic&r=&i=&bw=941&px=350&py=592&sx=350&sy=592&m=0&nsc=works.mail&u=about%3Ablank&time=1499412681770";
    // public static String url =
    // "http://testapi.mail.naver.com/external/testapi?url=/json/option/read/set?firstFolderSN=all&dddddd=1231233&unreadMailType=0&popupRead=123";
    // public static String url =
    // "http://testapi.mail.naver.com/external/testapi?url=/json/folder/setRead?folderSN=5&status=unRead";
    // public static String url =
    // "http://testapi.mail.naver.com/external/testapi?url=/json/option/read/get?sOption=asdasdasdasdad";
    public static JSONParser parser = new JSONParser();
    public static ObjectMapper mapper = new ObjectMapper();

    // 프로젝트 키워드 블랙박스 자동화
    // 미리 디자인된 것도 api가 바뀌면 안될 수 있음
    // 시나리오의 디테일 필요성
    //

    // public static void main(String[] args) {
    //
    // MailListRequest request = new MailListRequestImpl();
    // ArrayList<MailList> list = request.requestAllList();
    // System.out.println(list.size());
    //
    // // TestList testList = new TestListImpl();
    // // testList.testSameRequest(100);
    //
    // }
    
    
    public static void main(String[] args) {
	URI uri;
	try {
	    HttpClient client = HttpClientBuilder.create().build();
	    uri = new URI(url);
	    HttpPost post = new HttpPost(uri);
	    List<NameValuePair> params = new ArrayList<>();
	    params.add(new BasicNameValuePair("folderSN", "5"));
	    
	    UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
	    post.setEntity(ent);
	    HttpResponse httpPost = client.execute(post);
	    HttpEntity entity = httpPost.getEntity();
	    String result = EntityUtils.toString(entity);
	    System.out.println(result);
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ClientProtocolException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    

    public static void displayMailList(JSONObject object) throws ParseException, JsonProcessingException, IOException {
	String paramName;
	String paramContent;

	for (MailListParam param : MailListParam.values()) {
	    paramName = param.param;
	    paramContent = String.valueOf(object.get(paramName));

	    if (MailListParam.MAIL_DATA.param.equals(paramName)) {
		displayMailData((Object) object.get(paramName), 1);
	    } else {
		System.out.println(paramName + " : " + paramContent);
	    }
	}
    }

    public static void displayMailData(Object mailData, int tab)
	    throws ParseException, JsonProcessingException, IOException {
	String paramName;
	String paramContent;
	JSONObject object;
	StringBuilder tabB = new StringBuilder();

	for (int i = 0; i < tab; i++) {
	    tabB.append("  ");
	}

	// System.out.println(mailData);
	// System.out.println("mailData : " +
	// mapper.readTree(mailData.toString()).isArray());
	JSONArray array = (JSONArray) mailData;

	int size = array.size();
	for (int i = 0; i < size; i++) {

	    System.out.println();
	    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-");
	    System.out.println();
	    object = (JSONObject) array.get(i);

	    for (MailDataParam param : MailDataParam.values()) {
		paramName = param.param;
		paramContent = String.valueOf(object.get(paramName));

		// System.out.println(paramContent);

		if (param.equals(MailDataParam.TO_LIST) || param.equals(MailDataParam.FROM)) {
		    // System.out.println("===" + paramName);
		    // JSONArray jsonArray = (JSONArray) object.get(paramName);
		    displayFromToList(object.get(paramName), tab + 1);
		} else {
		    System.out.println(tabB.toString() + paramName + " : " + paramContent);
		}
	    }

	    System.out.println();
	    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-");
	    System.out.println();
	}

    }

    public static void displayFromToList(Object fromToList, int tab)
	    throws ParseException, JsonProcessingException, IOException {
	String paramName;
	String paramContent;
	JSONObject object;
	StringBuilder tabB = new StringBuilder();

	for (int i = 0; i < tab; i++) {
	    tabB.append("  ");
	}

	if (mapper.readTree(fromToList.toString()).isArray()) {

	    // System.out.println("tolist");
	    JSONArray array = (JSONArray) fromToList;
	    int size = array.size();

	    for (int i = 0; i < size; i++) {
		object = (JSONObject) array.get(i);

		for (FromToListParam param : FromToListParam.values()) {
		    paramName = param.param;
		    paramContent = String.valueOf(object.get(paramName));

		    System.out.println(tabB.toString() + paramName + " : " + paramContent);

		}

	    }

	} else {

	    // System.out.println("from");
	    object = (JSONObject) fromToList;
	    for (FromToListParam param : FromToListParam.values()) {
		paramName = param.param;
		paramContent = String.valueOf(object.get(paramName));

		System.out.println(tabB.toString() + paramName + " : " + paramContent);

	    }
	}
    }

    public static boolean isJSONArray(Object obj) {
	return obj instanceof JSONArray;
    }

//    public static void main(String[] args) {
//	try {
//	    // URI uri = new URI(ConstanceValue.API_URL + APIs.LIST.api);
//	    List<NameValuePair> params = new ArrayList<>();
//	    params.add(new BasicNameValuePair("folderSN", "1"));
//	    // add parameter
//	    // uri = new URIBuilder().addParameter("aaa", "aaaa").addParameter("bbbb",
//	    // "bbbb").build();
////	    System.out.println(url);
////	    URI uri = new URI(url, URLEncodedUtils.format(params, "UTF-8"), null);
//	    URI uri = URIUtils.createURI("http", url, -1, "",URLEncodedUtils.format(params, "UTF-8"), null);
//	    HttpClient httpClient = HttpClientBuilder.create().build();
//	    
//	    HttpResponse response = httpClient.execute(new HttpGet(uri));
//	    
//	    HttpEntity entity = response.getEntity();
//
//	    String content = EntityUtils.toString(entity);
//	    System.out.println(content);
//
//	    JSONObject object = (JSONObject) parser.parse(content);
//
//	    String paramName;
//	    String paramContent;
//
//	    // displayMailList(object);
//	    // MailListResponseDto mailListDto = new MailListResponseDto();
//	    // mailListDto.setField(object);
//	    // System.out.println(mailListDto);
//
//	} catch (URISyntaxException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	} catch (ClientProtocolException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	} catch (IOException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	} catch (ParseException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	}
//    }
}
