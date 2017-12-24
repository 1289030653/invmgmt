package org.sxd.invmgmt.web.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sxd.invmgmt.common.Result;
import org.sxd.invmgmt.dto.ex.ExDto;
import org.sxd.invmgmt.service.ex.ExService;

/**
 * Created by eddie on 2017/12/19.
 */
@RestController
@RequestMapping("/test")
public class ExController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExService exService;

    @RequestMapping(value = "/ex", method = RequestMethod.GET)
    public Result<Object> test(ExDto dto) {
        Result<Object> res = null;
        if (exService.addEx(dto) == 1) {
           res = new Result<Object>(true, "success");
        } else {
            res = new Result<Object>(false, "failed");
        }
        return res;
    }
}
