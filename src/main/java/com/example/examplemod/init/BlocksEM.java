package com.example.examplemod.init;

import com.example.examplemod.common.content.blocks.*;
import com.zeitheron.hammercore.annotations.*;
import org.zeith.terraria.api.items.IRareItem;
import org.zeith.terraria.api.npc.Economy;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;
import org.zeith.terraria.common.content.blocks.simple.BlockBar;

@SimplyRegister
public class BlocksEM
{
	@RegistryName("example_block")
	public static final ExampleBlock EXAMPLE_BLOCK = new ExampleBlock();

	@RegistryName("bricks/example")
	public static final ExampleBrick EXAMPLE_BRICK = new ExampleBrick();

	@RegistryName("bars/example")
	public static final BlockBaseTC EXAMPLE_BAR = new BlockBar("example", IRareItem.ItemRarity.BLUE)
			.sell(Economy.SILVER_VALUE)
			.inTab(ItemTabsEM.ITEMS_TAB, ItemTabsEM.BLOCKS_TAB);
}