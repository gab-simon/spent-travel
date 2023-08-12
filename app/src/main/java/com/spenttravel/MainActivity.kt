package com.spenttravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.spenttravel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat();
            val price = binding.editPrice.text.toString().toFloat();
            val autonomy = binding.editAutonomy.text.toString().toFloat();

            val amount = (distance * price) / autonomy;
            val totalAmountStr = "R$ ${"%.2f".format(amount)}";

            binding.textAmount.text = totalAmountStr;

            Toast.makeText(this, totalAmountStr, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.fill_all_field, Toast.LENGTH_SHORT).show()
        }
    }
}