package com.example.examplemod.init;

import com.example.examplemod.common.content.items.ExampleSword;
import com.example.examplemod.init.items.MaterialsEM;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;

@SimplyRegister
public interface ItemsEM
		extends MaterialsEM
{
	@RegistryName("swords/example")
	ExampleSword EXAMPLE_SWORD = new ExampleSword(14);
}