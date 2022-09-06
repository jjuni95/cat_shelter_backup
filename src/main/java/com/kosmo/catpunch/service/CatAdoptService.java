package com.kosmo.catpunch.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.kosmo.catpunch.common.dto.SearchDTO;
import com.kosmo.catpunch.dto.CatAdoptDTO;
import com.kosmo.catpunch.dto.CatListAdoptJoinDTO;
import com.kosmo.catpunch.mapper.CatAdoptMapper;
import com.kosmo.catpunch.paging.Pagination;
import com.kosmo.catpunch.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatAdoptService {
	
	final private CatAdoptMapper catAdoptMapper;


	   public long saveBoard(CatAdoptDTO catAdoptDto) {
		   catAdoptMapper.save(catAdoptDto);
	        return catAdoptDto.getCaId();
	    }
	   
	   
	    public PagingResponse<CatListAdoptJoinDTO> findAllBoard(final SearchDTO params) {
	    	int count = catAdoptMapper.count(params);
	    	Pagination pagination = new Pagination(count, params);
	    	params.setPagination(pagination);
	    	
	    	List<CatListAdoptJoinDTO> list = catAdoptMapper.catAdoptFindAll(params);
	    	return new PagingResponse<>(list, pagination);
	    	
//	        return catAdoptMapper.catAdoptFindAll(params);
	        
	        
	    }
	    
	    
//	    //게시글 리스트 조회
//	    public List<CatAdoptDTO> findAllCatList(final SearchDTO params){
//	    	return catAdoptMapper.showCatAll(params);
//	    }
	   



}
