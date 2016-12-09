package com.xy.util;

import java.util.List;

public class PageUtil<T> {

		private Integer page=1;
		private Integer rows=5;
		private List<T> data;
		private Integer totalRecords;
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {

			this.page = page;
		}
		public Integer getRows() {
			return rows;
		}
		public void setRows(Integer rows) {
			this.rows = rows;
		}
		public List<T> getData() {
			return data;
		}
		public void setData(List<T> data) {
			this.data = data;
		}
		public Integer getTotalRecords() {
			return totalRecords;
		}
		public void setTotalRecords(Integer totalRecords) {
			this.totalRecords = totalRecords;
		}
		
		public int getTotalPages(){
			return (int)Math.ceil(this.getTotalRecords()*1.0/this.rows);
		}
		public int getBegin(){
			return (this.page-1)*this.rows;
		}
		public int getEnd(){
			return this.rows;
		}
		
		public int getPrev(){
			if(this.page-1>=1){
				return this.page-1;
			}
			return 1;
		}
		
		public int getNext(){
			if(this.page+1<=this.getTotalPages()){
				return this.page+1;
			}
			return this.getTotalPages();
		}
		
		//生成分页导航条
		public String getCreateNavigatePost(){
				StringBuffer str=new StringBuffer();
				if(this.getTotalRecords()==0){
					str.append("<div class=\"navbarinfo clearfix\">  \n");
					 str.append("查询不到数据!");			
					str.append("</div>");
					return str.toString();
				}
				if(this.getTotalPages()<page){
					this.page=1;
				
				}
				int [] arr={1,5,10,20,25,30,50,100};

				str.append("<div class=\"navbarinfo clearfix\">  \n");

				str.append("   <div class=\"col-width-20 showtips\"> \n");
				str.append("           第" + this.page + "页/共" + this.getTotalPages()
						+ "页  每页<select id=\"rows\" name=\"rows\">  \n");
				for (int a : arr) {

					if (this.rows == a) {
						str.append("     <option selected   value=\"" + a + "\">" + a
								+ "</option>  \n");
					} else {
						str.append("     <option  value=\"" + a + "\">" + a
								+ "</option>  \n");
					}
				}

				str.append("</select>");
				str.append("笔/共" + this.totalRecords + "笔");
				str.append("  <input  type='hidden'  id='page' name='page' value='"+this.page+"' />  ");
				
				str.append("   </div>\n");
				if(this.getTotalPages()>1){
					 
					// 计算页码
					str.append(" <div class=\"col-width-80\"> \n ");

					str.append("    <ul class=\"pagination-sm pagination\" id=\"mypage\"> \n");
					if(this.page>1){
						//判断是否显示首页与上一页
						str.append("  <li class=\"first\"  > \n");
						str.append("        <a data-page=\"1\" href=\"javascript:void(0);\">首页</a>  \n");
						str.append("    </li>  \n");

						str.append("    <li class=\"prev\"  >  \n");
						str.append("        <a data-page=\"" + this.getPrev()
								+ "\" href=\"javascript:void(0);\">上一页</a>  \n");
						str.append("    </li>  \n");

					}
					int start=0;
					int end=0;
					int middle=5;
					if(this.page>5){
						middle=this.page;
					}
					start=middle-4;
					end=middle+5;
					if(end>this.getTotalPages()){
						end=this.getTotalPages();
					}
					start=end-9;
					if(start<=0){
						start=1;
					}
					for(int i=start;i<=end;i++){
						if(this.page==i){
							str.append(" <li class=\"page active\"  > \n");
							str.append("           <a   href=\"javascript:void(0);\">"+i+"</a> \n");
							str.append("  </li> \n");
						}else{
							str.append(" <li class=\"page \"  > \n");
							str.append("           <a data-page=\""+i+"\" href=\"javascript:void(0);\">"+i+"</a> \n");
							str.append("  </li> \n");
						}
					}
					if(this.page<this.getTotalPages()){
						str.append(" <li>  \n");
						str.append("   <a data-page=\"" + this.getNext() + "\"  href=\"javascript:void(0);\">下一页</a>   \n");
						str.append("</li>   \n");

						str.append(" <li class=\"last\"  > \n");
						str.append("     <a data-page=\"" + this.getTotalPages() + "\" href=\"javascript:void(0);\">尾页</a>  \n");
						str.append("</li>  \n");
					}

					str.append(" </ul> \n");
					str.append(" </div> \n");
				}

				str.append("</div> \n");

				return str.toString();

		}
}
