package test;

import org.json.simple.JSONObject;

import util.ConstanceValue;

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

}
