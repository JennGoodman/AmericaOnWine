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
@RequestMapping(value="/country", headers="Accept=application/json, text/plain")
public class CountryController {
	@Autowired
	private WineFormHibernate wfs;

	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String getCountries(ObjectMapper om) throws JsonProcessingException {
		return om.writeValueAsString(wfs.getCountries());
	}
	
}
