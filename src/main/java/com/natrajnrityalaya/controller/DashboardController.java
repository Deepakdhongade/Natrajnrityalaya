package com.natrajnrityalaya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.natrajnrityalaya.model.Admission;
import com.natrajnrityalaya.repository.AdmissionRepository;

@Controller
@RequestMapping(value = "pages")
public class DashboardController {
	@Autowired
	AdmissionRepository admissionRepository;
	
	@GetMapping(value = "students")
	public ModelMap mmStudents(Model model, @RequestParam(defaultValue = "0") int page) {
		int pageSize = 5; // Set your desired page size here
	    Page<Admission> admissionPage = admissionRepository.findAll(PageRequest.of(page, pageSize));
	    model.addAttribute("admissions", admissionPage);
        return new ModelMap();
    }
	
	@GetMapping(value = "dashboard")
	public ModelMap mmDashboard() {
        return new ModelMap();
    }
	
	
	@GetMapping(value = "admission-form")
	public ModelMap mmAdmissionForm(Model model) {
		model.addAttribute("admission", new Admission());
        return new ModelMap();
    }
	
	@PostMapping(value = "save-admission")
	public String mmSaveAdmissionForm(@ModelAttribute("admission") Admission admission, RedirectAttributes redirectAttributes) {
		admissionRepository.save(admission);
		redirectAttributes.addFlashAttribute("successMessage", "Form submitted successfully!");
        return "redirect:/pages/admission-form";
		
    }
}
