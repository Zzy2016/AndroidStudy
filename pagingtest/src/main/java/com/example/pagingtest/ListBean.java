package com.example.pagingtest;

import java.util.List;

public class ListBean {


    /**
     * items : [{"badge_counts":{"bronze":8851,"silver":8599,"gold":778},"account_id":11683,"is_employee":false,"last_modified_date":1606957811,"last_access_date":1607206972,"reputation_change_year":70407,"reputation_change_quarter":13670,"reputation_change_month":1065,"reputation_change_week":10,"reputation_change_day":10,"reputation":1225022,"creation_date":1222430705,"user_type":"registered","user_id":22656,"accept_rate":86,"location":"Reading, United Kingdom","website_url":"http://csharpindepth.com","link":"https://stackoverflow.com/users/22656/jon-skeet","profile_image":"https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=identicon&r=PG","display_name":"Jon Skeet"},{"badge_counts":{"bronze":572,"silver":446,"gold":47},"account_id":1165580,"is_employee":false,"last_modified_date":1607162400,"last_access_date":1607220910,"reputation_change_year":146283,"reputation_change_quarter":27429,"reputation_change_month":2250,"reputation_change_week":35,"reputation_change_day":35,"reputation":1044533,"creation_date":1326311637,"user_type":"registered","user_id":1144035,"location":"New York, United States","website_url":"http://www.data-miners.com","link":"https://stackoverflow.com/users/1144035/gordon-linoff","profile_image":"https://www.gravatar.com/avatar/e514b017977ebf742a418cac697d8996?s=128&d=identicon&r=PG","display_name":"Gordon Linoff"},{"badge_counts":{"bronze":4067,"silver":3480,"gold":416},"account_id":4243,"is_employee":false,"last_modified_date":1607222110,"last_access_date":1607240552,"reputation_change_year":83658,"reputation_change_quarter":16543,"reputation_change_month":1523,"reputation_change_week":188,"reputation_change_day":188,"reputation":1002441,"creation_date":1221344553,"user_type":"registered","user_id":6309,"accept_rate":100,"location":"France","website_url":"http://careers.stackoverflow.com/vonc","link":"https://stackoverflow.com/users/6309/vonc","profile_image":"https://www.gravatar.com/avatar/7aa22372b695ed2b26052c340f9097eb?s=128&d=identicon&r=PG","display_name":"VonC"},{"badge_counts":{"bronze":3417,"silver":3437,"gold":345},"account_id":52822,"is_employee":false,"last_modified_date":1607118906,"last_access_date":1607207748,"reputation_change_year":59099,"reputation_change_quarter":11207,"reputation_change_month":839,"reputation_change_week":20,"reputation_change_day":20,"reputation":965141,"creation_date":1250527322,"user_type":"registered","user_id":157882,"accept_rate":93,"location":"Willemstad, Cura&#231;ao","website_url":"https://balusc.omnifaces.org","link":"https://stackoverflow.com/users/157882/balusc","profile_image":"https://www.gravatar.com/avatar/89927e2f4bde24991649b353a37678b9?s=128&d=identicon&r=PG","display_name":"BalusC"},{"badge_counts":{"bronze":2852,"silver":3165,"gold":252},"account_id":14332,"is_employee":false,"last_modified_date":1606819502,"last_access_date":1607190402,"reputation_change_year":46714,"reputation_change_quarter":8384,"reputation_change_month":728,"reputation_change_week":10,"reputation_change_day":10,"reputation":939029,"creation_date":1224432467,"user_type":"registered","user_id":29407,"accept_rate":86,"location":"Sofia, Bulgaria","website_url":"http://stackoverflow.com/search?q=user%3a29407&tab=newest","link":"https://stackoverflow.com/users/29407/darin-dimitrov","profile_image":"https://www.gravatar.com/avatar/e3a181e9cdd4757a8b416d93878770c5?s=128&d=identicon&r=PG","display_name":"Darin Dimitrov"},{"badge_counts":{"bronze":2737,"silver":2374,"gold":229},"account_id":11975,"is_employee":true,"last_modified_date":1606937703,"last_access_date":1607177731,"reputation_change_year":59134,"reputation_change_quarter":10430,"reputation_change_month":760,"reputation_change_week":20,"reputation_change_day":20,"reputation":898994,"creation_date":1222667162,"user_type":"moderator","user_id":23354,"accept_rate":100,"location":"Forest of Dean, United Kingdom","website_url":"http://blog.marcgravell.com","link":"https://stackoverflow.com/users/23354/marc-gravell","profile_image":"https://i.stack.imgur.com/CrVFH.png?s=128&g=1","display_name":"Marc Gravell"}]
     * has_more : true
     * quota_max : 300
     * quota_remaining : 296
     */

