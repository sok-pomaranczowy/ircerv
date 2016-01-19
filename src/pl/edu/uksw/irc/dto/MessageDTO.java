package pl.edu.uksw.irc.dto;

/**
 * Created by sok_pomaranczowy on 08.01.16.
 */
public class MessageDTO {
    private String prefix = "";
    private String name; //serverName lub nick
    private String user;
    private String host;
    private String command;
    private String params = "";
    private String middleParams;
    private String trailingParams;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getMiddleParams() {
        return middleParams;
    }

    public void setMiddleParams(String middleParams) {
        this.middleParams = middleParams;
    }

    public String getTrailingParams() {
        return trailingParams;
    }

    public void setTrailingParams(String trailingParams) {
        this.trailingParams = trailingParams;
    }
    
    
}
