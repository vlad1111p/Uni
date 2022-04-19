import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class FigurSerialization implements JsonSerializer<Figur>, JsonDeserializer<Figur> {
	
	@Override
	public Figur deserialize(JsonElement json, Type TypeofT,
							JsonDeserializationContext context) throws JsonParseException {

		JsonObject obj = json.getAsJsonObject();
		String type = obj.get("type").getAsString();
		switch (type) {
			case "rechteck":
				return context.deserialize(json, Rechteck.class);
			case "kreis":
				return context.deserialize(json, Kreis.class);
			case "linie":
				return context.deserialize(json, Linie.class);
			default:
				throw new JsonParseException("Figur nicht bekannt: " + type);
		}
	}

	@Override
	public JsonElement serialize(Figur figur, Type typeOfSrc,
								JsonSerializationContext context) {
		String type;
		if(figur instanceof Rechteck) {
			type = "rechteck";
		} else if(figur instanceof Kreis) {
			type = "kreis";
		} else if(figur instanceof Linie) {
			type = "linie";
		} else {
			throw new RuntimeException("Figur nicht bekannt: " + figur);
		}
		JsonObject obj = (JsonObject) context.serialize(figur);
		obj.add("type", new JsonPrimitive(type));
		return obj;
	}
}