package egovframework.myAnwser.dialog.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.myAnwser.cmmn.service.JsonUtil;
import egovframework.myAnwser.dialog.service.DialogWebService;
import egovframework.myAnwser.resume.service.ResumeService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class DialogWebController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "dialogWebService")
	private DialogWebService dialogWebService;
	
	@Resource(name = "resumeService")
	private ResumeService resumeService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "dialogReq.do", produces = "application/json; charset=utf8")
	@ResponseBody
	private String dialogWeb(@RequestBody(required=false) String req,
			ModelMap model) throws Exception {
		
			HashMap<String, Object> data		= JsonUtil.JsonToLinkedHashMap(req);
			HashMap<String, Object> queryResult	= (HashMap)data.get("queryResult");
			HashMap<String, Object> intent	= (HashMap)data.get("intent");
			
			HashMap<String,Object> returnVal = null;
			logger.info(intent.get("displayName").toString());
			if (intent.get("displayName").toString().contains("resume")) {
				
				logger.info(req);
				model.addAttribute("paramMap", JsonUtil.JsonToMap(req));
			
				Map<String, Object> paramMap = JsonUtil.JsonToMap(req);
				
				paramMap = (Map<String, Object>) paramMap.get("queryResult");
			
				List<Map<String, Object>> outputContexts = 
						(List<Map<String,Object>>)(paramMap.get("outputContexts"));
				
				paramMap = (Map<String, Object>) outputContexts.get(0).get("parameters");
				
				String outputContextsStr = JsonUtil.ListToJson(outputContexts);
				String lifespanCount = outputContexts.get(0).get("lifespanCount").toString();
				String userName = paramMap.get("userId").toString();
				String resumeItem = paramMap.get("resumeItem").toString();
				String resumeDetails = null;
				
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
				
				List<EgovMap> memberList = dialogWebService.selectMemberList(paramMap);

				if (memberList.size() == 0){
					//다시 말해주세요 멤버가 없음
					model.addAttribute("msg", "찾으시는 이름의 이력서가 없습니다.");
					return "jong/dialog3.ajax";
				} else {
					paramMap.put("userId", memberList.get(0).get("id").toString());
					if (resumeDetails != null) { 
						model.addAttribute("resumeDetails", resumeDetails);
						if (resumeItem.equals("경력") || resumeItem.equals("대외활동")) {
							EgovMap resumeContent = dialogWebService.selectResumeItemDetailsInfo(paramMap);
							logger.info(resumeContent.toString());
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
						resume = dialogWebService.selectResumeItemList(paramMap);
						logger.info(resume.toString());
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
				
			} else if (intent.get("displayName").toString().contains("training")) {
				HashMap<String,Object> trainingMap = dialogWebService.selectQuestion(req);
				System.out.println(trainingMap);
				
				returnVal = trainingMap;
			} else {
				HashMap<String,Object> defaultObj = dialogWebService.selectDefaultMessage(req);
				
				System.out.println("컨트롤러"+defaultObj);
				
				returnVal = defaultObj;
			}
			
		return JsonUtil.HashMapToJson(returnVal);
	}
}
