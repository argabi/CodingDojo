package com.argabi.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class theController {

		//index
		@RequestMapping("/")
		public String index() {
			return "index.jsp";
		}
		
		@RequestMapping(value="/code", method=RequestMethod.POST)
		
		public String theCode(@RequestParam(value="textCode") String textCode , RedirectAttributes theFalshMessage ) {
			
			if (textCode.equals("bushido")) // the password (code)
			{
				return "codePage.jsp";
			}
			else
			{
				theFalshMessage.addFlashAttribute("errorCode", " You must train harder!");
				return "redirect:/"; // redirect to home page , root
			}
			
		}
		
		
}
