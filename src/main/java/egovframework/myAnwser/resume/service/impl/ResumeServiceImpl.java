package egovframework.myAnwser.resume.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.myAnwser.cmmn.service.JsonUtil;
import egovframework.myAnwser.resume.service.ResumeService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "resumeMapper")
	private ResumeMapper resumeMapper;

	@SuppressWarnings("unchecked")
	@Override
	public void saveResumeInfo(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		//파라미터로 받은 맵의 값들을 보여준다
		for (String key : paramMap.keySet()) {
			logger.info(key + " : " + paramMap.get(key));
		}

		List<String> eduStrList = null;
		List<String> carStrList = null;
		List<String> actStrList = null;
		List<String> licStrList = null;
		List<String> awaStrList = null;

		if (paramMap.get("eduStrList") != null) {
			eduStrList = (List<String>) paramMap.get("eduStrList");
			paramMap.remove("eduStrList");
		}
	
		if (paramMap.get("carStrList") != null) {
			carStrList = (List<String>) paramMap.get("carStrList");
			paramMap.remove("carStrList");
		}

		if (paramMap.get("actStrList") != null) {
			actStrList = (List<String>) paramMap.get("actStrList");
			paramMap.remove("actStrList");
		}

		if (paramMap.get("licStrList") != null) {
			licStrList = (List<String>) paramMap.get("licStrList");
			paramMap.remove("licStrList");
		}

		if (paramMap.get("awaStrList") != null) {
			awaStrList = (List<String>) paramMap.get("awaStrList");
			paramMap.remove("awaStrList");
		}

		Map<String, Object> tempParamMap = null;
		String userId = paramMap.get("userId").toString();
		//아이디를 통해 기본 인적사항 업데이트
		resumeMapper.updateResumeOne(paramMap);
		//아이디를 통해 희망 연봉 업데이트
		//마이바티스의 SELECT KEY기능을 이용하여 희망연봉이 존재하는지 확인후
		//UPDATE문 혹은 INSERT문을 수행
		resumeMapper.insertHopeOne(paramMap);
		//학력 제이슨 스트링 리스트를 맵으로 변환하여 
		//UPDATE문 혹은 INSERT문을 수행
		if (eduStrList != null) {
			logger.info("학력 디비 입력");
			for (String eduStr : eduStrList) {
				tempParamMap = JsonUtil.JsonToMap(eduStr);
				tempParamMap.put("userId", userId);
				resumeMapper.insertEduOne(tempParamMap);
			}
		} else {
			logger.info("학력 없음");
		}
		//경력 제이슨 스트링 리스트를 맵으로 변환하여 
		//UPDATE문 혹은 INSERT문을 수행
		if (carStrList != null) {
			logger.info("경력 디비 입력");

			for (String carStr : carStrList) {
				tempParamMap = JsonUtil.JsonToMap(carStr);
				tempParamMap.put("userId", userId);
				for (String key : tempParamMap.keySet()) {
					logger.info("{} : {}", key, tempParamMap.get(key));
				}
				resumeMapper.insertCarOne(tempParamMap);
			}
		} else {
			logger.info("경력 없음");
		}
		//대외활동 제이슨 스트링 리스트를 맵으로 변환하여 
		//UPDATE문 혹은 INSERT문을 수행
		if (actStrList != null) {
			logger.info("대외활동 입력");

			for (String actStr : actStrList) {
				tempParamMap = JsonUtil.JsonToMap(actStr);
				tempParamMap.put("userId", userId);
				resumeMapper.insertActOne(tempParamMap);
			}
		} else {
			logger.info("대외활동 없음");
		}
		//자격증 제이슨 스트링 리스트를 맵으로 변환하여 
		//UPDATE문 혹은 INSERT문을 수행
		if (licStrList != null) {
			logger.info("자격증 입력");

			for (String licStr : licStrList) {
				tempParamMap = JsonUtil.JsonToMap(licStr);
				tempParamMap.put("userId", userId);
				resumeMapper.insertLicOne(tempParamMap);
			}
		} else {
			logger.info("자격증 없음");
		}
		//수상 제이슨 스트링 리스트를 맵으로 변환하여 
		//UPDATE문 혹은 INSERT문을 수행
		if (awaStrList != null) {
			logger.info("수상 입력");

			for (String awaStr : awaStrList) {
				tempParamMap = JsonUtil.JsonToMap(awaStr);
				tempParamMap.put("userId", userId);
				resumeMapper.insertAwaOne(tempParamMap);
			}

		} else {
			logger.info("수상 없음");
		}

	}

	@Override
	public List<EgovMap> selectSchoolServiceList(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return resumeMapper.selectSchoolList(paramMap);
	}

	@Override
	public List<EgovMap> selectResumeItemList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		String resumeItem = paramMap.get("resumeItem").toString();
		List<EgovMap> result = null;
		
		if (resumeItem.equals("경력")) {
			result = resumeMapper.selectCarList(paramMap);
		} else if (resumeItem.equals("이력서")) {
			result = resumeMapper.selectDefList(paramMap);
		} else if (resumeItem.equals("학력")) {
			result = resumeMapper.selectEduList(paramMap);
			
			for (EgovMap egovMap : result) {
				String schoolName = resumeMapper.selectSchoolName(egovMap);
				egovMap.put("schoolCode", schoolName);
			}
			
		} else if (resumeItem.equals("대외활동")) {
			result = resumeMapper.selectActList(paramMap);
		} else if (resumeItem.equals("자격증")) {
			result = resumeMapper.selectLicList(paramMap);
		} else if (resumeItem.equals("수상")) {
			result = resumeMapper.selectAwaList(paramMap);
		}
		
		return result;
	}

	@Override
	public List<EgovMap> selectMemberList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return resumeMapper.selectMemberList(paramMap);
	}

	@Override
	public EgovMap selectResumeItemDetailsInfo(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		String resumeItem = paramMap.get("resumeItem").toString();
		EgovMap result = null;
		
		if (resumeItem.equals("경력")) {
			result = resumeMapper.selectCarDetailsOne(paramMap);
		} else if (resumeItem.equals("대외활동")) {
			result = resumeMapper.selectActDetailsOne(paramMap);
		} 
		
		return result;
	}

}
