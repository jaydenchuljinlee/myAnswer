package egovframework.myAnwser.introduction.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.myAnwser.introduction.service.IntroductionService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("introductionService")
public class IntroductionServiceImpl implements IntroductionService {
	
	@Resource(name = "introductionMapper")
	private IntroductionMapper introductionMapper;
	
	@Override
	public List<EgovMap> selectCustomQList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return introductionMapper.selectCustomQList(paramMap);
	}

	@Override
	public List<EgovMap> selectCareerQList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return introductionMapper.selectCareerQList(paramMap);
	}

	@Override
	public List<EgovMap> selectActivityQList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return introductionMapper.selectActivityQList(paramMap);
	}

	@Override
	public void saveCustomOne(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveCompanyOne(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		List<String> joinDayList = (List<String>) paramMap.get("joinDay");
		List<String> leaveDayList = (List<String>) paramMap.get("leaveDay");
		List<String> contentList = (List<String>) paramMap.get("content");
		
		String userId = paramMap.get("userId").toString();
		
		paramMap.clear();
		paramMap.put("userId", userId);
		for (int i = 0; i < joinDayList.size(); i++) {
			paramMap.put("joinDay", joinDayList.get(i));
			paramMap.put("leaveDay", leaveDayList.get(i));
			paramMap.put("content", contentList.get(i));
			introductionMapper.updateCompanyOne(paramMap);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveActivetyOne(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		List<String> startDayList = (List<String>) paramMap.get("startDay");
		List<String> endDayList = (List<String>) paramMap.get("endDay");
		List<String> contentList = (List<String>) paramMap.get("content");
		
		String userId = paramMap.get("userId").toString();
		
		paramMap.clear();
		paramMap.put("userId", userId);
		for (int i = 0; i < startDayList.size(); i++) {
			paramMap.put("startDay", startDayList.get(i));
			paramMap.put("endDay", endDayList.get(i));
			paramMap.put("content", contentList.get(i));
			introductionMapper.updateActivityOne(paramMap);
		}
	}

}
