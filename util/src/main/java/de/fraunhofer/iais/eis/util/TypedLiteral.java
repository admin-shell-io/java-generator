package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

//Prevent empty values from being printed - @language AND @type in combination is forbidden
//Note that the Serializer uses this class by name. If this class is renamed, make sure to adapt the MessageParser class accordingly!
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypedLiteral extends RdfResource implements Serializable {

	@JsonProperty("@language")
	private String language = null;

	public TypedLiteral() {
		super();
	}
	

	public TypedLiteral(String valueAndTypeOrLanguage) {
		if(valueAndTypeOrLanguage.contains("@"))
		{
			String[] splitString = valueAndTypeOrLanguage.split("@");
			this.value = splitString[0];
			this.language = splitString[1];
		}
		//.contains expects character sequence. Passing "^^"
		else if(valueAndTypeOrLanguage.contains("^^"))
		{
			//.split expects regex. "^" is meta character for "start of line", so it needs to be escaped
			String[] splitString = valueAndTypeOrLanguage.split("\\^\\^");
			this.value = splitString[0].replace("\"", "");
			this.type = splitString[1];
		}
		else
		{
			this.value = valueAndTypeOrLanguage;
			this.type = "http://www.w3.org/2001/XMLSchema#string";
		}
	}

	public TypedLiteral(String value, URI type) { super(value, type); }

	public TypedLiteral(String value, String language) {
		this.value = value;
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	//This override doesn't seem to do much...
	@Override
	public String toString() {
		String result = this.value;
		if (this.language != null && !this.language.isEmpty())
		{
			return "\"" + result + "\"@" + this.language;
		}
		if (this.type != null && !this.type.isEmpty()) return "\"" + result + "\"^^" + this.type;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			TypedLiteral other = (TypedLiteral) obj;
			return Objects.equals(this.value, other.value) &&
					Objects.equals(this.type, other.type) &&
					Objects.equals(this.language, other.language) &&
					Objects.equals(this.properties, other.properties);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value,
				this.type,
				this.language,
				this.properties);
	}
}
