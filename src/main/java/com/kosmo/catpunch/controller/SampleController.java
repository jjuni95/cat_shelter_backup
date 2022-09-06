package com.kosmo.catpunch.controller;

import com.kosmo.catpunch.dto.KakaoPayApprovalVO;
import com.kosmo.catpunch.dto.TieSponsorshipVO;
import com.kosmo.catpunch.service.KakaoPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
 
@Log
@Controller

public class SampleController {
    
 private String supportCatName;
	
    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
    
    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {
        
    }
    
    //정기결제 1회차
    @PostMapping("/kakaoPay")
    public String kakaoPay(@RequestParam("money") String money,
    						@RequestParam("supportCatName") String catName) {
        log.info("kakaoPay post............................................");
        supportCatName = catName;
        
        return "redirect:" + kakaopay.kakaoPayReady2(money);
 
    }
    
    
    @GetMapping("/kakaoPaySuccess2")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        
        KakaoPayApprovalVO kpVO = kakaopay.kakaoPayInfo2(pg_token);
//        model.addAttribute("info", kakaopay.kakaoPayInfo2(pg_token));
        
        TieSponsorshipVO a = new TieSponsorshipVO();
        a.setAid(kpVO.getAid());
        a.setSid(kpVO.getSid());
        a.setAmount(kpVO.getAmount().getTotal().toString());
        a.setItem_name(kpVO.getItem_name());
        a.setApproved_at(kpVO.getApproved_at());
        a.setOnesorregural(1); //정기,결연후원이면 1
        
        
        //로그인 없으므로 결제취소용 임시 테스트값 
        a.setUserid("testko");
        a.setCatname(supportCatName);
        
        
        
        
        kakaopay.saveinfo(a); //디비에 저장
        
        model.addAttribute("info", kpVO);
     
        
        return "kakaoPaySuccess.html";
        
        
    }

    
	@PostMapping("/kakaoPay3")
    public String kakaoPay3() {
        log.info("kakaoPay post............................................");
        
       kakaopay.kakaoPayReady3();
       return "kakaoPaySuccess.html";
 
    }
    
    
}