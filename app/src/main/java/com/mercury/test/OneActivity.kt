package com.mercury.test

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.mercury.diary.R
import kotlinx.android.synthetic.main.activity_one.*
import java.security.Permissions

class OneActivity : AppCompatActivity() {



    private val launcher = registerForActivityResult(MyResultContract(),ActivityResultCallback<String>{
        Toast.makeText(this,it,Toast.LENGTH_SHORT).show();
    })

    private val myLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),ActivityResultCallback<ActivityResult>{

    })

    private val permissionLauncher  = registerForActivityResult(ActivityResultContracts.RequestPermission(),
        ActivityResultCallback {  })

//    StartActivityForResult()
//    RequestMultiplePermissions()
//    RequestPermission()
//    TakePicturePreview()
//    TakePicture()
//    TakeVideo()
//    PickContact()
//    CreateDocument()
//    OpenDocumentTree()
//    OpenMultipleDocuments()
//    OpenDocument()
//    GetMultipleContents()
//    GetContent()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        tv_go.setOnClickListener(View.OnClickListener {  launcher.launch("i have a dream")})
        lifecycle.addObserver(LifecycleEventObserver(){ lifecycleOwner: LifecycleOwner, event: Lifecycle.Event ->{
            when(event){
                Lifecycle.Event.ON_CREATE ->{

                }


            }



        }
        })
//        tv_go.setOnClickListener(View.OnClickListener { permissionLauncher.launch(Manifest.permission.ACCESS_NETWORK_STATE) })

    }






}