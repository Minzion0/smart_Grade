package com.green.smart_grade.major;

import com.green.smart_grade.admin.major.AdminMajorMapper;
import com.green.smart_grade.admin.major.AdminMajorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({AdminMajorService.class})
class MajorServiceTest {

    @MockBean
    private AdminMajorMapper MAPPER;

    @Autowired
    private AdminMajorService SERVICE;

    @Test
    void insMajor() {
//        when(MAPPER.insMajor(any())).thenReturn(1);
//
//        MajorInsParam p = new MajorInsParam();
//        p.setMajorName("기계공학과");
//        p.setGraduationScore(100);
//
//        MajorRes res = SERVICE.insMajor(p);
//        assertEquals(1, res);
//
//        verify(MAPPER).insMajor(any());
    }
}