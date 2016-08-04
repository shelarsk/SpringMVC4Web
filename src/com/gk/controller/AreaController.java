package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.gk.model.Area;
import com.gk.service.IAreaService;
import com.gk.util.AppConstants;
import com.gk.util.JsonUtil;
import com.google.gson.JsonArray;

@Controller
public class AreaController {
	@Autowired
	private IAreaService pService;

	IAreaService getService() {
		return pService;
	}

	@RequestMapping(value = "/area", method = RequestMethod.GET)
	public String getList(ModelMap model) {
		try {
			model.addAttribute("areaList", getService().loadAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Area";
	}

	@RequestMapping(value = "/saveArea", method = RequestMethod.POST)
	public View create(@ModelAttribute Area aObj, ModelMap model) {
		try {
			if (StringUtils.hasText(aObj.getId())) {
				getService().update(aObj);
			} else {
				getService().add(aObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new RedirectView("/SpringMVC4Web/area.do");
	}

	@RequestMapping(value = "/deleteArea", method = RequestMethod.GET)
	public View delete(@ModelAttribute Area aObj, ModelMap model) {
		System.out.println("inside delete");
		try {
			getService().remove(aObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/SpringMVC4Web/area.do");
	}

	protected String getJsonDataTableString(List<JsonArray> jsonList,
			long startIndex, long endIndex, long totalRecords) {
		return JsonUtil.getJsonDataTableString(jsonList, startIndex, endIndex,
				totalRecords);
	}

	protected String getJsonString(List<JsonArray> jsonList) {
		return JsonUtil.getJsonString(jsonList);
	}

	protected String getJsonString(List<JsonArray> jsonList, String[] attributes) {
		return JsonUtil.getJsonString(jsonList, attributes);
	}

	protected String getJsonDataTableErrorString() {
		String message = AppConstants.AP_ERROR_MSG;
		return JsonUtil.getJsonDataTableErrorString(message);
	}

	protected String getJsonErrorString() {
		String message = AppConstants.AP_ERROR_MSG;
		return JsonUtil.getJsonErrorString(message);
	}

	protected String getJsonDefaultString() {
		return JsonUtil.getJsonDefaultString();
	}
}
