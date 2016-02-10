package com.nsi.btcltv.helper;

public class Item
{
    private int slid;
    private String tilte;
    private String imageUrl;
    private String vdoUrl;


    public int getSlid() { return this.slid; }
    public void setSlid(int slid){ this.slid = slid; }

    public void setTitle(String _title)
    {
        this.tilte = _title;
    }
    public String getTitle(){    return 	this.tilte;    }

    public String getImageUrl(){ return this.imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void setVdoUrl(String vdoUrl){ this.vdoUrl = vdoUrl; }
    public String getVdoUrl(){ return this.vdoUrl; }
}
