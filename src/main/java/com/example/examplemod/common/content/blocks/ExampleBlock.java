package com.example.examplemod.common.content.blocks;

import com.example.examplemod.init.ItemTabsEM;
import com.example.examplemod.init.ItemsEM;
import net.minecraft.block.material.Material;
import org.zeith.terraria.api.items.IRareItem;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;

public class ExampleBlock
		extends BlockBaseTC
		implements IRareItem
{
	public ExampleBlock()
	{
		super(Material.ROCK);

		setTranslationKey("example_block");

		inTab(ItemTabsEM.BLOCKS_TAB);
	}

	@Override
	public ItemRarity getRarity()
	{
		return ItemRarity.BLUE;
	}

	@Override
	public void addRecipes(Craftery c)
	{
		super.addRecipes(c);

		c.addCraftingRecipe(stack(), ItemsEM.EXAMPLE_ITEM.stack(2));
	}
}