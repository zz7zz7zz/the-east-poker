package com.poker.login.handler;

import java.util.HashMap;

import com.google.protobuf.InvalidProtocolBufferException;
import com.open.net.client.object.AbstractClient;
import com.open.net.client.object.AbstractClientMessageProcessor;
import com.poker.cmd.LoginCmd;
import com.poker.data.DistapchType;
import com.poker.login.Main;
import com.poker.protocols.login.LoginRequestProto;
import com.poker.protocols.login.LoginServer;
import com.poker.protocols.server.DispatchPacketProto.DispatchPacket;


public class ClientMessageHandler {

	public static HashMap<String, Long> uidMap = new HashMap<>();
	public static int uid_auto_generator = 10000;
	
	public void login(AbstractClient mClient ,byte[] write_buff_dispatcher,byte[] write_buf, byte[] data, int body_start, int body_length, int squenceId,AbstractClientMessageProcessor sender) throws InvalidProtocolBufferException{
		
		DispatchPacket mDispatchPacket = DispatchPacket.parseFrom(data,body_start,body_length);
		mDispatchPacket.getData().copyTo(Main.write_buff, 0);
		
		LoginRequestProto.LoginRequest loginRequest = LoginRequestProto.LoginRequest.parseFrom(Main.write_buff,0,mDispatchPacket.getData().size());
		System.out.println("login "+loginRequest.toString());
		
		String uuid = loginRequest.getUuid();
		long uid = 0;
		Long uidObject = uidMap.get(uuid);
		if(null == uidObject){
			uid = uid_auto_generator;
			uidMap.put(uuid, uid);
			
			uid_auto_generator++;
		}else{
			uid = uidObject;
		}
		
		byte[] resp_data = LoginServer.login_response(write_buf, squenceId, (int)uid);
		int length = ImplDataTransfer.send2Access(write_buff_dispatcher, squenceId, uid, LoginCmd.CMD_LOGIN_RESPONSE, DistapchType.TYPE_P2P, resp_data, 0, resp_data.length);
		sender.send(mClient, write_buff_dispatcher, 0, length);
	}
}
