package com.leolee.metadataplatform.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by panxiaobai on 19/08/2017.
 */
@Data
@Entity
public class UDObject {
    @Id
    private String id;
    private String name;
    private long createTime;
    private long updateTime;

}
