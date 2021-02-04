package com.Serialization.Service;

import com.Serialization.Cache.Cache;
import com.Serialization.Cache.CacheType;
import com.Serialization.Cache.Choose;

public interface Service {
    /*
    with @Choose annotation you can change cached parameter
    default @Choose on value
     */

    @Cache(name = "First", cachetype = CacheType.MEMORY)
     int MemoryWork( String name,@Choose int value);

    @Cache(name = "Second", cachetype = CacheType.FILE)
     int FileWork(String name,@Choose int value);

    @Cache(name = "Third", cachetype = CacheType.FILE, isZip = true)
     int ZipWork( @Choose String name, int value);
}
