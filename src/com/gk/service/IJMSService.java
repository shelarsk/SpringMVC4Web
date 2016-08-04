package com.gk.service;

import com.gk.view.JMSView;


public interface IJMSService {

	boolean sendMessage(JMSView screenView) throws Exception;

	boolean sendMessageOnWeblogicQueue(JMSView screenView) throws Exception;

	boolean sendMessageOnWeblogicTopic(JMSView screenView) throws Exception;

}
