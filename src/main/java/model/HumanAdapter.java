package model;

import com.google.gson.*;
import java.lang.reflect.Type;

public class HumanAdapter implements JsonDeserializer<Human>, JsonSerializer<Human> {

    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        System.out.println("Deserializing JSON: " + jsonObject); // Логування JSON перед парсингом

        String type = jsonObject.has("type") ? jsonObject.get("type").getAsString() : "Unknown";
        System.out.println("Deserializing Human of type: " + type);

        switch (type) {
            case "Student":
                return context.deserialize(json, Student.class);
            case "Human":
                return new Human(
                        jsonObject.get("firstName").getAsString(),
                        jsonObject.get("lastName").getAsString(),
                        jsonObject.get("middleName").getAsString(),
                        Gender.valueOf(jsonObject.get("gender").getAsString())
                ) {};
            default:
                throw new JsonParseException("Unknown type: " + type);
        }
    }

    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstName", src.firstName);
        jsonObject.addProperty("lastName", src.lastName);
        jsonObject.addProperty("middleName", src.middleName);
        jsonObject.addProperty("gender", src.gender.toString());

        String type = (src instanceof Student) ? "Student" : "Human";
        jsonObject.addProperty("type", type);

        System.out.println("Serializing Human: " + jsonObject);
        return jsonObject;
    }


}
