package egovframework.myAnwser.dialog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface DialogWebService {

	EgovMap selectResumeList(String req)throws Exception;

	HashMap<String,Object> selectQuestion(String req)throws Exception;

	HashMap<String,Object> selectDefaultMessage(String req)throws Exception;

	List<EgovMap> selectMemberList(Map<String, Object> paramMap)throws Exception;

	EgovMap selectResumeItemDetailsInfo(Map<String, Object> paramMap)throws Exception;

	List<EgovMap> selectResumeItemList(Map<String, Object> paramMap)throws Exception;
}
