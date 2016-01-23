package pl.edu.uksw.irc.queue;

import pl.edu.uksw.irc.dto.MessageDTO;

/**
 * Created by sok_pomaranczowy on 08.01.16.
 */
public class EventBus {
	
	public MessageDTO getIncomingEvent(){
		return null;
	}
	
	public boolean pushOutgoingEvent(){
		return true;
	}
	
	public MessageDTO getOutgoingEvent(){
		return null;
	}
	
	public boolean pushIncomingEvent(){
		return true;
	}
	
	
	
}
