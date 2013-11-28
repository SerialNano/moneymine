package com.icloud.jxthibeault.moneymine;

public class armorID{
	public static int helmet(String armour){
		int armour_id = 0;
		
		armour = armour.toUpperCase();
		
		if(armour == "LEATHER"){armour_id = 298;}
		if(armour == "CHAIN"){armour_id = 302;}
		if(armour == "CHAINMAIL"){armour_id = 302;}
		if(armour == "IRON"){armour_id = 306;}
		if(armour == "GOLD"){armour_id = 314;}
		if(armour == "DIAMOND"){armour_id = 310;}
		
		return armour_id;
	}
	
	public static int chestplate(String armour){
		int armour_id = 0;
		
		armour = armour.toUpperCase();
		
		if(armour == "LEATHER"){armour_id = 299;}
		if(armour == "CHAIN"){armour_id = 303;}
		if(armour == "CHAINMAIL"){armour_id = 303;}
		if(armour == "IRON"){armour_id = 307;}
		if(armour == "GOLD"){armour_id = 315;}
		if(armour == "DIAMOND"){armour_id = 311;}
		
		return armour_id;
	}
	
	public static int leggings(String armour){
		int armour_id = 0;
		
		armour = armour.toUpperCase();
		
		if(armour == "LEATHER"){armour_id = 300;}
		if(armour == "CHAIN"){armour_id = 304;}
		if(armour == "CHAINMAIL"){armour_id = 304;}
		if(armour == "IRON"){armour_id = 308;}
		if(armour == "GOLD"){armour_id = 316;}
		if(armour == "DIAMOND"){armour_id = 312;}
		
		return armour_id;
	}
	
	public static int boots(String armour){
		int armour_id = 0;
		
		armour = armour.toUpperCase();
		
		if(armour == "LEATHER"){armour_id = 301;}
		if(armour == "CHAIN"){armour_id = 305;}
		if(armour == "CHAINMAIL"){armour_id = 305;}
		if(armour == "IRON"){armour_id = 309;}
		if(armour == "GOLD"){armour_id = 317;}
		if(armour == "DIAMOND"){armour_id = 313;}
		
		return armour_id;
	}
}