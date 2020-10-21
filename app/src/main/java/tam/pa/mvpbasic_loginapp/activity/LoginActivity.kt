package tam.pa.mvpbasic_loginapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import tam.pa.mvpbasic_loginapp.R
import tam.pa.mvpbasic_loginapp.model.UserItem

class LoginActivity : AppCompatActivity(), IViewLogin{
    var email: TextInputEditText? = null
    var pass: TextInputEditText? = null
    var btnLogin: Button? = null
    private lateinit var presenter: LoginPresenter
    private lateinit var iview: IViewLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iview = this
        init()
        btnLogin?.setOnClickListener {
            if (email?.text.isNullOrEmpty()) {
                email?.error = "Masukan alamat email anda!"
                email?.requestFocus()
            }else if (pass?.text.isNullOrEmpty()){
                pass?.error = "Masukan alamat email anda!"
                pass?.requestFocus()
            }else {
                presenter.onGetLogin(UserItem (email!!.text.toString(), pass!!.text.toString()))
            }
        }
    }
    fun init(){
        email = findViewById(R.id.tieEmail)
        pass = findViewById(R.id.tiePass)
        btnLogin = findViewById(R.id.btnLogin)
        presenter = LoginPresenter(iview)
    }
    override fun onGetResult(message: String) {
        Toast.makeText(this, ""+message, Toast.LENGTH_LONG).show()
    }
}