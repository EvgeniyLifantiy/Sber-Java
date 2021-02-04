package com.Serialization.Service;

import com.Serialization.Cache.Choose;

public interface Service {
    /*
    with @Choose annotation you can change cached parameter
    default @Choose on value
     */

    public int MemoryWork( String name,@Choose int value);
    public int FileWork(String name,@Choose int value);
    public int ZipWork( String name,@Choose int value);
}
