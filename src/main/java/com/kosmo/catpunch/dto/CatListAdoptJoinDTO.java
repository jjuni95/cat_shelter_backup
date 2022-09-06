package com.kosmo.catpunch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatListAdoptJoinDTO {
//cat_list, cat_adopt  join
	
	
	private Long caId; 
	private int fkCaid;
	private int catAdopt; 
	private int catAge; 
	private int catGender;
	private String catName; 
	private String catColor; 
	private String catBreed; 
	private int catSupportok; 
	
	private String catAdoptImage;
	private String catAdoptText;
}
