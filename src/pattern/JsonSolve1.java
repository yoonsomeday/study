package a_Json;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonSolve1 {

	public static void main(String[] args) throws IOException {
		JsonObject jo = new JsonObject();
		jo.addProperty("name", "spiderman");
		jo.addProperty("age", 45);
		jo.addProperty("name", true);
		
		JsonArray ja = new JsonArray();
		ja.add("martial art");
		ja.add("gun");
		jo.add("specialty", ja);

		JsonObject jo2 = new JsonObject();
		jo2.addProperty("1st", "done");
		jo2.addProperty("2nd", "expected");
		jo2.add("3rd", null);
		jo.add("vaccine", jo2);

		jo2 = new JsonObject();
		JsonArray ja2 = new JsonArray();
		jo2.addProperty("name", "spiderboy");
		jo2.addProperty("age", 10);
		ja2.add(jo2);
		
		jo2 = new JsonObject();
		jo2.addProperty("name", "spiderfirl");
		jo2.addProperty("age", 8);
		ja2.add(jo2);
		jo.add("children", ja2);
		
		try(Writer writer = new FileWriter("sample.json")) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			gson.toJson(jo,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println(jo.toString());
		
		// �ٸ� ���
		
//		FileWriter fw = new FileWriter("sample2.json");
//		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(jsonObject.toString());
//		bw.close();
//		fw.close();
		
	}
}
