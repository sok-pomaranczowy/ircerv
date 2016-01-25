/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.irc.executor;

import java.nio.channels.SelectionKey;

/**
 *
 * @author Anna Łukaszek-Zadrożna
 */
public class User {
    SelectionKey userKey; //hash, którego używa Jarek
    String nickName;
    String hostName;
    String serwerName;
    Boolean i; // i - marks a users as invisible;
    Boolean s;//      s - marks a user for receipt of server notices;
    Boolean w; //       w - user receives wallops;
    Boolean o; //      o - operator flag.
    
    
    public User(SelectionKey key, String nick, String host, String serwer){
       userKey = key;
       nickName = nick;
       hostName = host;
       serwerName = serwer;
       
        
    }
    
}