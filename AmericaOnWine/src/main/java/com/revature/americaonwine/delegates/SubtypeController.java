package com.revature.americaonwine.delegates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.services.WineFormHibernate;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(value="/subtype", headers="Accept=application/json, text/plain")
public class SubtypeController {
	
	@Autowired
	private WineFormHibernate wfs;
	@Autowired
	private ObjectMapper om;

	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String getSubTypes() throws JsonProcessingException {
		return om.writeValueAsString(wfs.getSubtypes());
	}
	
}