    private boolean has_more;
    private int quota_max;
    private int quota_remaining;
    private List<ItemsBean> items;

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * badge_counts : {"bronze":8851,"silver":8599,"gold":778}
         * account_id : 11683
         * is_employee : false
         * last_modified_date : 1606957811
         * last_access_date : 1607206972
         * reputation_change_year : 70407
         * reputation_change_quarter : 13670
         * reputation_change_month : 1065
         * reputation_change_week : 10
         * reputation_change_day : 10
         * reputation : 1225022
         * creation_date : 1222430705
         * user_type : registered
         * user_id : 22656
         * accept_rate : 86
         * location : Reading, United Kingdom
         * website_url : http://csharpindepth.com
         * link : https://stackoverflow.com/users/22656/jon-skeet
         * profile_image : https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=identicon&r=PG
         * display_name : Jon Skeet
         */

        private BadgeCountsBean badge_counts;
        private int account_id;
        private boolean is_employee;
        private int last_modified_date;
        private int last_access_date;
        private int reputation_change_year;
        private int reputation_change_quarter;
        private int reputation_change_month;
        private int reputation_change_week;
        private int reputation_change_day;
        private int reputation;
        private int creation_date;
        private String user_type;
        private int user_id;
        private int accept_rate;
        private String location;
        private String website_url;
        private String link;
        private String profile_image;
        private String display_name;

        public BadgeCountsBean getBadge_counts() {
            return badge_counts;
        }

        public void setBadge_counts(BadgeCountsBean badge_counts) {
            this.badge_counts = badge_counts;
        }

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public boolean isIs_employee() {
            return is_employee;
        }

        public void setIs_employee(boolean is_employee) {
            this.is_employee = is_employee;
        }

        public int getLast_modified_date() {
            return last_modified_date;
        }

        public void setLast_modified_date(int last_modified_date) {
            this.last_modified_date = last_modified_date;
        }

        public int getLast_access_date() {
            return last_access_date;
        }

        public void setLast_access_date(int last_access_date) {
            this.last_access_date = last_access_date;
        }

        public int getReputation_change_year() {
            return reputation_change_year;
        }

        public void setReputation_change_year(int reputation_change_year) {
            this.reputation_change_year = reputation_change_year;
        }

        public int getReputation_change_quarter() {
            return reputation_change_quarter;
        }

        public void setReputation_change_quarter(int reputation_change_quarter) {
            this.reputation_change_quarter = reputation_change_quarter;
        }

        public int getReputation_change_month() {
            return reputation_change_month;
        }

        public void setReputation_change_month(int reputation_change_month) {
            this.reputation_change_month = reputation_change_month;
        }

        public int getReputation_change_week() {
            return reputation_change_week;
        }

        public void setReputation_change_week(int reputation_change_week) {
            this.reputation_change_week = reputation_change_week;
        }

        public int getReputation_change_day() {
            return reputation_change_day;
        }

        public void setReputation_change_day(int reputation_change_day) {
            this.reputation_change_day = reputation_change_day;
        }

        public int getReputation() {
            return reputation;
        }

        public void setReputation(int reputation) {
            this.reputation = reputation;
        }

        public int getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(int creation_date) {
            this.creation_date = creation_date;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getAccept_rate() {
            return accept_rate;
        }

        public void setAccept_rate(int accept_rate) {
            this.accept_rate = accept_rate;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getWebsite_url() {
            return website_url;
        }

        public void setWebsite_url(String website_url) {
            this.website_url = website_url;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public static class BadgeCountsBean {
            /**
             * bronze : 8851
             * silver : 8599
             * gold : 778
             */

            private int bronze;
            private int silver;
            private int gold;

            public int getBronze() {
                return bronze;
            }

            public void setBronze(int bronze) {
                this.bronze = bronze;
            }

            public int getSilver() {
                return silver;
            }

            public void setSilver(int silver) {
                this.silver = silver;
            }

            public int getGold() {
                return gold;
            }

            public void setGold(int gold) {
                this.gold = gold;
            }
        }
    }
}
