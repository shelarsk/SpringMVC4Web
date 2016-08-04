package com.gk.service.serviceImpl;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.service.IJMSService;
import com.gk.view.JMSView;
import com.gk.vo.SubAddributes;

@Service
@Transactional(readOnly = true)
public class JMSServiceImpl implements IJMSService {

	// Active MQ Setting START
	ActiveMQConnectionFactory connectionFactory;
	Connection connection;
	Session session;
	Destination destination;
	MessageProducer producer;
	TextMessage message;
	// Active MQ Setting END

	// WEBLOGIC Setting START

	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	protected TopicConnectionFactory tconFactory;
	protected TopicConnection tcon;
	protected TopicSession tsession;
	protected TopicPublisher tpublisher;
	protected Topic topic;
	protected TextMessage msg;

	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueSender qsender;
	private Queue queue;

	// WEBLOGIC Setting END

	@Override
	public boolean sendMessage(JMSView screenView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sendMessage - START");
		if (screenView != null) {
			// screen view not null - checking for destination type

			// Create a ConnectionFactory
			connectionFactory = new ActiveMQConnectionFactory(
					screenView.getsConnectionFactory());
			// Create a Connection
			connection = connectionFactory.createConnection();
			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			if ("Queue".equals(screenView.getsDestinatinType())) {
				// Create the destination (Topic or Queue)
				destination = session.createQueue(screenView
						.getsSessionQueueName());
			} else {
				destination = session.createTopic(screenView
						.getsSessionQueueName());
			}
			// Create a MessageProducer from the Session to the Topic or Queue
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			message = session.createTextMessage(screenView.getsMessage());
			System.out.println("Sent message: " + message.hashCode());
			producer.send(message);

			// Clean up
			session.close();
			connection.close();
			System.out.println("sendMessage - SUCESS END");
			return true;

		} else {
			System.out.println("sendMessage - ERROR END");
			return false;
		}

	}

	@Override
	public boolean sendMessageOnWeblogicQueue(JMSView screenView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sendMessageOnWeblogicQueue - START");
		if (screenView != null) {
			// screen view not null - checking for destination type

			InitialContext ic = getWeblogicInitialContext(screenView);
			initWeblogicQueue(ic, screenView);
			sendWebLogicQueueMsg(screenView.getsMessage());
			closeWeblogicQueue();
			System.out.println("sendMessageOnWeblogicQueue - SUCESS END");
			return true;

		} else {
			System.out.println("sendMessageOnWeblogicQueue - ERROR END");
			return false;
		}

	}

	@Override
	public boolean sendMessageOnWeblogicTopic(JMSView screenView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sendMessageOnWeblogicTopic - START");
		if (screenView != null) {
			// screen view not null - checking for destination type

			InitialContext ic = getWeblogicInitialContext(screenView);
			initWeblogicTopic(ic, screenView);
			sendWeblogicTopicMsg(screenView.getsMessage());
			closeWeblogicTopic();
			System.out.println("sendMessageOnWeblogicTopic - SUCESS END");
			return true;

		} else {
			System.out.println("sendMessageOnWeblogicTopic - ERROR END");
			return false;
		}

	}

	public void initWeblogicQueue(Context ctx, JMSView screenView)
			throws NamingException, JMSException {
		qconFactory = (QueueConnectionFactory) ctx.lookup(screenView
				.getsConnectionFactory());
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(screenView.getsSessionQueueName());
		qsender = qsession.createSender(queue);
		msg = qsession.createTextMessage();
		qcon.start();
	}

	public void sendWebLogicQueueMsg(String message) throws JMSException {
		msg.setText(message);
		qsender.send(msg);
	}

	public void closeWeblogicQueue() throws JMSException {
		qsender.close();
		qsession.close();
		qcon.close();
	}

	public void sendWeblogicTopicMsg(String message) throws JMSException {
		msg.setText(message);
		tpublisher.publish(msg);
	}

	public void closeWeblogicTopic() throws JMSException {
		tpublisher.close();
		tsession.close();
		tcon.close();
	}

	private InitialContext getWeblogicInitialContext(JMSView screenView)
			throws NamingException {
		Hashtable env = new Hashtable();
		// env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		// env.put(Context.PROVIDER_URL, screenView.getpSubAddributesList());
		if (null != screenView.getpSubAddributesList()
				&& screenView.getpSubAddributesList().size() > 0)
			for (SubAddributes vo : screenView.getpSubAddributesList()) {
				env.put(vo.getKey(), vo.getVal());
			}

		return new InitialContext(env);
	}

	public void initWeblogicTopic(Context ctx, JMSView screenView)
			throws NamingException, JMSException {
		tconFactory = (TopicConnectionFactory) PortableRemoteObject.narrow(
				ctx.lookup(screenView.getsConnectionFactory()),
				TopicConnectionFactory.class);
		tcon = tconFactory.createTopicConnection();
		tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) PortableRemoteObject.narrow(
				ctx.lookup(screenView.getsSessionQueueName()), Topic.class);
		tpublisher = tsession.createPublisher(topic);
		msg = tsession.createTextMessage();
		tcon.start();
	}

}
