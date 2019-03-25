package egovframework.myAnwser.resume.web;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import egovframework.myAnwser.cmmn.service.JsonUtil;
import egovframework.myAnwser.resume.service.ResumeService;
import egovframework.myAnwser.resume.service.impl.ResumeMapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class ResumeController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "resumeService")
	private ResumeService resumeService;

	@ModelAttribute("pageName")
	public String pageName() throws Exception {
		return "nav-resume";
	}

	@RequestMapping(value = "resume.do")
	public String resume() throws Exception {
		
		return "resume/resume.left";
	}

	@RequestMapping(value = "saveResume.do")
	public String saveResume(
			MultipartFile photo,
			HttpServletRequest request, 
			@RequestParam(value="eduStr", required=false) List<String> eduStrList,
			@RequestParam(value="carStr", required=false) List<String> carStrList,
			@RequestParam(value="actStr", required=false) List<String> actStrList,
			@RequestParam(value="licStr", required=false) List<String> licStrList,
			@RequestParam(value="awaStr", required=false) List<String> awaStrList,
			@RequestParam HashMap<String, Object> paramMap
			) throws Exception {
		
		if (photo != null) {
			String saveName = photo.getOriginalFilename();
			File file = new File("C:/Users/skdlt/Desktop/photo/" + saveName);
			
			photo.transferTo(file);
			paramMap.put("thumnail", "/photo/" + saveName);
		}
		//아이디
		paramMap.put("userId", "kim");
		//자바스크립트를 이용하여 추가가 가능한 항목들은 모두 각 항목 별로 제이슨 스트링으로 변환하여 서버로 전송
		paramMap.put("eduStrList", eduStrList);
		paramMap.put("carStrList", carStrList);
		paramMap.put("actStrList", actStrList);
		paramMap.put("licStrList", licStrList);
		paramMap.put("awaStrList", awaStrList);

		resumeService.saveResumeInfo(paramMap);
		
		return "redirect:introduction.do";
	}

	@RequestMapping(value = "eduContent.do", produces = "application/html; charset=UTF-8;")
	private String eduContent() throws Exception {
		return "resume/eduContent.ajax";
	}

	@RequestMapping(value = "carContent.do", produces = "application/html; charset=UTF-8;")
	private String carContent() throws Exception {
		return "resume/carContent.ajax";
	}

	@RequestMapping(value = "actContent.do", produces = "application/html; charset=UTF-8;")
	private String actContent() throws Exception {
		return "resume/actContent.ajax";
	}

	@RequestMapping(value = "licContent.do", produces = "application/html; charset=UTF-8;")
	private String licContent() throws Exception {
		return "resume/licContent.ajax";
	}

	@RequestMapping(value = "awaContent.do", produces = "application/html; charset=UTF-8;")
	private String awaContent() throws Exception {
		return "resume/awaContent.ajax";
	}

	@RequestMapping(value = "expContent.do", produces = "application/html; charset=UTF-8;")
	private String expContent() throws Exception {
		return "resume/expContent.ajax";
	}

	@RequestMapping(value = "schollSearch.do", produces = "application/html; charset=UTF-8;")
	private String schollSearch(ModelMap model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		List<EgovMap> schoolList = resumeService.selectSchoolServiceList(paramMap);

		for (EgovMap egovMap : schoolList) {
			logger.info(egovMap.toString());
		}

		model.addAttribute("schoolList", schoolList);

		return "resume/schollSearch.ajax";
	}
	
	@SuppressWarnings({ "unchecked"})
	@RequestMapping(value = "dialog.do")
	private String dialog(ModelMap model ,
			@RequestBody(required=false) String req) throws Exception {
		model.addAttribute("paramMap", JsonUtil.JsonToMap(req));
	
		Map<String, Object> paramMap = JsonUtil.JsonToMap(req);
		
		paramMap = (Map<String, Object>) paramMap.get("queryResult");
	
		List<Map<String, Object>> outputContexts = 
				(List<Map<String,Object>>)(paramMap.get("outputContexts"));
		
		paramMap = (Map<String, Object>) outputContexts.get(0).get("parameters");
		//다이얼 로그의 컨텍스트 정보
		String outputContextsStr = JsonUtil.ListToJson(outputContexts);
		//현재 인텐트의 생명주기
		String lifespanCount = outputContexts.get(0).get("lifespanCount").toString();
		//유저아이디
		String userName = paramMap.get("userId").toString();
		//검색하려는 이력서 항목
		String resumeItem = paramMap.get("resumeItem").toString();
		//검색하려는 경력 혹은 대외활동의 이름
		String resumeDetails = null;
		//경력 혹은 대외활동 이름을 검색하고 생명주기가 10이 아닐 경우
		//즉 기본적인 이력서 항목 검색이 아니라 특별한 항목에 대하여 궁금할 경우
		if (paramMap.containsKey("resumeDetails") && !lifespanCount.equals("10.0")) {
			resumeDetails = paramMap.get("resumeDetails").toString();
		}

		model.addAttribute("outputContextsStr", outputContextsStr);
		model.addAttribute("userName", userName);
		model.addAttribute("resumeItem", resumeItem);
		
		paramMap.clear();
		paramMap.put("userName", userName);
		paramMap.put("resumeItem", resumeItem);
		paramMap.put("resumeDetails", resumeDetails);
		
		//전달받은 유저의 이름을 가지고 아이디를 검색
		List<EgovMap> memberList = resumeService.selectMemberList(paramMap);

		if (memberList.size() == 0){
			//멤버가 없음
			model.addAttribute("msg", "찾으시는 이름의 이력서가 없습니다.");
			return "jong/dialog-error.ajax";
		} else {
			//유저의 아이디
			paramMap.put("userId", memberList.get(0).get("id").toString());
			
			if (resumeDetails != null) { 
				model.addAttribute("resumeDetails", resumeDetails);
				//경력 혹은 대외활동의 요소 중에서만 자기소개서 검색이 가능
				if (resumeItem.equals("경력") || resumeItem.equals("대외활동")) {
					//사용자가 작성한 내용 
					EgovMap resumeContent = resumeService.selectResumeItemDetailsInfo(paramMap);
					model.addAttribute("resumeContent", resumeContent);
					
					if (resumeItem.equals("경력") ) {
						return "jong/dialog-car-details.ajax";
					} else {
						return "jong/dialog-awa-details.ajax";
					}
					
				} else {
					model.addAttribute("msg", "경력과 대외활동에서만 검색하실 수 있습니다.");
					//경력에는 그러한 항목이 없습니다.
					return "jong/dialog-error.ajax";
				}
			} else {
				List<EgovMap> resume = null;
				//각 이력서의 항목의 모든 리스트를 가져옴
				resume = resumeService.selectResumeItemList(paramMap);
				model.addAttribute("resume", resume);
	
				if (resume.size() <  1) {
					model.addAttribute("msg", "해당 항목이 기재되어 있지 않습니다.");
					return "jong/dialog-error.ajax";
				} else if (resumeItem.equals("이력서")) {
					return "jong/dialog-def.ajax";
				} else if (resumeItem.equals("경력")) {
					return "jong/dialog-car.ajax";
				} else if (resumeItem.equals("학력")) {
					return "jong/dialog-edu.ajax";
				} else if (resumeItem.equals("대외활동")) {
					return "jong/dialog-act.ajax";
				} else if (resumeItem.equals("자격증")) {
					return "jong/dialog-lic.ajax";
				} else if (resumeItem.equals("수상")) {
					return "jong/dialog-awa.ajax";
				} else {
					model.addAttribute("msg", "서버오류 죄송합니다 다시한번 말씀해주세요");
					return "jong/dialog-error.ajax";
				}
			}
		}
	}
}
