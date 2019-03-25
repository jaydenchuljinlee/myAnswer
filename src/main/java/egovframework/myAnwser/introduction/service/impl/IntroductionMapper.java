package egovframework.myAnwser.introduction.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface IntroductionMapper {

	List<EgovMap> selectCustomQList(Map<String, Object> paramMap) throws Exception;

	List<EgovMap> selectCareerQList(Map<String, Object> paramMap) throws Exception;

	List<EgovMap> selectActivityQList(Map<String, Object> paramMap) throws Exception;

	void updateCompanyOne(Map<String, Object> paramMap) throws Exception;

	void updateActivityOne(Map<String, Object> paramMap) throws Exception;

}
