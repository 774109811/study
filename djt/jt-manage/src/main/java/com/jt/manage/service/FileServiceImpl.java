package com.jt.manage.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
@Service
//文件上传
public class FileServiceImpl implements FileService {
	//成员变量不能修改 
	
	//定义图片保存地址根目录
	@Value("${image.dirPath}")//从spring容器中取数据 image.properties
	private String dirPath;
	//虚拟路径代替
	@Value("${image.urlPath}")
	private String urlPath;
	/**
	 * 1.判断是否为图片.jpg.png.gif..
	 * 2.木马.exe.jpg判断是否是恶意程序
	 * 3.为了方便图片存取,分文件存储
	 *  3.1 hash值 8位一截
	 *  3.2   按照时间格式yyyy/MM/dd
	 * 4.应该防止图片重名 UUID 
	 */
	@Override
	public PicUploadResult upLoadFile(MultipartFile uploadFile) {
		PicUploadResult result = new PicUploadResult();
		//1.获取图片信息 .jpg
		String filename = uploadFile.getOriginalFilename();
		//2将图片字符转为小写
		filename=filename.toLowerCase();
		//3.判断图片类型^开始$结束 . 任意字符 + 1个或多个字符 \\.转点   | 或
		if(!filename.matches("^.+\\.(jpg|png|gif)$")) {
			//不是图片类型
			result.setError(1);
			return result;
		}
		
		
		//4.判断文件是否是恶意程序
		try {
			//转换成图片对象 读取图片信息 
			//如果可以装就转换,转换不成就抛异常返回
			BufferedImage image=ImageIO.read(uploadFile.getInputStream());
			//高度
			int height = image.getHeight();
			//宽度
			int width = image.getWidth();
			//判断不是图片
			if(height==0||width==0) {
				result.setError(1);
				return result;
			}
			
			
			//5.图片存取,分文件存储 datePath文件名
			SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy/MM/dd");
			//datePath文件夹     把它解析成字符串2019/11/11这样的文件夹
			String datePath = DateFormat.format(new Date());
			//创建文件夹E:/jt/2019/11/11
			File dirfile = new File(dirPath+datePath);
			if(!dirfile.exists()) {
				//创建多层文件夹
				dirfile.mkdirs();
			}
			//6
			//为文件生成唯一名称UUID+后缀
			UUID randomUUID = UUID.randomUUID();
			//把它转成字符串
			String uuid = randomUUID.toString().replace("-","");
			//图片名截串  substring规则:包头不包尾
			filename.substring(filename.lastIndexOf("."));
			//生成图片名
			String realFileName=uuid+filename;
			
			//5.将文件上传"E:/jt"+yyyy/MM/dd/realFileName
			File realfile = new File(dirPath+datePath+"/"+realFileName);
			uploadFile.transferTo(realfile);	
			//封装返回值的数据
			result.setHeight(height+"");
			result.setWidth(width+"");
			String realUrlPath=urlPath+datePath+"/"+realFileName;
			result.setUrl(realUrlPath);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			result.setError(1);
			return result;
		}

	}

}
