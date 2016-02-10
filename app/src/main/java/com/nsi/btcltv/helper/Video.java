package com.nsi.btcltv.helper;

/**
 * Created by user on 18-08-15.
 */
public class Video
{
    private String tilte;
    private String duration;
    private String size;
    private String category;
    private String description;
    private String imageUrl;
    private String vdoUrl;

    public Video() {
    }

    public void setTitle(String _title)
    {
        this.tilte = _title;
    }

    public String getTitle()
    {
        return 	this.tilte;
    }

    public void setDuration(String _duration)
    {
        this.duration = _duration;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public void setSize(String _size)
    {
        this.size = _size;
    }

    public String getSize()
    {
        return this.size;
    }

    public void setCategory(String _category)
    {
        this.category = _category;
    }

    public String getCategory()
    {
        return this.category;
    }

    public void setDescription(String _description)
    {
        this.description = _description;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setImageUrl(String _imageUrl)
    {
        this.imageUrl = _imageUrl;
    }

    public String getImageUrl()
    {
        return this.imageUrl;
    }

    public void setVdoUrl(String vdoUrl){ this.vdoUrl = vdoUrl; }
    public String getVdoUrl(){ return this.vdoUrl; }
}
