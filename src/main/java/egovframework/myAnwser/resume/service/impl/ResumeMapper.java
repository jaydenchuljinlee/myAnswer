package egovframework.myAnwser.resume.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface ResumeMapper {

	public List<EgovMap> selectSchoolList(Map<String, Object> paramMap) throws Exception;

	public int insertEduOne(Map<String, Object> paramMap) throws Exception;

	public void insertCarOne(Map<String, Object> paramMap) throws Exception;

	public void insertActOne(Map<String, Object> paramMap) throws Exception;

	public void insertLicOne(Map<String, Object> paramMap) throws Exception;

	public void insertAwaOne(Map<String, Object> paramMap) throws Exception;

	public void updateResumeOne(Map<String, Object> paramMap) throws Exception;

	public void insertHopeOne(Map<String, Object> paramMap) throws Exception;

	public List<EgovMap> selectCarList(Map<String, Object> paramMap)  throws Exception;

	public List<EgovMap> selectEduList(Map<String, Object> paramMap)  throws Exception;

	public List<EgovMap> selectActList(Map<String, Object> paramMap)  throws Exception;

	public List<EgovMap> selectLicList(Map<String, Object> paramMap) throws Exception;

	public List<EgovMap> selectAwaList(Map<String, Object> paramMap) throws Exception;

	public List<EgovMap> selectMemberList(Map<String, Object> paramMap) throws Exception;

	public EgovMap selectCarDetailsOne(Map<String, Object> paramMap) throws Exception;

	public EgovMap selectActDetailsOne(Map<String, Object> paramMap) throws Exception;

	public String selectSchoolName(EgovMap egovMap) throws Exception;

	public List<EgovMap> selectDefList(Map<String, Object> paramMap) throws Exception;

}
