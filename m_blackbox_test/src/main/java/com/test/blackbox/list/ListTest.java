package com.test.blackbox.list;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.blackbox.list.model.MailListDto;
import com.test.blackbox.util.ConstanceValue.FromAndToListParam;
import com.test.blackbox.util.ConstanceValue.MailDataParam;
import com.test.blackbox.util.ConstanceValue.MailResponseParam;


public class ListTest {

	public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list";
//	public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/read";
	public static JSONParser parser = new JSONParser();
	public static ObjectMapper mapper = new ObjectMapper();



	public static void main(String[] args) {
		try {
			URI uri = new URI(url);
			// add parameter
			// uri = new URIBuilder().addParameter("aaa", "aaaa").addParameter("bbbb",
			// "bbbb").build();

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse response = httpClient.execute(new HttpGet(uri));
			HttpEntity entity = response.getEntity();

			String content = EntityUtils.toString(entity);
			System.out.println(content);
		
			JSONObject object = (JSONObject) parser.parse(content);

			String paramName;
			String paramContent;

			displayMailList(object);
			MailListDto mailListDto = new MailListDto();
			mailListDto.setField(object);
			System.out.println(mailListDto);

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

	public static void displayMailList(JSONObject object) throws ParseException, JsonProcessingException, IOException {
		String paramName;
		String paramContent;

		for (MailResponseParam param : MailResponseParam.values()) {
			paramName = param.param;
			paramContent = String.valueOf(object.get(paramName));

			if (MailResponseParam.MAIL_DATA.param.equals(paramName)) {
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

//		System.out.println(mailData);
//		System.out.println("mailData : " + mapper.readTree(mailData.toString()).isArray());
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
//					System.out.println("===" + paramName);
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

//			System.out.println("tolist");
			JSONArray array = (JSONArray) fromToList;
			int size = array.size();

			for (int i = 0; i < size; i++) {
				object = (JSONObject) array.get(i);

				for (FromAndToListParam param : FromAndToListParam.values()) {
					paramName = param.param;
					paramContent = String.valueOf(object.get(paramName));

					System.out.println(tabB.toString() + paramName + " : " + paramContent);

				}

			}

		} else {

//			System.out.println("from");
			object = (JSONObject) fromToList;
			for (FromAndToListParam param : FromAndToListParam.values()) {
				paramName = param.param;
				paramContent = String.valueOf(object.get(paramName));

				System.out.println(tabB.toString() + paramName + " : " + paramContent);

			}
		}
	}

	public static boolean isJSONArray(Object obj) {
		return obj instanceof JSONArray;
	}
}
