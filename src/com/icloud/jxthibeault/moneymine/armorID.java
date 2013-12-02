/*
 * Copyright 2013 Joshua Thibeault. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

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