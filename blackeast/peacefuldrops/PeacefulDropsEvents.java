package com.blackeast.peacefuldrops;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PeacefulDropsEvents {
	
	@SubscribeEvent
	public void peacefulMobsDrop(LivingDropsEvent e) {
		System.out.println("YOLO");//Drop bones
		
		EntityLivingBase mob = e.entityLiving;
		
		int num = MathHelper.getRandomIntegerInRange(new Random(), 0, 3);
		
		ItemStack bone = new ItemStack(Items.bone, num);

		mob.worldObj.spawnEntityInWorld(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, bone.copy()));
	}

}
