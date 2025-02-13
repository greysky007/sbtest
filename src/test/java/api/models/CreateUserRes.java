package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRes{

	@JsonProperty("code")
	private int code;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	public int getCode(){
		return code;
	}

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}
}