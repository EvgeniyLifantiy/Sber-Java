package com.Serialization.Service;

import com.Serialization.Cache.Choose;

public interface Service {
    /*
    with @Choose annotation you can change cached parameter
    default @Choose on value
     */

     int MemoryWork( String name,@Choose int value);
     int FileWork(String name,@Choose int value);
     int ZipWork( String name,@Choose int value);
}
