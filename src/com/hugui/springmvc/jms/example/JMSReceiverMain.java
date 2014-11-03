package com.hugui.springmvc.jms.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JMSReceiverMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"webRoot/WEB-INF/springmvc-servlet.xml");
		JMSReceiver proxyJMSConsumer = (JMSReceiver) applicationContext
				.getBean("messageReceiver");
		proxyJMSConsumer.receive();
		System.out.println("Initial Consumer End! ");
	}

}
