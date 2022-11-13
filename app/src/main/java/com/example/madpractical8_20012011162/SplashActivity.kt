package com.example.madpractical8_20012011162

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var uvpceframebyframeanimation:AnimationDrawable
    lateinit var twinanimation:Animation
    lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        img=findViewById<ImageView>(R.id.image)
        img.setBackgroundResource(R.drawable.uvpceanimation)
        uvpceframebyframeanimation=img.background as AnimationDrawable
        twinanimation=AnimationUtils.loadAnimation(this,R.anim.list)
        twinanimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus)
        {
            uvpceframebyframeanimation.start()
            img.startAnimation(twinanimation)
        }
        else
        {
            uvpceframebyframeanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {
    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also { startActivity(it) }
        overridePendingTransition(R.anim.scale_centre_in,R.anim.scale_centre_out)
        finish()
    }

    override fun onAnimationRepeat(p0: Animation?) {
        TODO("Not yet implemented")
    }
}