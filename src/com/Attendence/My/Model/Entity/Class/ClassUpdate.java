package com.Attendence.My.Model.Entity.Class;

public class ClassUpdate {
    private String Id;
    private String ClassId;
    private String Cname;
    private String Mtime;
    private String Atime;
    private String Desc;

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getMtime() {
        return Mtime;
    }

    public void setMtime(String mtime) {
        Mtime = mtime;
    }

    public String getAtime() {
        return Atime;
    }

    public void setAtime(String atime) {
        Atime = atime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
