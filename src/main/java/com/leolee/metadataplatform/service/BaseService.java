package com.leolee.metadataplatform.service;

import com.leolee.metadataplatform.exception.BusinessCheckFailedException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by panxiaobai on 20/08/2017.
 */
@Slf4j
public class BaseService {

    protected void setFailMessage(String code,String message) throws BusinessCheckFailedException {

        throw new BusinessCheckFailedException(message);
    }
}
