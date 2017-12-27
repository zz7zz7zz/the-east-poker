package com.poker.monitor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.protobuf.InvalidProtocolBufferException;
import com.open.net.server.GServer;
import com.open.net.server.impl.udp.nio.UdpNioClient;
import com.open.net.server.impl.udp.nio.UdpNioServer;
import com.open.net.server.structures.AbstractClient;
import com.open.net.server.structures.AbstractMessageProcessor;
import com.open.net.server.structures.ServerConfig;
import com.open.net.server.structures.ServerLog;
import com.open.net.server.structures.ServerLog.LogListener;
import com.open.net.server.structures.message.Message;
import com.open.net.server.utils.TextUtils;
import com.open.util.log.Logger;
import com.poker.data.DataPacket;
import com.poker.protocols.server.ServerInfoProto;
import com.poker.protocols.server.ServerInfoProto.ServerInfo;;
/**
 * author       :   long
 * created on   :   2017/11/30
 * description  :  服务器入口
 */

public class Main {

    public static void main(String [] args){

    	//1.配置初始化
        ServerConfig mServerInfo = new ServerConfig();
        mServerInfo.initArgsConfig(args);
        mServerInfo.initFileConfig("./conf/lib.server.config");
        
        //2.数据初始化
        GServer.init(mServerInfo, UdpNioClient.class);
        
        //3.日志初始化
        Logger.init("./conf/lib.log.config",mServerInfo.id);
        Logger.addFilterTraceElement(ServerLog.class.getName());
        Logger.addFilterTraceElement(mLogListener.getClass().getName());
        Logger.v("-------Server------"+ mServerInfo.toString());
        
        //4.连接初始化
        Logger.v("-------Server------start---------");
        try {
            UdpNioServer mBioServer = new UdpNioServer(mServerInfo,mMessageProcessor,mLogListener);
            mBioServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.v("-------Server------end---------");
    }

    //-------------------------------------------------------------------------------------------
    public static HashMap<Integer, ArrayList<ServerInfoProto.ServerInfo>> serverOnlineList = new HashMap<Integer, ArrayList<ServerInfoProto.ServerInfo>>();
    
    public static AbstractMessageProcessor mMessageProcessor = new AbstractMessageProcessor() {

    	private ByteBuffer mWriteBuffer  = ByteBuffer.allocate(16*1024);
        private long oldTime = System.currentTimeMillis();
        private long nowTime  = oldTime;
        
        protected void onReceiveMessage(AbstractClient client, Message msg){
        	try {
        		Logger.v("onReceiveMessage 0x" + Integer.toHexString(DataPacket.Header.getCmd(msg.data, msg.offset)));
        		
        		ServerInfo enterServer = ServerInfo.parseFrom(msg.data,DataPacket.Header.HEADER_LENGTH+msg.offset,msg.length-DataPacket.Header.HEADER_LENGTH);
        		ArrayList<ServerInfo> serverArray = serverOnlineList.get(enterServer.getType());
        		if(null == serverArray){
        			serverArray = new ArrayList<ServerInfo>(10);
        			serverOnlineList.put(enterServer.getType(), serverArray);
        		}else{
            		for(ServerInfo obj:serverArray){
            			if(obj.getId() == enterServer.getId()){
            				serverArray.remove(obj);
            				break;
            			}
            		}
        		}
        		serverArray.add(enterServer);

        		//打印所有的服务
        		Iterator<Entry<Integer, ArrayList<ServerInfo>>> iter = serverOnlineList.entrySet().iterator();
        		while (iter.hasNext()) {
    				Entry<Integer, ArrayList<ServerInfo>> entry = iter.next();
    				Integer key = entry.getKey();
    				ArrayList<ServerInfo> val = entry.getValue();
    				
    				Logger.v(System.getProperty("line.separator"));
    		        Logger.v("------- "+key+" size " + val.size() + " -------");
    		        for(ServerInfo ser:val){
    		        	Logger.v(String.format("------- name %s id %d host %s port %d ", ser.getName(),ser.getId(),!TextUtils.isEmpty(ser.getHost())? ser.getHost() : "null",ser.getPort()));
    		        }
    		        
        		}
        		
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
			}
//            Logger.v("onReceiveMessage()  "+new String(msg.data,msg.offset,msg.length));
//            String data ="MainUdpBioServer--onReceiveMessage()--src_reuse_type "+msg.src_reuse_type
//                    + " dst_reuse_type " + msg.dst_reuse_type
//                    + " block_index " +msg.block_index
//                    + " offset " +msg.offset;
//            Logger.v("--onReceiveMessage()--reply "+data);
//            
//            byte[] response = data.getBytes();
//
//
//            mWriteBuffer.clear();
//            mWriteBuffer.put(response,0,response.length);
//            mWriteBuffer.flip();
////        unicast(client,mWriteBuffer.array(),0,response.length);
//            broadcast(mWriteBuffer.array(),0,response.length);
//            mWriteBuffer.clear();
        }

		@Override
		public void onTimeTick() {
			nowTime = System.currentTimeMillis();
			if(nowTime - oldTime > 1000){
				oldTime = nowTime;
				
			}
		}

		@Override
		public void onClientEnter(AbstractClient client) {
			Logger.v("onClientEnter " + client.mClientId);
		}

		@Override
		public void onClientExit(AbstractClient client) {
			Logger.v("onClientExit " + client.mClientId);
		}
    };

    public static LogListener mLogListener = new LogListener(){

		@Override
		public void onLog(String tag, String msg) {
			Logger.v(msg);
		}
    };
}
