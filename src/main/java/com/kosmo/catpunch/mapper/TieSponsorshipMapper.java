package com.kosmo.catpunch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kosmo.catpunch.dto.TieSponsorshipVO;

@Mapper
public interface TieSponsorshipMapper {
	
	/*
	 * 정보저장 
	 */
	void TieSponsorshipSave(TieSponsorshipVO params);
	
	/*
	 * 리스트 조회
	 */
	List<TieSponsorshipVO> findAll();

}
