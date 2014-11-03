package com.hugui.springmvc.jms.further;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ReceiverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new FileSystemXmlApplicationContext("webRoot/WEB-INF/applicationContext.xml");
		Receiver receiver=(Receiver) context.getBean("receiver");
		System.out.println(receiver.receiveMessage());
	}

	
}
