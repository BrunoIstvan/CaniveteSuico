package br.com.bicmsystems.canivetesuico.toast

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import br.com.bicmsystems.canivetesuico.R

class CustomToast(val context: Context, val inflater: LayoutInflater) {

    private fun show(view: View, text: String) {

        val customtoast = Toast(context)
        val textView = view.findViewById<TextView>(R.id.textView1)

        textView.text = text
        customtoast.view = view
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 0)
        customtoast.duration = Toast.LENGTH_LONG
        customtoast.show()
    }

    fun showErrorToast(text: String)  {
        val toast = returnView("error")
        show(toast, text)
    }


    fun showWarningToast(text: String)  {
        val toast = returnView("warning")
        show(toast, text)
    }


    fun showInfoToast(text: String)  {
        val toast = returnView("info")
        show(toast, text)
    }

    fun showDefaultToast(text: String) {
        val toast = returnView("default")
        show(toast, text)

    }

    private fun returnView(tipo: String) : View {

        when(tipo) {
            "error" -> return inflater.inflate(R.layout.custom_toast_error, null)
            "warning" -> return inflater.inflate(R.layout.custom_toast_warning, null)
            "info" -> return inflater.inflate(R.layout.custom_toast_info, null)
            else -> return inflater.inflate(R.layout.custom_toast, null)
        }

    }


}