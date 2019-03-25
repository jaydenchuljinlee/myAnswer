package egovframework.myAnwser.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

	@ModelAttribute("pageName")
	public String pageName() throws Exception {
		return "nav-portfolio";
	}
	
	@RequestMapping(value = "portfolio.do")
	private String portfolio()throws Exception {
		
		return "portfolio/portfolio.left";
	}
	
	@RequestMapping(value = "create_portfolio.do")
	private String create_portfolio()throws Exception {
		
		return "portfolio/create_portfolio.left";
	}
	
	@RequestMapping(value = "update_portfolio.do")
	private String update_portfolio()throws Exception {
		
		return "portfolio/update_portfolio.left";
	}
	
	@RequestMapping(value = "detail_portfolio.do")
	private String detail_portfolio()throws Exception {
		
		return "portfolio/detail_portfolio.left";
	}
	
	@RequestMapping(value = "list_portfolio.do")
	private String list_portfolio()throws Exception {
		
		return "portfolio/list_portfolio.left";
	}
}
