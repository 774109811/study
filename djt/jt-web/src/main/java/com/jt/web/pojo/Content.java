package com.jt.web.pojo;



import com.jt.common.po.BasePojo;


public class Content extends BasePojo{
	  private Long  id;// bigint not null auto_increment,
	  private Long categoryId;//    bigint,
	  private String title; //   varchar(200),
	  private String  subTitle;    //        varchar(100) comment '例如：价格显示',
	  private String titleDesc;     //      varchar(500),
	  private String url;   //               varchar(300),
	  private String pic;   //               varchar(300),
	  private String pic2;   //              varchar(300),
	  private String content;   //           text comment '活动页',
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getTitleDesc() {
		return titleDesc;
	}
	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	 
}
