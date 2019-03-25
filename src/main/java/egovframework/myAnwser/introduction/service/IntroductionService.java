package egovframework.myAnwser.introduction.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface IntroductionService {

	List<EgovMap> selectCustomQList(Map<String, Object> paramMap) throws Exception;

	List<EgovMap> selectCareerQList(Map<String, Object> paramMap) throws Exception;

	List<EgovMap> selectActivityQList(Map<String, Object> paramMap) throws Exception;

	void saveCustomOne(Map<String, Object> paramMap) throws Exception;

	void saveCompanyOne(Map<String, Object> paramMap) throws Exception;

	void saveActivetyOne(Map<String, Object> paramMap) throws Exception;

}
