package egovframework.myAnwser.introduction.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.myAnwser.introduction.service.IntroductionService;
import egovframework.myAnwser.resume.service.ResumeService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class IntroductionController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "introductionService")
	private IntroductionService introductionService;
	
	@ModelAttribute("pageName")
	public String pageName() throws Exception {
		return "nav-intro";
	}
	
	//자기소개서 페이지
	@RequestMapping(value = "introduction.do")
	private String introduct() throws Exception {
		
		return "introduction/introduction.left";
	}
	
	//이력서 항목 페이지
	@RequestMapping(value = "plusQ.do")
	private String plusQ() throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", "kim");
		//introductionService.selectCustomQList(paramMap);
		return "introduction/customIntro.ajax";
	}
	
	@RequestMapping(value = "careerQ.do")
	private String careerQ(ModelMap model) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", "kim");
		List<EgovMap> careerQList = introductionService.selectCareerQList(paramMap);
		model.addAttribute("careerQList", careerQList);
		return "introduction/careerIntro.ajax";
	}
	
	@RequestMapping(value = "activityQ.do")
	private String activityQ(ModelMap model) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", "kim");
		List<EgovMap> activityQList = introductionService.selectActivityQList(paramMap);
		model.addAttribute("activityQList", activityQList);
		return "introduction/activityIntro.ajax";
	}
	
	//자기소개서 저장
	@RequestMapping(value = "saveIntroduce.do")
	private String saveIntroduce(
			@RequestParam(required=false) List<String> customQ,
			@RequestParam(required=false) List<String> customA,
			@RequestParam(required=false) List<String> content,
			@RequestParam(required=false) List<String> joinDay,
			@RequestParam(required=false) List<String> leaveDay,
			@RequestParam(required=false) List<String> startDay,
			@RequestParam(required=false) List<String> endDay
			) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("userId", "kim");
		
		if (customQ != null) {
			introductionService.saveCustomOne(paramMap);
		}

		if (joinDay != null) {
			paramMap.put("joinDay", joinDay);
			paramMap.put("leaveDay", leaveDay);
			paramMap.put("content", content);
			introductionService.saveCompanyOne(paramMap);
		}

		if (startDay != null) {
			paramMap.put("startDay", startDay);
			paramMap.put("endDay", endDay);
			paramMap.put("content", content);
			introductionService.saveActivetyOne(paramMap);
		}
		
		return "redirect:introduction.do";
	}

	
	//자기소개서 질문 추가 
	@RequestMapping(value = "plusQuestion.do", 
			produces="application/html; charset=UTF-8;")
	private String plusQuestion() throws Exception {
		return "introduction/question.ajax";
	}
}
