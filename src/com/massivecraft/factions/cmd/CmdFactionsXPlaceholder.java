package com.massivecraft.factions.cmd;

public class CmdFactionsXPlaceholder extends FactionsCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public String extensionName;
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsXPlaceholder(String extensionName, String... aliases)
	{
		// Fields
		this.extensionName = extensionName;
		
		// Aliases
		this.addAliases(aliases);
		
		// Desc
		this.setDesc("Use " + extensionName);
		
		// Args
		this.setGivingErrorOnTooManyArgs(false);
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		msg("<b>The extension <h>%s <b>isn't installed.", this.extensionName);
		msg("<g>Learn more and download the extension here:");
		msg("<aqua>http://www.massivecraft.com/%s", this.extensionName.toLowerCase());
	}
	
}
