package temp;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestClass3 {

	public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list";
	public static JSONParser parser = new JSONParser();

	public static enum MailResponseParam {
		MESSAGE("message"), RESULT("result"), CURRENT_TIMe("currentTime"), FOLDER_NAME("folderName"), LAST_OFFSET(
				"lastOffset"), LAST_PAGE("lastPage"), LIST_COUNT("listCount"), MAIL_DATA(
						"mailData"), PAGE_SIZE("pageSize"), TOTAL_COUNT("totalCount"), UNREAD_COUNT("unreadCount");

		public String param;

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

		public String param;

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

			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(content);
			System.out.println(node);
			System.out.println(node.get("mailData"));
			System.out.println(node.path("mailData"));
			System.out.println(node.get("mailData").get("toList"));
			System.out.println(node.path("mailData").path("toList"));
			System.out.println("----------");
			JsonNode toListNode = mapper.readTree(node.get("mailData").toString());
			System.out.println(toListNode.isArray());
			ArrayList<MailDataDto> mailDataList = mapper.readValue(toListNode.toString(), new TypeReference<ArrayList<MailDataDto>>() {});
			
			
			System.out.println(toListNode);
			System.out.println(toListNode.get("from"));

		} catch (URISyntaxException e) {
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

	public static void displayMailList(JSONObject object) throws ParseException {
		String paramName;
		String paramContent;

		for (MailResponseParam param : MailResponseParam.values()) {
			paramName = param.param;
			paramContent = String.valueOf(object.get(paramName));

			if (MailResponseParam.MAIL_DATA.param.equals(paramName)) {
				JSONArray jsonArray = (JSONArray) object.get(paramName);
				displayMailData(jsonArray, 1);
			} else {
				System.out.println(paramName + " : " + paramContent);
			}
		}
	}

	public static void displayMailData(JSONArray array, int tab) throws ParseException {
		String paramName;
		String paramContent;
		int size = array.size();
		JSONObject object;
		StringBuilder tabB = new StringBuilder();

		for (int i = 0; i < tab; i++) {
			tabB.append("  ");
		}

		for (int i = 0; i < size; i++) {
			object = (JSONObject) array.get(i);

			for (MailDataParam param : MailDataParam.values()) {
				paramName = param.param;
				paramContent = String.valueOf(object.get(paramName));

				// System.out.println(paramContent);

				if ((MailDataParam.FROM.param.equals(paramName) || MailDataParam.TO_LIST.equals(paramName))) {
					System.out.println(paramContent);
					JSONArray jsonArray = (JSONArray) object.get(paramName);
					displayFromToList(jsonArray, tab++);
				} else {
					System.out.println(tabB.toString() + paramName + " : " + paramContent);
				}
			}

		}

	}

	public static void displayFromToList(JSONArray array, int tab) throws ParseException {
		String paramName;
		String paramContent;
		JSONObject object;
		StringBuilder tabB = new StringBuilder();

		for (int i = 0; i < tab; i++) {
			tabB.append("  ");
		}

		int size = array.size();

		for (int i = 0; i < size; i++) {
			object = (JSONObject) array.get(i);

			for (FromAndToListParam param : FromAndToListParam.values()) {
				paramName = param.param;
				paramContent = String.valueOf(object.get(paramName));

				System.out.println(tabB.toString() + paramName + " : " + paramContent);

			}

		}

	}

	public static boolean isJSONArray(Object obj) {
		System.out.println("####is JsonArray");
		return obj instanceof JSONArray;
	}
}
