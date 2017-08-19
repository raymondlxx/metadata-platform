package com.leolee.metadataplatform.common.mapper;

import com.leolee.metadataplatform.model.UDObject;
import com.leolee.metadataplatform.model.UDObjectDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panxiaobai on 19/08/2017.
 */
public class UDObjectMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static UDObject toUDObject(UDObjectDTO udObjectDTO){
       return modelMapper.map(udObjectDTO, UDObject.class);
    }

    public static UDObjectDTO toUDObjectDTO(UDObject udObject){
        return modelMapper.map(udObject, UDObjectDTO.class);
    }
    public static List<UDObject> toUDObjects(List<UDObjectDTO> udObjectDTOs){
        List<UDObject> result = new ArrayList<>();


        return modelMapper.map(udObjectDTOs, result.getClass());
    }

    public static List<UDObjectDTO> toUDObjectDTOs(List<UDObject> udObjects){
        List<UDObjectDTO> result = new ArrayList<>();

        return modelMapper.map(udObjects, result.getClass());
    }

}
