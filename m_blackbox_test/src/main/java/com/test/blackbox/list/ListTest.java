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


//{"currentTime":1499248692,"lastPage":1,"Message":"","pageSize":30,"unreadCount":1,"mailData":[{"mailSN":23,"folderSN":0,"folderName":null,"iconType":0,"status":2097152,"from":{"name":"테스트01","email":"api_test01@mail.wdomain8.com"},"subject":"받는사람 참조","receivedTime":1499229489,"sentTime":1499229489,"size":6261,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#fffde0","preview":"","mimeSN":"1499229489.751951.14206.38656","toList":[{"name":"테스트00","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<2d2c8f79b794423dac6ddbece03fc125@cvweb026.wmail.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499229489,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200000","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":22,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"이창선[Changseon Lee]","email":"changsun.lee@worksmobile.com"},"subject":"테스트테스트","receivedTime":1499160642,"sentTime":1499160642,"size":2549,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499160642.680047.19424.38656","toList":[{"name":"테스트00","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<f6b82367cd157585ac5359ace514ddba@cvweditor02.nmdf.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499160642,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":21,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"LINE WORKS","email":"no_reply@worksmobile.com"},"subject":"[발송실패 안내] sdd@mail.wdomain8.com으로 메일이 전송되지 못했습니다.","receivedTime":1499153397,"sentTime":1499153397,"size":26065,"attachCount":1,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499153397.889769.22697.22272","toList":[{"name":"","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<1499153397843.7f4b9.88108@cvsendbo06.wmail>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499153397,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":20,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"LINE WORKS","email":"no_reply@worksmobile.com"},"subject":"[발송실패 안내] asdd@mail.wdomain8.com으로 메일이 전송되지 못했습니다.","receivedTime":1499153397,"sentTime":1499153397,"size":26091,"attachCount":1,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499153397.909062.21043.38656","toList":[{"name":"","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<1499153397870.7f4b9.88110@cvsendbo06.wmail>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499153397,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":19,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"LINE WORKS","email":"no_reply@worksmobile.com"},"subject":"[발송실패 안내] adsasd@mail.wdomain8.com으로 메일이 전송되지 못했습니다.","receivedTime":1499153397,"sentTime":1499153397,"size":26100,"attachCount":1,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499153397.895731.23032.46848","toList":[{"name":"","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<1499153397857.7f4b9.88109@cvsendbo06.wmail>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499153397,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":12,"folderSN":0,"folderName":null,"iconType":0,"status":2359301,"from":{"name":"테스트01","email":"api_test01@mail.wdomain8.com"},"subject":"RE: 전송데이터 참초","receivedTime":1499148396,"sentTime":1499148396,"size":11484,"attachCount":1,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499148396.328905.22627.46848","toList":[{"name":"테스트00","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<d8ab52cdb21ad4811d245a52af23ac@cvweb023.wmail.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499148396,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"240005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":10,"folderSN":6,"folderName":null,"iconType":0,"status":5,"from":{"name":"테스트00","email":"api_test00@mail.wdomain8.com"},"subject":"테스트 메모","receivedTime":1499147724,"sentTime":1499147724,"size":1056,"attachCount":0,"iDomainEmail":"","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499147724.232763.21612.22272","toList":[{"name":"","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<dad94972214b5164f63453533e6f54@cvweb013.wmail.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499147724,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"5","isDomainMail":true,"bigFile":false,"toMe":false},{"mailSN":6,"folderSN":0,"folderName":null,"iconType":0,"status":6291461,"from":{"name":"관리자","email":"admin@mail.wdomain8.com"},"subject":"[약속 초대] 회의 - 07.04(화) 오후 01:30 서울 (GMT+09:00) (10-4 회의실)","receivedTime":1499134838,"sentTime":1499134838,"size":20414,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499134838.542141.21722.1792","toList":[{"name":"테스트00","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<1499134838505.7f79b.23840@cvowl01.wmail>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499134838,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"600005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":5,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"이창선[Lee Changseon]","email":"changsun.lee@worksmobile.com"},"subject":"테스트 1","receivedTime":1499134223,"sentTime":1499134222,"size":4380,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499134223.283069.21043.46848","toList":[{"name":"","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<5ac69e575afc23dc3eedfc33a5290c1@cvweditor01.nmdf.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499134223,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":4,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"테스트01","email":"api_test01@mail.wdomain8.com"},"subject":"발송 테스트","receivedTime":1499070975,"sentTime":1499070975,"size":1932,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499070976.221435.24885.1792","toList":[{"name":"테스트00","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<184c3fa0b4b3af8ea275e6cb5f2d6c58@cvweb014.wmail.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499070975,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":2,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"테스트로 추가한 이름","email":"admin@mail.wdomain8.com"},"subject":"테스트 메일을 발송합니다.","receivedTime":1499066675,"sentTime":1499066675,"size":4205,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499066676.531760.26813.26368","toList":[{"name":"테스트00","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<24a16c2bec4e26ede826f549c943812@cvweb003.wmail.nhnsystem.com>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499066675,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true},{"mailSN":1,"folderSN":0,"folderName":null,"iconType":0,"status":2097157,"from":{"name":"LINE WORKS","email":"no_reply@worksmobile.com"},"subject":"mail.wdomain8.com에 계정이 등록되었습니다.","receivedTime":1499066259,"sentTime":1499066259,"size":35664,"attachCount":0,"iDomainEmail":"api_test00@mail.wdomain8.com","priority":3,"securityLevel":"NORMAL","reSend":true,"color":"#ffffff","preview":"","mimeSN":"1499066259.935868.26192.63232","toList":[{"name":"","email":"api_test00@mail.wdomain8.com"}],"spamType":null,"attachInfo":[],"threadId":"<1499066259877.7f79b.19474@cvowl01.wmail>","bccList":[],"receiveByBcc":false,"threadCount":0,"unreadThreadCount":0,"firstLocatedTime":1499066259,"remindAt":0,"threadRemindAt":0,"threadRemindFlag":0,"statusHex":"200005","isDomainMail":true,"bigFile":false,"toMe":true}],"folderName":"전체메일","totalCount":12,"listCount":12,"Result":"OK"}


public class ListTest {

    public static String url = "http://testapi.mail.naver.com/external/testapi?url=/json/list";
    // public static String url =
    // "http://testapi.mail.naver.com/external/testapi?url=/json/read";
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
