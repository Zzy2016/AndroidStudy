package com.example.logintest;

import java.util.List;

public class LoginNativeResult {
    /**
     * status : 0
     * retValue : {"id":100223,"mobile":"17635663998","osName":"Android","imPassword":"9Vd371A2c2","isSetLoginPassword":true,"jwt":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAyMjMiLCJleHAiOjE2MDIwMzcxNDcsImlhdCI6MTYwMTQzMjM0NywiQWNjb3VudEluZm8iOnsiaWQiOjEwMDIyMywibW9iaWxlIjoiMTc2MzU2NjM5OTgiLCJ1c2VyVHlwZSI6MSwiaW1QYXNzd29yZCI6IjlWZDM3MUEyYzIiLCJpc1NldExvZ2luUGFzc3dvcmQiOnRydWUsIm9zTmFtZSI6IkFuZHJvaWQiLCJsYXN0TG9naW5UaW1lIjoiMjAyMC0wOS0zMCAxMDoxOTowNyIsInZlcnNpb24iOiJ2Mi4wLjAxIiwidXNlclJvbGUiOlsiUk9MRV9QQVRJRU5UIiwiUk9MRV9NRU5UQUwiXSwiaXNFbmFibGUiOmZhbHNlLCJhZGRUaW1lIjoiMjAxOS0wMS0yOCAxMDoyODo0NiJ9fQ.TSVpXpa3x3twbE018o-R6rWgTAyg0zbTeUjjL24_iRE","familyInfo":[{"id":68635,"userName":"测试","userSex":1,"userBirth":"2010-10-20","cardType":2,"card":"*********4886","bindUid":100223,"bindUserRelationship":"其他","patientHospital":[{"hospitalName":"复旦大学附属中山医院","isSelect":true}],"isNormal":true},{"id":85858,"userName":"小号","userSex":1,"userBirth":"1990-03-07","card":"**************7379","bindUid":100223,"patientHospital":[],"isNormal":false},{"id":85886,"userName":"是说的","userSex":1,"userBirth":"1990-07-06","card":"**************0094","bindUid":100223,"patientHospital":[],"isNormal":false},{"id":85887,"userName":"策士","userSex":1,"userBirth":"1990-07-06","card":"**************8117","bindUid":100223,"patientHospital":[],"isNormal":false},{"id":87144,"userName":"阿尔山","userSex":1,"userBirth":"1993-03-07","card":"**************3650","bindUid":100223,"patientHospital":[],"isNormal":false}],"addressInfo":[]}
     */

    private int status;
    private RetValueBean retValue;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RetValueBean getRetValue() {
        return retValue;
    }

    public void setRetValue(RetValueBean retValue) {
        this.retValue = retValue;
    }

    public static class RetValueBean {
        /**
         * id : 100223
         * mobile : 17635663998
         * osName : Android
         * imPassword : 9Vd371A2c2
         * isSetLoginPassword : true
         * jwt : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAyMjMiLCJleHAiOjE2MDIwMzcxNDcsImlhdCI6MTYwMTQzMjM0NywiQWNjb3VudEluZm8iOnsiaWQiOjEwMDIyMywibW9iaWxlIjoiMTc2MzU2NjM5OTgiLCJ1c2VyVHlwZSI6MSwiaW1QYXNzd29yZCI6IjlWZDM3MUEyYzIiLCJpc1NldExvZ2luUGFzc3dvcmQiOnRydWUsIm9zTmFtZSI6IkFuZHJvaWQiLCJsYXN0TG9naW5UaW1lIjoiMjAyMC0wOS0zMCAxMDoxOTowNyIsInZlcnNpb24iOiJ2Mi4wLjAxIiwidXNlclJvbGUiOlsiUk9MRV9QQVRJRU5UIiwiUk9MRV9NRU5UQUwiXSwiaXNFbmFibGUiOmZhbHNlLCJhZGRUaW1lIjoiMjAxOS0wMS0yOCAxMDoyODo0NiJ9fQ.TSVpXpa3x3twbE018o-R6rWgTAyg0zbTeUjjL24_iRE
         * familyInfo : [{"id":68635,"userName":"测试","userSex":1,"userBirth":"2010-10-20","cardType":2,"card":"*********4886","bindUid":100223,"bindUserRelationship":"其他","patientHospital":[{"hospitalName":"复旦大学附属中山医院","isSelect":true}],"isNormal":true},{"id":85858,"userName":"小号","userSex":1,"userBirth":"1990-03-07","card":"**************7379","bindUid":100223,"patientHospital":[],"isNormal":false},{"id":85886,"userName":"是说的","userSex":1,"userBirth":"1990-07-06","card":"**************0094","bindUid":100223,"patientHospital":[],"isNormal":false},{"id":85887,"userName":"策士","userSex":1,"userBirth":"1990-07-06","card":"**************8117","bindUid":100223,"patientHospital":[],"isNormal":false},{"id":87144,"userName":"阿尔山","userSex":1,"userBirth":"1993-03-07","card":"**************3650","bindUid":100223,"patientHospital":[],"isNormal":false}]
         * addressInfo : []
         */

