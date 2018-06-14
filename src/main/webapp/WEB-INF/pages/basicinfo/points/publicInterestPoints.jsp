<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>积分管理</title>
	<link rel="stylesheet" rev="stylesheet" type="text/css"
      href="css/extreme/extremecomponents.css"/>
	<link rel="stylesheet" rev="stylesheet" type="text/css"
      href="css/extreme/extremesite.css"/>
	<link rel="stylesheet" rev="stylesheet" type="text/css"
      href="css/viewdetail.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
      href="css/default.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="css/main.css" media="all"/>
           <meta charset="utf-8">
        

<style>
	.odd{
		   border-top: 1px solid #b7dad6;
		    border-bottom: 1px solid #c1e1dd;
		    color: #00554a;
		    font-family: verdana, arial, helvetica, sans-serif;
		    font-size: 9pt;
		    font-weight: bold;
		    text-align: left;
		    padding: 6px;
		    margin: 0px;
	
}
</style>
</head>

<body>
<form name="icform" method="post">
    <table class="modelTable" cellspacing="1">
        <tr>
            <td colspan="2" class="modelTitle">公益积分</td>
        </tr>
    </table>

    <div class="textbox-header">
        <div class="textbox-inner-header">

            <div class="textbox-title">
                                                 用户ID:<input type="text" name="likes" id="likes" value="${likes}">
                                                 用户名:<input type="text" name="likes" id="likes" value="${likes}">
                                                 时    间:<input type="text" name="likes" id="likes" value="${likes}">
                         —— <input type="text" name="likes" id="likes" value="${likes}">
                <button href="#" onclick="formSubmit('list.action','_self');">查询</button>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">积分列表</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid"
                        ></td>
                        <td class="tableHeader" align="center">序号</td>
                        <td class="tableHeader" align="center">用户ID</td>
                        <td class="tableHeader" align="center">用户名</td>
                        <td class="tableHeader" align="center">积分明细</td>
                        <td class="tableHeader" align="center">积分类型</td>
                        <td class="tableHeader" align="center">会员积分</td>
                        <td class="tableHeader" align="center">积分操作</td>
                        <td class="tableHeader" align="center">时间</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                        <tr class="odd">
	                        <td><input type="checkbox"/></td>
	                        <td>1</td>
	                        <td>001</td>
	                        <td>Jane</td>
	                        <td>抢单</td>
	                        <td>公益积分</td>
	                        <td>50</td>
	                        <td>加分</td>
	                        <td>2018.05.03</td>
                        </tr>
                        
                         <tr class="odd">
	                        <td><input type="checkbox"/></td>
	                        <td>2</td>
	                        <td>001</td>
	                        <td>Jane</td>
	                        <td>购买课程</td>
	                        <td>公益积分</td>
	                        <td>50</td>
	                        <td>加分</td>
	                        <td>2018.05.03</td>
                        </tr>
                        
                        
                         <tr class="odd">
	                        <td><input type="checkbox"/></td>
	                        <td>3</td>
	                        <td>001</td>
	                        <td>Jane</td>
	                        <td>抢单</td>
	                        <td>公益积分</td>
	                        <td>50</td>
	                        <td>加分</td>
	                        <td>2018.05.03</td>
                        </tr>
                        
                         <tr class="odd">
	                        <td><input type="checkbox"/></td>
	                        <td>4</td>
	                        <td>001</td>
	                        <td>Jane</td>
	                        <td>购买课程</td>
	                        <td>公益积分</td>
	                        <td>50</td>
	                        <td>加分</td>
	                        <td>2018.05.03</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>


</form>
</body>
</html>