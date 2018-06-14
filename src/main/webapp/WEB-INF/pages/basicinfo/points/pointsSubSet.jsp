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
            <td colspan="2" class="modelTitle">我的积分--加积分</td>
        </tr>
    </table>

    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">加积分的设定</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                   
                    <tbody class="tableBody">

                        <tr class="odd">
	                        <td><p align="center">教师未签到减<input type="text" align="right" width="10"/>信用积分</p></td>
	                        <td><p align="center"><input type="text" value="请输入修改的积分数值" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style ="#999;"/>分</p></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td><button>确定</button></td>
	                    </tr>
                        
                        <tr class="odd">
	                        <td><p align="center">匠人未签到减<input type="text" align="right" width="10"/>信用积分</p></td>
	                        <td><p align="center"><input type="text" value="请输入修改的积分数值" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style ="#999;"/>分</p></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td><button>确定</button></td>
	                    </tr>
	                    
                       
                       <tr class="odd">
	                        <td><p align="center">志愿者未签到减<input type="text" align="right" width="10"/>信用积分</p></td>
	                        <td><p align="center"><input type="text" value="请输入修改的积分数值" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style ="#999;"/>分</p></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td><button>确定</button></td>
	                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</form>
</body>
<script type="text/javascript" src="js/pointsAddSet.js">
</html>