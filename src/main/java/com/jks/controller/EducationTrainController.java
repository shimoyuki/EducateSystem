package com.jks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jks.entity.EducationTrain;
import com.jks.entity.Size;
import com.jks.service.EducationTrainService;
import com.jks.service.LoginService;
import com.jks.utils.ExcelUtil;


@Controller
@RequestMapping("/educationTrain")
public class EducationTrainController {
	@Autowired
	private EducationTrainService educationTrainService;
	@Autowired
	private LoginService loginService;

	/**
	 * 获取所有教师培养培训列表
	 * 
	 * @param request
	 * @return
	 */
   @RequestMapping("/getEducationTrainList")  
   public String getEducationTrainList(@RequestParam(value="pn",defaultValue="1")Integer pagenum,Model model,HttpServletRequest request){  
    
    	HttpSession session = request.getSession();
    	String level = (String) session.getAttribute("level");
    	
    	Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year= (String)param.get("year");
		String schoolName= (String)param.get("schoolName");			
		String years= (String)param.get("years");
		String schoolNames= (String)param.get("schoolNames");
		String sn= (String)param.get("sn");
		
		param.remove("year");
		param.remove("schoolName");
		param.remove("years");
		param.remove("schoolNames");			
		param.remove("sn");
		
		if(sn!=null&&sn!=""){
			session.setAttribute("sn", sn);	
		}
	
    	String admcode;
    	
    	if(level.equals("3")){	
    		if(year==null&&schoolName==null){
    		  if(schoolNames==null||schoolNames==""){    			 
    			    String city = (String) session.getAttribute("schoolname");
	    			PageHelper.startPage(pagenum,12);
	    			List<EducationTrain> educationTrain = educationTrainService.findByCity(city,years);	 
	    			PageInfo pageInfo = new PageInfo(educationTrain,5);
	    			model.addAttribute("pageInfo", pageInfo);
	    			model.addAttribute("year", years);
	    	        model.addAttribute("schoolName", schoolNames);
	    	        model.addAttribute("sn", sn);
    		  }else{	    			 
    			    admcode = schoolNames;	    			
	    			PageHelper.startPage(pagenum,12);
	    			List<EducationTrain> educationTrain = educationTrainService.getEducationTrainList(admcode,year);  
	    	    	PageInfo pageInfo = new PageInfo(educationTrain,5);
	    	        model.addAttribute("pageInfo", pageInfo);
	    	        model.addAttribute("year", years);
	    	        model.addAttribute("schoolName", schoolNames);
	    	        model.addAttribute("sn", sn);
    		  }
    		}else{
    			if(schoolName==null||schoolName==""){	    				 
    				String city = (String) session.getAttribute("schoolname");
	    			PageHelper.startPage(pagenum,12);
	    			List<EducationTrain> educationTrain = educationTrainService.findByCity(city,year);	 
	    			PageInfo pageInfo = new PageInfo(educationTrain,5);
	    			model.addAttribute("pageInfo", pageInfo);
	    			model.addAttribute("year", year);
	    	        model.addAttribute("schoolName", schoolName);
	    	        model.addAttribute("sn", sn);
    			}else{	    				
    				admcode = schoolName;	    			
	    			PageHelper.startPage(pagenum,12);
	    			List<EducationTrain> educationTrain = educationTrainService.getEducationTrainList(admcode,year);  
	    	    	PageInfo pageInfo = new PageInfo(educationTrain,5);
	    	        model.addAttribute("pageInfo", pageInfo);
	    	        model.addAttribute("year", year);
	    	        model.addAttribute("schoolName", schoolName);
	    	        model.addAttribute("sn", sn);
    			}
    		}
    	}else if(level.equals("2")){
    		 String username = (String) session.getAttribute("username");
    		 admcode = username.substring(0,username.length()-1);
    		 PageHelper.startPage(pagenum,12);
    		 List<EducationTrain> educationTrain = educationTrainService.getEducationTrainList(admcode,year);  
 	    	 PageInfo pageInfo = new PageInfo(educationTrain,5);    	    	   	    	
 	         model.addAttribute("pageInfo", pageInfo);
 	         model.addAttribute("year", year);
    	}else{
    		 admcode = (String) session.getAttribute("username");
    		 PageHelper.startPage(pagenum,12);
    		 List<EducationTrain> educationTrain = educationTrainService.getEducationTrainList(admcode,year);  
 	    	PageInfo pageInfo = new PageInfo(educationTrain,5);	    	    	   	    	
 	         model.addAttribute("pageInfo", pageInfo);
 	         model.addAttribute("year", year);
    	}	    	
      	return "/qualityAssurance/educationTrain"; 
     }
    
