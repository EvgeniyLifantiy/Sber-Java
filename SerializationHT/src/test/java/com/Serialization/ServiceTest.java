package com.Serialization;

import com.Serialization.Service.Service;
import com.Serialization.Service.Servicelmp;
import org.testng.annotations.Test;

public class ServiceTest {
    @Test
    public void TestMemoryWork(){
        Service service=new Servicelmp();
        service.MemoryWork("12",2);

    }
}
