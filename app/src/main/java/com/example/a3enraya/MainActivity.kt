package com.example.a3enraya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
        button.setEnabled(false)
        if(missingWinner(player)) {winnerFounded()}
        player=changePlayer(player)
    }

    private fun changePlayer(player:Char):Char{
        return when(player){
            'X' -> 'O'
            'O' -> 'X'
            else -> 'p'
        }
    }

    private fun missingWinner(player:Char):Boolean{
        var playerStr=player.toString()
        if(binding.btn1.getText().toString()==playerStr && binding.btn2.getText().toString()==playerStr && binding.btn3.getText().toString()==playerStr){
            return true
        }else if(binding.btn4.getText().toString()==playerStr && binding.btn5.getText().toString()==playerStr && binding.btn6.getText().toString()==playerStr){
            return true
        }else if(binding.btn7.getText().toString()==playerStr && binding.btn8.getText().toString()==playerStr && binding.btn9.getText().toString()==playerStr){
            return true
        }else if(binding.btn1.getText().toString()==playerStr && binding.btn5.getText().toString()==playerStr && binding.btn9.getText().toString()==playerStr){
            return true
        }else if(binding.btn3.getText().toString()==playerStr && binding.btn2.getText().toString()==playerStr && binding.btn7.getText().toString()==playerStr) {
            return true
        }else if(binding.btn1.getText().toString()==playerStr && binding.btn4.getText().toString()==playerStr && binding.btn7.getText().toString()==playerStr){
            return true
        }else if(binding.btn2.getText().toString()==playerStr && binding.btn5.getText().toString()==playerStr && binding.btn8.getText().toString()==playerStr){
            return true
        }
        else if(binding.btn3.getText().toString()==playerStr && binding.btn6.getText().toString()==playerStr && binding.btn9.getText().toString()==playerStr){
            return true
        }
        return false
    }
    private fun winnerFounded(){
        blockButtons()
        Toast.makeText(this,"Winner: $player.\uD83C\uDFC6",Toast.LENGTH_SHORT).show()
    }

    private fun blockButtons(){
        binding.btn1.setEnabled(false)
        binding.btn2.setEnabled(false)
        binding.btn3.setEnabled(false)
        binding.btn4.setEnabled(false)
        binding.btn5.setEnabled(false)
        binding.btn6.setEnabled(false)
        binding.btn7.setEnabled(false)
        binding.btn8.setEnabled(false)
        binding.btn9.setEnabled(false)
    }
}