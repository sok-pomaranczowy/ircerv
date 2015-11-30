package pl.edu.uksw.irc;

import java.nio.channels.SelectionKey;

public interface UserManager {

	/*
	 * This interface implements IRC server commands
	 * 
	 * Commands will be received and parsed elsewhere this interface is used by
	 * invoking methods by layer closer to user
	 * 
	 * Parameter "connectionKey" specifies connection from which command was received
	 * 
	 * 
	 * Return codes:
	 * 
	 * 0 - command executed properly
	 * 
	 * 1.. - integer specifying which error from RFC #1459 occured (counted from
	 * left to right)
	 * 
	 * for example for NICK command:
	 * 
	 * 0 - OK 1 - ERR_NONICKNAMEGIVEN 2 - ERR_ERRONEUSNICKNAME 3 -
	 * ERR_NICKNAMEINUSE 4 - ERR_NICKCOLLISION
	 * 
	 * number lower than 0 or higher than number of declared errors means
	 * unexpected error occured
	 */

	public int pass(String password, SelectionKey connectionKey);

	public int nick(String nickname, SelectionKey connectionKey);

	public int user(String username, String hostname, String servername,
			String realname, SelectionKey connectionKey);

	public int server(String servername, String hopcount, String info, SelectionKey connectionKey);

	public int oper(String user, String password, SelectionKey connectionKey);

	public int quit(String message, SelectionKey connectionKey);

	public int squit(String server, String comment, SelectionKey connectionKey);

	public int join(String channel, String channel2, String key, String key2, SelectionKey connectionKey);

	public int part(String channel, String channel2, SelectionKey connectionKey);

	public int channelMode(String channel, String modes, String limit,
			String user, String banMask, SelectionKey connectionKey);

	public int userMode(String nickname, String modes, SelectionKey connectionKey);

	public int topic(String channel, String topic, SelectionKey connectionKey);

	public int names(String channel, String channel2, SelectionKey connectionKey);

	public int list(String channel, String channel2, String server, SelectionKey connectionKey);

	public int invite(String nickname, String channel, SelectionKey connectionKey);

	public int kick(String channel, String user, String comment, SelectionKey connectionKey);

	public int version(String server, SelectionKey connectionKey);

	public int stats(String query, String server, SelectionKey connectionKey);

	public int links(String remoteServer, String serverMask, SelectionKey connectionKey);

	public int time(String server, SelectionKey connectionKey);

	public int connect(String targetServer, String port, String remoteServer, SelectionKey connectionKey);

	public int trace(String server, SelectionKey connectionKey);

	public int admin(String server, SelectionKey connectionKey);

	public int info(String server, SelectionKey connectionKey);

	public int privmsg(String receiver, String receiver2, String text, SelectionKey connectionKey);

	public int notice(String nickname, String text, SelectionKey connectionKey);

	public int who(String name, String o, SelectionKey connectionKey);

	public int whois(String server, String nickMask, String nickMask2, SelectionKey connectionKey);

	public int whowas(String nickname, String count, String server, SelectionKey connectionKey);

	public int kill(String nick, String comment, SelectionKey connectionKey);

	public int ping(String server1, String server2, SelectionKey connectionKey);

	public int pong(String daemon, String daemon2, SelectionKey connectionKey);

	public int error(String errorMessage, SelectionKey connectionKey);

}
