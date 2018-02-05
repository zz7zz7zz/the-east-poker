package com.poker.games.impl.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.poker.games.impl.User;

public class TexasDefine {
	
	public static final byte[] POKER_ARRAY={
		
			0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x0a,0x0b,0x0c,0x0d,0x0e,   //黑桃 2 - A spades
		
			0x12,0x13,0x14,0x15,0x16,0x17,0x18,0x19,0x1a,0x1b,0x1c,0x1d,0x1e,	//红花 2 - A hearts
			
		    0x22,0x23,0x24,0x25,0x26,0x27,0x28,0x29,0x2a,0x2b,0x2c,0x2d,0x2e,	//梅桃 2 - A clubs 
		    
		    0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x39,0x3a,0x3b,0x3c,0x3d,0x3e,	//方块 2 - A diamonds
		    
	};
	
	public static enum GameStep{
		START(1),
		PREFLOP(2),
		FLOP(3),
		TRUN(4),
		RIVER(5),
		SHOWHAND(6),
		STOP(7);
		
		int code;
        private GameStep(int code) {
            this.code = code;
        }
	}
	
	
	public static enum UserStatus{
		PLAY(1),
		NOT_PLAY_SITDOWN(2),
		NOT_PLAY_ONLOOKERS(3),
		NOT_PLAY_WAIT(4);
		
		int code;
        private UserStatus(int code) {
            this.code = code;
        }
	}
	
	public static enum TCard{
		NO(0),  //无
		HIGHT(1),  //高牌
		ONE_PAIR(2),//对子
		TWO_PAIR(3),//两对
		SET(4),		//三条
		STRAIGHT(5),//顺子
		FLUSH(6),//同花
		FULL_HOUSE(7),//葫芦
		FOUR(8),//金刚
		STRAIGHT_FLUSH(9),//同花顺
		ROYAL_STRAIGHT_FLUSH(10);//皇家同花顺
		
		int code;
		TCard(int code){
			this.code = code;
		}
	}
	
	public static class Result{
		public TCard cardType;//牌的类型
		public byte[] finalCards=new byte[5];//最好的牌型	
		public int    value;//牌型的值，用于比较牌的大小
		public void clear(){
			cardType = TCard.NO;
			Arrays.fill(finalCards, (byte)0);
			value = 0;
		}
	}
	
	public static class Pot{
		public String name;//Pot名字
		public long pot_chips;//Pot下注额
		public ArrayList<Byte> seatIds = new ArrayList<>();
		
//		byte seatIds;//哪些座位上的人参与分成，按位运算
	}
	
	public static class PotComparator implements Comparator<User>  
	{  
		@Override
		public int compare(User o1, User o2) {
			if(o1.round_chip == o2.round_chip){
				//按剩余金币再比较一下
				if(o1.chip == o2.chip){
					return 0;
				}else if(o1.chip > o2.chip){
					return 1;
				}else{
					return -1;
				}
			}else if(o1.round_chip > o2.round_chip){
				return 1;
			}else{
				return -1;
			}
		}  
	} 
	
	public static class Pair{
		
		public byte color_value;
		public ArrayList<Byte> cards;
		
		public Pair(byte color_value, ArrayList<Byte> cards) {
			super();
			this.color_value = color_value;
			this.cards = cards;
		}
	}
	
	public static class PairComparator implements Comparator<Pair>{
		
		@Override
		public int compare(Pair o1, Pair o2) {
			int ret =  o2.cards.size() - o1.cards.size();
			if(ret == 0){
				return o2.color_value - o1.color_value;
			}
			return ret;
		} 
	}
}