package com.example.diceroller
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mencari button
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener pada saat menekan button
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Objek  dadu 1
        val dice = Dice(6)

        //Objek dadu 2
        val dice2 = Dice(6)

        //Memanggil method roll() untuk dadu
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Memanggil ImageView di layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll 1
        //Untuk mencari gambar(resource) yang bisa dipakai saat angka dadu jatuh suatu angka
        val drawableResourceForDice1 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Determine which drawable resource ID to use based on the dice roll 2
        //Untuk mencari gambar(resource) yang bisa dipakai saat angka dadu jatuh suatu angka
        val drawableResourceForDice2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update ImageView drawable resource ID dadu 1 dan 2
        diceImage.setImageResource(drawableResourceForDice1)
        diceImage2.setImageResource(drawableResourceForDice2)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        doubleChecker(diceRoll,diceRoll2)
    }

    //Untuk mengecek nilai kedua dadu apa double atau tidak
    private fun doubleChecker(D1: Int, D2: Int) {
        if (D1 == D2) {
            Toast.makeText(this, "Selamat Anda Mendapatkan Double!", Toast.LENGTH_SHORT).show()
        } else if (D1 < D2) Toast.makeText(this, "Anda Belum Beruntung, Coba Lagi!", Toast.LENGTH_SHORT).show()
    }
}

    //Kelas dadu
class Dice(private val numSides: Int) {
        //berfungsi untuk menggulirkan dadu dengan mengembalikan nilai  sebagai int
        //random untuk mengacak dadu
    fun roll(): Int {
        return (1..numSides).random()
    }
}