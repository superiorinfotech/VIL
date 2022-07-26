package com.vil.searchapp.controllers;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vil.searchapp.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET )
    public String result(Model model, @RequestParam String serial) {
		
		List<Document> serialOwnerList = this.searchService.getResults(serial);
		if(serialOwnerList.isEmpty()) {
			 model.addAttribute("serialNo", "Not a Valid Serial No");	
		} else {
		model.addAttribute("assetOwner", serialOwnerList.get(0).getString("ASSET_OWNERSHIP"));
		model.addAttribute("city", serialOwnerList.get(0).getString("CITY"));
		model.addAttribute("userName", serialOwnerList.get(0).getString("USER_NAME"));
	    model.addAttribute("serialNo", serial);		
		}
	   return "home";
   }
}
