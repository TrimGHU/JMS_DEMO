package com.hugui.springmvc.jms.example;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSSender {

//	private JmsTemplate jmsTemplate;
//
//	public JmsTemplate getJmsTemplate() {
//		return jmsTemplate;
//	}
//
//	public void setJmsTemplate(JmsTemplate jmsTemplate) {
//		this.jmsTemplate = jmsTemplate;
//	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext(
				"webRoot/WEB-INF/springmvc-servlet.xml");
		JmsTemplate template=(JmsTemplate)applicationContext.getBean("jmsTemplate");
		Destination destination=(Destination)applicationContext.getBean("destination");
		template.send(destination, new MessageCreator(){

			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Send Message:Hello ActiveMQ Text Message!");
			}
			
		});
		System.out.println("Send the JMS Message Successfully!");
	}

}

