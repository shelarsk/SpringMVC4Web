package com.gk.util;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonUtil {

	public static String getJsonDataTableString(List<JsonArray> jsonList, long startIndex, long endIndex, long totalRecords) {
		JsonArray data = getJsonArray(jsonList);
		JsonObject jsonResponse = getJsonDataTableResponse(data, startIndex, endIndex, totalRecords);
		return convertResponseToJson(jsonResponse);
	}

	public static String getJsonString(List<JsonArray> jsonList) {
		JsonArray data = getJsonArray(jsonList);
		JsonObject jsonResponse = getJsonResponse(data);
		return convertResponseToJson(jsonResponse);
	}
	
	public static String getJsonString(List<JsonArray> jsonList, String[] attributes) {
		JsonArray data = getJsonArray(jsonList, attributes);
		JsonObject jsonResponse = getJsonResponse(data);
		return convertResponseToJson(jsonResponse);
	}

	public static String getJsonDataTableErrorString(String message) {
		JsonArray data = new JsonArray();
		JsonArray row = new JsonArray();
		row.add(new JsonPrimitive(message));
		data.add(row);
		JsonObject jsonResponse = getJsonDataTableResponse(data, 0, 0, 0);
		jsonResponse.addProperty(JsonConstants.JC_ERROR, message);
		return convertResponseToJson(jsonResponse);
	}

	public static String getJsonErrorString(String message) {
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty(JsonConstants.JC_ERROR, message);
		return convertResponseToJson(jsonResponse);
	}

	public static String getJsonDefaultString() {
		JsonArray data = new JsonArray();
		JsonObject jsonResponse = getJsonResponse(data);
		return convertResponseToJson(jsonResponse);
	}
	
	private static JsonArray getJsonArray(List<JsonArray> jsonList) {
		JsonArray data = new JsonArray();
		for (JsonArray row : jsonList) {
			data.add(row);
		}
		return data;
	}
	
	private static JsonArray getJsonArray(List<JsonArray> jsonList, String[] attributes) {
		JsonArray data = new JsonArray();
		for (JsonArray row : jsonList) {
			data.add(getJsonResponse(row, attributes));
		}
		return data;
	}

	private static JsonObject getJsonResponse(JsonArray data) {
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.add(JsonConstants.JC_OUTPUT, data);
		return jsonResponse;
	}
	
	private static JsonObject getJsonResponse(JsonArray data, String[] attributes) {
		JsonObject jsonResponse = new JsonObject();
		for (int i = 0; i < attributes.length; i++)
		{
			jsonResponse.add(attributes[i], data.get(i));
		}		
		return jsonResponse;
	}

	private static JsonObject getJsonDataTableResponse(JsonArray data, long startIndex, long endIndex, long totalRecords) {
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty(JsonConstants.JC_START_INDEX, startIndex);
		jsonResponse.addProperty(JsonConstants.JC_END_INDEX, endIndex);
		jsonResponse.addProperty(JsonConstants.JC_TOTAL_RECORDS, totalRecords);
		jsonResponse.add(JsonConstants.JC_AADATA, data);
		return jsonResponse;
	}

	private static String convertResponseToJson(JsonObject jsonResponse) {
		Gson gson = new Gson();
		return StringEscapeUtils.unescapeJava(gson.toJson(jsonResponse));
	}
}
