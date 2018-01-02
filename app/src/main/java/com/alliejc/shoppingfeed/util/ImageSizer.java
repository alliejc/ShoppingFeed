package com.alliejc.shoppingfeed.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


// changed base url from https://cdn.fs.grailed.com/
public class ImageSizer {

    private static final String IMAGE_BASE_URL =
            "https://process.fs.grailed.com/AJdAgnqCST4iPtnUxiGtTz/rotate=deg:exif/rotate=deg:0/resize=width:%s,fit:crop/output=format:jpg,compress:true,quality:95/%s";

    public static String resizeImage(String url){
        int width = 100;
        String newUrl = String.format(IMAGE_BASE_URL, width, url);

        Log.e("url", newUrl);
        return newUrl;
    }
        }
