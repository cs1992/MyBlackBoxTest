package com.test.blackbox.list.model;

import org.json.simple.JSONObject;

import com.test.blackbox.util.ConstanceValue;
import com.test.blackbox.util.ConstanceValue.FromAndToListParam;

public class FromToListDto {
    private String name;
    private String email;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setField(JSONObject field) {
	name = String.valueOf(field.get(ConstanceValue.FromAndToListParam.NAME.param));
	email = String.valueOf(field.get(ConstanceValue.FromAndToListParam.EMAIL.param));

    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	StringBuilder value = new StringBuilder();
	for (FromAndToListParam param : FromAndToListParam.values()) {
	    str.append("\t\t" + param.param + " : ");

	    switch (param) {
	    case EMAIL:
		value.append(email);
		break;
	    case NAME:
		value.append(name);
		break;
	    default:
		value.append("null");
	    }

	    str.append(value + "\n");
	    value = new StringBuilder();
	}

	return str.toString();
    }

}
