package com.leolee.metadataplatform.service;

import com.leolee.metadataplatform.model.UDObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by panxiaobai on 19/08/2017.
 */
@Component
public class UDObjectService {
    public List<UDObject> findAll(){
        List<UDObject> items = new ArrayList<UDObject>();

        items.add(getFakeUDObject());

        return items;
    }

    public UDObject findById(String id) {
        UDObject udObject = getFakeUDObject();
        udObject.setId(id);
        return udObject;
    }

    private UDObject getFakeUDObject(){
        UDObject udObject = new UDObject();
        udObject.setName("Customer");
        udObject.setId(UUID.randomUUID().toString());
        udObject.setCreateTime(new Date().getTime());
        udObject.setUpdateTime(new Date().getTime());
        return udObject;
    }

    public boolean deleteById(String id) {
        return false;
    }
}
