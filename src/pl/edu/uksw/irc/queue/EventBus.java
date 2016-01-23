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
		return null;
	}
	
	public boolean pushOutgoingEvent(MessageDTO message){
            boolean success = outgoingQueue.add(message);
		return success;
	}
	
	public MessageDTO getOutgoingEvent(){
		return null;
	}
	
	public boolean pushIncomingEvent(MessageDTO message){
		return true;
	}
	
	
	
}
