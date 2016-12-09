package com.xy.action.permission;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xy.biz.StudentBiz;
import com.xy.biz.impl.StudentBizImpl;
import com.xy.entity.Student;
import com.xy.util.ExcelUtil;

public class UploadAction extends ActionSupport {
	private File excel;
	private String excelContentType;
	private String excelFileName;
	private String result;
	private StudentBiz stubiz=new StudentBizImpl();

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public File getExcel() {
		return excel;
	}


	public void setExcel(File excel) {
		this.excel = excel;
	}


	public String getExcelContentType() {
		return excelContentType;
	}


	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}


	public String getExcelFileName() {
		return excelFileName;
	}


	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}


	@Override
	public String execute() throws Exception {
		
		
		
		String path=ServletActionContext.getServletContext().getRealPath("/static/upload");
		File file=new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		System.out.println(excelFileName);
		
		FileUtils.copyFile(excel, new File(file,excelFileName));
		List<List<String>> all=ExcelUtil.readXlsx(path+"/"+excelFileName);	

		for(int i=0;i<all.size();i++){
			Student stu=new Student();
			System.out.println((int)(Double.parseDouble(all.get(i).get(0))));
			stu.setStuId((int)(Double.parseDouble(all.get(i).get(0))));
			stu.setStuName(all.get(i).get(1));
			stu.setSex(all.get(i).get(2));
			stubiz.insert(stu);
		}
		result="上传成功！";
		
		return SUCCESS;
	}
	
	public String search(){
		List<Student> students=stubiz.findAll();
		ActionContext.getContext().getSession().put("students",students);
		
		
		return "search";
	}
	
}
