package com.example.bt_cuoiky;



public class TaiKhoan {
    private String password;
    private String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }






    public TaiKhoan(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public TaiKhoan(){
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TaiKhoan:" +
                "email:'" + email + '\'' +
                ", password:'" + password + '\'';
    }
}
