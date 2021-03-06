package com.poker.games.impl.config;

import java.util.Arrays;
import java.util.HashMap;

import com.open.util.log.util.CfgParser;


public class GameConfig {

	public int game_id;
	public int level;
	public String level_name;
	
    //桌子信息
    public int table_count = 0;                   //一个房间中对桌子数量

    public int table_min_user = 0;                //每台桌子对最少玩家数量，达到这个数量即可开始游戏
    public int table_max_user = 0;                //每台桌子对最大玩家数量
    public long table_min_chip = 0;             //最小进入筹码
    public long table_max_chip = 0;             //最大进入筹码
    public long table_init_chip = 0;             //初始化筹码
    public long[] table_ante;                  	//前注;数组意味着比赛场，如SNG
    public long[] table_blind ;                 //大盲注;数组意味着比赛场，如SNG
    public int[] table_blind_time ;             //每个盲注持续时间;数组意味着比赛场，如SNG

    public int timeout_preflop = 0;       
    public int timeout_flop = 0;        
    public int timeout_turn = 0;        
    public int timeout_river = 0;        
    public int timeout_showhand = 0;      
    public int timeout_user_action = 0;        
    public int timeout_next_user_action = 0;       
    public int timeout_pot = 0;       
    public int timeout_clearing = 0;       
    public int timeout_new_game = 0;       
    
    //解析文件配置参数
    public final void initFileConfig(String config_path) {
        HashMap<String,Object> map = CfgParser.parseToMap(config_path);
        initFileConfig(map);
    }
    
    //-------------------------------------------------------------------------------------------
    protected void initFileConfig(HashMap<String,Object> map){
    	if(null !=map){
    		
    		game_id = CfgParser.getInt(map, "Game","id");
    		level = CfgParser.getInt(map, "Game","level");
    		level_name = CfgParser.getString(map, "Game","level_name");
    		
    		table_count = CfgParser.getInt(map, "Game","table_count");
    		table_min_user = CfgParser.getInt(map, "Game","table_min_user");
    		table_max_user = CfgParser.getInt(map, "Game","table_max_user");
    		table_min_chip = CfgParser.getLong(map, "Game","table_min_chip");
    		table_max_chip = CfgParser.getLong(map, "Game","table_max_chip");
    		table_init_chip = CfgParser.getLong(map, "Game","table_init_chip");
    		
	        String val[]     = CfgParser.getStringArray(map,"Game","table_blind");
	        if(null != val){
	        		table_blind = new long[val.length];
	            for (int i = 0; i < val.length; i++) {
	            		table_blind[i] = Long.valueOf(val[i]);
	            }
	        }
	            
	        val    = CfgParser.getStringArray(map,"Game","table_blind_time");
	        if(null != val){
	        		table_blind_time = new int[val.length];
	            for (int i = 0; i < val.length; i++) {
	            		table_blind_time[i] = Integer.valueOf(val[i]);
	            }
	        }
	        
	        val    = CfgParser.getStringArray(map,"Game","table_ante");
	        if(null != val){
	        	table_ante = new long[val.length];
	            for (int i = 0; i < val.length; i++) {
	            	table_ante[i] = Integer.valueOf(val[i]);
	            }
	        }
        
	        timeout_preflop = CfgParser.getInt(map, "Game","timeout_preflop");
	        timeout_flop = CfgParser.getInt(map, "Game","timeout_flop");
	        timeout_turn = CfgParser.getInt(map, "Game","timeout_turn");
	        timeout_river = CfgParser.getInt(map, "Game","timeout_river");
	        timeout_showhand = CfgParser.getInt(map, "Game","timeout_showhand");
	        timeout_user_action = CfgParser.getInt(map, "Game","timeout_user_action");
	        timeout_next_user_action = CfgParser.getInt(map, "Game","timeout_next_user_action");
	        timeout_pot = CfgParser.getInt(map, "Game","timeout_pot");
	        timeout_clearing = CfgParser.getInt(map, "Game","timeout_clearing");
	        timeout_new_game = CfgParser.getInt(map, "Game","timeout_new_game");
       }
    }

	@Override
	public String toString() {
		return "GameConfig [game_id=" + game_id + ", level=" + level + ", level_name=" + level_name + ", table_count="
				+ table_count + ", table_min_user=" + table_min_user + ", table_max_user=" + table_max_user
				+ ", table_min_chip=" + table_min_chip + ", table_max_chip=" + table_max_chip + ", table_init_chip="
				+ table_init_chip + ", table_ante=" + Arrays.toString(table_ante) + ", table_blind="
				+ Arrays.toString(table_blind) + ", table_blind_time=" + Arrays.toString(table_blind_time)
				+ ", timeout_preflop=" + timeout_preflop + ", timeout_flop=" + timeout_flop + ", timeout_turn="
				+ timeout_turn + ", timeout_river=" + timeout_river + ", timeout_showhand=" + timeout_showhand
				+ ", timeout_user_action=" + timeout_user_action + ", timeout_next_user_action="
				+ timeout_next_user_action + ", timeout_pot=" + timeout_pot + ", timeout_clearing=" + timeout_clearing
				+ ", timeout_new_game=" + timeout_new_game + "]";
	}
}
