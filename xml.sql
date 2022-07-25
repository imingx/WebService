/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-2zeu3f7e1n5yt10v0co.mysql.rds.aliyuncs.com:3306
 Source Schema         : xml

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 25/07/2022 13:57:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES (1, '数据结构');
INSERT INTO `course` VALUES (4, '数学建模');
INSERT INTO `course` VALUES (5, '经济管理');
INSERT INTO `course` VALUES (6, '线性代数2');
INSERT INTO `course` VALUES (26, '体育（5）');
INSERT INTO `course` VALUES (42, '线性代数');
INSERT INTO `course` VALUES (45, '测试课程');
INSERT INTO `course` VALUES (59, '算法');
INSERT INTO `course` VALUES (68, '算法设计2');
INSERT INTO `course` VALUES (71, 'xml和webservice');
INSERT INTO `course` VALUES (72, '计算机导论');
INSERT INTO `course` VALUES (73, '物联网');
INSERT INTO `course` VALUES (74, '假设学');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(254) DEFAULT NULL,
  `name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('123', '123456', '王五');
INSERT INTO `student` VALUES ('19373135', '123456', '田旗舰');
INSERT INTO `student` VALUES ('19373136', '123', '郭明明');
INSERT INTO `student` VALUES ('19373222', '123456', '白梧桐');
INSERT INTO `student` VALUES ('19373223', '123456', '白梧桐');
INSERT INTO `student` VALUES ('19373686', '123456', '欧阳奎');
INSERT INTO `student` VALUES ('19373888', '123456', '郭德');
INSERT INTO `student` VALUES ('19373999', '123456', '欧阳娜');
INSERT INTO `student` VALUES ('stu0', '123456', '张三');
INSERT INTO `student` VALUES ('stu1', '123', '李四');
COMMIT;

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `student_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `coursesd` (`course_id`),
  CONSTRAINT `coursesd` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
BEGIN;
INSERT INTO `student_course` VALUES ('19373135', 1);
INSERT INTO `student_course` VALUES ('19373136', 1);
INSERT INTO `student_course` VALUES ('19373686', 1);
INSERT INTO `student_course` VALUES ('stu0', 1);
INSERT INTO `student_course` VALUES ('19373135', 4);
INSERT INTO `student_course` VALUES ('19373136', 5);
INSERT INTO `student_course` VALUES ('stu0', 5);
INSERT INTO `student_course` VALUES ('19373136', 6);
INSERT INTO `student_course` VALUES ('19373136', 26);
INSERT INTO `student_course` VALUES ('19373136', 42);
INSERT INTO `student_course` VALUES ('19373136', 68);
INSERT INTO `student_course` VALUES ('19373136', 72);
INSERT INTO `student_course` VALUES ('19373136', 73);
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(254) DEFAULT NULL,
  `name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('123', '123456', '王老师');
INSERT INTO `teacher` VALUES ('t10001', '123456', '张老师');
INSERT INTO `teacher` VALUES ('t190617', '123456', '郭老师');
INSERT INTO `teacher` VALUES ('t19373135', '123456', '田老师');
INSERT INTO `teacher` VALUES ('tea0', '123', '李老师');
INSERT INTO `teacher` VALUES ('teacher01', '123456', '欧阳老师');
COMMIT;

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `teacher_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`teacher_id`,`course_id`),
  KEY `123` (`course_id`),
  CONSTRAINT `123` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
BEGIN;
INSERT INTO `teacher_course` VALUES ('teacher01', 1);
INSERT INTO `teacher_course` VALUES ('t19373135', 4);
INSERT INTO `teacher_course` VALUES ('t19373135', 5);
INSERT INTO `teacher_course` VALUES ('t19373135', 6);
INSERT INTO `teacher_course` VALUES ('teacher01', 26);
INSERT INTO `teacher_course` VALUES ('teacher01', 42);
INSERT INTO `teacher_course` VALUES ('teacher01', 45);
INSERT INTO `teacher_course` VALUES ('teacher01', 59);
INSERT INTO `teacher_course` VALUES ('t19373135', 68);
INSERT INTO `teacher_course` VALUES ('t190617', 71);
INSERT INTO `teacher_course` VALUES ('t190617', 72);
INSERT INTO `teacher_course` VALUES ('t190617', 73);
INSERT INTO `teacher_course` VALUES ('t190617', 74);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
