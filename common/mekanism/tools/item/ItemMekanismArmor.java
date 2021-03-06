package mekanism.tools.item;

import java.util.List;

import mekanism.common.Mekanism;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemMekanismArmor extends ItemArmor
{
	protected EnumArmorMaterial material;
	
    public ItemMekanismArmor(int id, EnumArmorMaterial enumarmormaterial, int renderIndex, int armorType)
    {
        super(id, enumarmormaterial, renderIndex, armorType);
        material = enumarmormaterial;
        setCreativeTab(Mekanism.tabMekanism);
    }
    
    @Override
	public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag)
	{
		list.add("HP: " + (itemstack.getMaxDamage() - itemstack.getItemDamage()));
	}
    
	@Override
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon("mekanism:" + getUnlocalizedName().replace("item.", ""));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
		return "mekanism:armor/" + material.name().toLowerCase() + "_" + layer + ".png";
    }
}
