package com.gk.service;

import java.util.List;

import com.gk.model.Notification;

public interface INotificationService {

	boolean add(Notification area) throws Exception;

	List<Notification> loadAll() throws Exception;

	boolean update(Notification area) throws Exception;

	boolean remove(Notification area) throws Exception;

	List<com.google.gson.JsonArray> getJsonAllRecords(Object[] prmObj)
			throws Exception;

	List<Notification> loadAllJSON() throws Exception;

}
