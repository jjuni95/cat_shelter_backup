package com.kosmo.catpunch.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatAdoptDTO {
//cat_adopt 테이블 관리자페이지

	private int caId;
	private int fkCaid; // null
	private String catAdoptImage;
	private String catAdoptText;
	private LocalDateTime catAdoptWritedate;
	private LocalDateTime catAdoptUpdate; // null
	private LocalDateTime catAdoptDeletedate; // null
	private Boolean catAdoptShow; // 0
	private int catAdoptViewCount; // 0

}
