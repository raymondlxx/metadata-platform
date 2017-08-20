package com.leolee.metadataplatform.dao;

import com.leolee.metadataplatform.model.UDObject;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by panxiaobai on 20/08/2017.
 */
@Service
public interface UDObjectRepository extends BaseRepository<UDObject, String>{


    @Async
    List<UDObject> findByName(String name);
}
