package com.poker.user.handler;


import com.google.protobuf.InvalidProtocolBufferException;
import com.open.net.base.util.ExceptionUtil;
import com.open.net.client.object.AbstractClient;

import com.open.util.log.Logger;
import com.poker.access.object.User;
import com.poker.access.object.UserPool;
import com.poker.base.cmd.CmdAllocator;
import com.poker.base.cmd.Cmd;
import com.poker.base.cmd.CmdGame;
import com.poker.base.cmd.CmdUser;
import com.poker.base.packet.BasePacket;
import com.poker.base.packet.InPacket;
import com.poker.base.packet.OutPacket;
import com.poker.base.packet.PacketInfo;
import com.poker.base.packet.PacketTransfer;
import com.poker.base.type.TDistapch;
import com.poker.protocols.game.client.RequestLoginGameProto.RequestLoginGame;
import com.poker.protocols.server.DispatchPacketProto.DispatchPacket;
import com.poker.user.Main;

public class ClientHandler extends AbsClientHandler{


	public ClientHandler(InPacket mInPacket, OutPacket mOutPacket) {
		super(mInPacket, mOutPacket);
	}
	
	@Override
	public void dispatchMessage(AbstractClient client, byte[] data, int header_start, int header_length, int body_start,
			int body_length) {
		
		try {
    		int cmd   = BasePacket.getCmd(data, header_start);
    		Logger.v("input_packet cmd 0x" + Integer.toHexString(cmd) + " name " + Cmd.getCmdString(cmd) + " length " + BasePacket.getLength(data,header_start));
    		
    		int squenceId = BasePacket.getSequenceId(data, header_start);
    		if(cmd == CmdUser.CMD_CHECK_GAME_STATUS){
        		checkGameStatus(squenceId,data, header_start,header_length,body_start, body_length);
        	}else if(cmd == CmdUser.CMD_LOGIN_GAME){
        		loginGame(squenceId,data, header_start,header_length,body_start, body_length);
        	}else if(cmd == CmdUser.CMD_ENTER_ROOM){
        		enterRoom(squenceId,data, header_start,header_length,body_start, body_length);
        	}else if(cmd == CmdUser.CMD_LEAVE_ROOM){
        		leaveRoom(squenceId,data, header_start,header_length,body_start, body_length);
        	}
    		
		} catch (Exception e) {
			e.printStackTrace();
			Logger.v(ExceptionUtil.getStackTraceString(e));
		}
	}
	
	public void checkGameStatus(int squenceId ,byte[] data, int header_start, int header_length, int body_start, int body_length) throws InvalidProtocolBufferException{
		DispatchPacket mDispatchPacket = DispatchPacket.parseFrom(data,body_start,body_length);
		long uid = mDispatchPacket.getDispatchChainList(0).getUid();
		mInPacket.copyFrom(mDispatchPacket.getData().toByteArray(), 0, mDispatchPacket.getData().size());
		int accessId  = mInPacket.readInt();
		
		User user = Main.userMap.get(uid);
		if(null != user){
			int tableId = user.tableId;
			short gameId = user.gameId;
			short gameSid = user.gameSid;
			short matchId = user.matchId;
			short matchSid = user.matchSid;
			
			//当InPacket不需要使用时，可以复用buff，防止过多的分配内存，产生内存碎片
			byte[] mTempBuff = mInPacket.getPacket();
			if(tableId >= 0){//说明在游戏中，需要重新进入游戏
				
				mOutPacket.begin(squenceId, CmdGame.CMD_CHECK_GAME_STATUS);
				mOutPacket.writeInt(accessId);//AccessId
				mOutPacket.end();
				
				int length = PacketTransfer.send2Game(gameId,gameSid, mTempBuff, squenceId, uid, CmdGame.CMD_CHECK_GAME_STATUS, TDistapch.TYPE_P2P, mOutPacket.getPacket(),0,  mOutPacket.getLength());
				send2Dispatch(mTempBuff,0,length);	
			}
			
			if(user.accessId != accessId){
				user.accessId = accessId;
				//需要断掉旧的连接，以新的连接为准
			}
		}
	}
	
