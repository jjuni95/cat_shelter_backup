package com.kosmo.catpunch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.catpunch.common.dto.SearchDTO;
import com.kosmo.catpunch.dto.CatAdoptDTO;
import com.kosmo.catpunch.dto.CatListAdoptJoinDTO;
import com.kosmo.catpunch.paging.PagingResponse;
import com.kosmo.catpunch.service.CatAdoptService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CatAdoptController {

	final CatAdoptService catAdoptService;
//    // 게시글 작성 페이지
//    @RequestMapping("/main")
//    public String main() {
//        return "main";
//    }
//    @RequestMapping("/board")
//    public String boardlist() {
//        return "addboardpage";
//    }
//
	
    @RequestMapping("/addboard")
    public String addboard(@ModelAttribute CatAdoptDTO catAdoptDto ) {

    	catAdoptService.saveBoard(catAdoptDto);
    	
    	
        return "redirect:/boardlist";
    }
    
    
    
    @RequestMapping("/CatAdoptListPage")
    public String boardlist(@ModelAttribute("params") final SearchDTO params ,Model model) {

//    	   List<CatAdoptDTO> catAdoptDto = catAdoptService.findAllBoard();
    	PagingResponse<CatListAdoptJoinDTO> catListAdoptJoinDTO = catAdoptService.findAllBoard(params);
           model.addAttribute("catpost", catListAdoptJoinDTO);
   
        return "CatAdoptListPage";
    }
    
//    
//    @RequestMapping("/CatAdoptFilter")
//    @ResponseBody
//    public PagingResponse<CatListAdoptJoinDTO> catFilter
//  
    
    //카카오페이
    @RequestMapping("/payinfopage")
    public String addboard(@RequestParam("supportcatname") String catname , Model model) {
    	
       model.addAttribute("catname", catname);
    	
    	
        return "kakaoPay";
    }

    //

}
