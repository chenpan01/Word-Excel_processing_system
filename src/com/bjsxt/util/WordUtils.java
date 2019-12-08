package com.bjsxt.util;
import java.io.*;
import java.net.URLEncoder;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//import cn.sina.ttjava_13.database.DB;
import freemarker.template.*;
public class WordUtils {
    //配置信息,代码本身写的还是很可读的,就不过多注解了
    public  Configuration configuration = null;
    //这里注意的是利用WordUtils的类加载器动态获得模板文件的位置
    //public  String templateFolder = WordUtils.class.getClassLoader().getResource("../../").getPath() + "asserts/templete/";
   public WordUtils()
   {
	   configuration = new Configuration();
       configuration.setDefaultEncoding("utf-8");
   }
       
       
         //configuration.setDirectoryForTemplateLoading(new File(templateFolder));
       

    public  void exportMillCertificateWord(HttpServletRequest request, HttpServletResponse response, Map map) throws IOException, ServletException 
    {
    	//System.out.println("templateFolder "+templateFolder);  NationPrice  Product
    	configuration.setClassForTemplateLoading(this.getClass(), "/Template");
    	Template freemarkerTemplate = configuration.getTemplate("NationPrice.ftl");
    	
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类的createDoc方法生成Word文档
            file = this.createDoc(map,freemarkerTemplate);
            fin = new FileInputStream(file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件名
            String fileName = "国家励志奖学金申请表.doc";
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));

            out = response.getOutputStream();
            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) 
            {
                out.write(buffer, 0, bytesToRead);
            }
        } 
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        finally {
            if(fin != null) fin.close();
            if(out != null) out.close();
            if(file != null) file.delete(); // 删除临时文件
           // request.getRequestDispatcher("doc_test.jsp").forward(request, response);
        }
    }

    public  File createDoc(Map<?, ?> dataMap, Template template) throws IOException {
        String name =  "test.doc";
        File f = new File(name);
        Template t = template;
        Writer w=null;
        try 
        {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
             w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
             t.process(dataMap, w);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        finally
        {
        	w.close();
        }
        return f;
    }
}