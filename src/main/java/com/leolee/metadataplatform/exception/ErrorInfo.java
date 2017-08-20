package com.leolee.metadataplatform.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by panxiaobai on 20/08/2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorInfo {
    private String url;
    private int code;
    private String type;
    private String message;

    public ErrorInfo() {}

    public ErrorInfo(String url, int code,
                     String type, String message) {
        this.url = url;
        this.code = code;
        this.type = type;
        this.message = message;
    }

}