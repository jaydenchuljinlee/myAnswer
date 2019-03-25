package egovframework.myAnwser.dialog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.myAnwser.cmmn.service.JsonUtil;
import egovframework.myAnwser.dialog.service.DialogWebService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("dialogWebService")
public class DialogWebServiceImpl implements DialogWebService {

	@Resource(name = "dialogMapper")
	private DialogMapper dialogMapper;

	@Override
	public EgovMap selectResumeList(String req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public HashMap<String,Object> selectQuestion(String req) throws Exception {
		
		
		HashMap<String, Object> data		= JsonUtil.JsonToLinkedHashMap(req);
		HashMap<String, Object> queryResult	= (HashMap)data.get("queryResult");
		HashMap<String, Object> parameters	= (HashMap)queryResult.get("parameters");
		
		EgovMap returnVal 	= null;
		
		String id = "lcj";
		
		List<EgovMap> selectList = dialogMapper.selectQuestionMap(id);
		
		if (parameters.size() == 1) {
			
			String queryText	= queryResult.get("queryText").toString();
			
			if (queryText.contains("시작")) {
				//시작부분
				returnVal = selectList.get(0);
				returnVal.put("final", 0);
			} else{
				//종료를 했을 때,
				System.out.println("트레이닝 종료");
				
				returnVal = new EgovMap();
				returnVal.put("final", 1);
			}
			
		} else {
			String queryText						= queryResult.get("queryText").toString();
			ArrayList<Object> outputContexts		= (ArrayList)queryResult.get("outputContexts");
			HashMap<String, Object> outputContext	= new HashMap<String,Object>();
			
			for (int i = 0; i < outputContexts.size(); i++) {
			
				Object projectName = ((HashMap)(outputContexts.get(i))).get("name");
				
				if (projectName.toString().contains("contexts/training-followup")) {
					
					outputContext = (HashMap)outputContexts.get(i);
				}
			}
			
			int lifespanCount		= (int)Double.parseDouble(outputContext.get("lifespanCount").toString());
			int lifespan			= 10;
			int questionLength		= selectList.size();
			int validation			= lifespan - lifespanCount;
			
			if (validation < questionLength) {
				int q_no = (lifespan - lifespanCount) + 1;//보내야될 질문번호
				System.out.println(validation+"번째 질문 답이 왔고, 보낼 질문은"+q_no+"입니다.");
				returnVal = selectList.get(validation);
				returnVal.put("final", 0);
			} else {
				System.out.println(validation+"번째 질문 답이 왔고, 파이널 리스폰스를 보내야합니다.");
				returnVal = new EgovMap();
				returnVal.put("final", 1);
			}
		}
		
		return convertTraining(returnVal);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public HashMap<String,Object> selectDefaultMessage(String req) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,Object> defaultMap = jsonMap();
		
		((HashMap)(((HashMap)(defaultMap.get("payload"))).get("google"))).put("expectUserResponse","true");
		
		((HashMap)(((HashMap)(((ArrayList)(((HashMap)(((HashMap)(((HashMap)(defaultMap.get("payload"))).
				get("google"))).get("richResponse"))).get("items"))).get(0))).get("simpleResponse"))).
				put("displayText","1.트레이닝 2.이력서");
		
		((HashMap)(((HashMap)(((ArrayList)(((HashMap)(((HashMap)(((HashMap)(defaultMap.get("payload"))).
				get("google"))).get("richResponse"))).get("items"))).get(0))).get("simpleResponse"))).
				put("textToSpeech","1.트레이닝 2.이력서");
		
		return defaultMap;
	}

	public HashMap<String,Object> jsonMap(){
		
		HashMap<String,Object> obj = new HashMap<String,Object>();
		HashMap<String,Object> payload = new HashMap<String,Object>();
		HashMap<String,Object> google = new HashMap<String,Object>();
		HashMap<String,Object> items = new HashMap<String,Object>();
		
		ArrayList<Object> itemsArray = new ArrayList<>();
		
		HashMap<String,Object> simpleResponse = new HashMap<String,Object>();
		HashMap<String,Object> textMap = new HashMap<String,Object>();
		
		textMap.put("textToSpeech", "");
		textMap.put("displayText", "");
		
		simpleResponse.put("simpleResponse", textMap);
		
		itemsArray.add(simpleResponse);
		
		items.put("items", itemsArray);
		
		google.put("expectUserResponse", 1);
		google.put("richResponse", items);
		
		payload.put("google", google);
		
		obj.put("payload", payload);
		
		return obj;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String,Object> convertTraining(EgovMap param) {
		
		HashMap<String,Object> trainingMap = jsonMap();
		
		if (param.get("final").equals(0)) {
			
			((HashMap)(((HashMap)(trainingMap.get("payload"))).get("google"))).put("expectUserResponse","true");
			
			((HashMap)(((HashMap)(((ArrayList)(((HashMap)(((HashMap)(((HashMap)(trainingMap.get("payload"))).
					get("google"))).get("richResponse"))).get("items"))).get(0))).get("simpleResponse"))).
					put("displayText",param.get("qContents"));
			
			((HashMap)(((HashMap)(((ArrayList)(((HashMap)(((HashMap)(((HashMap)(trainingMap.get("payload"))).
					get("google"))).get("richResponse"))).get("items"))).get(0))).get("simpleResponse"))).
					put("textToSpeech",param.get("qContents"));
			
		} else {
			
			((HashMap)(((HashMap)(trainingMap.get("payload"))).get("google"))).put("expectUserResponse","false");
			
			((HashMap)(((HashMap)(((ArrayList)(((HashMap)(((HashMap)(((HashMap)(trainingMap.get("payload"))).
					get("google"))).get("richResponse"))).get("items"))).get(0))).get("simpleResponse"))).
					put("displayText","종료");
			
			((HashMap)(((HashMap)(((ArrayList)(((HashMap)(((HashMap)(((HashMap)(trainingMap.get("payload"))).
					get("google"))).get("richResponse"))).get("items"))).get(0))).get("simpleResponse"))).
					put("textToSpeech","종료");
		}
		return trainingMap;
	}

	@Override
	public List<EgovMap> selectMemberList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return dialogMapper.selectMemberList(paramMap);
	}

	@Override
	public EgovMap selectResumeItemDetailsInfo(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		String resumeItem = paramMap.get("resumeItem").toString();
		EgovMap result = null;
		
		if (resumeItem.equals("경력")) {
			result = dialogMapper.selectCarDetailsOne(paramMap);
		} else if (resumeItem.equals("대외활동")) {
			result = dialogMapper.selectActDetailsOne(paramMap);
		} 
		return result;
	}

	@Override
	public List<EgovMap> selectResumeItemList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		String resumeItem = paramMap.get("resumeItem").toString();
		List<EgovMap> result = null;
		
		if (resumeItem.equals("경력")) {
			result = dialogMapper.selectCarList(paramMap);
		} else if (resumeItem.equals("이력서")) {
			result = dialogMapper.selectDefList(paramMap);
		} else if (resumeItem.equals("학력")) {
			result = dialogMapper.selectEduList(paramMap);
			
			for (EgovMap egovMap : result) {
				String schoolName = dialogMapper.selectSchoolName(egovMap);
				egovMap.put("schoolCode", schoolName);
			}
			
		} else if (resumeItem.equals("대외활동")) {
			result = dialogMapper.selectActList(paramMap);
		} else if (resumeItem.equals("자격증")) {
			result = dialogMapper.selectLicList(paramMap);
		} else if (resumeItem.equals("수상")) {
			result = dialogMapper.selectAwaList(paramMap);
		}
		return result;
	}

	
}
