package com.example.examplemod.common.content.items;

import com.example.examplemod.init.ItemTabsEM;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.api.npc.Economy;
import org.zeith.terraria.api.tooltip.I18nTooltipElement;
import org.zeith.terraria.api.tooltip.TooltipLine;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.init.items.ItemsTC;

public class ExampleItem
		extends ItemBaseTC
{
	public ExampleItem(String name)
	{
		setTranslationKey(name);
		this.rarity = ItemRarity.BLUE;
		this.maxStackSize = 99;
		this.hasTooltip = true;
		this.sellValue = Economy.COPPER_VALUE * 70;
		inTab(ItemTabsEM.ITEMS_TAB);
	}

	@Override
	public void addRecipes(Craftery c)
	{
		super.addRecipes(c);

		c.addCraftingRecipe(stack(), ItemsTC.GEL.stack(5));
	}
}