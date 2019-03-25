package egovframework.myAnwser.resume.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface ResumeService {

	void saveResumeInfo(HashMap<String, Object> paramMap) throws Exception;

	List<EgovMap> selectSchoolServiceList(HashMap<String, Object> paramMap) throws Exception;

	List<EgovMap> selectResumeItemList(Map<String, Object> paramMap) throws Exception;

	List<EgovMap> selectMemberList(Map<String, Object> paramMap) throws Exception;

	EgovMap selectResumeItemDetailsInfo(Map<String, Object> paramMap) throws Exception;

}
