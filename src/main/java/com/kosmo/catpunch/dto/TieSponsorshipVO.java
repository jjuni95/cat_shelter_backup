package com.kosmo.catpunch.dto;

import java.util.Date;

import lombok.Data;

//결연후원 DTO
//response   KakaoPayReadyVO가 request
@Data //Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor
public class TieSponsorshipVO {
	   private String aid, tid, cid, sid;
       private String amount;
       private String card_info;
       private String item_name;
       private Integer quantity, tax_free_amount;
       private Date created_at, approved_at;
       private String userid;
       private String catname;
       private int onesorregural;
       private Integer counting;
//	private String partner_order_id, partner_user_id, payment_method_type;
	

}
