package com.roi.testframeworks.async;

import java.util.concurrent.Callable;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.awaitility.Awaitility.await;
import static com.jayway.awaitility.Awaitility.to;
import static org.hamcrest.Matchers.equalTo;


public class ExampleAwaitilityTests {

	private NodeRepository nodeRepository;
	private MessageService messageService;
	private static long startTime;
	private static long endTime;
	
	
	@BeforeClass
	public static void startClass(){
		startTime = System.nanoTime();
	}

	@AfterClass
	public static void endClass(){
		endTime = System.nanoTime();
		System.out.printf("Test run time is %.6f seconds ", (endTime - startTime)/1000000000.0);
	}
	
	
	
	@Before
	public void init(){
		nodeRepository = new NodeRepository();
		messageService = new MessageService(nodeRepository);
	}
	

	@Test
	public void testOne(){
		System.out.println("Running test one");
	}

	@Test
	public void simplePublishWillUpdateRepositoryRecordSizeByOne(){
		messageService.publish(new Node());		
		System.out.println("Running test with delay");
		await().until( nodeRepositorySize(), equalTo(1) );
	}
	
	@Test
	public void testTwo(){
		messageService.publish(new Node());		
		messageService.publish(new Node());		
		messageService.publish(new Node());		
		System.out.println("Running test three");
		
		await().untilCall( to(nodeRepository).size(), equalTo(3) );
	}
	
	private Callable<Integer> nodeRepositorySize() {
	      return new Callable<Integer>() {
	            public Integer call() throws Exception {
	                  return nodeRepository.size(); 
	            }
	      };
	}
}
