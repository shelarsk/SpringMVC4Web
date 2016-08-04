package com.gk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.gk.service.IPersonService;
import com.gk.util.AppConstants;
import com.gk.util.JsonUtil;
import com.gk.util.RequestConstants;
import com.google.gson.JsonArray;

@Controller
public class SampleController {
	@Autowired
	private IPersonService personService;

	IPersonService getService() {
		return personService;
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getPersonList(ModelMap model) {
		try {
			model.addAttribute("personList", personService.loadAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "output";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public View createPerson(@ModelAttribute com.gk.model.Person person,
			ModelMap model) {
		try {
			if (StringUtils.hasText(person.getId())) {
				personService.updatePerson(person);
			} else {
				personService.addPerson(person);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new RedirectView("/SpringMVC4Web/person.do");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public View deletePerson(@ModelAttribute com.gk.model.Person person,
			ModelMap model) {
		System.out.println("inside delete");
		try {
			personService.removePerson(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/SpringMVC4Web/person.do");
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboard(ModelMap model) {
		try {
			// model.addAttribute("personList", personService.loadAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "screenHome";
	}

	@RequestMapping(value = "/homeSample", method = RequestMethod.GET)
	public String getSampleHome(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// model.addAttribute("personList", personService.loadAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("JSP_PATH", "sHomeSample.jsp");
		return "screenHome";
	}
	
	@RequestMapping(value = "/homeSampleJson", method = RequestMethod.GET)
	public String getSampleJasonHome(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// model.addAttribute("personList", personService.loadAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("JSP_PATH", "sHomeSampleJson.jsp");
		return "screenHome";
	}

	@RequestMapping(value = RequestConstants.RM_JSON_DT_RECORD_SAMPLE)
	@ResponseBody
	public String getJsonDataTableRecordsList(final ModelMap model,
			HttpServletRequest request) {

		System.out.println("inside  getJsonDataTableRecordsList ");
		String jsonStr = "";

		try {

			String sCountSQL = "";
			long totalRecords = 0;
			long startIndex = 0;
			long endIndex = 0;
			long offset = startIndex - 1;
			List<JsonArray> jsonList = null;
			Object[] prmObj = null;
			jsonList = getService().getJsonAllRecords(prmObj);
			jsonStr = getJsonDataTableString(jsonList, startIndex, endIndex,
					totalRecords);
			System.out.println("jsonStr => "+jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr = getJsonDataTableErrorString();
		}
		System.out.println("jsonStr Final => "+jsonStr);
		return jsonStr;
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
