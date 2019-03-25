package egovframework.myAnwser.dialog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("dialogMapper")
public interface DialogMapper {

	List<EgovMap> selectQuestionMap(String id)throws Exception;

	List<EgovMap> selectMemberList(Map<String, Object> paramMap)throws Exception;

	EgovMap selectCarDetailsOne(Map<String, Object> paramMap)throws Exception;

	EgovMap selectActDetailsOne(Map<String, Object> paramMap)throws Exception;

	List<EgovMap> selectCarList(Map<String, Object> paramMap)throws Exception;

	List<EgovMap> selectDefList(Map<String, Object> paramMap)throws Exception;

	List<EgovMap> selectEduList(Map<String, Object> paramMap)throws Exception;

	String selectSchoolName(EgovMap egovMap)throws Exception;

	List<EgovMap> selectActList(Map<String, Object> paramMap)throws Exception;

	List<EgovMap> selectLicList(Map<String, Object> paramMap)throws Exception;

	List<EgovMap> selectAwaList(Map<String, Object> paramMap)throws Exception;

	
}
