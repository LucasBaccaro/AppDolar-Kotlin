package com.neo.practicaapi.view

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.neo.practicaapi.R
import com.neo.practicaapi.fragments.BlueFragment
import com.neo.practicaapi.fragments.OficialFragment

class MainActivity : AppCompatActivity() {

    lateinit var blue: Button
    lateinit var oficial:Button
    lateinit var frame:FrameLayout
    lateinit var salir:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ponemos en contexto los sms y los disponibilizamos automaticamente

        Firebase.messaging.isAutoInitEnabled = true

        val manager = supportFragmentManager
        val blueFragment = BlueFragment()
        val oficialFragment = OficialFragment()


        blue = findViewById(R.id.btn_ConsultarBlue)
        oficial=findViewById(R.id.btn_consultarOficial)
        frame = findViewById(R.id.frame)
        salir = findViewById(R.id.btn_Salir)

        val transaction = manager.beginTransaction()

        blue.setOnClickListener {
            
            try{
                transaction.replace(R.id.frame,blueFragment)
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.frame,blueFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }catch (e:Exception){
                Toast.makeText(this, "Un momento por favor", Toast.LENGTH_SHORT).show()
            }
        }
        oficial.setOnClickListener {

            try{
                transaction.replace(R.id.frame,oficialFragment)
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.frame,oficialFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }catch(e:Exception){
                Toast.makeText(this, "Un momento por favor", Toast.LENGTH_SHORT).show()
            }
        }
        salir.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Realmente desea salir?")
            builder.setMessage("Esta por salir")

            builder.setPositiveButton(android.R.string.yes) { _, _ ->
                finish()
            }

            builder.setNegativeButton(android.R.string.no) { _, _ ->
                Toast.makeText(this, "Permaneces en la APP", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
    }
}