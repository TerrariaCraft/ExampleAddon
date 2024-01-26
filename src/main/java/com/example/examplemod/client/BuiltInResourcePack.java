package com.example.examplemod.client;

import com.example.examplemod.ExampleAddon;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.*;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class BuiltInResourcePack
		implements IResourcePack
{
	@Override
	public InputStream getInputStream(ResourceLocation location)
			throws IOException
	{
		InputStream str = ExampleAddon.class.getResourceAsStream("/assets/" + location.getNamespace() + "/" + location.getPath());
		if(str == null)
			throw new FileNotFoundException(location.toString());
		return str;
	}
	
	@Override
	public boolean resourceExists(ResourceLocation location)
	{
		try(InputStream str = ExampleAddon.class.getResourceAsStream("/assets/" + location.getNamespace() + "/" + location.getPath()))
		{
			return str != null;
		} catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Set<String> getResourceDomains()
	{
		return Collections.singleton(ExampleAddon.MODID);
	}
	
	@Nullable
	@Override
	public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer metadataSerializer, String metadataSectionName)
			throws IOException
	{
		throw new FileNotFoundException();
	}
	
	@Override
	public BufferedImage getPackImage()
			throws IOException
	{
		throw new FileNotFoundException();
	}
	
	@Override
	public String getPackName()
	{
		return "Built in resources";
	}
}