	public void loginGame(int squenceId ,byte[] data, int header_start, int header_length, int body_start, int body_length) throws InvalidProtocolBufferException{
		
		DispatchPacket mDispatchPacket = DispatchPacket.parseFrom(data,body_start,body_length);
		long uid = mDispatchPacket.getDispatchChainList(0).getUid();
		
		mInPacket.copyFrom(mDispatchPacket.getData().toByteArray(), 0, mDispatchPacket.getData().size());
		int accessId = mInPacket.readInt();
		PacketInfo mSubPacket = mInPacket.readBytesToSubPacket();
		RequestLoginGame mRequestLoginGame = RequestLoginGame.parseFrom(mSubPacket.buff,mSubPacket.body_start, mSubPacket.body_length);
		
		int request_gameid = mRequestLoginGame.getGameid();
		int request_gamelevel = mRequestLoginGame.getLevel();
		
		int tableId = -1;
		short gameId = -1;
		short gameSid = -1;
		short matchId =-1;
		short matchSid = -1;
		User user = Main.userMap.get(uid);
		if(null != user){
			tableId = user.tableId;
			gameId = user.gameId;
			gameSid = user.gameSid;
			matchId = user.matchId;
			matchSid = user.matchSid;
			
			if(user.accessId != accessId){
				user.accessId = accessId;
				//需要告知对应的AccessServer 断掉旧的连接，以新的连接为准
			}
		}
		
		//当InPacket不需要使用时，可以复用buff，防止过多的分配内存，产生内存碎片
		byte[] mTempBuff = mInPacket.getPacket();
		if(tableId >= 0){//说明在游戏中，需要重新进入游戏
			
			mOutPacket.begin(squenceId, CmdGame.CMD_LOGIN_GAME);
			mOutPacket.writeInt(accessId);//AccessId
			mOutPacket.writeInt(tableId);//tableId
			mOutPacket.end();
			
			int length = PacketTransfer.send2Game(gameId,gameSid, mTempBuff, squenceId, uid, CmdGame.CMD_LOGIN_GAME, TDistapch.TYPE_P2P, mOutPacket.getPacket(),0,  mOutPacket.getLength());
			send2Dispatch(mTempBuff,0,length);	
		}else{//说明没有在游戏中，去Alloc中寻找桌子再进入游戏
			
			mOutPacket.begin(squenceId, CmdAllocator.CMD_LOGIN_GAME);
			mOutPacket.writeInt(accessId);//AccessId
			mOutPacket.writeBytes(mSubPacket.buff, mSubPacket.header_start, mSubPacket.header_length+mSubPacket.body_length);
			mOutPacket.end();
			
			int length = PacketTransfer.send2Alloc(request_gameid,mTempBuff, squenceId, uid,CmdAllocator.CMD_LOGIN_GAME,TDistapch.TYPE_P2P,mOutPacket.getPacket(),0,  mOutPacket.getLength());
	  		send2Dispatch(mTempBuff,0,length);	
		}
	}
	
	public void enterRoom(int squenceId ,byte[] data, int header_start, int header_length, int body_start, int body_length) throws InvalidProtocolBufferException{
		DispatchPacket mDispatchPacket = DispatchPacket.parseFrom(data,body_start,body_length);
		long uid = mDispatchPacket.getDispatchChainList(0).getUid();
		
		mInPacket.copyFrom(mDispatchPacket.getData().toByteArray(), 0, mDispatchPacket.getData().size());
		int tid = mInPacket.readInt();
		short gameId = mInPacket.readShort();
		short gameSid = mInPacket.readShort();
		
		User user = Main.userMap.get(uid);
		if(null == user){
			user = UserPool.get(uid);
			Main.userMap.put(uid, user);
		}
		
		user.tableId = tid;
		user.gameId = gameId;
		user.gameSid = gameSid;
	}
	
	public void leaveRoom(int squenceId ,byte[] data, int header_start, int header_length, int body_start, int body_length) throws InvalidProtocolBufferException{
		DispatchPacket mDispatchPacket = DispatchPacket.parseFrom(data,body_start,body_length);
		long uid = mDispatchPacket.getDispatchChainList(0).getUid();
		User user = Main.userMap.remove(uid);
		UserPool.release(user);
	}
}
