//用单纯的js来校验表单
function checkForm() {
    var activityName = document.getElementById("activityName").value;
    var address = document.getElementById("address").value;
    var firstCategory = document.getElementById("firstCategory").value;
    var secondCategory = document.getElementById("secondCategory").value;
    var affiliatedCompany = document.getElementById("affiliatedCompany").value;
    var activityDate = document.getElementById("activityDate").value;
    var isNeedTeacher = document.getElementById("isNeedTeacher").value;
    var isNeedCraftsman = document.getElementById("isNeedCraftsman").value;
    var isNeedVolunteer = document.getElementById("isNeedVolunteer").value;
    var isNeedAudience = document.getElementById("isNeedAudience").value;
    var teacherNumbers = document.getElementById("teacherNumbers").value;
    var craftsmanNumbers = document.getElementById("craftsmanNumbers").value;
    var volunteerNumbers = document.getElementById("volunteerNumbers").value;
    var audienceNumbers = document.getElementById("audienceNumbers").value;
    var teacherDomain = document.getElementById("teacherDomain").value;
    var craftsmanDomain = document.getElementById("craftsmanDomain").value;
    var teacherDeposit = document.getElementById("teacherDeposit").value;
    var craftsmanDeposit = document.getElementById("craftsmanDeposit").value;
    var volunteerDeposit = document.getElementById("volunteerDeposit").value;
    var teacherReward = document.getElementById("teacherReward").value;
    var craftsmanReward = document.getElementById("craftsmanReward").value;
    var volunteerReward = document.getElementById("volunteerReward").value;
    var isNeedPlace = document.getElementById("isNeedPlace").value;
    var placeProvider = document.getElementById("placeProvider").value;
    var traffic = document.getElementById("traffic").value;
    var image = document.getElementById("image").value;
    var activityDescribe = document.getElementById("activityDescribe").value;
    if (isNull(activityName)) {
        alert("活动名称不能为空");
        return false;
    }
    else if (firstCategory == "请选择活动类别") {
        alert("请选择活动类别");
        return false;
    }
    else if (secondCategory == "请选择活动类别") {
        alert("请选择活动类别");
        return false;
    }
    else if (isNull(address)) {
        alert("活动地点不能为空");
        return false;
    }
    else if (isNull(activityDate)) {
        alert("请选择时间");
        return false;
    }
    else if (isNull(affiliatedCompany)) {
        alert("所属单位不能为空");
        return false;
    }
    else if (isNeed(isNeedTeacher) && isIllNum(teacherNumbers)) {
        alert("导师人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanNumbers)) {
        alert("匠人人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedVolunteer) && isIllNum(volunteerNumbers)) {
        alert("志愿者人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedAudience) && isIllNum(audienceNumbers)) {
        alert("观众人数请输入数字");
        return false;
    }
    else if (isNeed(isNeedTeacher) && teacherDomain == "请选择导师领域") {
        alert("请选择导师领域");
        return false;
    }
    else if (isNeed(isNeedTeacher) && isIllNum(teacherDeposit)) {
        alert("导师押金请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && craftsmanDomain == "请选择匠人领域") {
        alert("请选择匠人领域");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanDeposit)) {
        alert("匠人押金请输入数字");
        return false;
    }
    else if (isNeed(isNeedVolunteer) && isIllNum(volunteerDeposit)) {
        alert("志愿者押金请输入数字");
        return false;
    }
    else if (isNeed(isNeedTeacher) && isIllNum(teacherReward)) {
        alert("导师酬金请输入数字");
        return false;
    }
    else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanReward)) {
        alert("匠人酬金请输入数字");
        return false;
    }
    else if (isNeed(isNeedVolunteer) && isIllNum(volunteerReward)) {
        alert("志愿者酬金请输入数字");
        return false;
    }
    else if (isNeed(isNeedPlace) && placeProvider == "请选择场地提供方") {
        alert("请选择场地提供方");
        return false;
    }
    else if (isNull(traffic)) {
        alert("交通不能为空");
        return false;
    }
    else if (isNull(image)) {
        alert("请选择活动图片");
        return false;
    }
    else if (isNull(activityDescribe)) {
        alert("活动描述不能为空");
        return false;
    }
    else return true;
}


