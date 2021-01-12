package com.example.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryLruCache {
    private LruCache<String, Bitmap> lruCache;

    public MemoryLruCache() {

        int cacheSize = (int) (Runtime.getRuntime().maxMemory() / 8);
        lruCache = new LruCache<>(cacheSize);
    }

    public void add(String key, Bitmap value) {
        if (getBitmap(key) != null) {
            lruCache.put(key, value);
        }
    }

    public Bitmap getBitmap(String key) {
        return lruCache.get(key);
    }

    public void delete(String key) {
        lruCache.remove(key);
    }
}
