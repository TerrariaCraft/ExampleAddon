package com.example.examplemod.init.items;

import com.example.examplemod.common.content.items.ExampleItem;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;

@SimplyRegister(prefix = "materials/")
public interface MaterialsEM
{
	@RegistryName("example")
	ExampleItem EXAMPLE_ITEM = new ExampleItem();
}
