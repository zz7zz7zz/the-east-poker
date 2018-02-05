package com.poker.games.protocols;


public final class BaseGameCmd {
	
	//客户端发起   （游戏基础命令字）,范围是0x1001~0x1FFF
	public static final int CMD_CLIENT_USER_EXIT             	= 0x1002;//用户退出
	public static final int CMD_CLIENT_USER_READY 				= 0x1003;//用户准备
	public static final int CMD_CLIENT_KICK_USER 	    		= 0x1004;//用户踢人
	public static final int CMD_CLIENT_OFFLINE 	    			= 0x1005;//用户掉线
	
	//服务器返回  （游戏基础命令字）,范围是0x2001~0x2FFF
	public static final int CMD_SERVER_USERLOGIN   				= 0x2001;//用户进入
	public static final int CMD_SERVER_BROAD_USERLOGIN   		= 0x2002; 
	
	public static final int CMD_SERVER_USERLOGOUT   			= 0x2003;//用户退出 
	public static final int CMD_SERVER_BROAD_USERLOGOUT   		= 0x2004; 
	
	public static final int CMD_SERVER_USERREADY   				= 0x2005;//用户准备
	public static final int CMD_SERVER_BROAD_USERREADY   		= 0x2006; 
	
	public static final int CMD_SERVER_BROAD_USEROFFLINE  		= 0x2007;//用户掉线
}