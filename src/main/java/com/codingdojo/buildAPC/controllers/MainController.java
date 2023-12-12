package com.codingdojo.buildAPC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.buildAPC.models.Build;
import com.codingdojo.buildAPC.models.CPU;
import com.codingdojo.buildAPC.models.CPUCooler;
import com.codingdojo.buildAPC.models.ComputerCase;
import com.codingdojo.buildAPC.models.GPU;
import com.codingdojo.buildAPC.models.Login;
import com.codingdojo.buildAPC.models.Motherboard;
import com.codingdojo.buildAPC.models.PSU;
import com.codingdojo.buildAPC.models.RAM;
import com.codingdojo.buildAPC.models.User;
import com.codingdojo.buildAPC.services.BuildService;
import com.codingdojo.buildAPC.services.CPUCoolerService;
import com.codingdojo.buildAPC.services.CPUService;
import com.codingdojo.buildAPC.services.ComputerCaseService;
import com.codingdojo.buildAPC.services.GPUService;
import com.codingdojo.buildAPC.services.MotherboardService;
import com.codingdojo.buildAPC.services.PSUService;
import com.codingdojo.buildAPC.services.RAMService;
import com.codingdojo.buildAPC.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private UserService users;
	
	@Autowired
	private BuildService builds;
	
	@Autowired
	private ComputerCaseService compCaseServ;
	
	@Autowired
	private CPUCoolerService coolServ;
	
	@Autowired
	private CPUService cpuServ;
	
	@Autowired
	private GPUService gpuServ;
	
	@Autowired
	private MotherboardService moboServ;
	
	@Autowired
	private PSUService psuServ;
	
	@Autowired
	private RAMService ramServ;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("newLogin", new Login());
		return "index.jsp";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("newUser", new User());
		return "register.jsp";
	}
	
	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute("newLogin") Login newLogin, BindingResult result, Model model, HttpSession session) {
		User user = users.login(newLogin,  result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId",  user.getId());
		model.addAttribute("builds", builds.getAll());
		model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
		return "redirect:/home";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = users.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new Login());
			return "register.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model , HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Build> Build = builds.getAll();
		model.addAttribute("builds", Build);
		model.addAttribute("userId", users.findById((Long)session.getAttribute("userId")));
		return "home.jsp";
	}
	
	@GetMapping("/build/add")
	public String addBuild(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("builds", new Build());
		List<CPU> CPU = cpuServ.getAll();
		List<ComputerCase> compCase = compCaseServ.getAll();
		List<CPUCooler> cooler = coolServ.getAll();
		List<GPU> GPU = gpuServ.getAll();
		List<Motherboard> mobo = moboServ.getAll();
		List<PSU> PSU = psuServ.getAll();
		List<RAM> RAM = ramServ.getAll();
		model.addAttribute("rams", RAM);
		model.addAttribute("gpus", GPU);
		model.addAttribute("mobos", mobo);
		model.addAttribute("psus", PSU);
		model.addAttribute("coolers", cooler);
		model.addAttribute("cases", compCase);
		model.addAttribute("cpus", CPU);
		return "addBuild.jsp";
	}
	
	@PostMapping("/addBuild")
	public String addBuildPost(@Valid @ModelAttribute("builds") Build build, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "addBuild.jsp";
		}
		User user = users.findById((Long)session.getAttribute("userId"));
		build.setUser(user);
		builds.create(build);
		return "redirect:/home";
	}
	
	@GetMapping("/builds/{id}")
	public String oneBuild(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/home";
		}
		Build build = builds.findById(id);
		CPU cpu = cpuServ.findById(Long.parseLong(build.getCpu()));
		ComputerCase computerCase = compCaseServ.findById(Long.parseLong(build.getComputerCase()));
		CPUCooler cpuCooler = coolServ.findById(Long.parseLong(build.getCooler()));
		GPU gpu = gpuServ.findById(Long.parseLong(build.getGpu()));
		Motherboard mobo = moboServ.findById(Long.parseLong(build.getMotherboard()));
		PSU psu = psuServ.findById(Long.parseLong(build.getPsu()));
		RAM ram = ramServ.findByid(Long.parseLong(build.getRam()));
		double total = (cpu.getPrice() + computerCase.getPrice() + cpuCooler.getPrice() + gpu.getPrice() + mobo.getPrice() + psu.getPrice() + ram.getPrice());
		model.addAttribute("total", total);
		model.addAttribute("rams", ram);
		model.addAttribute("psus", psu);
		model.addAttribute("mobo", mobo);
		model.addAttribute("gpus", gpu);
		model.addAttribute("cooler", cpuCooler);
		model.addAttribute("cases", computerCase);
		model.addAttribute("cpus", cpu);
		model.addAttribute("builds", build);
		model.addAttribute("user", (Long)session.getAttribute("userId"));
		session.setAttribute("buildId", build.getId());
		return "oneBuild.jsp";
	}
	
	@GetMapping("/builds/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/home";
		}
		List<CPU> CPU = cpuServ.getAll();
		List<ComputerCase> compCase = compCaseServ.getAll();
		List<CPUCooler> cooler = coolServ.getAll();
		List<GPU> GPU = gpuServ.getAll();
		List<Motherboard> mobo = moboServ.getAll();
		List<PSU> PSU = psuServ.getAll();
		List<RAM> RAM = ramServ.getAll();
		model.addAttribute("rams", RAM);
		model.addAttribute("gpus", GPU);
		model.addAttribute("mobos", mobo);
		model.addAttribute("psus", PSU);
		model.addAttribute("coolers", cooler);
		model.addAttribute("cases", compCase);
		model.addAttribute("cpus", CPU);
		model.addAttribute("builds", builds.findById(id));
		return "editBuild.jsp";
	}
	
	@PostMapping("/builds/{id}/edit")
	public String editPost(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("builds") Build build, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "editBuild.jsp";
		}
		User user = users.findById((Long)session.getAttribute("userId"));
		build.setUser(user);
		builds.create(build);
		return "redirect:/builds/{id}";
	}
	
	
	@RequestMapping("/builds/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		Build build = builds.findById(id);
		builds.delete(build);
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
	
}
