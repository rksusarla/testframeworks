package com.roi.testframeworks.concurrent;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

public class MessageService {
	private EventBus eventbus = new AsyncEventBus(Executors.newFixedThreadPool(5));
	
	
	public void publish(String message){
		eventbus.post(message);
	}
	
	public void register(Object receiver){
		eventbus.register(receiver);
	}
}
