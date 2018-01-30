package com.poker.cmd;

import com.poker.base.ServerIds;

public class UserCmd {

	public static int CMD_LOGIN_GAME 				= (ServerIds.SERVER_USER <<16) + 0x1001;//0x50001登录游戏
	
	public static int CMD_ENTER_ROOM 				= (ServerIds.SERVER_USER <<16) + 0x1002;//0x50003进入房间
	public static int CMD_LEAVE_ROOM 				= (ServerIds.SERVER_USER <<16) + 0x1003;//0x50004退出房间

}
