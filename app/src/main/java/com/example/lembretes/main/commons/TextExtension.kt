package com.example.lembretes.main.commons

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText
import java.text.NumberFormat

fun TextInputEditText.addCurrencyFormatter() {

    this.addTextChangedListener(object: TextWatcher {

        private var current = ""

        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (s.toString() != current) {
                this@addCurrencyFormatter.removeTextChangedListener(this)
                val cleanString = s.toString().replace("\\D".toRegex(), "")
                val parsed = if (cleanString.isBlank()) 0.0 else cleanString.toDouble()
                // format the double into a currency format
                val formated = NumberFormat.getCurrencyInstance()
                    .format(parsed / 100)

                current = formated
                this@addCurrencyFormatter.setText(formated)
                this@addCurrencyFormatter.setSelection(formated.length)

                this@addCurrencyFormatter.addTextChangedListener(this)
            }
        }
    })
}
