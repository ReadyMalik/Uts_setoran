package com.belajar.uts_setoran

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.belajar.uts_setoran.databinding.ActivityRegisBinding

class RegisActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {
    private lateinit var mBinding: ActivityRegisBinding
    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        databaseHelper = DatabaseHelper(this)
        mBinding.regisBut.setOnClickListener {
            val regisUsername = mBinding.etNIM.text.toString()
            val regisPassword = mBinding.etPass.text.toString()
            regisDatabase(regisUsername, regisPassword)
        }
        mBinding.signIn.setOnClickListener {
            val intentDestination = Intent(this@RegisActivity, LoginActivity::class.java)
            startActivity(intentDestination)
        }

        mBinding.etNIM.onFocusChangeListener = this
        mBinding.etPass.onFocusChangeListener = this
        mBinding.etConpass.onFocusChangeListener = this
    }

    private fun regisDatabase(username: String, password:String){
        val insertedRowId = databaseHelper.insertUser(username, password)
        if(insertedRowId != -1L){
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
        }
    }


    private fun validateNIM(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.etNIM.text.toString()
        if(value.isEmpty()){
            errorMessage = "NIM is required"
        }else if(value.length<11){
            errorMessage = "NIM is invalid"
        }

        if(errorMessage != null){
            mBinding.tiNIM.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.etPass.text.toString()
        if(value.isEmpty()){
            errorMessage = "Password is required"
        }else if(value.length<6){
            errorMessage = "Password must be 6 characters long"
        }

        if(errorMessage != null){
            mBinding.tiPass.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.etConpass.text.toString()
        if(value.isEmpty()){
            errorMessage = "Confirm password is required"
        }else if(value.length<6){
            errorMessage = "Confirm password must be 6 characters long"
        }

        if(errorMessage != null){
            mBinding.tiConPass.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPassword(): Boolean {
        var errorMessage: String? = null
        val password = mBinding.etPass.text.toString()
        val confirmPass = mBinding.etConpass.text.toString()
        if(password != confirmPass){
            errorMessage = "Confirm password doesn't match with password"
        }
        if(errorMessage != null){
            mBinding.tiConPass.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    override fun onClick(view: View?) {
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null){
            when(view.id){
                R.id.et_NIM -> {
                    if (hasFocus){
                        if (mBinding.tiNIM.isErrorEnabled){
                            mBinding.tiNIM.isErrorEnabled = false
                        }
                    }else{
                        if(validateNIM()){

                        }
                    }
                }

                R.id.et_pass -> {
                    if (hasFocus){
                        if (mBinding.tiPass.isErrorEnabled){
                            mBinding.tiPass.isErrorEnabled = false
                        }
                    }else{
                        if (validatePassword() && mBinding.etConpass.text!!.isNotEmpty() && validateConfirmPassword() && validatePasswordAndConfirmPassword()){
                            if (mBinding.tiConPass.isErrorEnabled){
                                mBinding.tiConPass.isErrorEnabled = false
                            }
                            mBinding.tiConPass.apply {
                                setStartIconDrawable(R.drawable.sharp_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }

                R.id.et_conpass -> {
                    if (hasFocus){
                        if (mBinding.tiConPass.isErrorEnabled){
                            mBinding.tiConPass.isErrorEnabled = false
                        }
                    }else{
                        if(validateConfirmPassword() && validatePassword() && validatePasswordAndConfirmPassword()){
                            if (mBinding.tiPass.isErrorEnabled){
                                mBinding.tiPass.isErrorEnabled = false
                            }
                            mBinding.tiConPass.apply {
                                setStartIconDrawable(R.drawable.sharp_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent): Boolean {
        return false
    }
}
