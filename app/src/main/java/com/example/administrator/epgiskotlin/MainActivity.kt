package com.example.administrator.epgiskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.administrator.epgiskotlin.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    override fun afterTextChanged(s: Editable?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View) {
        if (v.getId() == R.id.loginbutton) {
            Log.v("tfhr", "this is $str")
            Log.v("tfhr", "this is ${1 + i++}")
            Log.v("tfhr", "this is ${1 + i++}")
            Log.v("tfhr", "this is ${1 + (++j)}")
            Log.v("tfhr", "this is ${3 + i}")
            Log.v("tfhr", "this is ${3 + j}")
            startActivity(Intent(this@MainActivity, MapActivity::class.java))
        }
    }

    var a: Any? = null
    var arrayList: ArrayList<Bean>? = null
    var str: String? = "";
    var i: Int = 0;
    var j: Int = 0;
    var recylerViewAdapter: RecylerViewAdapter? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
        str = "first kotlin demo";
    }

    private fun initData() {
        arrayList = ArrayList<Bean>()
        arrayList?.add(Bean("this is first"))
        arrayList?.add(Bean("this is second"))
        arrayList?.add(Bean("this is third"))
//        recylerViewAdapter?.notifyDataSetChanged()
    }

    private fun initView() {
        loginbutton?.setOnClickListener(this)
        input?.setText(str)
        input?.addTextChangedListener(this)
        kotlin_recyclerview?.layoutManager = LinearLayoutManager(this)
        recylerViewAdapter = RecylerViewAdapter(this)
        kotlin_recyclerview?.adapter = recylerViewAdapter
        recylerViewAdapter?.setData(arrayList)
        recylerViewAdapter?.notifyDataSetChanged()
        loginpassword?.addTextChangedListener(object : MyTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                LogUtils.v("liu","after text change")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                super.beforeTextChanged(s, start, count, after)
                LogUtils.v("liu","before text change")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                LogUtils.v("liu","text changing")
            }
        })
    }

    open class MyTextWatcher() : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
}

