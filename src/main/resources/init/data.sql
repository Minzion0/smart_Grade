INSERT INTO `admin` (`iadmin`, `admin_Id`, `admin_password`, `del_yn`, `role`) VALUES
(1, 'admin', '1234', 0, 'ROLE_ADMIN');

INSERT INTO `board` (`iboard`, `iadmin`, `ctnt`, `created_at`, `updated_at`, `importance`, `board_view`, `del_yn`, `title`) VALUES
(1, 1, '바뀌어라', '2023-07-21 16:40:22', '2023-07-21 16:40:22', 0, 1, 1, '바꼈냐?'),
(2, 1, 'ㅁㄴㅇ', '2023-07-21 16:40:39', '2023-07-21 16:40:39', 0, 0, 1, 'ㅁㄴㅇ'),
(3, 1, 'ㅁㄴㅇ', '2023-07-21 16:41:19', '2023-07-21 16:41:19', 0, 0, 0, 'ㅁㄴㅇ'),
(4, 1, '저는 맞아야해요', '2023-07-21 16:43:23', '2023-07-21 16:43:23', 0, 0, 0, '저같은 놈은 맞아야해요');





INSERT INTO `lecture_name` (`ilecture_name`, `lecture_name`, `score`, `del_yn`) VALUES
(1, '물리1', 1, 0),
(17, '물리학1', 1, 0),
(18, '수학1', 1, 0),
(19, '고급 화학', 2, 0),
(20, '화학 실험', 2, 0),
(21, '정보 과학', 3, 0),
(22, '프로그래밍', 3, 0),
(23, '융합과학탐구', 3, 0),
(24, '기하', 1, 0),
(25, '확학1', 1, 0),
(26, '확률과 통계', 1, 0),
(27, '디지털 논리 회로', 2, 0),
(28, '공학일반', 1, 0),
(29, '생활과 과학', 1, 0),
(30, '물리학실험', 1, 0);

INSERT INTO `lecture_room` (`ilecture_room`, `lecture_room_name`, `building_name`, `max_capacity`, `del_yn`) VALUES
(1, '502호', '백매관', 30, 0),
(2, '503호', '백매관', 30, 0),
(3, '504호', '백매관', 30, 0),
(4, '505호', '백매관', 30, 0),
(5, '506호', '백매관', 30, 0);





INSERT INTO `major` (`imajor`, `major_name`, `graduation_score`, `del_yn`) VALUES
(1, 'IT융합학과', 120, 0),
(2, '건축공학과', 120, 0),
(3, '게임공학과', 115, 0),
(4, '고분자공학과', 125, 0),
(5, '건축설비과', 130, 0),
(6, '광학공학과', 132, 0),
(7, '건설정보과', 125, 0),
(8, '건축과', 120, 0),
(9, '건축학과', 130, 0),
(10, '게임콘텐츠과', 120, 0),
(11, '공업화학과', 125, 0),
(12, '교양공학부', 130, 0),
(13, '교통공학과', 120, 0),
(14, '국방기술학과', 140, 0),
(15, '금형설계과', 136, 0),
(16, '기계과', 130, 0),
(17, '기계설계과', 140, 0),
(18, '냉동공조공학과', 120, 0),
(19, '국방기술과', 126, 0),
(20, '금속공학과', 130, 0),
(21, '기계공학과', 135, 0);

INSERT INTO `professor` (`iprofessor`, `imajor`, `professor_password`, `nm`, `gender`, `pic`, `birthdate`, `phone`, `email`, `address`, `created_at`, `updated_at`, `del_yn`, `role`) VALUES
(100007, 2, 'ae2c9bf215760b887504c847bf9b8dfa0e63dcb970f097e167df2695f8791fad', 'sㅇㄴㅁ', 'F', NULL, '2023-07-21', '010-123-456', 'ASD@naver.com', '아앙', '2023-07-21 16:59:53', '2023-07-21 16:59:53', 0, 'ROLE_PROFESSOR'),
(100009, 14, 'ae2c9bf215760b887504c847bf9b8dfa0e63dcb970f097e167df2695f8791fad', 'sㅇㄴㅁ', 'F', NULL, '2023-07-21', '010-123-456', 'dlsioz@naver.com', '아앙', '2023-07-21 17:00:13', '2023-07-21 17:00:13', 0, 'ROLE_PROFESSOR'),
(100011, 21, 'ae2c9bf215760b887504c847bf9b8dfa0e63dcb970f097e167df2695f8791fad', '배성현', 'F', NULL, '2023-07-21', '010-4567-4561', 'zlal@naver.com', '마마아', '2023-07-21 17:00:47', '2023-07-21 17:00:47', 0, 'ROLE_PROFESSOR'),
(100021, 4, 'ae2c9bf215760b887504c847bf9b8dfa0e63dcb970f097e167df2695f8791fad', '배성현', 'F', NULL, '2023-07-21', '010-4567-4561', 'qwedfucv@nate.com', '마마아', '2023-07-21 17:05:22', '2023-07-21 17:05:22', 0, 'ROLE_PROFESSOR');

INSERT INTO `semester` (`isemester`, `year`, `semester`, `semester_str_date`, `semester_end_date`, `del_yn`) VALUES
(20, '2023', 1, '2023-03-02', '2023-06-30', 0),
(21, '2023', 2, '2023-08-12', '2023-12-24', 0);

