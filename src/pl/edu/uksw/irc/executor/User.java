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
       i= s = w = o = null;
        
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userKey.equals(user.userKey)) {
            return false;
        }

        return nickName.equals(user.nickName);

    }

    @Override
    public int hashCode() {
        int result = userKey.hashCode();
        result = 31 * result + nickName.hashCode();
        return result;
    }


    public SelectionKey getUserKey() {
        return userKey;
    }

    public String getNickName() {
        return nickName;
    }

    public String getHostName() {
        return hostName;
    }

    public String getSerwerName() {
        return serwerName;
    }

    public Boolean getI() {
        return i;
    }

    public Boolean getS() {
        return s;
    }

    public Boolean getW() {
        return w;
    }

    public Boolean getO() {
        return o;
    }

    public void setUserKey(SelectionKey userKey) {
        this.userKey = userKey;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setSerwerName(String serwerName) {
        this.serwerName = serwerName;
    }

    public void setI(Boolean i) {
        this.i = i;
    }

    public void setS(Boolean s) {
        this.s = s;
    }

    public void setW(Boolean w) {
        this.w = w;
    }

    public void setO(Boolean o) {
        this.o = o;
    }
    
    
}