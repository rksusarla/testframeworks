package com.roi.testframeworks.async;

/**
 * 
 * @author user
 *
 * Simulates a messaging service that writes a message to a repository with a  second delay
 */
public class MessageService {
	private NodeRepository nodeRepository;

	public MessageService(NodeRepository nodeRepository) {
		this.nodeRepository = nodeRepository;
	}
	
	public void publish(final Node node){
	    new Thread(){
	    	public void run(){
	    		try {
			    // Here to simulate delay for showing awaitility for asynchronous testing
	    			Thread.sleep(3000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    		nodeRepository.addNode(node);
	    	}
	    }.start();
	}
}
