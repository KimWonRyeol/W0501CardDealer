package kr.ac.kumoh.s20200252.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20200252.w0501carddealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCardName(39)
        binding.card1.setImageResource((R.drawable.c_ace_of_spades))
    }

    private fun getCardName(c:Int) : String {
        Log.i("getCardName():", c.toString())
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }
        Log.i("getCardName():", shape.toString())

        val number = when (c % 13) {
            in 1..9 -> (c % 13 + 1).toString()
            0 -> "Ace"
            10 -> "Jack"
            11 -> "Queen"
            12 -> "King"
            else -> "error"
        }
        Log.i("getCardName():", number.toString())


        return "c_6_of_clubs"
    }
}