package com.example.examplemod.proxy;

import com.example.examplemod.ExampleAddon;
import com.example.examplemod.client.BuiltInResourcePack;
import com.zeitheron.hammercore.client.HammerCoreClient;

public class ClientProxy
		extends CommonProxy
{
	@Override
	public void construct()
	{
		super.construct();
		
		if(ExampleAddon.IN_DEV)
			// This is a workaround with FG3+.
			// Required, otherwise you won't see textures/models/sounds/etc load in dev correctly.
			HammerCoreClient.injectResourcePack(new BuiltInResourcePack());
	}
}