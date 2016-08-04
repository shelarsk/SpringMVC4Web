package com.gk.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.model.Area;
import com.gk.repository.AreaRepository;
import com.gk.service.IAreaService;
import com.gk.vo.sampleVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Service
@Transactional(readOnly = true)
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private AreaRepository repository;

	@Override
	@Transactional(readOnly = false)
	public boolean add(Area area) throws Exception {
		repository.add(area);
		return true;
	}

	@Override
	public List<Area> loadAll() throws Exception {
		return repository.list();
	}

	@Override
	@Transactional(readOnly = false)
	public boolean update(Area area) throws Exception {
		repository.update(area);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean remove(Area area) throws Exception {
		repository.delete(area);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public List<JsonArray> getJsonAllRecords(Object[] prmObj) throws Exception

	{
		List<JsonArray> l = new ArrayList<JsonArray>();
		Gson gson = new Gson();
		JsonArray array = new JsonArray();
		array.add(gson
				.toJsonTree(new sampleVO(1, "001", "Gaurav k	", "95520184900",
						"<a href='#'><i class='fa  fa-check-square-o  fa-fw'></i></a>")));
		l.add(array);
		return l;
	}

}
