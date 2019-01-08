package com.example.kin.kotlindemo.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class KUser {

    public static final String TABLE_NAME = "k_user";

    //用户ID
    public static final String ID = "id";
    @Id
    public String id;

    //用户姓名
    public static final String UNAME = "uname";
    public String uname;

    //姓名拼音
    public static final String UNAME_PINYIN = "uname_pinyin";
    public String uname_pinyin;

    //登录账户
    public static final String UACCOUNT = "uaccount";
    public String uaccount;

    //登录密码
    public static final String UPWD = "upwd";
    public String upwd;

    //角色
    public static final String ROLE_ID = "role_id";
    public String role_id;

    //电话
    public static final String TEL = "tel";
    public String tel;

    //审核类型
    public static final String AUDIT_TYPE = "audit_type";
    public String audit_type;

    //是否可用
    public static final String ENABLED = "enabled";
    public String enabled;

    //最后修改时间
    public static final String LAST_MODIFY_TIME = "last_modify_time";
    public String last_modify_time;

    //创建时间
    public static final String CREATE_TIME = "create_time";
    public String create_time;

    //备注
    public static final String REMARK = "remark";
    public String remark;

    //签名
    public static final String SIGN = "sign";
    public String sign;

    //头像
    public static final String HEADPIC = "headpic";
    public String headpic;

    //身份证
    public static final String IDCARD = "idcard";
    public String idcard;

    //性格特征
    public static final String U_CHARACTER = "u_character";
    public String u_character;

    //参加工作时间
    public static final String WORK_TIME = "work_time";
    public String work_time;

    //工作年限
    public static final String WORK_YEARS = "work_years";
    public String work_years;

    //性别
    public static final String SEX = "sex";
    public String sex;

    //企业信息ID
    public static final String COMPANY_ID = "company_id";
    public String company_id;

    //籍贯
    public static final String NATIVE_PLACE = "native_place";
    public String native_place;

    //毕业院校
    public static final String GRADUATE_SCHOOL = "graduate_school";
    public String graduate_school;

    //学历
    public static final String EDUCATION_LEVEL = "education_level";
    public String education_level;

    @Generated(hash = 381523145)
    public KUser(String id, String uname, String uname_pinyin, String uaccount,
            String upwd, String role_id, String tel, String audit_type,
            String enabled, String last_modify_time, String create_time,
            String remark, String sign, String headpic, String idcard,
            String u_character, String work_time, String work_years, String sex,
            String company_id, String native_place, String graduate_school,
            String education_level) {
        this.id = id;
        this.uname = uname;
        this.uname_pinyin = uname_pinyin;
        this.uaccount = uaccount;
        this.upwd = upwd;
        this.role_id = role_id;
        this.tel = tel;
        this.audit_type = audit_type;
        this.enabled = enabled;
        this.last_modify_time = last_modify_time;
        this.create_time = create_time;
        this.remark = remark;
        this.sign = sign;
        this.headpic = headpic;
        this.idcard = idcard;
        this.u_character = u_character;
        this.work_time = work_time;
        this.work_years = work_years;
        this.sex = sex;
        this.company_id = company_id;
        this.native_place = native_place;
        this.graduate_school = graduate_school;
        this.education_level = education_level;
    }
    @Generated(hash = 1085418315)
    public KUser() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUname() {
        return this.uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUname_pinyin() {
        return this.uname_pinyin;
    }
    public void setUname_pinyin(String uname_pinyin) {
        this.uname_pinyin = uname_pinyin;
    }
    public String getUaccount() {
        return this.uaccount;
    }
    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }
    public String getUpwd() {
        return this.upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
    public String getRole_id() {
        return this.role_id;
    }
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
    public String getTel() {
        return this.tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAudit_type() {
        return this.audit_type;
    }
    public void setAudit_type(String audit_type) {
        this.audit_type = audit_type;
    }
    public String getEnabled() {
        return this.enabled;
    }
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
    public String getLast_modify_time() {
        return this.last_modify_time;
    }
    public void setLast_modify_time(String last_modify_time) {
        this.last_modify_time = last_modify_time;
    }
    public String getCreate_time() {
        return this.create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getSign() {
        return this.sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getHeadpic() {
        return this.headpic;
    }
    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }
    public String getIdcard() {
        return this.idcard;
    }
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getU_character() {
        return this.u_character;
    }
    public void setU_character(String u_character) {
        this.u_character = u_character;
    }
    public String getWork_time() {
        return this.work_time;
    }
    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }
    public String getWork_years() {
        return this.work_years;
    }
    public void setWork_years(String work_years) {
        this.work_years = work_years;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getCompany_id() {
        return this.company_id;
    }
    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }
    public String getNative_place() {
        return this.native_place;
    }
    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }
    public String getGraduate_school() {
        return this.graduate_school;
    }
    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }
    public String getEducation_level() {
        return this.education_level;
    }
    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }
}
