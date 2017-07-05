package temp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestClass4 {

	public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list";
	// public static String url =
	// "http://testapi.mail.naver.com/external/testapi?url=/json/read";
	public static JSONParser parser = new JSONParser();
	public static ObjectMapper mapper = new ObjectMapper();

	public static enum MailResponseParam {
		MESSAGE("message"), RESULT("result"), CURRENT_TIMe("currentTime"), FOLDER_NAME("folderName"), LAST_OFFSET(
				"lastOffset"), LAST_PAGE("lastPage"), LIST_COUNT("listCount"), MAIL_DATA(
						"mailData"), PAGE_SIZE("pageSize"), TOTAL_COUNT("totalCount"), UNREAD_COUNT("unreadCount");

		String param;

		MailResponseParam(String param) {
			this.param = param;
		}
	}

	public static enum MailDataParam {
		ATTACH_COUNT("attachCount"), ATTACH_INFO("attachInfo"), BCC_LIST("bccList"), BIG_FILE("bigFile"), COLOR(
				"color"), FIRST_LOCATION_TIME("firstLocationTime"), FOLDER_NAME("folderName"), FOLDER_SN(
						"folerSN"), FROM("from"), I_DOMAIN_EMAIL("iDomailEmail"), ICON_TYPE("iconType"), IS_DOMAIN_MAIL(
								"isDomainMail"), MAIL_SN("mailSN"), MIME_SN("miemeSN"), PREVIEW("preview"), PRIORITY(
										"priority"), RE_SEND("reSend"), RECEIVE_TIME("receiveTime"), REMIND_AT(
												"remindAt"), SECURITY_LEVEL("securityLevel"), SEND_TIME(
														"sendTime"), SIZE("size"), SPAM_TYPE("spamType"), STATUS(
																"status"), STATUS_HEX(
																		"statusHex"), SUBJECT("subject"), THREAD_COUNT(
																				"threadCount"), THREAD_ID(
																						"threadId"), THREAD_REMIND_AT(
																								"threadRemindAt"), THREAD_REMIND_FLAG(
																										"threadRemindFlag"), TO_LIST(
																												"toList"), TO_ME(
																														"toMe"), UNREAD_THREAD_COUNT(
																																"unreadThreadCount");

		String param;

		MailDataParam(String param) {
			this.param = param;
		}
	}

	public static enum FromAndToListParam {
		EMAIL("email"), NAME("name");

		String param;

		FromAndToListParam(String param) {
			this.param = param;
		}
	}

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

			// String paramName;
			// String paramContent;
			//
			// displayMailList(object);

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(content, new TypeReference<Map<String, Object>>() {
			});

			ArrayList<Map<String, Object>> mailData = new ArrayList<>();
			Map<String, Object> innerMap;
			for (String key : map.keySet()) {
				innerMap = mapper.readValue(String.valueOf(map.get(key)), new TypeReference<Map<String, Object>>() {
				});
				
				System.out.println(innerMap);
			}
			
			// JsonNode node = mapper.readTree(content);
			// for (String key : map.keySet()) {
			// // node = mapper.readTree(String.valueOf(map.get(key)));
			// if (node.path(key).isArray()) {
			// // Map<String, Object> inner = mapper.readValue(map.get(key).toString(), new
			// // TypeReference<Map<String, Object>>() {
			// // });
			// //
			// // for(String innerKey : inner.keySet()) {
			// // System.out.println(" \t" + inner.get(innerKey));
			// // }
			// System.out.println(node.path(key));
			// System.out.println(map.get(key));
			// ArrayList<Map<String, Object>> array =
			// mapper.readValue(node.get(key).toString(),
			// new TypeReference<Map<String, Object>>() {
			// });
			// } else {
			// System.out.println(key + " : " + map.get(key));
			// }
			// }
			//
			// System.out.println(map.keySet());

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

				for (FromAndToListParam param : FromAndToListParam.values()) {
					paramName = param.param;
					paramContent = String.valueOf(object.get(paramName));

					System.out.println(tabB.toString() + paramName + " : " + paramContent);

				}

			}

		} else {

			// System.out.println("from");
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
