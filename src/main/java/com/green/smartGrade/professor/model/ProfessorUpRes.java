package com.green.smartGrade.professor.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfessorUpRes {
    private Long iprofessor;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime updatedAt;


    public ProfessorUpRes(ProfessorUpDto dto) {
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.iprofessor= dto.getIprofessor();
        this.updatedAt = LocalDateTime.now();
    }


}

