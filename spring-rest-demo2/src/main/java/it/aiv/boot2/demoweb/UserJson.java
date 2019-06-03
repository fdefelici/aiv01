package it.aiv.boot2.demoweb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJson {

	@JsonProperty
	public long id;
	@JsonProperty
	public String name;
	@JsonProperty
	public String surname;
	

}
