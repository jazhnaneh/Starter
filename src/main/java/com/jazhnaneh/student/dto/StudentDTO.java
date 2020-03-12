package com.jazhnaneh.student.dto;


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

    @ApiModelProperty(required = true, hidden = false)
    private String studentFamily;

    @ApiModelProperty(required = true, hidden = false)
    private String studentPhoneNumber;

    @ApiModelProperty(required = true, hidden = false)
    private String studentNationalCode;


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

    public String getStudentFamily() {
        return studentFamily;
    }

    public void setStudentFamily(String studentFamily) {
        this.studentFamily = studentFamily;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentNationalCode() {
        return studentNationalCode;
    }

    public void setStudentNationalCode(String studentNationalCode) {
        this.studentNationalCode = studentNationalCode;
    }
}
