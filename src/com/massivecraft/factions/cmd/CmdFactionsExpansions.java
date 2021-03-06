package com.massivecraft.factions.cmd;

import java.util.Map.Entry;

import com.massivecraft.factions.event.EventFactionsExpansions;
import com.massivecraft.factions.Perm;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.util.Txt;

public class CmdFactionsExpansions extends FactionsCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsExpansions()
	{
		// Aliases
		this.addAliases("e", "expansions");

		// Requirements
		this.addRequirements(ReqHasPerm.get(Perm.EXPANSIONS.node));
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		// Event
		EventFactionsExpansions event = new EventFactionsExpansions(sender);
		event.run();
		
		// Title
		msg(Txt.titleize("Factions Expansions"));
		
		// Lines
		for (Entry<String, Boolean> entry : event.getExpansions().entrySet())
		{
			String name = entry.getKey();
			Boolean installed = entry.getValue();
			String format = (installed ? "<g>[X] <h>%s" : "<b>[ ] <h>%s");
			msg(format, name);
		}
		
		// URL Suggestion
		msg("<i>Learn all about expansions in the online documentation:");
		msg("<aqua>http://www.massivecraft.com/factions");
	}
	
}
