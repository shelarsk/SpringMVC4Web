package com.gk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gk.service.IJMSService;
import com.gk.view.JMSView;
import com.gk.vo.SubAddributes;

@Controller
public class JMSMessageController {

	@Autowired
	private IJMSService service;

	@RequestMapping(value = "/showActiveMQ", method = RequestMethod.GET)
	public String showActiveMQScreen(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		JMSView screenView = new JMSView();
		List<SubAddributes> pSubAddributesList = new ArrayList<SubAddributes>();
		pSubAddributesList.add(new SubAddributes());
		pSubAddributesList.add(new SubAddributes());
		pSubAddributesList.add(new SubAddributes());
		pSubAddributesList.add(new SubAddributes());
		pSubAddributesList.add(new SubAddributes());
		pSubAddributesList.add(new SubAddributes());
		screenView.setpSubAddributesList(pSubAddributesList);
		model.put("screenView", screenView);
		request.setAttribute("TABS", "stActiveMQ.jsp");
		request.setAttribute("TITLE", "Send Message ");
		request.setAttribute("MESSAGE", "");
		return "sHome";
	}

	@RequestMapping(value = "/sendActiveMQ", method = RequestMethod.POST)
	public String processRegistration(
			@ModelAttribute("screenView") JMSView screenView,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {

		try {

			if (screenView != null) {
				System.out.println("connection factory : "
						+ screenView.getsConnectionFactory());
				System.out.println("destination type : "
						+ screenView.getsDestinatinType());
				System.out.println("message : " + screenView.getsMessage());
				System.out.println("session queue name : "
						+ screenView.getsSessionQueueName());
				System.out.println("session topic name : "
						+ screenView.getsSessionTopicName());
				
				if(screenView.getpSubAddributesList() != null)
				{
					System.out.println("addribute list is not null");
					if( screenView.getpSubAddributesList().size()>0)
					{
						System.out.println("addribute size is more than 0 => "+ screenView.getpSubAddributesList().size());
						for(SubAddributes vo:screenView.getpSubAddributesList())
						{
							System.out.println("key := "+vo.getKey() +"   value :="+vo.getVal());
						}
						
					}else
					{
						System.out.println("addribite size came as 0");
					}
					
				}else
				{
					System.out.println("addribute list came as null");
				}

				boolean bMessageStatus = service.sendMessage(screenView);

				System.out.println("bMessageStatus = > " + bMessageStatus);
				request.setAttribute("MESSAGE", "Message Send Successfully !");
				request.setAttribute("MESSAGE_STATUS", "SUCCESS");
			} else {
				System.out.println("no data fetched from form object ...");
				request.setAttribute("MESSAGE",
						"No Message FOr Send try again later !");
				request.setAttribute("MESSAGE_STATUS", "FAILED");
			}
		} catch (Exception e) {
			request.setAttribute("MESSAGE",
					"Some Error Occured While processing your request, please try again.");
			request.setAttribute("MESSAGE_STATUS", "FAILED");
			e.printStackTrace();
		}

		// implement your own registration logic here...

		// for testing purpose:

		request.setAttribute("TABS", "stActiveMQ.jsp");
		request.setAttribute("TITLE", "Send Message ");

		return "sHome";
	}
	
	
	@RequestMapping(value = "/showWLSMessage", method = RequestMethod.GET)
	public String showWeblogicScreen(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		JMSView screenView = new JMSView();
		model.put("screenView", screenView);
		request.setAttribute("TABS", "stWLSMessage.jsp");
		request.setAttribute("TITLE", "Send Message to Weblogic Queue /Topic");
		request.setAttribute("MESSAGE", "");
		return "sHome";
	}

	@RequestMapping(value = "/sendWLSMessage", method = RequestMethod.POST)
	public String processWeblogicMessage(
			@ModelAttribute("screenView") JMSView screenView,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {

		try {

			if (screenView != null) {
				System.out.println("connection factory : "
						+ screenView.getsConnectionFactory());
				System.out.println("destination type : "
						+ screenView.getsDestinatinType());
				System.out.println("message : " + screenView.getsMessage());
				System.out.println("session queue name : "
						+ screenView.getsSessionQueueName());
				System.out.println("session topic name : "
						+ screenView.getsSessionTopicName());

				boolean bMessageStatus = service.sendMessage(screenView);

				System.out.println("bMessageStatus = > " + bMessageStatus);
				request.setAttribute("MESSAGE", "Message Send Successfully !");
				request.setAttribute("MESSAGE_STATUS", "SUCCESS");
				
			} else {
				System.out.println("no data fetched from form object ...");
				request.setAttribute("MESSAGE",
						"No Message FOr Send try again later !");
				request.setAttribute("MESSAGE_STATUS", "FAILED");
			}
		} catch (Exception e) {
			request.setAttribute("MESSAGE",
					"Some Error Occured While processing your request, please try again.");
			request.setAttribute("MESSAGE_STATUS", "FAILED");
			e.printStackTrace();
		}

		// implement your own registration logic here...

		// for testing purpose:

		request.setAttribute("TABS", "stWLSMessage.jsp");
		request.setAttribute("TITLE", "Send Message to Weblogic Queue /Topic");

		return "sHome";
	}
	
}
