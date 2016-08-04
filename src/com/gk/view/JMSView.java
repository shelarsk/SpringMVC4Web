/**
 * 
 */
package com.gk.view;

import java.util.List;

import com.gk.vo.SubAddributes;

/**
 * @author gaurav_kshirsagar
 *
 */
public class JMSView {

	private String sConnectionFactory;
	private String sSessionQueueName;
	private String sSessionTopicName;
	private String sMessage;
	private String sDestinatinType;
	private String sServiceProvider;
	private List<SubAddributes> pSubAddributesList;
	private String sApplicationName;
	private String sApplicationNARID;
	private String sIdentificationName;

	/**
	 * @return the sConnectionFactory
	 */
	public String getsConnectionFactory() {
		return sConnectionFactory;
	}

	/**
	 * @param sConnectionFactory
	 *            the sConnectionFactory to set
	 */
	public void setsConnectionFactory(String sConnectionFactory) {
		this.sConnectionFactory = sConnectionFactory;
	}

	/**
	 * @return the sSessionQueueName
	 */
	public String getsSessionQueueName() {
		return sSessionQueueName;
	}

	/**
	 * @param sSessionQueueName
	 *            the sSessionQueueName to set
	 */
	public void setsSessionQueueName(String sSessionQueueName) {
		this.sSessionQueueName = sSessionQueueName;
	}

	/**
	 * @return the sSessionTopicName
	 */
	public String getsSessionTopicName() {
		return sSessionTopicName;
	}

	/**
	 * @param sSessionTopicName
	 *            the sSessionTopicName to set
	 */
	public void setsSessionTopicName(String sSessionTopicName) {
		this.sSessionTopicName = sSessionTopicName;
	}

	/**
	 * @return the sMessage
	 */
	public String getsMessage() {
		return sMessage;
	}

	/**
	 * @param sMessage
	 *            the sMessage to set
	 */
	public void setsMessage(String sMessage) {
		this.sMessage = sMessage;
	}

	/**
	 * @return the sDestinatinType
	 */
	public String getsDestinatinType() {
		return sDestinatinType;
	}

	/**
	 * @param sDestinatinType
	 *            the sDestinatinType to set
	 */
	public void setsDestinatinType(String sDestinatinType) {
		this.sDestinatinType = sDestinatinType;
	}

	public String getsServiceProvider() {
		return sServiceProvider;
	}

	public void setsServiceProvider(String sServiceProvider) {
		this.sServiceProvider = sServiceProvider;
	}

	public List<SubAddributes> getpSubAddributesList() {
		return pSubAddributesList;
	}

	public void setpSubAddributesList(List<SubAddributes> pSubAddributesList) {
		this.pSubAddributesList = pSubAddributesList;
	}

	public String getsApplicationName() {
		return sApplicationName;
	}

	public void setsApplicationName(String sApplicationName) {
		this.sApplicationName = sApplicationName;
	}

	public String getsApplicationNARID() {
		return sApplicationNARID;
	}

	public void setsApplicationNARID(String sApplicationNARID) {
		this.sApplicationNARID = sApplicationNARID;
	}

	public String getsIdentificationName() {
		return sIdentificationName;
	}

	public void setsIdentificationName(String sIdentificationName) {
		this.sIdentificationName = sIdentificationName;
	}
}
