package com.example.parking;

import android.widget.EditText;

 public class Users{
     String uid;
     String name;
     String email;

     public Users() {
     }
// Constructor
     public Users(String uid, String name, String email) {
         this.uid = uid;
         this.name = name;
         this.email = email;
     }

     // Getter Setter Methods
     public String getUid() {
         return uid;
     }

     public void setUid(String uid) {
         this.uid = uid;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }
 }
