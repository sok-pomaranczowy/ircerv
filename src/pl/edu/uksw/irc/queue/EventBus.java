package pl.edu.uksw.irc.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import pl.edu.uksw.irc.dto.MessageDTO;

/**
 * Created by sok_pomaranczowy on 08.01.16.
 */
public class EventBus {
	 
    ConcurrentLinkedQueue<MessageDTO> incomingQueue;
    
    ConcurrentLinkedQueue<MessageDTO> outgoingQueue;
    
    public EventBus(){
        incomingQueue= new ConcurrentLinkedQueue<>();
        outgoingQueue =new ConcurrentLinkedQueue<>();
    }
	public MessageDTO getIncomingEvent(){
		return incomingQueue.poll();
	}
	
	public boolean pushOutgoingEvent(MessageDTO message){
            boolean success = outgoingQueue.add(message);
		return success;
	}
	
	public MessageDTO getOutgoingEvent(){
		return outgoingQueue.poll();
	}
	
	public boolean pushIncomingEvent(MessageDTO message){
		 boolean success = incomingQueue.add(message);
		return success;
	}
	
	
	
}
