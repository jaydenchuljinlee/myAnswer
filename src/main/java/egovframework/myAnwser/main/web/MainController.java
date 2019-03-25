package egovframework.myAnwser.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@ModelAttribute("pageName")
	public String pageName() throws Exception {

		return "nav-main";
	}

	@RequestMapping(value = "main.do")
	public String main() throws Exception {

		return "main/main.tiles";
	}

}
