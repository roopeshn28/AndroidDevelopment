package com.example.studentform;

public class Form {
        private String Fullname;
        private String Branch;
        private String Usn;
        private String Email;
        private String Phone;
        private String Guidename;
        private String Guideemail;
        private String Guidephone;
        private String Organization;

        public Form() {
        }

        public Form(String fullname, String branch, String usn, String email, String phone, String guidename, String guideemail, String guidephone, String organization) {
            Fullname = fullname;
            Branch = branch;
            Usn = usn;
            Email = email;
            Phone = phone;
            Guidename = guidename;
            Guideemail = guideemail;
            Guidephone = guidephone;
            Organization = organization;
        }

        public String getFullname() {
            return Fullname;
        }

        public void setFullname(String fullname) {
            Fullname = fullname;
        }

        public String getBranch() {
            return Branch;
        }

        public void setBranch(String branch) {
            Branch = branch;
        }

        public String getUsn() {
            return Usn;
        }

        public void setUsn(String usn) {
            Usn = usn;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public String getGuidename() {
            return Guidename;
        }

        public void setGuidename(String guidename) {
            Guidename = guidename;
        }

        public String getGuideemail() {
            return Guideemail;
        }

        public void setGuideemail(String guideemail) {
            Guideemail = guideemail;
        }

        public String getGuidephone() {
            return Guidephone;
        }

        public void setGuidephone(String guidephone) {
            Guidephone = guidephone;
        }

        public String getOrganization() {
            return Organization;
        }

        public void setOrganization(String organization) {
            Organization = organization;
        }
    }


