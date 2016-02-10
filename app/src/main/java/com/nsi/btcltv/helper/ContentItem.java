package com.nsi.btcltv.helper;

public class ContentItem {

	private String vdoTitle;
	private String timeDuration;
	private String vdoSize;
	private String vdoDescription;

	
	public ContentItem(String _vdoTitle,String _timeDuration,String _vdoSize,String _vdoDescription) 
	{
		this.vdoTitle = _vdoTitle;
		this.timeDuration = _timeDuration;
		this.vdoSize = _vdoSize;
		this.vdoDescription = _vdoDescription;
	}
	
	public void setVdoTitle(String _vdoTitle)
	{
		this.vdoTitle = _vdoTitle;		
	}
	
	public String getVdoTitle()
	{
		return this.vdoTitle;	
	}

	public void setTimeDuration(String _timeDuration)
	{
		this.timeDuration = _timeDuration;
	}
	
	public String getTimeDuration()
	{
		return this.timeDuration;		
	}
	
	public void setVdoSize(String _vdoSize)
	{
		this.vdoSize = _vdoSize;
	}
	
	public String getVdoSize()
	{
		return this.vdoSize;
	}
	
	
	public void setVdoDescription(String _vdoDescription)
	{
		this.vdoDescription = _vdoDescription;
	}
	
	public String getVdoDescription()
	{
		return this.vdoDescription;
	}
	
}
