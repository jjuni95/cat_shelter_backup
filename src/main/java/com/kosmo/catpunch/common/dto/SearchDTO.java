package com.kosmo.catpunch.common.dto;

import com.kosmo.catpunch.paging.Pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {

	private int page;
	private int recordSize;	//페이지마다 출력할 데이터 개수
	private int pageSize;	//화면 하단에 출력할 페이지 크기
	
//	  private String keyword; //검색키워드
//	 private String searchType; //검색유형
	
	 private String catGender;
	 private String catAge;
	 private String catName;
	 
	private Pagination pagination;    // 페이지네이션 정보

	private SearchDTO() {
		this.page = 1;
		this.recordSize = 8;	//한페이지에 8개 데이터 출력
		this.pageSize = 10;		//화면 하단에 1~10까지의 페이지 보임
	}
	
}
