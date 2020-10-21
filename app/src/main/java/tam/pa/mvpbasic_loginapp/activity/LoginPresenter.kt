package tam.pa.mvpbasic_loginapp.activity

import tam.pa.mvpbasic_loginapp.model.UserItem

class LoginPresenter(val iView: IViewLogin){
    fun onGetLogin(dataUser: UserItem){
        if (dataUser.email.equals("email@gmail.com")
                && dataUser.password.equals("123")){
            iView.onGetResult("Login berhasil!")
        }else{
            iView.onGetResult("Data yang anda masukan salah!!")
        }
    }
}