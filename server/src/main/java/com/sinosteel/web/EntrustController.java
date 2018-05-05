package com.sinosteel.web;

import com.sinosteel.framework.core.web.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LBW
 */
@RequestMapping(value = "/entrust")
@RestController
public class EntrustController extends BaseController
{
//    @Autowired
//    private EntrustService entrustService;

    @RequestMapping(method = RequestMethod.GET)
//    public Entrust queryEntrusts()
    public String queryEntrusts()
    {
//        Entrust entrust = entrustService.queryEntrusts();
//
//        return entrust;
        return "return current Entrusts";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEntrust(@RequestBody String entrust)
    {

        try {
//            entrustService.updateEntrusts(entrust);
            return ResponseEntity.<Void>ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.<Void>badRequest().build();
        }

    }
}
