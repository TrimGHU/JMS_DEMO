package com.hugui.springmvc.jms.further;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Sender {
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendInfo() {
		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				//message.setString("firstName", "hu");
				message.setString("lastName", "gui123");
				//message.setString("flag", "you are right !");
				return message;
			}

		});
	}

}
