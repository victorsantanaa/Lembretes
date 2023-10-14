package com.example.lembretes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.DatePicker
import android.widget.RadioGroup
import android.widget.Toast
import com.example.lembretes.databinding.ActivityReminderMainBinding
import com.example.lembretes.main.commons.addCurrencyFormatter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import java.util.Calendar

class ReminderMainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityReminderMainBinding.inflate(layoutInflater) }

    private val calendar = Calendar.getInstance()
    private var bottomSheetDialog: BottomSheetDialog? = null

    private var flagAddButton = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.activityReminderDurationPickerButton.isClickable = false
        binding.activityReminderDurationPickerButton.isFocusable = false
        binding.activityReminderDurationPickerButton.isFocusableInTouchMode = false
        binding.activityReminderDurationPickerButton.isActivated = false

        onInputTitleHasChanged()
        binding.activityReminderValueInputText.addCurrencyFormatter()

        binding.activityReminderRecurrencePickerButton.setOnClickListener{
            showRecurrenceBottomSheetDialog()
        }

        binding.activityReminderDatePickerButton.setOnClickListener{
            showDatePickerDialog()
        }

        binding.activityReminderDurationPickerButton.setOnClickListener{
            showDurationBottomSheetDialog()
        }

        binding.activityReminderAddEventButton.setOnClickListener {
            Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showRecurrenceBottomSheetDialog() {

        if (bottomSheetDialog == null) {
            val view = layoutInflater.inflate(R.layout.recorrence_bottom_sheet_layout, null)
            bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog?.setContentView(view)

            bottomSheetDialog?.setOnDismissListener {
                bottomSheetDialog?.dismiss()
                bottomSheetDialog = null
            }


            val recurrenceRadioGroup = findViewById<RadioGroup>(R.id.recurrence_radio_group)
            val defineRecurrenceButton = findViewById<MaterialButton>(R.id.define_recurrence_button)

            defineRecurrenceButton.setOnClickListener(View.OnClickListener {
                val selectedRadioButtonId = recurrenceRadioGroup.checkedRadioButtonId

                if (selectedRadioButtonId != -1) {
                    // Um RadioButton foi selecionado
                    when (selectedRadioButtonId) {
                        R.id.daily_radio_button -> {
                            // O RadioButton "Daily" foi selecionado
                            // Faça algo com base nessa seleção
                        }
                        R.id.weekly_radio_button -> {
                            // O RadioButton "Weekly" foi selecionado
                            // Faça algo com base nessa seleção
                        }
                        R.id.monthly_radio_button -> {
                            // O RadioButton "Monthly" foi selecionado
                            // Faça algo com base nessa seleção
                        }
                        R.id.semiannual_radio_button -> {
                            // O RadioButton "Semiannual" foi selecionado
                            // Faça algo com base nessa seleção
                        }
                    }
                } else {
                    // Nenhum RadioButton foi selecionado
                }
            })
        }

        bottomSheetDialog?.show()
    }

    private fun showDurationBottomSheetDialog() {

        if (bottomSheetDialog == null) {
            val view = layoutInflater.inflate(R.layout.duration_bottom_sheet_dialog, null)
            bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog?.setContentView(view)

            bottomSheetDialog?.setOnDismissListener {
                bottomSheetDialog?.dismiss()
                bottomSheetDialog = null
            }

            val durationRadioGroup = findViewById<RadioGroup>(R.id.duration_radio_group)
            val defineDurationButton = findViewById<MaterialButton>(R.id.define_duration_button)

            defineDurationButton.setOnClickListener {
                val selectedRadioButtonId = durationRadioGroup.checkedRadioButtonId

                if (selectedRadioButtonId != -1) {
                    // Um RadioButton foi selecionado
                    when (selectedRadioButtonId) {
                        R.id.one_month_radio_button -> {
                            // O RadioButton "One Month" foi selecionado
                            // Faça algo com base nessa seleção
                        }

                        R.id.two_month_radio_button -> {
                            // O RadioButton "Two Month" foi selecionado
                            // Faça algo com base nessa seleção
                        }

                        R.id.six_month_radio_button -> {
                            // O RadioButton "Six Month" foi selecionado
                            // Faça algo com base nessa seleção
                        }

                        R.id.one_year_radio_button -> {
                            // O RadioButton "One Year" foi selecionado
                            // Faça algo com base nessa seleção
                        }
                    }
                } else {
                    // Nenhum RadioButton foi selecionado
                }
            }
        }

        bottomSheetDialog?.show()
    }

    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // O código aqui será executado quando o usuário selecionar uma data
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                binding.activityReminderDatePickerButton.setText(selectedDate)
                binding.activityReminderAddEventButton.isEnabled = true
                binding.activityReminderRecurrencePickerButton.setTextColor(resources.getColor(R.color.black))
            },
            year,
            month,
            day
        )

        // Configura o limite mínimo e máximo (opcional)
         datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        // datePickerDialog.datePicker.maxDate = System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 7) // Limite máximo para uma semana no futuro

        datePickerDialog.show()
    }

    private fun onInputTitleHasChanged() {
        binding.activityReminderNameInputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()

                if(text.isNotEmpty()) {
                    binding.activityReminderDatePickerButton.setTextColor(resources.getColor(R.color.black))
                } else {
                    binding.activityReminderDatePickerButton.setTextColor(resources.getColor(R.color.disabled))
                    binding.activityReminderAddEventButton.isEnabled = false
                }
            }

        })
    }
}