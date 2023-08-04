package com.green.smartGrade.student;

import com.green.smartGrade.admin.board.model.BoardUpdRes;
import com.green.smartGrade.professor.model.SelProfessorRes;
import com.green.smartGrade.student.model.*;
import com.green.smartGrade.utils.FileUtils;
import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentMapper mapper;
    @Value("${file.dir}")
    private String fileDir;


    public StudentInsRes inslecture(StudentParam param) {
        StudentInsDto dto = new StudentInsDto();

        dto.setIstudent(param.getIstudent());
        dto.setIlecture(param.getIlecture());
        dto.setFinishedYn(param.getFinishedYn());

        int result = mapper.insSdy(dto);
        if (result == 1) {
            StudentInsRes res = new StudentInsRes(dto);
            return res;
        }
        return null;
    }


    public StudentSelRes selAllSdy(StudentSelDto dto,int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page,maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setStudentNum(dto.getStudentNum());
        dto.setRow(utils.getROW());

        List<StudentSelVo> list = mapper.selAllSdy(dto);
        for (StudentSelVo  vo  :  list ) {
            GradeUtils gradeUtils = new GradeUtils(vo.getTotalScore());
            double score = gradeUtils.totalScore();
            String rating = gradeUtils.totalRating(score);
            vo.setRating(rating);
        }
        return StudentSelRes.builder()
                .list(list)
                .page(utils)
                .build();

    }

    public StudentSelProfileRes selStudentProfile(StudentSelProfileDto dto,int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page,maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setStudentNum(dto.getStudentNum());
        dto.setRow(utils.getROW());
        List<StudentSelProfileVo> list = mapper.selStudentProfile(dto);

        return StudentSelProfileRes.builder().list(list).page(utils).build();
    }

    public StudentSelPointRes selStudentRemainingPoint(StudentSelPointDto dto, int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page, maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setRow(utils.getROW());
        dto.setStudentNum(dto.getStudentNum());
        List<StudentSelPointVo> list = mapper.selStudentRemainingPoint(dto);

        return StudentSelPointRes.builder().list(list).page(utils).build();
    }

    public StudentUpRes upStudent(MultipartFile pic, StudentUpParam param) {
        StudentUpdto dto = new StudentUpdto();
        dto.setAddress(param.getAddress());
        dto.setPhone(param.getPhone());
        dto.setEmail(param.getEmail());
        dto.setStudentNum(param.getStudentNum());
        int result = 0;


         result = mapper.upStudent(dto);
        if (result == 1) {
            if (pic != null) {
                String centerPath = String.format("student/%d", param.getStudentNum());
                String dicPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath);
                String temp = "0";

                File dic = new File(dicPath);
                if(!dic.exists()) {
                    dic.mkdirs();
                }

                String originFileName = pic.getOriginalFilename();
                String savedFileName = FileUtils.makeRandomFileNm(originFileName);
                String savedFilePath = String.format("%s/%s", centerPath, savedFileName);
                String targetPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), savedFilePath);

                File target = new File(targetPath);

                try {
                    pic.transferTo(target);
                } catch (IOException e) {
                    throw new RuntimeException(temp);
                }
                  dto.setPic(savedFileName);
                try {
                    result = mapper.upStudent(dto);
                    if (result == Integer.parseInt(temp)) {
                        throw new Exception("사진 등록 불가");
                    }
                } catch (Exception e) {
                    target.delete();
                }
            }

            StudentUpRes res = new StudentUpRes(dto);
            return res;
        }
        return null;

    }



}
