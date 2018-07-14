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
        data: {id: n},
        async: false,
        success: function (data) {
            var dataHtml = "<option>请选择活动类别</option>";
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


//判断是否为空
function isNull(x) {
    return ($.trim(x) == "");
}
//判断是否需要相关角色
function isNeed(x) {
    return (x == 1);
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
//改变需求复选框的值
function changeCheckbox(obj) {
    obj.value = Math.abs(obj.value - 1);
}
//显示或隐藏场地
function showPlaceOrNot(x) {
    if (x == 1) {
        document.getElementById("placeProvider").style.display = "";
    } else document.getElementById("placeProvider").style.display = "none";
}
//显示或隐藏观众
function showAudienceOrNot(x) {
    if (x == 1) {
        document.getElementById("audienceNumbers").style.display = "";
    } else document.getElementById("audienceNumbers").style.display = "none";
}
//显示或隐藏志愿者
function showVolunteerOrNot(x) {
    var volunteerNumbers = document.getElementById("volunteerNumbers");
    var volunteerDeposit = document.getElementById("volunteerDeposit");
    var volunteerReward = document.getElementById("volunteerReward");
    if (x == 1) {
        volunteerNumbers.style.display = "";
        volunteerDeposit.style.display = "";
        volunteerReward.style.display = "";
    } else {
        volunteerNumbers.style.display = "none";
        volunteerDeposit.style.display = "none";
        volunteerReward.style.display = "none";
    }
}
//显示或隐藏匠人
function showCraftsmanOrNot(x) {
    var craftsmanNumbers = document.getElementById("craftsmanNumbers");
    var craftsmanDomain = document.getElementById("craftsmanDomain");
    var craftsmanDeposit = document.getElementById("craftsmanDeposit");
    var craftsmanReward = document.getElementById("craftsmanReward");
    if (x == 1) {
        craftsmanNumbers.style.display = "";
        craftsmanDomain.style.display = "";
        craftsmanDeposit.style.display = "";
        craftsmanReward.style.display = "";
    } else {
        craftsmanNumbers.style.display = "none";
        craftsmanDomain.style.display = "none";
        craftsmanDeposit.style.display = "none";
        craftsmanReward.style.display = "none";
    }
}
//显示或隐藏导师
function showTeacherOrNot(x) {
    var teacherNumbers = document.getElementById("teacherNumbers");
    var teacherDomain = document.getElementById("teacherDomain");
    var teacherDeposit = document.getElementById("teacherDeposit");
    var teacherReward = document.getElementById("teacherReward");
    if (x == 1) {
        teacherNumbers.style.display = "";
        teacherDomain.style.display = "";
        teacherDeposit.style.display = "";
        teacherReward.style.display = "";
    } else {
        teacherNumbers.style.display = "none";
        teacherDomain.style.display = "none";
        teacherDeposit.style.display = "none";
        teacherReward.style.display = "none";
    }
}