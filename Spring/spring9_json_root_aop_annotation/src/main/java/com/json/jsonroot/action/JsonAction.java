package com.json.jsonroot.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.json.jsonroot.dao.jsonService;
import com.json.jsonroot.model.BoardVO;

@Controller
/*
 * @ResponseBody오 jackson을 이용하여 JSON 사용하기
   @ResponseBody란?
       메서드에 @ResponseBody Annotation이 되어 있으면
   return되는 값은 View를 통해서 출력되는 것이 아니라
   HTTP Response Body에 직접 쓰여지게 된다.
 *
 */
public class JsonAction {

	@Autowired
	private jsonService service;
	
	@RequestMapping(value="/start")
	public ModelAndView start() {
		ModelAndView a = new ModelAndView();
		a.setViewName("start");
		return a;
	}
	
	@RequestMapping(value="/jsontest3")
	@ResponseBody
	public Object jsonTest3() {
		List<BoardVO> li = new ArrayList<BoardVO>();
		
		try {
			//select * from products order by id
			li = service.selectall();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return li;
	}
	
	@RequestMapping(value="/jsontest2")
	@ResponseBody
	public Object jsonTest(
			@RequestParam("name") String name, 
			@RequestParam("modelnumber") String modelnumber, 
			@RequestParam("series") String series) {
		int max = 1;
		BoardVO save = new BoardVO();
		try {
			max = service.getMaxid() + 1; //service.getMaxid() : select max(id) from products
			save.setId(max);
			save.setModelnumber(modelnumber);
			save.setName(name);
			save.setSeries(series);
			service.setInsert(save);
			save = service.get_whereid(max); //select * from products where id = #{id}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return save;
	}
}
