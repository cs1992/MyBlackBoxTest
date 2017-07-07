package test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import util.ConstanceValue.FromToListParam;

public class FromToList {
    HashMap<String, Object> field;
    
    public FromToList() {
	field = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getField() {
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
