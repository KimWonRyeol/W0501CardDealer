package kr.ac.kumoh.s20200252.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20200252.w0501carddealer.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDeal.setOnClickListener{
            val c = IntArray(5,{-1})
            val res = IntArray(5)

            var tmp = Random.nextInt(52)
            for(i in 0 until c.size)
            {
                while(c.contains(tmp))
                    tmp = Random.nextInt(52)
                c[i] = tmp


                Log.i("Test", "${c[i]} : " +
                        "${getCardName(c[i])}")

                res[i] = resources.getIdentifier(
                    getCardName(c[i]),
                    "drawable",
                    packageName
                )
            }
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        }


    }

    private fun getCardName(c:Int) : String {
        Log.i("getCardName():", c.toString())
        var shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }


        val number = when (c % 13) {
            in 1..9 -> (c % 13 + 1).toString()
            0 -> "ace"
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        Log.i("getCardName():", number.toString())

        if(/*number == "ace" ||*/ number == "queen" || number == "king" || number == "jack" )
            shape = "${shape}2"

        Log.i("getCardName():", shape.toString())
        Log.i("getCardName():","c_${number}_of_${shape}")
        return "c_${number}_of_${shape}"
    }
}