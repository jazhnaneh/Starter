package com.raya.test.dto;


import io.swagger.annotations.ApiModelProperty;


public class StudentDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long studentId;

    @ApiModelProperty(required = true, hidden = false)
    private String studentName;

    @ApiModelProperty(required = true, hidden = false)
    private String studentAge;

    @ApiModelProperty(required = false, hidden = true)
    private String studentImageName;

    @ApiModelProperty(required = false, hidden = true)
    private String studentImageType;

    @ApiModelProperty(required = false, hidden = true)
    private byte[] studentImage;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentImageName() {
        return studentImageName;
    }

    public void setStudentImageName(String studentImageName) {
        this.studentImageName = studentImageName;
    }

    public String getStudentImageType() {
        return studentImageType;
    }

    public void setStudentImageType(String studentImageType) {
        this.studentImageType = studentImageType;
    }

    public byte[] getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(byte[] studentImage) {
        this.studentImage = studentImage;
    }
}
