package com.roi.testframeworks.concurrent;

import java.util.concurrent.TimeoutException;

import net.jodah.concurrentunit.Waiter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import com.google.common.eventbus.Subscribe;



public class ExampleConcurrentUnitTests {
	
	/* Concurrentunit waiter provides await() and resume() for 
       waiting for a condition and triggering a condition.	
	*/
	
	
	private Waiter waiter;
	
	@Before
	public void init(){
		waiter = new Waiter();
	}

	@Test
	public void simpleAsyncPublishWillBeReceivedByMessageService() throws TimeoutException{
		MessageService messageService = new  MessageService();
		
		messageService.register(new MessageListener());
		
		messageService.publish("Starting message");
		
		// Wait for resume but only for 2 seconds
		
		waiter.await(2000);
	}
	
	
	@Test
	public void simpleAsyncPublishMultipleMessagesWillBeReceivedByMessageService() throws TimeoutException{
		MessageService messageService = new  MessageService();
		
		messageService.register(new MessageListener());
		
		messageService.publish("Message One");
		messageService.publish("Message Two");
		messageService.publish("Message Three");
		
		// Wait for resume called three times but only for 2 seconds
		
		waiter.await(2000, 3);
	}
	
	@Test
	public void simpleAsyncPublishWithAssertionInAsynchronousReceiver() throws TimeoutException{
		MessageService messageService = new  MessageService();
		
		messageService.register(new MessageListenerUsingAssertion());
		
		messageService.publish("Message One");
				
		waiter.await();
	}
	

	
	
	
	
	class MessageListener{
		
		@Subscribe
		public void receive(String message){
			// Signal to waiter that message has been received
			
			waiter.resume();
			
			System.out.printf("Message Listener Received %s%n", message);
		}
	}

	class MessageListenerUsingAssertion{
		
		@Subscribe
		public void receive(String message){
			// Test will fail if assertion fails
			
			waiter.assertThat(true, is(false));
			
			System.out.printf("Message Listener Received %s%n", message);
		}
	}



}
