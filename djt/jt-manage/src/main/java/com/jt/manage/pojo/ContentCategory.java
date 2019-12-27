package com.jt.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;
@Table(name="tb_content_category")
public class ContentCategory extends BasePojo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long	id;       //      bigint not null auto_increment,
	private Long  parentId ;  //  bigint comment 'ID=0，代表一级分类',
	private String  name  ; //      varchar(50),
	private Integer  status ; //    tinyint(1) comment '1正常2删除',
	private Integer   sortOrder ; //     int(4),
	private Boolean  isParent  ; //   tinyint(1) comment '1true0false',
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Boolean getIsParent() {
		return isParent ;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent  = isParent;
	}
	@Override
	public String toString() {
		return "ContentCategory [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrder=" + sortOrder + ", isParent=" + isParent + "]";
	}

}
