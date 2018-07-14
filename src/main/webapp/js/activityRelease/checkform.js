//使用vue来校验表单
const vueForm = new Vue({
    el: '#activity_release',
    data: {
        errorStyle: {
            color: 'red',
        },
        activityName: null,
        address: null,
        affiliatedCompany: null,
        activityDate: null,
        traffic: null,
        image: null,
        activityDescribe: null,
        isNeedTeacher: false,
        teacherNumbers: null,
        teacherDomain: '请选择导师领域',
        teacherDeposit: null,
        teacherReward: null,
        isNeedCraftsman: false,
        craftsmanNumbers: null,
        craftsmanDomain: '请选择匠人领域',
        craftsmanDeposit: null,
        craftsmanReward: null,
        isNeedVolunteer: false,
        volunteerNumbers: null,
        volunteerDeposit: null,
        volunteerReward: null,
        isNeedAudience:false,
        audienceNumbers:null,
        isNeedPlace:false,
        placeProvider:'请选择场地提供方',
        //错误变量
        activityNameError: null,
        addressError: null,
        affiliatedCompanyError: null,
        activityDateError: null,
        trafficError: null,
        imageError: null,
        activityDescribeError: null,
        teacherNumbersError: null,
        teacherDomainError: null,
        teacherDepositError: null,
        teacherRewardError: null,
        craftsmanNumbersError: null,
        craftsmanDomainError: null,
        craftsmanDepositError: null,
        craftsmanRewardError: null,
        volunteerNumbersError: null,
        volunteerDepositError: null,
        volunteerRewardError: null,
        audienceNumbersError:null,
        placeProviderError:null,
        firstCategoryError:null,
        secondCategoryError:null,
        error: '*必填',
        numerror: '*必填数字'
    },
    methods: {
        checkform: function (e) {
            this.activityNameError = null,
                this.addressError = null,
                this.affiliatedCompanyError = null,
                this.activityDateError = null,
                this.trafficError = null,
                this.imageError = null,
                this.activityDescribeError = null,
                this.teacherNumbersError = null,
                this.teacherDomainError = null,
                this.teacherDepositError = null,
                this.teacherRewardError = null,
                this.craftsmanNumbersError = null,
                this.craftsmanDomainError = null,
                this.craftsmanDepositError = null,
                this.craftsmanRewardError = null,
                this.volunteerNumbersError = null,
                this.volunteerDepositError = null,
                this.volunteerRewardError = null,
                this.audienceNumbersError = null,
                this.placeProviderError = null,
                this.firstCategoryError = null,
                this.secondCategoryError = null;
            if (this.activityName &&
                this.address &&
                this.affiliatedCompany &&
                this.activityDate &&
                this.traffic &&
                this.activityDescribe &&
                ((this.isNeedTeacher && !isIllNum(this.teacherNumbers)) || !this.isNeedTeacher) &&
                ((this.isNeedTeacher && this.teacherDomain != '请选择导师领域') || !this.isNeedTeacher) &&
                ((this.isNeedTeacher && !isIllNum(this.teacherDeposit)) || !this.isNeedTeacher) &&
                ((this.isNeedTeacher && (!isIllNum(this.teacherReward)) || !this.isNeedTeacher)) &&
                ((this.isNeedCraftsman && !isIllNum(this.craftsmanNumbers)) || !this.isNeedCraftsman) &&
                ((this.isNeedCraftsman && this.craftsmanDomain != '请选择匠人领域') || !this.isNeedCraftsman) &&
                ((this.isNeedCraftsman && !isIllNum(this.craftsmanDeposit)) || !this.isNeedCraftsman) &&
                ((this.isNeedCraftsman && (!isIllNum(this.craftsmanReward)) || !this.isNeedCraftsman))
                ((this.isNeedVolunteer && !isIllNum(this.volunteerNumbers)) || !this.isNeedVolunteer) &&
                ((this.isNeedVolunteer && !isIllNum(this.volunteerDeposit)) || !this.isNeedVolunteer) &&
                ((this.isNeedVolunteer && (!isIllNum(this.volunteerReward)) || !this.isNeedVolunteer))
                ((this.isNeedAudience && !isIllNum(this.audienceNumbers)) || !this.isNeedAudience) &&
                ((this.isNeedPlace && this.placeProvider !='请选择场地提供方' || !this.isNeedPlace)) &&
                this.$refs.firstCategory.value !='请选择活动类别' &&
                this.$refs.secondCategory.value !='请选择活动类别'
            ) return true;
            if (!this.activityName) this.activityNameError = this.error;
            if (!this.address) this.addressError = this.error;
            if (!this.affiliatedCompany) this.affiliatedCompanyError = this.error;
            if (!this.activityDate) this.activityDateError = this.error;
            if (!this.traffic) this.trafficError = this.error;
            if (!this.image) this.imageError = this.error;
            if (!this.activityDescribe) this.activityDescribeError = this.error;
            if (!((this.isNeedTeacher && !isIllNum(this.teacherNumbers)) || !this.isNeedTeacher)) this.teacherNumbersError = this.numerror;
            if (!((this.isNeedTeacher && this.teacherDomain != '请选择导师领域') || !this.isNeedTeacher)) this.teacherDomainError = this.error;
            if (!((this.isNeedTeacher && !isIllNum(this.teacherDeposit)) || !this.isNeedTeacher)) this.teacherDepositError = this.numerror;
            if (!((this.isNeedTeacher && !isIllNum(this.teacherReward)) || !this.isNeedTeacher)) this.teacherRewardError = this.numerror;
            if (!((this.isNeedCraftsman && !isIllNum(this.craftsmanNumbers)) || !this.isNeedCraftsman)) this.craftsmanNumbersError = this.numerror;
            if (!((this.isNeedCraftsman && this.craftsmanDomain != '请选择匠人领域') || !this.isNeedCraftsman)) this.craftsmanDomainError = this.error;
            if (!((this.isNeedCraftsman && !isIllNum(this.craftsmanDeposit)) || !this.isNeedCraftsman)) this.craftsmanDepositError = this.numerror;
            if (!((this.isNeedCraftsman && !isIllNum(this.craftsmanReward)) || !this.isNeedCraftsman)) this.craftsmanRewardError = this.numerror;
            if (!((this.isNeedVolunteer && !isIllNum(this.volunteerNumbers)) || !this.isNeedVolunteer)) this.volunteerNumbersError = this.numerror;
            if (!((this.isNeedVolunteer && !isIllNum(this.volunteerDeposit)) || !this.isNeedVolunteer)) this.volunteerDepositError = this.numerror;
            if (!((this.isNeedVolunteer && !isIllNum(this.volunteerReward)) || !this.isNeedVolunteer)) this.volunteerRewardError = this.numerror;
            if(!((this.isNeedAudience && !isIllNum(this.audienceNumbers)) || !this.isNeedAudience)) this.audienceNumbersError = this.numerror;
            if(!((this.isNeedPlace && this.placeProvider !='请选择场地提供方' || !this.isNeedPlace))) this.placeProviderError = this.error;
            if(this.$refs.firstCategory.value == '请选择活动类别') this.firstCategoryError =this.error;
            if(this.$refs.secondCategory.value == '请选择活动类别') this.secondCategoryError = this.error;
            e.preventDefault();
        },
        showError: function () {
            if (!this.isNeedTeacher) {
                this.teacherNumbers = null,
                    this.teacherDomain = "请选择导师领域",
                    this.teacherDeposit = null,
                    this.teacherReward = null,
                    this.teacherNumbersError = null,
                    this.teacherDomainError = null,
                    this.teacherDepositError = null,
                    this.teacherRewardError = null;
            }
            if (!this.isNeedCraftsman) {
                this.craftsmanNumbers = null,
                    this.craftsmanDomain = "请选择匠人领域",
                    this.craftsmanDeposit = null,
                    this.craftsmanReward = null,
                    this.craftsmanNumbersError = null,
                    this.craftsmanDomainError = null,
                    this.craftsmanDepositError = null,
                    this.craftsmanRewardError = null;
            }
            if (!this.isNeedVolunteer) {
                this.volunteerNumbers = null,
                    this.volunteerDeposit = null,
                    this.volunteerReward = null,
                    this.volunteerNumbersError = null,
                    this.volunteerDepositError = null,
                    this.volunteerRewardError = null;
            }
            if (!this.isNeedAudience) {
                this.audienceNumbers = null,
                    this.audienceNumbersError = null;
            }
            if (!this.isNeedPlace) {
                this.placeProvider = '请选择场地提供方',
                    this.placeProviderError = null;
            }
        }
    }
})

function isIllNum(x) {
    return (isNull(x) || isNaN(x));
}