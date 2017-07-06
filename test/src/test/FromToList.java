package test;

import java.util.Map;

import org.json.simple.JSONObject;

import util.ConstanceValue.FromToListParam;

public class FromToList {
    MailMap field;
    
    public FromToList() {
	field = new MailMap();
    }

    public MailMap getField() {
	return field;
    }

    public void setField(JSONObject object) {
	if (object != null) {
	    for (FromToListParam param : FromToListParam.values()) {
		field.put(param.param, object.get(param.param));
	    }

	}
    }
    
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	
	for(FromToListParam param : FromToListParam.values()) {
	    str.append("\t" + param.param + " : " + field.get(param.param) + "\n");
	}
	
	return str.toString();
    }

}
