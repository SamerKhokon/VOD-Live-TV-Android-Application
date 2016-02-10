package com.nsi.btcltv.helper;

public class TvHelper {

	static String baseUri = "http://nextstepbpo.com/restApi/";
	
	
	public TvHelper() {
		
	}

	public static String baseUrl()
	{		
		return baseUri+"getContents/ALL/0/10/";
	}
	
	
	public static String baseImageUrl()
	{
		//return "http://nextstepbpo.com/file/tv_images/";
		return "http://cream-netca.com/spa/stream/img/";
	}
	
	//http://nextstepbpo.com/restApi/getContents/ALL/0/10/
	//http://nextstepbpo.com/restApi/getEGPData($date)
	//http://nextstepbpo.com/restApi/getEPGLastThreeDays()
	//http://nextstepbpo.com/restApi/getEPGCurrentDay()
	
	
	
	
	
}
