package com.kosmo.catpunch.service;

import java.net.URI;
import java.net.URISyntaxException;


import com.kosmo.catpunch.dto.KakaoPayApprovalVO;
import com.kosmo.catpunch.dto.KakaoPayReadyVO2;
import com.kosmo.catpunch.dto.TieSponsorshipVO;
import com.kosmo.catpunch.mapper.TieSponsorshipMapper;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
 
@Service
@Log
@RequiredArgsConstructor
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    private final TieSponsorshipMapper tieSponsorshipMapper;

    private KakaoPayReadyVO2 kakaoPayReadyVO2;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    
    public String kakaoPayReady2(String money) {
   	 
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "e9a1e19447a8a27a719c8a36f985e382");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TCSUBSCRIP");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("item_name", "결연후원");
        params.add("quantity", "1");
        params.add("total_amount", money);
        params.add("tax_free_amount", "100");
        params.add("approval_url", "http://localhost:8080/kakaoPaySuccess2");
        params.add("cancel_url", "http://localhost:8080/kakaoPayCancel");
        params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
        	kakaoPayReadyVO2 = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO2.class);
            
            log.info("" + kakaoPayReadyVO2);
            
            return kakaoPayReadyVO2.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/pay";
        
    }
    
    public KakaoPayApprovalVO kakaoPayInfo2(String pg_token) {
    	 
        log.info("KakaoPayInfoVO............................................");
        log.info("-----------------------------");
        
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "e9a1e19447a8a27a719c8a36f985e382");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
 
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TCSUBSCRIP");
        params.add("sid", kakaoPayReadyVO2.getSid());
        params.add("tid", kakaoPayReadyVO2.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("pg_token", pg_token);
        params.add("item_name", "결연후원");
        params.add("quantity", "1");
        params.add("vat_amount", "900");
        params.add("tax_free_amount", "0");
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("" + kakaoPayApprovalVO);
          
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public String kakaoPayReady3() {
   	 
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "e9a1e19447a8a27a719c8a36f985e382");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TCSUBSCRIP");
        params.add("sid", "S30714a5485350f5a7fd");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("item_name", "결연후원");
        params.add("quantity", "1");
        params.add("total_amount", "2100");
        params.add("vat_amount", "900");
        params.add("tax_free_amount", "0");
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
        	kakaoPayReadyVO2 = restTemplate.postForObject(new URI(HOST + "/v1/payment/subscription"), body, KakaoPayReadyVO2.class);
            
            log.info("" + kakaoPayReadyVO2);
            
            return kakaoPayReadyVO2.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/pay";
        
    }
    
    
    public void saveinfo(TieSponsorshipVO params) {
    	tieSponsorshipMapper.TieSponsorshipSave(params);
    }
    
    
    
}