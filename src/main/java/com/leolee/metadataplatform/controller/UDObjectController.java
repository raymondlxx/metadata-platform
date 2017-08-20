package com.leolee.metadataplatform.controller;

import com.leolee.metadataplatform.common.mapper.UDObjectMapper;
import com.leolee.metadataplatform.exception.BusinessCheckFailedException;
import com.leolee.metadataplatform.model.UDObject;
import com.leolee.metadataplatform.model.UDObjectDTO;
import com.leolee.metadataplatform.service.UDObjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by panxiaobai on 19/08/2017.
 */
@RestController()
public class UDObjectController extends BaseController {

    @Autowired
    private UDObjectService udObjectService;

    @RequestMapping(value = "api/udobject/{id}",method = RequestMethod.GET)
    public UDObjectDTO find(@PathVariable("id") String id) {

        UDObject udObject = udObjectService.findById(id);
        return UDObjectMapper.toUDObjectDTO(udObject);
    }

    @RequestMapping(value="api/udobjects", method = RequestMethod.GET)
    public List<UDObjectDTO> findAll() {
        List<UDObject> items = udObjectService.findAll();

        return UDObjectMapper.toUDObjectDTOs(items);
    }

    @RequestMapping(value = "api/udobject",method = RequestMethod.POST)
    public String create(@RequestBody UDObject udObject) throws BusinessCheckFailedException {

        UDObject result=  udObjectService.create(udObject);
        return result.getId();
    }

    @RequestMapping(value = "api/udobject",method = RequestMethod.PUT)
    public String update(@RequestBody UDObject udObject) {


        return "updated:"+udObject.toString();
    }


    @RequestMapping(value = "api/udobject/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {

        return "deleted:"+udObjectService.deleteById(id);

    }

}
