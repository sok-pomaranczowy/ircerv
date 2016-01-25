/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.irc.executor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudi
 */
public class Channel {
    
    List<User> membersList;
    String channelTopic;
    String channelName;
    
    
    public Channel(String newName,String newTopic, User member){
       channelName = newName;
        channelTopic = newTopic;
        membersList = new ArrayList<>();
        membersList.add(member);
    }
    
    public void changeTopic(String newTopic){
        channelTopic = newTopic;
        
    }
}
