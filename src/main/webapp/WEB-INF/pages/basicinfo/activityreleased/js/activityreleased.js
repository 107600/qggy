$(function () {
    insertTeacherDomain("#teacherDomain");
    insertCraftsmanDomain("#craftsmanDomain")
    insertCategory(0, "#firstCategory");
    insertSecondCategory();
})

function insertSecondCategory() {
    insertCategory($("#firstCategory option:selected").val(), "#secondCategory");
}

function insertCategory(n, m) {
    $.ajax({
        url: "/qggy/basicinfo/activitydirectory/activitydirectory.action",
        type: 'get',
        data: {id:n},
        async: false,
        success: function (data) {
            var dataHtml = "";
            /*
              后台返回的data是含两个json对象的数组
              alert(data[0].id);
              alert(data[0].activityCategory);
              alert(data[1].id);
              alert(data[1].activityCategory);
            */
            $.each(
                data, function (index, obj) {
                    dataHtml += "<option value=" + obj.id + ">" + obj.activityCategory + "</option>";
                }
            );
            $(m).html(dataHtml);
        }
    })
}

//从后台读导师领域
function insertTeacherDomain(m) {
    $.ajax({
        url: "/qggy/basicinfo/teacherdomain/selectteacherdomain.action",
        type: 'get',
        async: false,
        success: function (data) {
            var dataHtml = "<option>请选择导师领域</option>";
            $.each(
                data, function (index, obj) {
                    dataHtml += "<option value=" + obj.id + ">" + obj.domainName + "</option>";
                }
            );
            $(m).html(dataHtml);
        }
    })
}

//从后台读匠人领域
function insertCraftsmanDomain(m) {
    $.ajax({
        url: "/qggy/basicinfo/craftsmandomain/selectcraftsmandomain.action",
        type: 'get',
        async: false,
        success: function (data) {
            var dataHtml = "<option>请选择匠人领域</option>";
            $.each(
                data, function (index, obj) {
                    dataHtml += "<option value=" + obj.id + ">" + obj.domainName + "</option>";
                }
            );
            $(m).html(dataHtml);
        }
    })
}

//校验表单
function checkForm(){
    var activityName =  document.getElementById("activityName").value;
    var address=document.getElementById("address").value;
    var affiliatedCompany=document.getElementById("affiliatedCompany").value;

    var isNeedTeacher=document.getElementById("isNeedTeacher").value;
    var isNeedCraftsman=document.getElementById("isNeedCraftsman").value;
    var isNeedVolunteer=document.getElementById("isNeedVolunteer").value;
    var isNeedAudience=document.getElementById("isNeedAudience").value;

    var teacherNumbers=document.getElementById("teacherNumbers").value;
    var craftsmanNumbers=document.getElementById("craftsmanNumbers").value;
    var volunteerNumbers=document.getElementById("volunteerNumbers").value;
    var audienceNumbers=document.getElementById("audienceNumbers").value;

    var teacherDeposit=document.getElementById("teacherDeposit").value;
    var craftsmanDeposit=document.getElementById("craftsmanDeposit").value;
    var volunteerDeposit=document.getElementById("volunteerDeposit").value;

    var teacherReward=document.getElementById("teacherReward").value;
    var craftsmanReward=document.getElementById("craftsmanReward").value;
    var volunteerReward=document.getElementById("volunteerReward").value;

    var traffic=document.getElementById("traffic").value;
    var image=document.getElementById("image").value;
    var activityDescribe=document.getElementById("activityDescribe").value;

    if(isNull(activityName))
    {
        alert("活动名称不能为空");
        return false;
    }
    else if(isNull(address))
    {
        alert("活动地点不能为空");
        return false;
    }
    else if(isNull(affiliatedCompany))
    {
        alert("所属单位不能为空");
        return false;
    }
    else if (false && isIllNum(teacherNumbers))
    {
        alert("导师人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanNumbers))
    {
        alert("匠人人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedVolunteer) && isIllNum(volunteerNumbers))
    {
        alert("志愿者人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedAudience) && isIllNum(audienceNumbers))
    {
        alert("观众人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedTeacher) && isIllNum(teacherDeposit))
    {
        alert("导师押金请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanDeposit))
    {
        alert("匠人押金请输入数字");
        return false;
    }
    else if (isNeed(isNeedVolunteer) && isIllNum(volunteerDeposit))
    {
        alert("志愿者押金请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(teacherReward))
    {
        alert("导师酬金请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanReward))
    {
        alert("匠人酬金请输入数字");
        return false;
    }
    else if (isNeed(isNeedVolunteer) && isIllNum(volunteerReward))
    {
        alert("志愿者酬金请输入数字");
        return false;
    }
    else if (isNull(traffic))
    {
        alert("交通不能为空");
        return false;
    }
    else if (isNull(image))
    {
        alert("请选择活动图片");
        return false;
    }
    else if (isNull(activityDescribe))
    {
        alert("活动描述不能为空");
        return false;
    }
    else return true;
}

//判断是否为空
function isNull(x){
    return ($.trim(x)=="");
}

//判断是否需要相关角色
function isNeed(x) {
    return (x != null);
}

//判断数字输入是否非法
function isIllNum(x) {
    return (isNull(x) || isNaN(x));
}
/* //提示信息
 function msg(x) {
     switch (x) {
         case 'activityName':
             alert("活动名称不能为空")
             return false;
             break;
     }
 }*/



//改变复选框的值
function changeCheckbox() {
    document.getElementById(isNeedTeacher).value = "1";
}
