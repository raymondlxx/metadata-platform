package com.leolee.metadataplatform.service;

import com.leolee.metadataplatform.dao.UDObjectRepository;
import com.leolee.metadataplatform.exception.BusinessCheckFailedException;
import com.leolee.metadataplatform.model.UDObject;
import com.leolee.metadataplatform.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by panxiaobai on 19/08/2017.
 */
@Slf4j
@Component
public class UDObjectService extends BaseService {

    @Autowired
    private UDObjectRepository udObjectRepository;

    public List<UDObject> findAll(){
        List<UDObject> items = new ArrayList<UDObject>();

        items.add(getFakeUDObject());

        return items;
    }

    public UDObject findById(String id) {


        UDObject udObject =  udObjectRepository.findOne(id);

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

    public UDObject create(UDObject udObject) throws BusinessCheckFailedException {

        if(udObject.getName()==null||udObject.getName().equals("")){
            setFailMessage("0","name is required!");
            return null;
        }

        List<UDObject> foundItems = udObjectRepository.findByName(udObject.getName());

        if(foundItems!=null && foundItems.size()>0){
            setFailMessage("0","name exists");
            return null;
        }

        udObject.setId(StringUtils.getRandomId());
        udObject.setCreateTime(new Date().getTime());
        udObject.setUpdateTime(new Date().getTime());

        return udObjectRepository.save(udObject);
    }
}
