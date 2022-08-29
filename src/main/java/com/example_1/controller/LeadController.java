package com.example_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example_1.Entity.Lead;
import com.example_1.Services.LeadService;
import com.example_1.controller.dto.LeadData;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		return"create_lead";
	}
	
	@RequestMapping("/saveLead")
   public String saveOneLead(@ModelAttribute Lead lead,ModelMap modal) {
		leadService.saveLead(lead);
		modal.addAttribute("msg", "leads saved!!");
    	return"create_lead";
   }
	@RequestMapping("/alllist")
	public String litAllLeads(ModelMap modal) {
		List<Lead> leads = leadService.listLeads();
		modal.addAttribute("leads",leads );
		return"lead_search_result";
	}
	 
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,ModelMap modal) {
		leadService.deleteLeadById(id);
		System.out.println(id);
		List<Lead> leads = leadService.listLeads();
		modal.addAttribute("leads",leads );
		return"lead_search_result";
	}
	 
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id")long id,ModelMap modal) {
		Lead lead = leadService.getOneLead(id);
		modal.addAttribute("lead",lead );
		return"update_lead";
	}
	  
	@RequestMapping("/updateLead")
	public String updateOneLeadData(LeadData data,ModelMap modal) {
		Lead lead = new Lead();
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());
		
		leadService.saveLead(lead);
		List<Lead> leads = leadService.listLeads();
		modal.addAttribute("leads",leads );
		return"lead_search_result";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@RequestMapping("/saveLead")
   // public String saveOneLead( LeadData data,ModelMap modal) {
	//	Lead lead = new Lead();
	  //  lead.setFirstName(data.getFirstName());
	   // lead.setLastName(data.getLastName());
	  //  lead.setEmail(data.getEmail());
	   // lead.setMobile(data.getMobile());
	   // System.out.println(lead);
		//modal.addAttribute("msg", "leads saved!!");
    //	return"create_lead";
   // }
}
