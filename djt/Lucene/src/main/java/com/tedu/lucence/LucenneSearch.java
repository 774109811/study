package com.tedu.lucence;

import java.io.File;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
//测试
public class LucenneSearch {
	@Test
	public void search()throws Exception {
		//1,指定文件夹
		Directory directory=
				FSDirectory.open(new File("./index"));
		//2,创建读对象
		IndexReader indexReader=IndexReader.open(directory);
		//3,创建查询对象
		IndexSearcher indexSearcher=
				new IndexSearcher(indexReader);
		//4,指定查询的关键字
		Query query=
				new TermQuery(new Term("sellPoint","love"));
		//5,执行查询
		//根据score 排序返回顶部的20个数据document
		TopDocs topDocs=indexSearcher.search(query, 20);
		//6,遍历结果
		//scoreDoc是一个包含score属性的doucument
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			//得到下标
			int index=scoreDoc.doc;
			//查找doucument元素
			Document document=indexSearcher.doc(index);
			//获取对象
			System.out.println("标题"+document.getField("title"));
			//获取标题
			System.out.println("标题"+document.get("title"));
			
		}
		//7,关闭资源
	}
}
