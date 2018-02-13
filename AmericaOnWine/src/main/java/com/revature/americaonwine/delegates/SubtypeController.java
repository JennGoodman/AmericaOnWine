package com.revature.americaonwine.delegates;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.SubType;
import com.revature.americaonwine.services.WineFormHibernate;
import com.revature.americaonwine.services.WineFormService;

@Controller
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping(value="/subtype")
public class SubtypeController {
	private WineFormService wfs = new WineFormHibernate();
	private ObjectMapper om = new ObjectMapper();

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getSubTypes() throws JsonProcessingException {
		return om.writeValueAsString(wfs.getSubtypes());
	}
	
}
