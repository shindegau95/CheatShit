package com.pkg.android.cheatshit;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by GAURAV on 13-02-2017.
 */

public class ComputeAlgorithm {
    public static Set<String> compute(Context context, int choice, String movie, int noOfWords){
        InputStreamReader isr = null;
        if (choice == 1) {
            // Hollywood
            switch (noOfWords){
                case 1:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h1));
                    break;
                case 2:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h2));
                    break;
                case 3:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h3));
                    break;
                case 4:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h4));
                    break;
                case 5:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h5));
                    break;
                case 6:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h6));
                    break;
                case 7:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h7));
                    break;
                case 8:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h8));
                    break;
                case 9:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h9));
                    break;
                case 10:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h10));
                    break;
                case 11:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h11));
                    break;
                case 12:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h12));
                    break;
                case 13:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h13));
                    break;
                case 14:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h14));
                    break;
                case 15:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.h15));
                    break;
            }

        } else {
            // Bollywood
            switch (noOfWords){
                case 1:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b1));
                    break;
                case 2:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b2));
                    break;
                case 3:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b3));
                    break;
                case 4:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b4));
                    break;
                case 5:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b5));
                    break;
                case 6:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b6));
                    break;
                case 7:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b7));
                    break;
                case 8:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b8));
                    break;
                case 9:isr = new InputStreamReader(context.getResources().openRawResource(R.raw.b9));
                    break;
            }
        }
        BufferedReader br = new BufferedReader(isr);
        int words = noOfWords;
        String[] mWords = movie.split(" ");
        List<String> movieList = new ArrayList<String>();
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                movieList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> cache = new ArrayList<String>();
        for (String m : movieList) {
            String[] wordList = m.split(" ");
            boolean flag = true;
            for (int i=0;i<words;i++) {
                if (wordList[i].length() != mWords[i].length()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cache.add(m);
            }
        }
        char[] movieChar = movie.toCharArray();
        for (int i=0;i<movie.length();i++) {
            List<String> reducedCache = new ArrayList<String>();
            if (movieChar[i] != '.') {
                for (String cacheMovie : cache) {
                    if (cacheMovie.charAt(i) == movieChar[i]) {
                        reducedCache.add(cacheMovie);
                    }
                }
                cache = reducedCache;
            }
        }
        Set<String> toPrint = new HashSet<String>(cache);
        //System.out.println(Arrays.asList(toPrint).toString());
        return toPrint;
    }
}
