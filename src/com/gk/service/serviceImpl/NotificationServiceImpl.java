package com.gk.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.model.Notification;
import com.gk.repository.NotificationRepository;
import com.gk.service.INotificationService;
import com.gk.vo.sampleVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Service
@Transactional(readOnly = true)
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	private NotificationRepository repository;

	@Override
	@Transactional(readOnly = false)
	public boolean add(Notification area) throws Exception {
		repository.add(area);
		return true;
	}

	@Override
	public List<Notification> loadAll() throws Exception {
		return repository.list();
	}
	
	@Override
	public List<Notification> loadAllJSON() throws Exception {
		return repository.list();
		
	}

	@Override
	@Transactional(readOnly = false)
	public boolean update(Notification area) throws Exception {
		repository.update(area);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean remove(Notification area) throws Exception {
		repository.delete(area);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public List<JsonArray> getJsonAllRecords(Object[] prmObj) throws Exception

	{
		List<JsonArray> l = new ArrayList<JsonArray>();
		Gson gson = new Gson();
		
		List<Notification> nl=repository.list();
		if(nl != null && nl.size() >0)
		{
			for(Notification vo:nl)
			{
				JsonArray array = new JsonArray();
				array.add(gson
						.toJsonTree(vo));
				l.add(array);
			}
			
		}else
		{
			JsonArray array = new JsonArray();		
			l.add(array);
		}
		
		return l;
	}

}
