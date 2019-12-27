package com.tedu.lucence;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class LuceneTest {
	@Test
	public void createIndex() throws Exception
	{	//创建文件夹.表示当前目录
		//1,指定文件夹保存数据
		File file=new File("./index");
		Directory directory=FSDirectory.open(file);
		//2,指定分词器
		Analyzer analyzer=new IKAnalyzer();
		//3,设置配置信息
		//查看索引工具支持4_10_2,工作中用新版本
		IndexWriterConfig config=new IndexWriterConfig
				//版本   和分词器
				(Version.LUCENE_4_10_2, analyzer);
		//4,创建写数据的对象
		IndexWriter indexWriter=
				new IndexWriter(directory, config);
		//5,创建document
		//新的名称entity,pojo,bean,vo
		//一个document以包含多个field
		//一个商品是一个document
		//这个商品包含id,title,sellpoint 三个field
		Document document=new Document();
		//6,创建field
		//添加商品 id,title,sellPoint
		Field idField=new LongField("id", 2, Store.YES);
		Field titleField=new 
				TextField("title", "BMW", Store.YES);
		Field sellPointField=new TextField
				("sellPoint", "i love you much", Store.YES);
		document.add(idField);
		document.add(titleField);
		document.add(sellPointField);
		//7,写数据,进行中文分词和倒排索引
		indexWriter.addDocument(document);
		//8,关闭资源
		indexWriter.close();
		
	}

}
