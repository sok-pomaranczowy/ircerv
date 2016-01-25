package pl.edu.uksw.irc.tests;

import junit.framework.Assert;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import pl.edu.uksw.irc.dto.Command;
import pl.edu.uksw.irc.dto.MessageDTO;
import pl.edu.uksw.irc.executor.MessageParser;
import pl.edu.uksw.irc.executor.MessageRenderer;

public class MessageParserTest {

    MessageParser parser;
    MessageRenderer renderer;
    
    @Before
    public void onSetUp(){
        parser = new MessageParser();
        renderer = new MessageRenderer();
    }
        
    @Test
    public void testPasswordMessage(){
        String incomingMessage = ":hello!sir@madam PRIVMSG test :Hello, world!";
        MessageDTO parseMessage = parser.parseMessage(new MessageDTO(incomingMessage,null));
        Assert.assertEquals(parseMessage.getName(), "hello");
        Assert.assertEquals(parseMessage.getUser(), "sir");
        Assert.assertEquals(parseMessage.getHost(), "madam");
        Assert.assertEquals(parseMessage.getCommand(), Command.PRIVMSG);
        Assert.assertEquals(parseMessage.getMiddleParams()[0], "test ");
        Assert.assertEquals(parseMessage.getTrailingParams(), "Hello, world!");
        assertThat(parseMessage.getName(), not("h1ello"));
        
    }

    
     @Test
    public void testRendererMessage(){
        String name = "";
        String user = "";
        String host = "";
        Command command = Command.NICK;
        String [] middleParams ={"A", "B"};
        String trailingParams = "";
        MessageDTO message = new MessageDTO();
        
        message.setName(name);
        message.setUser(user);
        message.setHost(host);
        message.setCommand(command);
        message.setMiddleParams(middleParams);
        
        message.setTrailingParams(trailingParams);
        String msg = renderer.renderMessage(message);
        String msg4 = Command.NICK+ " "+middleParams[0]+ ", "+middleParams[1];
        Assert.assertEquals(msg, msg4);
    }
    
    @Test
    public void testRendererMessageZPrefiksem(){       
        
        String name = "Angel";
        String user = "";
        String host = "";
        Command command = Command.PRIVMSG;
        String [] middleParams ={"Wiz"};
        String trailingParams = "Hello, are you receiving this message?";
        
        MessageDTO message = new MessageDTO();
        
        message.setName(name);
        message.setUser(user);
        message.setHost(host);
        message.setCommand(command);
        message.setMiddleParams(middleParams);
        
        message.setTrailingParams(trailingParams);
        String msg3 = ":"+name+" "+Command.PRIVMSG+" "+middleParams[0]+ " :"+trailingParams;
        String msg = renderer.renderMessage(message);
        Assert.assertEquals(msg, msg3);       
    }
}