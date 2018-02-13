package com.revature.americaonwine.delegates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping(value="/inventory")
public class InventoryController {

}
