package pl.edu.uksw.irc.queue;

import pl.edu.uksw.irc.dto.MessageDTO;

/**
 * Created by sok_pomaranczowy on 08.01.16.
 */
public class EventBus {
	
	public MessageDTO getIncomingEvent(){
		return null;
	}
	
	public boolean pushOutgoingEvent(MessageDTO message){
		return true;
	}
	
	public MessageDTO getOutgoingEvent(){
		return null;
	}
	
	public boolean pushIncomingEvent(MessageDTO meessage){
		return true;
	}
	
	
	
}
