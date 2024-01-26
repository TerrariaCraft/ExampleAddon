package com.example.examplemod.common.content.blocks;

import com.example.examplemod.init.BlocksEM;
import com.example.examplemod.init.ItemTabsEM;
import net.minecraft.block.material.Material;
import org.zeith.terraria.api.items.IRareItem;
import org.zeith.terraria.common.content.blocks.simple.BlockBricks;

public class ExampleBrick
		extends BlockBricks
		implements IRareItem
{
	public ExampleBrick()
	{
		super(Material.ROCK, "example");

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

		c.addCraftingRecipe(stack(), BlocksEM.EXAMPLE_BLOCK.stack(2));
	}
}