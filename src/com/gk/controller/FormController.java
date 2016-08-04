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

import com.gk.model.Form;
import com.gk.model.FormField;
import com.gk.model.Notification;
import com.gk.service.IFormService;
import com.gk.util.AppConstants;
import com.gk.util.JsonUtil;
import com.google.gson.JsonArray;

@Controller
public class FormController {
	@Autowired
	private IFormService pService;

	IFormService getService() {
		return pService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getList(ModelMap model) {
		try {
			model.addAttribute("dataList", getService().loadAll());
			System.out.println(getService().getJsonAllRecords(null).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Form";
	}

	@RequestMapping(value = "/saveForm", method = RequestMethod.POST)
	public View create(@ModelAttribute Form aObj, ModelMap model) {
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

		return new RedirectView("/SpringMVC4Web-0.0.1-SNAPSHOT/form.do");
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public View delete(@ModelAttribute Form aObj, ModelMap model) {
		System.out.println("inside delete");
		try {
			getService().remove(aObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/SpringMVC4Web-0.0.1-SNAPSHOT/form.do");
	}
	
	@RequestMapping(value = "/getJsonFormList", method = RequestMethod.GET)
	@ResponseBody
	public String getJasonNotificationList(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("inside getJasonNotificationList");
		String jsonStr="";
		try {
		
			StringBuffer sb= new StringBuffer();
			List<Form> nl=getService().loadAll();
			String req= request.getParameter("callback");
			sb.append(req+"([");
			if(nl != null && nl.size() >0)
			{
				for(Form vo:nl)
				{
					sb.append("{");
					sb.append("id :"+"'"+vo.getId()+"'"+",");
					sb.append("title :"+"'"+vo.getTitle()+"'"+",");
					sb.append("summary :"+"'"+vo.getSummary()+"'"+",");
					sb.append("startDate :"+"'"+vo.getStartDate()+"'"+",");
					sb.append("endDate :"+"'"+vo.getEndDate()+"'"+",");
					sb.append("requestedBy :"+"'"+vo.getRequestedBy()+"'"+",");
					sb.append("contact :"+"'"+vo.getContact()+"'"+",");
					sb.append("detail :"+"'"+vo.getDetail()+"'");
					sb.append("}");
					sb.append(",");
				}
				
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("]);");
			
			System.out.println("sb => "+sb.toString());
			jsonStr=sb.toString();

			System.out.println("json String => "+jsonStr);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonStr=getJsonErrorString();
		}
		System.out.println("Final jsonStr => "+jsonStr);
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
	
	@RequestMapping(value = "/formField", method = RequestMethod.GET)
	public String getFieldList(ModelMap model) {
		try {
			model.addAttribute("formList", getService().loadAll());
			model.addAttribute("dataList", getService().loadFieldAll());
			System.out.println(getService().getJsonAllRecords(null).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "FormField";
	}
	
	@RequestMapping(value = "/saveFormField", method = RequestMethod.POST)
	public View saveFormField(@ModelAttribute FormField aObj, ModelMap model) {
		try {
			if (StringUtils.hasText(aObj.getId())) {
				getService().updateFormField(aObj);
			} else {
				getService().addFormField(aObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new RedirectView("/SpringMVC4Web-0.0.1-SNAPSHOT/formField.do");
	}

	@RequestMapping(value = "/deleteFormField", method = RequestMethod.GET)
	public View deleteField(@ModelAttribute FormField aObj, ModelMap model) {
		System.out.println("inside delete");
		try {
			getService().removeFormField(aObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/SpringMVC4Web-0.0.1-SNAPSHOT/formField.do");
	}
	
	
	
	@RequestMapping(value = "/getJsonFormFieldList", method = RequestMethod.GET)
	@ResponseBody
	public String getJsonFormFieldList(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("inside getJsonFormFieldList");
		String jsonStr="";
		try {
		
			String req= request.getParameter("callback");
			String formID= request.getParameter("id");
			StringBuffer sb= new StringBuffer();
			
			List<FormField> nl=getService().loadFieldAll(formID);
			
			sb.append(req+"([");
			if(nl != null && nl.size() >0)
			{
				for(FormField vo:nl)
				{
					sb.append("{");
					sb.append("id :"+"\""+vo.getId()+"\""+",");
					sb.append("name :"+"\""+vo.getName()+"\""+",");
					sb.append("type :"+"\""+vo.getType()+"\""+",");
					sb.append("placeholder :"+"\""+vo.getPlaceholder()+"\"");
					sb.append("}");
					sb.append(",");
				}
				
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("])");
			
			System.out.println("sb => "+sb.toString());
			jsonStr=sb.toString();

			System.out.println("json String => "+jsonStr);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonStr=getJsonErrorString();
		}
		System.out.println("Final jsonStr => "+jsonStr);
		response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods",

                                "POST, GET, OPTIONS, DELETE");

        response.setHeader("Access-Control-Max-Age", "3600");

        response.setHeader("Access-Control-Allow-Headers",

                                "Origin, X-Requested-With, Content-Type, Accept");

        // response.setStatus(404);

        response.flushBuffer();
		return jsonStr;
	}
	
	
}
