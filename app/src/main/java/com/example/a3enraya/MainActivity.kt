package com.example.a3enraya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.a3enraya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var player:Char='X'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun pressButton(view: View){
        val button=view as Button
        button.setText("$player")
        player=changePlayer(player)
        button.setEnabled(false)
        println(defineLoser(player))
    }

    private fun changePlayer(player:Char):Char{
        return when(player){
            'X' -> 'O'
            'O' -> 'X'
            else -> 'p'
        }
    }

    private fun defineLoser(player:Char):String{
        if(binding.btn1.text.toString()==player.toString() && binding.btn2.getText().toString()==player.toString() && binding.btn3.getText().toString()==player.toString()){
            return "Ganó el jugador $player"
        }else if(binding.btn4.text.toString()==player.toString() && binding.btn5.getText().toString()==player.toString() && binding.btn6.getText().toString()==player.toString()){
            return "Ganó el jugador $player"
        }else if(binding.btn7.text.toString()==player.toString() && binding.btn8.getText().toString()==player.toString() && binding.btn9.getText().toString()==player.toString()){
            return "Ganó el jugador $player"
        }else if(binding.btn1.text.toString()==player.toString() && binding.btn5.getText().toString()==player.toString() && binding.btn9.getText().toString()==player.toString()){
            return "Ganó el jugador $player"
        }else if(binding.btn3.text.toString()==player.toString() && binding.btn2.getText().toString()==player.toString() && binding.btn7.getText().toString()==player.toString()){
            return "Ganó el jugador $player"
        }
        return "No se define ganador aún."
    }
}