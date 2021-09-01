package com.neo.practicaapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neo.practicaapi.R
import com.neo.practicaapi.api.implementation.CotizacionImplementation
import com.neo.practicaapi.model.Moneda
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.blue_layout,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ventaBlue: TextView = view.findViewById(R.id.p_ventaBlue)
        val compraBlue: TextView = view.findViewById(R.id.p_compraBlue)

        val api: CotizacionImplementation = CotizacionImplementation()

        api.funGetCotizacion().enqueue(object : Callback<Moneda> {
            override fun onResponse(call: Call<Moneda>, response: Response<Moneda>) {
                if (response.body() != null) {
                    val data = response.body()

                    if(ventaBlue.text.isEmpty() && compraBlue.text.isEmpty())
                    {
                        ventaBlue.setText("Venta: " + data?.blue?.value_sell.toString())
                        compraBlue.setText("Compra: " + data?.blue?.value_buy.toString())
                    }else{
                        Toast.makeText(context, "Valores actualizados", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<Moneda>, t: Throwable) {
                Toast.makeText(context, "Error al invocar API", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

}