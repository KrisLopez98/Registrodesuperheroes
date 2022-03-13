package com.example.registrodesuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import com.example.registrodesuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* START BUILDING OF INTENTS (COMIENZO O CONSTRUCCIÓN DE INTENT (1° ACTIVITY AND 2° ACTIVITY))*/
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {

            /*PASS INFORMATION FROM MAIN ACTIVITY(principal activity) TO DETAIL ACTIVITY (second activity)*/
            val superheroName : String = binding.heroNameEdit.text.toString()
            val alterEgo : String = binding.alterEgoEdit.text.toString()
            val bio : String = binding.bioEdit.text.toString()
            val power: Float = binding.powerBar.rating

            /*CONSTANT (TYPE FACT) =  INFORMATION OF FIRST ACTIVITY*/
            /*USE PARCELABLES*/
            val hero = Superhero(superheroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }

        heroImage = binding.heroImage
        heroImage.setOnClickListener {
            openCamera()
        }
    }

    /*-----------------------------------IMPLICIT INTENT------------------------------------------*/
    /*FOR OPEN CAMERA*/
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent,1000)
    }
    /*--------------------------------------------------------------------------------------------*/


    /*-----------------------------------EXPLICIT INTENT------------------------------------------*/
    /*USE PARCELABLES*/
    /*PASS THE INFORMATION TO SECOND ACTIVITY AND PASS THE "VAL" OR DATA AS PARAMETERS */
    private fun openDetailActivity(superhero: Superhero){
        /*BUILDING AN INTENT (1° ACTIVITY (MAIN ACTIVITY) AND 2° ACTIVITY (DETAIL ACTIVITY))*/
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
        /*----------------------------------------------------------------------------------*/

        /*SEND INFORMATION TO SECOND ACTIVITY (DETAIL ACTIVITY) */
        startActivity(intent)
    }

    /*RECEIVE PHOTO*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == 1000){
            val extras = data?.extras
            val heroBitmap = extras?.getParcelable<Bitmap>("data")
            heroImage.setImageBitmap(heroBitmap)
        }
    }
    /* -----------------------------FINISH BUILDING OF INTENTS-------------------------------------*/
}