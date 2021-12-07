//package com.zdz.test.test;
//
//import java.util.Objects;
//
///**
// * @Description:
// * @Date: 2021/2/5
// */
//public class IDMaker {
//    /**
//     * id 生成.
//     */
//        private IDMaker() {
//        }
//
//        /**
//         * uid 构成
//         * 共计64位
//         * 前8位预留
//         * 业务标识8位 : 1位(标识是否为母子账户)+7位 交易所业务标识(1：exchange 2:broker )
//         * 具体的交易所ID 16位
//         * userid 32位
//         */
//
//        public static int accountTypeLen = 55;
//
//        public static int busTypeLen = 48;
//
//        public static int uidLen = 32;
//
//        public static Long uid0X = 0xFFFFFFFFL;
//
//        /**
//         * @param accountType  0 表示母账户  1表示子账户
//         * @param exchangeType
//         * @param exchangeId
//         * @param userId
//         * @return
//         */
//        public static Long generateUid(Long accountType,
//                                       Long exchangeType,
//                                       Long exchangeId,
//                                       Long userId) {
//
//            if (Objects.isNull(accountType) || Objects.isNull(exchangeType)
//                    || Objects.isNull(exchangeId) || Objects.isNull(userId)) {
//                throw new RuntimeException("参数不能为空");
//            }
//            long accountTypeNum = accountType << accountTypeLen;
//            long busTypeNum = exchangeType << busTypeLen;
//            long busIdNum = exchangeId << uidLen;
//            long result = accountTypeNum | busTypeNum | busIdNum | userId;
//            return result;
//        }
//
//        /**
//         * 根据uid查询用户信息
//         *
//         * @param uid
//         * @return
//         */
//        public static UserIdVO parseUserId(Long uid) {
//            if (Objects.isNull(uid)) {
//                throw new RuntimeException("用户的uid不能为空");
//            }
//            long userId = uid & uid0X;
//            long busId = (uid >> uidLen) & 0xFFFF;
//            long busType = (uid >> busTypeLen) & 0x7F;
//            long accountType = (uid >> accountTypeLen) & 0xF;
//            return UserIdVO.builder()
//                    .userId(userId)
//                    .busId(busId)
//                    .busType((int) busType)
//                    .accountType((int) accountType)
//                    .build();
//        }
//
//        @Builder
//        @Data
//        public static class UserIdVO {
//
//            private long userId;
//
//            private int accountType;
//
//            private int busType;
//
//            private long busId;
//
//        }
//
//
//        public static void main(String[] args) {
//            System.out.println(parseUserId(36310276290641999L).getUserId());
//        }
//
//}
