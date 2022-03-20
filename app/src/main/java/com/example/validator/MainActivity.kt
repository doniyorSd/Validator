package com.example.validator

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.validator.databinding.ActivityMainBinding
import com.example.validatorlib.ToastLib
import org.w3c.dom.Text
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    lateinit var arrayAdapter: ArrayAdapter<String>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viloyats = arrayOf(
            "Toshkent",
            "Andijon",
            "Samarqand",
            "Xiva",
            "Buxoro",
            "Namangan"
        )
        arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, viloyats)
//        appDatabaseServices = AppDatabaseServices.instance(this)


        binding.spinner.adapter = arrayAdapter


        binding.clearBtn.setOnClickListener {
            binding.userIdEt.setText("")
            binding.passwordEt.setText("")
            binding.reEt.setText("")
            binding.firstName.setText("")
            binding.lastName.setText("")
            binding.emailEt.setText("")
            binding.ipAddress.setText("")
            binding.numberEt.setText("")
            binding.codeEt.setText("")
            binding.yearEt.setText("")
        }


        binding.reEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.passwordEt.text.toString() == binding.reEt.text.toString()) {
                        getApp()
                    } else {
                        binding.submitBtn.isEnabled = false
                        binding.reEt.setError("Birinchi parol emas")
                    }
                    if (s == "") {
                        binding.submitBtn.isEnabled = false
                    }

                } catch (e: Exception) {

                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        binding.emailEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (s.toString() != "") {
                        if (android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()
                        ) {
                            getApp()
                        } else {
                            binding.submitBtn.isEnabled = false
                            binding.emailEt.setError("Email xato ")
                        }
                    }
                    if (s == "") {
                        binding.submitBtn.isEnabled = false
                    }
                    getApp()
                } catch (e: Exception) {

                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.numberEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (android.util.Patterns.PHONE.matcher(binding.numberEt.text.toString())
                            .matches()
                    ) {
                        getApp()
                    } else {
                        binding.submitBtn.isEnabled = false
                        binding.numberEt.setError("No'mer to'g'ri kiriting")
                    }
                    if (s == "") {
                        binding.submitBtn.isEnabled = false
                    }
                    getApp()
                } catch (e: Exception) {

                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.ipAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (android.util.Patterns.IP_ADDRESS.matcher(binding.ipAddress.text.toString())
                            .matches()
                    ) {
                        getApp()
                    } else {
                        binding.submitBtn.isEnabled = false
                        binding.ipAddress.setError("IP Address xato")
                    }
                    if (s == "") {
                        binding.submitBtn.isEnabled = false
                    }
                    getApp()
                } catch (e: Exception) {

                }


            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        binding.yearEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (2021 > binding.yearEt.text.toString().toInt()) {
                        getApp()
                    } else {
                        binding.submitBtn.isEnabled = false
                        binding.yearEt.setError("Yilni to'gri kiriting")
                    }
                    if (s == "") {
                        binding.submitBtn.isEnabled = false
                    }
                    getApp()
                } catch (e: Exception) {

                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        binding.codeEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.codeEt.text.toString().toInt() in 100000..1999999) {
                        getApp()
                    } else {
                        binding.submitBtn.isEnabled = false
                        binding.codeEt.error = "Zip Code xato"
                    }
                    if (s == "") {
                        binding.submitBtn.isEnabled = false
                    }
                    getApp()
                } catch (e: Exception) {

                }

            }

            override fun afterTextChanged(s: Editable?) {


            }
        })


        binding.submitBtn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


    }

    private fun getApp() {
        binding.submitBtn.isEnabled = (binding.numberEt.text.toString().trim().isNotEmpty()
                && binding.passwordEt.text.toString().trim().isNotEmpty() &&
                binding.lastName.text.toString().trim().isNotEmpty()
                && binding.ipAddress.text.toString().trim().isNotEmpty() &&
                binding.firstName.text.toString().trim().isNotEmpty()
                && binding.emailEt.text.toString().trim().isNotEmpty() &&
                binding.codeEt.text.toString().trim().isNotEmpty() &&
                binding.reEt.text.toString().trim().isNotEmpty()
                && binding.userIdEt.text.toString().trim().isNotEmpty()
                && binding.yearEt.text.toString().trim().isNotEmpty())
    }
}



