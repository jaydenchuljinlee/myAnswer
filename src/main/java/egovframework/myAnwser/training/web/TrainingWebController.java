package egovframework.myAnwser.training.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainingWebController {

	@ModelAttribute("pageName")
	public String pageName() throws Exception {
		return "nav-training";
	}
	
	@RequestMapping(value = "training.do")
	private String trainingWeb() throws Exception {
		
		return "training/training_setting.left";
	}
	
	@RequestMapping(value = "training_input.do")
	private String training_input() throws Exception {
		
		return "training/training_input.left";
	}
	
	@RequestMapping(value = "training_result.do")
	private String training_result() throws Exception {
		
		return "training/training_result.left";
	}
}
