package temp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.JsonParser;

import util.ConstanceValue.MailListParam;

public class MailList {

    MailMap mailList;
    ArrayList<MailData> mailDataList;

    public MailList() {
	mailList = new MailMap();
	mailDataList = new ArrayList<>();
    }

    public MailMap getMailList() {
	return mailList;
    }

    public void setMailList(MailMap mailList) {
	this.mailList = mailList;
    }

    public ArrayList<MailData> getMailDataList() {
	return mailDataList;
    }

    public void setMailDataList(JSONArray array) {
	MailData mailData;
	JSONObject temp;
	int size = array.size();
	
	for(int i = 0; i < size; i++) {
	    temp = (JSONObject) array.get(i);
	    mailData = new MailData();
	    mailData.setMailData(temp);
	    mailDataList.add(mailData);
	}
	
    }

    public void setMailList(JSONObject object) {

	if (object != null) {

	    for (MailListParam param : MailListParam.values()) {
		if (param == MailListParam.MAIL_DATA) {
		    setMailDataList((JSONArray) object.get(param.param));
		} else {
		    mailList.put(param.param, object.get(param.param));
		}

	    }

	}
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	for (MailListParam param : MailListParam.values()) {
	    if (param == MailListParam.MAIL_DATA) {
		int size = mailDataList.size();

		for (int i = 0; i < size; i++) {
		    str.append(mailDataList.get(i).toString() + "\n");
		}
	    } else {
		str.append(param.param + " : " + mailList.get(param.param) + "\n");
	    }
	}
	
	str.append("\n========================================================\n");

	return str.toString();

    }

}
