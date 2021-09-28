/*
 Navicat Premium Data Transfer2

 Source Server         : 172.51.216.118
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 172.51.216.118:3306
 Source Schema         : assetscatalogue

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 19/08/2021 14:53:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bi_portal
-- ----------------------------
DROP TABLE IF EXISTS `bi_portal`;
CREATE TABLE `bi_portal`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `assets_id` int(11) NULL DEFAULT NULL COMMENT '资产ID',
  `assets_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编号',
  `assets_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产名称',
  `assets_alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产别名',
  `first_parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '一级目录',
  `second_parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二级目录',
  `third_parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '三级目录',
  `data_size` decimal(65, 3) NULL DEFAULT NULL COMMENT '数据大小',
  `visits` int(11) NULL DEFAULT NULL COMMENT '访问量',
  `columns` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '数据量',
  `update_cycle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新周期',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `extra` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拓展字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '门户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bi_portal
-- ----------------------------
INSERT INTO `bi_portal` VALUES (1, 1, '1', 'marketingPromotion', '市场宣传', '内部管理网', 'TDA', '市场信息库', 30000.000, 3, 31, '1', '2021-07-27 09:26:56', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (2, 2, '2', 'adminArchives', '行政档案', '内部管理网', 'TDA', '支持信息库', 0.000, 2, 0, '2', '2021-07-27 09:27:30', '2021-08-06 16:10:34', NULL);
INSERT INTO `bi_portal` VALUES (3, 3, '3', 'TrainBasicStatus', '列车基本状态', '安全生产网', 'ATS', '行车信息', 0.000, 20, 0, '1', '2021-07-27 09:28:26', '2021-08-05 16:08:33', NULL);
INSERT INTO `bi_portal` VALUES (4, 4, '4', 'TrainRunStatus', '列车运行状态', '安全生产网', 'ATS', '列车服务信息', 0.000, 2, 0, '1', '2021-07-27 09:28:53', '2021-08-05 16:08:34', NULL);
INSERT INTO `bi_portal` VALUES (5, 5, '5', 'ConsumeTradRecord', '资产消费记录', '安全生产网', 'AFC', '票务信息', 0.000, 3, 0, '2', '2021-07-27 09:30:51', '2021-08-05 16:08:35', NULL);
INSERT INTO `bi_portal` VALUES (6, 6, '6', 'technicalExchange', '技术交流', '内部管理网', 'TDA', '市场信息库', 369000.000, 5, 378, '3', '2021-07-27 09:26:56', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (7, 7, '7', 'IntradayPlanIntradayPlan', '计划运行图', '安全生产网', 'ATS', '运行图信息', 0.000, 10, 0, '1', '2021-08-04 09:22:09', '2021-08-05 16:08:35', NULL);
INSERT INTO `bi_portal` VALUES (8, 8, '8', 'ActualRun', '实际运行图', '安全生产网', 'ATS', '列车服务信息', 0.000, 6, 0, '1', '2021-08-04 09:26:18', '2021-08-05 16:08:36', NULL);
INSERT INTO `bi_portal` VALUES (9, 9, '9', 'SignalStatus', '信号机状态', '安全生产网', 'ATS', 'BDMS信息', 0.000, 5, 0, '1', '2021-08-04 09:27:15', '2021-08-05 16:08:36', NULL);
INSERT INTO `bi_portal` VALUES (10, 10, '10', 'SectionStatus', '区段状态', '安全生产网', 'ATS', '运行图信息', 0.000, 64, 0, '1', '2021-08-04 09:29:38', '2021-08-05 16:08:37', NULL);
INSERT INTO `bi_portal` VALUES (11, 11, '11', 'SwitchStatus', '道岔状态', '安全生产网', 'ATS', '运行图信息', 0.000, 48, 0, '1', '2021-08-04 09:30:35', '2021-08-05 16:08:37', NULL);
INSERT INTO `bi_portal` VALUES (12, 12, '12', 'DoorStatus', '实际运行图', '安全生产网', 'ATS', '运行图信息', 0.000, 39, 0, '1', '2021-08-04 09:31:27', '2021-08-05 16:08:38', NULL);
INSERT INTO `bi_portal` VALUES (13, 13, '13', 'ConsumeTradRecord', '资产消费记录', '安全生产网', 'AFC', '票务信息', 0.000, 4, 0, '1', '2021-08-04 09:54:25', '2021-08-05 16:08:39', NULL);
INSERT INTO `bi_portal` VALUES (14, 14, '14', 'TicketStatistics', '设备内车票统计', '安全生产网', 'AFC', '票务信息', 0.000, 9, 0, '1', '2021-08-04 09:57:12', '2021-08-05 16:08:40', NULL);
INSERT INTO `bi_portal` VALUES (15, 15, '15', 'TicketInventoryInfo', '车站车票库存监视', '安全生产网', 'AFC', '票务信息', 0.000, 167, 0, '1', '2021-08-04 09:58:11', '2021-08-05 16:08:41', NULL);
INSERT INTO `bi_portal` VALUES (16, 16, '16', 'TicketAllocate', '车站票卡调配信息', '安全生产网', 'AFC', '票务信息', 0.000, 84, 0, '1', '2021-08-04 09:58:44', '2021-08-05 16:08:42', NULL);
INSERT INTO `bi_portal` VALUES (17, 17, '17', 'TicketBoxInfo', '票箱管理信息', '安全生产网', 'AFC', '票务信息', 0.000, 38, 0, '1', '2021-08-04 09:59:29', '2021-08-05 16:08:44', NULL);
INSERT INTO `bi_portal` VALUES (18, 18, '18', 'MoneyBoxInfo', '钱箱管理信息', '安全生产网', 'AFC', '票务信息', 0.000, 2, 0, '1', '2021-08-04 10:03:08', '2021-08-05 16:08:44', NULL);
INSERT INTO `bi_portal` VALUES (19, 19, '19', 'TransferPassenger', '换乘客流', '安全生产网', 'AFC', '客流信息', 0.000, 48, 0, '1', '2021-08-04 10:03:51', '2021-08-05 16:08:45', NULL);
INSERT INTO `bi_portal` VALUES (20, 20, '20', 'PettyCashInfo', '备用金管理', '安全生产网', 'AFC', '票务信息', 0.000, 37, 0, '1', '2021-08-04 10:04:52', '2021-08-05 16:08:45', NULL);
INSERT INTO `bi_portal` VALUES (21, 21, '21', 'brandExhibition', '品牌类展会', '内部管理网', 'TDA', '市场信息库', 0.000, 0, 0, '1', '2021-08-05 11:27:02', '2021-08-05 14:17:31', NULL);
INSERT INTO `bi_portal` VALUES (22, 22, '22', 'regionalBusinessManagement', '区域业务管理', '内部管理网', 'TDA', '市场信息库', 0.000, 0, 0, '1', '2021-08-05 11:27:02', '2021-08-05 14:17:33', NULL);
INSERT INTO `bi_portal` VALUES (23, 23, '23', 'regionalBusinessNeeds', '区域业务需求', '内部管理网', 'TDA', '市场信息库', 0.000, 0, 0, '1', '2021-08-05 11:27:02', '2021-08-05 14:17:35', NULL);
INSERT INTO `bi_portal` VALUES (24, 24, '24', 'patent', '专利', '内部管理网', 'TDA', '前沿信息库', 0.000, 0, 0, '1', '2021-08-05 11:39:13', '2021-08-05 14:17:38', NULL);
INSERT INTO `bi_portal` VALUES (25, 25, '25', 'technicalReport', '技术报告', '内部管理网', 'TDA', '前沿信息库', 7000.000, 25, 7, '1', '2021-08-05 11:39:13', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (26, 26, '26', 'regularDocuments', '白皮书', '内部管理网', 'TDA', '前沿信息库', 16000.000, 17, 16, '1', '2021-08-05 11:39:13', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (27, 27, '27', 'industryInformation', '行业资讯', '内部管理网', 'TDA', '前沿信息库', 673000.000, 59, 689, '1', '2021-08-05 11:39:13', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (28, 28, '28', 'technologyTrends', '技术动态', '内部管理网', 'TDA', '前沿信息库', 47000.000, 46, 48, '1', '2021-08-05 11:39:13', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (29, 29, '29', 'policyAnalyzing', '政策解读', '内部管理网', 'TDA', '前沿信息库', 32000.000, 35, 33, '1', '2021-08-05 11:39:13', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (30, 30, '30', 'biddingAndContractNegotiationInfo', '投标、合同谈判信息', '内部管理网', 'TDA', '项目信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:17:28', NULL);
INSERT INTO `bi_portal` VALUES (31, 31, '31', 'scientificResearchProjectInfo', '科研项目信息', '内部管理网', 'TDA', '项目信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:18:55', NULL);
INSERT INTO `bi_portal` VALUES (32, 32, '32', 'rdProjectInfo', '研发项目信息', '内部管理网', 'TDA', '项目信息库', 399210000.000, 3452, 408791, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (33, 33, '33', 'projectInfo', '工程项目信息', '内部管理网', 'TDA', '项目信息库', 107955000.000, 5231, 110546, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (34, 34, '34', 'maintenanceProjectInfo', '维保项目信息', '内部管理网', 'TDA', '项目信息库', 9000.000, 76, 9, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (35, 35, '35', 'conferenceInfo', '会议信息', '内部管理网', 'TDA', '项目信息库', 675000.000, 76, 691, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (36, 36, '36', 'faultInfo', '故障信息', '内部管理网', 'TDA', '项目信息库', 0.000, 239, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:25:06', NULL);
INSERT INTO `bi_portal` VALUES (37, 37, '37', 'customerFeedback', '客户反馈信息', '内部管理网', 'TDA', '项目信息库', 14000.000, 432, 14, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (38, 38, '38', 'reportAnalysis', '报表中心', '内部管理网', 'TDA', '项目信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:27:52', NULL);
INSERT INTO `bi_portal` VALUES (39, 39, '39', 'supplierInfo', '供方信息', '内部管理网', 'TDA', '供应链信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:31:43', NULL);
INSERT INTO `bi_portal` VALUES (40, 40, '40', 'productionInfo', '生产信息', '内部管理网', 'TDA', '供应链信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:31:43', NULL);
INSERT INTO `bi_portal` VALUES (41, 41, '41', 'trafficControlConvention', '交控公约', '内部管理网', 'TDA', '知识库', 1000.000, 34, 1, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (42, 42, '42', 'managementManual', '管理手册', '内部管理网', 'TDA', '知识库', 6000.000, 14, 6, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (43, 43, '43', 'processAndManagementStandard', '流程及管理标准', '内部管理网', 'TDA', '知识库', 371000.000, 84, 380, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (44, 44, '44', 'methods', '方法', '内部管理网', 'TDA', '知识库', 255000.000, 345, 261, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (45, 45, '45', 'technicalStandard', '技术标准', '内部管理网', 'TDA', '知识库', 6000.000, 49, 6, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (46, 46, '46', 'normalForm', '范式', '内部管理网', 'TDA', '知识库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:53:09', NULL);
INSERT INTO `bi_portal` VALUES (47, 47, '47', 'processInteresting', '流程小视频', '内部管理网', 'TDA', '知识库', 8000.000, 5, 8, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (48, 48, '48', 'culturalConsciousness', '文化意识', '内部管理网', 'TDA', '知识库', 90000.000, 59, 92, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (49, 49, '49', 'externalRegulationsAndStandards', '外部法规和标准', '内部管理网', 'TDA', '知识库', 46000.000, 24, 47, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (50, 50, '50', 'lesson', '经验教训', '内部管理网', 'TDA', '知识库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:57:52', NULL);
INSERT INTO `bi_portal` VALUES (51, 51, '51', 'emergencyPlan', '应急预案', '内部管理网', 'TDA', '知识库', 1000.000, 542, 1, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (52, 52, '52', 'environmentalFactors', '环境因素、职业健康危险源', '内部管理网', 'TDA', '知识库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:59:24', NULL);
INSERT INTO `bi_portal` VALUES (53, 53, '53', 'departmentalKnowledge', '部门知识', '内部管理网', 'TDA', '知识库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:59:24', NULL);
INSERT INTO `bi_portal` VALUES (54, 54, '54', 'trainingExamination', '培训考试', '内部管理网', 'TDA', '知识库', 470000.000, 243, 481, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (55, 55, '55', 'workAndPullTogether', '群策群力', '内部管理网', 'TDA', '知识库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:59:24', NULL);
INSERT INTO `bi_portal` VALUES (56, 56, '56', 'cockpit', '驾驶舱', '内部管理网', 'TDA', '支持信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:59:24', NULL);
INSERT INTO `bi_portal` VALUES (57, 57, '57', 'brandArchives', '品牌档案', '内部管理网', 'TDA', '支持信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 14:59:24', NULL);
INSERT INTO `bi_portal` VALUES (58, 58, '58', 'financialRecords', '财务档案', '内部管理网', 'TDA', '支持信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 15:04:40', NULL);
INSERT INTO `bi_portal` VALUES (59, 59, '59', 'humanFile', '人力档案', '内部管理网', 'TDA', '支持信息库', 93000.000, 49, 95, '1', '2021-08-05 14:16:22', '2021-08-19 14:52:37', NULL);
INSERT INTO `bi_portal` VALUES (60, 60, '60', 'departmentArchives', '部门档案', '内部管理网', 'TDA', '支持信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 15:06:43', NULL);
INSERT INTO `bi_portal` VALUES (61, 61, '61', 'otherArchives', '其他档案', '内部管理网', 'TDA', '支持信息库', 0.000, 0, 0, '1', '2021-08-05 14:16:22', '2021-08-05 15:06:43', NULL);

SET FOREIGN_KEY_CHECKS = 1;
