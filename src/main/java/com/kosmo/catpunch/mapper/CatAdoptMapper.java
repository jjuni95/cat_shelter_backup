package com.kosmo.catpunch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kosmo.catpunch.common.dto.SearchDTO;
import com.kosmo.catpunch.dto.CatAdoptDTO;
import com.kosmo.catpunch.dto.CatListAdoptJoinDTO;



@Mapper
public interface CatAdoptMapper {


	
	 void save(CatAdoptDTO catAdoptDto);

	 
	 List<CatListAdoptJoinDTO> catAdoptFindAll(SearchDTO params);

	 //게시글 수 카운팅
	 int count(SearchDTO params);
	 
	 
		/*
		 * //리스트 조회 List<CatAdoptDTO> showCatAll(SearchDTO params);
		 */


	 
}
