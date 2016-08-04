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

import com.gk.model.Notification;
import com.gk.service.INotificationService;
import com.gk.util.AppConstants;
import com.gk.util.JsonUtil;
import com.google.gson.JsonArray;

@Controller
public class NotificationController {
	@Autowired
	private INotificationService pService;

	INotificationService getService() {
		return pService;
	}

	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public String getList(ModelMap model) {
		try {
			model.addAttribute("dataList", getService().loadAll());
			System.out.println(getService().getJsonAllRecords(null).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Notification";
	}

	@RequestMapping(value = "/saveNotification", method = RequestMethod.POST)
	public View create(@ModelAttribute Notification aObj, ModelMap model) {
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

		return new RedirectView("/SpringMVC4Web/notification.do");
	}

	@RequestMapping(value = "/deleteNotification", method = RequestMethod.GET)
	public View delete(@ModelAttribute Notification aObj, ModelMap model) {
		System.out.println("inside delete");
		try {
			getService().remove(aObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/SpringMVC4Web/notification.do");
	}
	
	@RequestMapping(value = "/getJsonNoficationList", method = RequestMethod.GET)
	@ResponseBody
	public String getJasonNotificationList(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("inside getJasonNotificationList");
		String jsonStr="";
		try {
		
			StringBuffer sb= new StringBuffer();
			List<Notification> nl=getService().loadAll();
			String req= request.getParameter("callback");
			sb.append(req+"([");
			if(nl != null && nl.size() >0)
			{
				for(Notification vo:nl)
				{
					sb.append("{");
					sb.append("id :"+"\""+vo.getId()+"\""+",");
					sb.append("title :"+"\""+vo.getTitle()+"\""+",");
					sb.append("summary :"+"\""+vo.getSummary()+"\""+",");
					sb.append("detail :"+"\""+vo.getDetail()+"\"");
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
