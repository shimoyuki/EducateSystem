<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="utf-8"%> 
<%
String path = request.getContextPath();  
String basePath = request.getScheme() + "://"  
        + request.getServerName() + ":" + request.getServerPort()  
        + path + "/"; 
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>操作说明</title>
 <base href="<%=basePath%>">
</head>
<body> 
 	<%
   out.clear();
   out = pageContext.pushBody();
   response.setContentType("application/pdf");

   try {
    String strPdfPath = new String("D://Education//upload//四川省中等职业教育年度质量保证数据采集系统操作说明.pdf");
    //判断该路径下的文件是否存在
    File file = new File(strPdfPath);
    if (file.exists()) {
     DataOutputStream temps = new DataOutputStream(response
       .getOutputStream());
     DataInputStream in = new DataInputStream(
       new FileInputStream(strPdfPath));

     byte[] b = new byte[2048];
     while ((in.read(b)) != -1) {
      temps.write(b);
      temps.flush();
     }

     in.close();
     temps.close();
    } else {
     out.print(strPdfPath + " 文件不存在!");
    }

   } catch (Exception e) {
    out.println(e.getMessage());
   }
%>
</body>
</html>