package com.southwind.form;

import lombok.Data;

@Data
public class StudentForm {
    private Integer id;

    private String number;

    private String name;

    private String gender;

    private Integer dormitoryId;
    //老宿舍id
    private Integer oldDormitoryId;

    private String state;

    private String createDate;
}