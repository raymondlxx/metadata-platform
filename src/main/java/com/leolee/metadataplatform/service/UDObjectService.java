package com.leolee.metadataplatform.service;

import com.leolee.metadataplatform.dao.UDObjectRepository;
import com.leolee.metadataplatform.exception.BusinessCheckFailedException;
import com.leolee.metadataplatform.model.UDObject;
import com.leolee.metadataplatform.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by panxiaobai on 19/08/2017.
 */
@Slf4j
@Component
public class UDObjectService extends BaseService {

    @Autowired
    private UDObjectRepository udObjectRepository;

    public List<UDObject> findAll() {
        Iterable<UDObject> items = udObjectRepository.findAll();
        return Lists.newArrayList(items);
    }

    public UDObject findById(String id) {

        Optional<UDObject> udObject = udObjectRepository.findOne(id);

        return udObject.get();
    }


    public void deleteById(String id) {

        Optional<UDObject> found = udObjectRepository.findOne(id);
        if(found.isPresent()){
            udObjectRepository.delete(found.get());
        }
    }

    public UDObject create(UDObject udObject) throws BusinessCheckFailedException {

        if (udObject.getName() == null || udObject.getName().equals("")) {
            setFailMessage("0", "name is required!");
            return null;
        }

        List<UDObject> foundItems = udObjectRepository.findByName(udObject.getName());

        if (foundItems != null && foundItems.size() > 0) {
            setFailMessage("0", "name exists");
            return null;
        }

        udObject.setId(StringUtils.getRandomId());
        udObject.setCreateTime(new Date().getTime());
        udObject.setUpdateTime(new Date().getTime());

        return udObjectRepository.save(udObject);
    }

    public UDObject update(UDObject udObject) throws BusinessCheckFailedException {
        Optional<UDObject> item = udObjectRepository.findOne(udObject.getId());
        if (!item.isPresent()) {
            setFailMessage("0", "record doesn't exists!");
            return null;
        }

        UDObject found = item.get();
        found.setName(udObject.getName());
        found.setUpdateTime(new Date().getTime());

        return udObjectRepository.save(found);

    }
}