        private int id;
        private String mobile;
        private String osName;
        private String imPassword;
        private boolean isSetLoginPassword;
        private String jwt;

        private List<?> addressInfo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }

        public String getImPassword() {
            return imPassword;
        }

        public void setImPassword(String imPassword) {
            this.imPassword = imPassword;
        }

        public boolean isIsSetLoginPassword() {
            return isSetLoginPassword;
        }

        public void setIsSetLoginPassword(boolean isSetLoginPassword) {
            this.isSetLoginPassword = isSetLoginPassword;
        }

        public String getJwt() {
            return jwt;
        }

        public void setJwt(String jwt) {
            this.jwt = jwt;
        }



        public List<?> getAddressInfo() {
            return addressInfo;
        }

        public void setAddressInfo(List<?> addressInfo) {
            this.addressInfo = addressInfo;
        }

        public static class FamilyInfoBean {
            /**
             * id : 68635
             * userName : 测试
             * userSex : 1
             * userBirth : 2010-10-20
             * cardType : 2
             * card : *********4886
             * bindUid : 100223
             * bindUserRelationship : 其他
             * patientHospital : [{"hospitalName":"复旦大学附属中山医院","isSelect":true}]
             * isNormal : true
             */

            private int id;
            private String userName;
            private int userSex;
            private String userBirth;
            private int cardType;
            private String card;
            private int bindUid;
            private String bindUserRelationship;
            private boolean isNormal;
            private List<PatientHospitalBean> patientHospital;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public int getUserSex() {
                return userSex;
            }

            public void setUserSex(int userSex) {
                this.userSex = userSex;
            }

            public String getUserBirth() {
                return userBirth;
            }

            public void setUserBirth(String userBirth) {
                this.userBirth = userBirth;
            }

            public int getCardType() {
                return cardType;
            }

            public void setCardType(int cardType) {
                this.cardType = cardType;
            }

            public String getCard() {
                return card;
            }

            public void setCard(String card) {
                this.card = card;
            }

            public int getBindUid() {
                return bindUid;
            }

            public void setBindUid(int bindUid) {
                this.bindUid = bindUid;
            }

            public String getBindUserRelationship() {
                return bindUserRelationship;
            }

            public void setBindUserRelationship(String bindUserRelationship) {
                this.bindUserRelationship = bindUserRelationship;
            }

            public boolean isIsNormal() {
                return isNormal;
            }

            public void setIsNormal(boolean isNormal) {
                this.isNormal = isNormal;
            }

            public List<PatientHospitalBean> getPatientHospital() {
                return patientHospital;
            }

            public void setPatientHospital(List<PatientHospitalBean> patientHospital) {
                this.patientHospital = patientHospital;
            }

            public static class PatientHospitalBean {
                /**
                 * hospitalName : 复旦大学附属中山医院
                 * isSelect : true
                 */

                private String hospitalName;
                private boolean isSelect;

                public String getHospitalName() {
                    return hospitalName;
                }

                public void setHospitalName(String hospitalName) {
                    this.hospitalName = hospitalName;
                }

                public boolean isIsSelect() {
                    return isSelect;
                }

                public void setIsSelect(boolean isSelect) {
                    this.isSelect = isSelect;
                }
            }
        }
    }
}
