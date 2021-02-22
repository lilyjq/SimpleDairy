package com.mercury.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.arch.core.util.Function
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.Transformations.switchMap
import com.mercury.diary.R
import kotlinx.android.synthetic.main.fragment_v.*

class VFragment : Fragment(){

    var viewModel:VLViewModle = VLViewModle()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_v,container,false)
        return view
    }



    lateinit var mutableLiveData: MutableLiveData<Int>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.let { ViewModelProvider(it).get(VLViewModle::class.java) }!!


        //fragment ktx

//        viewModel.
//        mutableLiveData = viewModel.mutableLiveData
//        mutableLiveData.observe(viewLifecycleOwner, Observer {  tv_num.setText(""+it)})

//        var function = Function<Int,String>(){
//            return@Function "ssss"+it
//        }

   /*    var live= Transformations.map(
            viewModel.mutableLiveData,
            Function<Int,String>(){
                return@Function "sss"+it
            }
        )

        live.observe(viewLifecycleOwner, Observer { tv_num.setText(it) })*/



        var lives = Transformations.switchMap(viewModel.mutableLiveData,Function<Int,LiveData<String>>(){
            var str :String
             if(it == 1){
                str = "i have a dream"
            }else{
                str = ""+it
            }

            var live = MutableLiveData<String>()
            live.value = str
            return@Function live
        } )


        lives.observe(viewLifecycleOwner, Observer {
            tv_num.setText(it)
        })
    }
}