    /**  
     * 跳转到添加教师培养界面  
     * @param request  
     * @return  
     */  
    @RequestMapping("/toAddEducationTrain")  
    public String toAddEducationTrain(){  
        return "/qualityAssurance/educationTrainAdd";  
    }  
    
    /**  
     * 添加教师培养并重定向  
     * @param size  
     * @param request  
     * @return  
     */ 
    @RequestMapping("/saveEducationTrain")  
    @ResponseBody
    public String saveEducationTrain(EducationTrain educationTrain,Model model,HttpServletRequest request){  
    	HttpSession session = request.getSession(); 
    	String admcode = (String) session.getAttribute("username");
    	String city = (String) session.getAttribute("city");
    	educationTrain.setAdmcode(admcode);
    	educationTrain.setCity(city);
    	String result;
		Integer count=educationTrainService.checkYear(educationTrain);		
		if(count>0) {
			result = "{\"result\":\"该年份数据已存在!\"}";
		} else {
			educationTrainService.saveEducationTrain(educationTrain);
			result = "{\"result\":\"success\"}";
		}		
		return result;   		 
    } 
    
    /**  
     * 删除教师培养  
     * @param id  
     * @param request  
     * @param response  
     */ 
    @RequestMapping("/delEducationTrain")  
    public void delEducationTrain(int id,HttpServletRequest request,HttpServletResponse response){  
        String result = "{\"result\":\"error\"}";  
        if(educationTrainService.deleteEducationTrain(id)){ 
            result = "{\"result\":\"success\"}";  
        }  
        response.setContentType("application/json");  
        try {  
            PrintWriter out = response.getWriter();
            out.write(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
    
   /**  
     * 根据id查询单个教师培养
     * @param id  
     * @param request  
     * @return  
     */  
    @RequestMapping("/getEducationTrain")  
    public String getEducationTrain(int id,String detailFlag,HttpServletRequest request,Model model){  	    	
    	EducationTrain educationTrain = educationTrainService.findById(id);	    	  	
    	request.setAttribute("educationTrain", educationTrain);  
        model.addAttribute("educationTrain", educationTrain);
        model.addAttribute("detailFlag", detailFlag);
        return "/qualityAssurance/educationTrainUpd";  
    }
    
   /**  
     *修改教师培养  
     * @param size  
     * @param request  
     * @return  
     */  
    @RequestMapping("/updateEducationTrain")  
    @ResponseBody
    public String updateEducationTrain(EducationTrain educationTrain,HttpServletRequest request,Model model){  
    	String result = "{\"result\":\"success\"}";
    	if(educationTrainService.updateEducationTrain(educationTrain)){  
            educationTrain = educationTrainService.findById(educationTrain.getId());  
            request.setAttribute("educationTrain", educationTrain);  
            model.addAttribute("educationTrain", educationTrain);    
        }else{  
        	result = "{\"result\":\"error!\"}";	  
        }
		return result;  
    }
    
    /**  
     *通过审核  
     * @param id 
     * @return  
     */  
    @RequestMapping("/updateAudit")  
    public String updateAudit(int id){  
        if(educationTrainService.updateAudit(id)){   
            return "redirect:/educationTrain/getEducationTrainList";   
        }else{  
            return "/error";  
        }  
    }
    
    @RequestMapping("/download")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	HttpSession session = request.getSession();
    	String level = (String) session.getAttribute("level");
    	
    	Map<String, Object> param = WebUtils.getParametersStartingWith(request, null);
		String year= (String)param.get("year");
		String schoolName= (String)param.get("schoolName");			
		String years= (String)param.get("years");
		String schoolNames= (String)param.get("schoolNames");
		String sn= (String)param.get("sn");
		
		param.remove("year");
		param.remove("schoolName");
		param.remove("years");
		param.remove("schoolNames");			
		param.remove("sn");
		
		if(sn!=null&&sn!=""){
			session.setAttribute("sn", sn);	
		}								
	
    	String admcode = new String();
    	List<EducationTrain> educationTrain = new ArrayList<EducationTrain>();
    	
    	if(level.equals("3")){	
    		if(year==null&&schoolName==null){
    		  if(schoolNames==null||schoolNames==""){    			 
    			    String city = (String) session.getAttribute("schoolname");		    		
	    			 educationTrain = educationTrainService.findByCity(city,years);	 
    		  }else{	    			 
    			    admcode = schoolNames;	    			
	    	    	 educationTrain = educationTrainService.getEducationTrainList(admcode,years);  
    		  }
    		}else{
    			if(schoolName==null||schoolName==""){	    				 
    				String city = (String) session.getAttribute("schoolname");		    			
	    			 educationTrain = educationTrainService.findByCity(city,year);	 		    			
    			}else{	    				
    				admcode = schoolName;	    					    			
	    	    	 educationTrain = educationTrainService.getEducationTrainList(admcode,year);  		    	    	
    			}
    		}
    	}else if(level.equals("2")){
    		 String username = (String) session.getAttribute("username");
    		 admcode = username.substring(0,username.length()-1);	    		 
 	    	  educationTrain = educationTrainService.getEducationTrainList(admcode,year);  
 	    	
    	}else{
    		 admcode = (String) session.getAttribute("username");
 	    	  educationTrain = educationTrainService.getEducationTrainList(admcode,year);  	 	    	
    }
    
    String fileName = "";
	if (!"".equals(year)&&year!=null) {//对应"&year="的链接
		fileName += year;
		if (!"".equals(admcode)) {//对应"&admcode="的链接
			fileName += ("-"+loginService.getSchoolInfo(admcode).getSchoolname());
		}
	}else if (!"".equals(admcode)) {//对应"&admcode="的链接
		fileName += loginService.getSchoolInfo(admcode).getSchoolname();
	}
	fileName += "教师培养培训汇总表.xlsx";
    //设置响应头和客户端保存文件名
    response.setCharacterEncoding("utf-8");
    response.setContentType("multipart/form-data");
    response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("gbk"),"iso-8859-1"));
    try {
    	//激活下载操作
        OutputStream os = response.getOutputStream();
        ExcelUtil excelUtil = new ExcelUtil(os);
        String[] title = {"招生代码", "年份","地区","参加区县级培训专任教师数","参加区县级培训人均课时数","参加市级培训专任教师数", 
			  			  "参加市级培训人均课时数","参加省级培训专任教师数","参加省级培训人均课时数","参加国家级培训专任教师数",
			  			  "参加国家级培训人均课时数","参加国外培训专任教师数","参加国外培训人均课时数","参加境外培训专任教师数",
			  			  "参加境外培训人均课时数","教师参加学历提升获得毕业证书人数","用于教师培养培训经费占学校公用经费的比例",
			  			  "教师参加国家级教学或技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",
			  			  "教师参加省级教学或技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",
			  			  "教师参加市级教学或技能大赛人数","其中一等奖获得人数","其中二等奖获得人数","其中三等奖获得人数",};
			excelUtil.writeTitle(title);
			Iterator<EducationTrain> iteEducationTrain = educationTrain.iterator();
			while (iteEducationTrain.hasNext()) {
				EducationTrain coun = (EducationTrain) iteEducationTrain.next();
				if (coun.getAudit() == 1) {
					excelUtil.write(coun);
				}
			}
			excelUtil.close();
			
	    } catch (Exception e){
	        e.printStackTrace();
	        return;
	    }
	}
}
