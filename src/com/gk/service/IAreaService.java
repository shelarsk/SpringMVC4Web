package com.gk.service;

import java.util.List;

import com.gk.model.Area;

public interface IAreaService {

	boolean add(Area area) throws Exception;

	List<Area> loadAll() throws Exception;

	boolean update(Area area) throws Exception;

	boolean remove(Area area) throws Exception;

	List<com.google.gson.JsonArray> getJsonAllRecords(Object[] prmObj)
			throws Exception;

}
