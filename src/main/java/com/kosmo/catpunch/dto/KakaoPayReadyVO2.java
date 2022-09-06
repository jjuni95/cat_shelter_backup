package com.kosmo.catpunch.dto;

import java.util.Date;

import lombok.Data;
 
@Data
public class KakaoPayReadyVO2 {
    
    //request
    private String tid,sid ,next_redirect_pc_url;
    private Date created_at;
    
}
 