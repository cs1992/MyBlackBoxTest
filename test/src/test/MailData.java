package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.ConstanceValue.MailDataParam;

public class MailData {

    HashMap<String, Object> mailData;
    FromToList from;
    ArrayList<FromToList> toList;

    public MailData() {
	mailData = new HashMap<String, Object>();
	from = new FromToList();
	toList = new ArrayList<>();
    }

    public HashMap<String, Object> getMailData() {
	return mailData;
    }

    public FromToList getFrom() {
	return from;
    }

    public void setFrom(FromToList from) {
	this.from = from;
    }

    public ArrayList<FromToList> getToList() {
	return toList;
    }

    public void setToList(JSONArray array) {
	JSONObject temp;
	FromToList fromToList;
	int size = array.size();
	
	for(int i = 0; i < size; i++) {
	    fromToList = new FromToList();
	    temp = (JSONObject) array.get(i);
	    fromToList.setField(temp);
	    toList.add(fromToList);
	}
    }

    public void setMailData(JSONObject object) {
	if (object != null) {
	    for (MailDataParam param : MailDataParam.values()) {
		if (param == MailDataParam.FROM) {
		    from.setField((JSONObject) object.get(param.param));
		} else if (param == MailDataParam.TO_LIST) {
		    setToList((JSONArray) object.get(param.param));
		} else {
		    mailData.put(param.param, object.get(param.param));

		}
	    }

	}
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	for (MailDataParam param : MailDataParam.values()) {
	    if (param == MailDataParam.FROM) {
		str.append("\t" + from.toString() + "\n");
	    } else if (param == MailDataParam.TO_LIST) {
		int size = toList.size();

		for (int i = 0; i < size; i++) {
		    str.append("\t" + toList.get(i).toString() + "\n");
		}
	    } else {
		str.append("\t" + param.param + " : " + mailData.get(param.param) + "\n");
	    }
	}

	str.append("----------------------------------------------------\n");
	return str.toString();
    }

}