INSERT INTO `student` (`istudent`, `student_num`, `student_password`, `imajor`, `grade`, `nm`, `gender`, `pic`, `birthdate`, `phone`, `email`, `address`, `finished_yn`, `created_at`, `updated_at`, `del_yn`, `role`) VALUES
(1, '23100001', '20230721', 10, 3, '재경킴', 'F', NULL, '2023-07-21', '010-2120-3636', 'aert1234@naver.com', '대구시어쩌고저쩌고', 1, '2023-07-21 17:00:14', '2023-07-21 17:00:14', 0, 'ROLE_STUDENT'),
(3, '23100002', 'ea0a97b661aee91b3b11cb37895fa8354edcd7a07c19d725c4d7309f11891194', 2, 1, '지녹제', 'F', NULL, '2023-07-21', '010-2120-3636', 'aert12341@naver.com', '대구시어쩌고저쩌고', 1, '2023-07-21 17:03:42', '2023-07-21 17:03:42', 0, 'ROLE_STUDENT'),
(4, '2310003', 'ea0a97b661aee91b3b11cb37895fa8354edcd7a07c19d725c4d7309f11891194', 3, 1, '지코바', 'F', NULL, '2023-07-21', '010-2120-3636', 'aert11@naver.com', '대구시어쩌고저쩌고', 1, '2023-07-21 17:06:01', '2023-07-21 17:06:01', 0, 'ROLE_STUDENT'),
(6, '2310004', 'ea0a97b661aee91b3b11cb37895fa8354edcd7a07c19d725c4d7309f11891194', 4, 1, '지코바', 'F', NULL, '2023-07-21', '010-2120-3636', 'aert1142@naver.com', '대구시어쩌고저쩌고', 1, '2023-07-21 17:08:55', '2023-07-21 17:08:55', 0, 'ROLE_STUDENT');

INSERT INTO `student_semester_score` (`istudent`, `isemester`, `score`, `grade`, `del_yn`, `avg_score`, `rating`) VALUES
(1, 20, 21, 3, 0, 38, 4.5),
(1, 21, 16, 1, 0, 38, 2.6),
(3, 20, 21, 1, 0, 90, 4.2),
(3, 21, 15, 1, 0, 65, 3.1),
(4, 20, 16, 1, 0, 60, 3.1),
(4, 21, 21, 1, 0, 88, 4.1),
(6, 20, 23, 1, 0, 80, 3.9),
(6, 21, 23, 1, 0, 88, 4.1);

INSERT INTO `lecture_applly` (`ilecture`, `ilecture_name`, `ilecture_room`, `iprofessor`, `isemester`, `opening_procedures`, `lecture_str_date`, `lecture_end_date`, `lecture_str_time`, `lecture_end_time`, `attendance`, `midterm_examination`, `final_examination`, `lecture_max_people`, `grade_limit`, `del_yn`, `created_at`) VALUES

(5, 17, 2, 100007, 21, 2, '2023-03-04', '2023-06-30', '10:00:00', '11:00:00', 20, 40, 40, 30, 1, 0, '2023-07-24 16:37:26'),
(6, 18, 1, 100021, 21, 1, '2023-03-04', '2023-06-30', '10:00:00', '11:00:00', 20, 40, 40, 30, 1, 0, '2023-07-24 16:38:03'),
(7, 20, 1, 100009, 20, 3, '2023-03-04', '2023-06-30', '10:00:00', '11:00:00', 20, 40, 40, 30, 1, 0, '2023-07-24 16:38:03'),
(8, 30, 1, 100011, 21, 1, '2023-03-04', '2023-06-30', '10:00:00', '11:00:00', 20, 40, 40, 30, 1, 0, '2023-07-24 16:38:03');


INSERT INTO `lecture_day_week` (`ilecture`, `day_week`, `del_yn`) VALUES
(5, 5, 0),
(5, 3, 0),
(5, 2, 0),
(7, 1, 0),
(8, 5, 0),
(8, 6, 0);

INSERT INTO `leture_condition` (`ilecture`, `return_ctnt`, `return_date`, `del_yn`) VALUES
(5, '진짜수업 개별로', '2023-07-24 18:21:11', 0),
(6, 'string', '2023-07-24 18:17:50', 0),
(7, '반려', '2023-07-24 17:03:55', 0),
(8, '개별로임', '2023-07-24 18:03:36', 0);

INSERT INTO `lecture_student` (`ilecture_student`, `istudent`, `ilecture`, `finished_yn`, `attendance`, `midterm_examination`, `final_examination`, `total_score`, `created_at`, `update_at`, `finished_at`, `correction_at`, `del_yn`) VALUES
(1, 1, 5, 1, 20, 30, 30, 80, '2023-07-24 16:46:29', '2023-07-28 18:06:08', '2023-07-24', '2023-08-11 12:39:14', 0),
(2, 3, 5, 1, 10, 10, 10, 30, '2023-07-24 16:47:03', '2023-07-27 21:37:30', '2023-07-25', '2023-08-10 21:37:30', 0),
(3, 4, 7, 1, 20, 25, 35, 80, '2023-07-24 16:47:14', '2023-07-24 16:47:14', NULL, NULL, 0),
(4, 6, 7, 1, 10, 10, 10, 30, '2023-07-24 16:47:14', '2023-07-26 17:02:15', NULL, NULL, 0),
(5, 6, 8, 1, 20, 20, 15, 55, '2023-07-24 16:47:15', '2023-07-24 16:47:15', NULL, NULL, 0),
(6, 4, 8, 1, 20, 25, 10, 55, '2023-07-24 16:47:15', '2023-07-24 16:47:15', NULL, NULL, 0);
