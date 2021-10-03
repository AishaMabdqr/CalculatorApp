package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var result : EditText
    lateinit var b1 : Button
    lateinit var b2 : Button
    lateinit var b3 : Button
    lateinit var b4 : Button
    lateinit var b5 : Button
    lateinit var b6 : Button
    lateinit var b7 : Button
    lateinit var b8 : Button
    lateinit var b9 : Button
    lateinit var b0 : Button
    lateinit var bDivision : Button
    lateinit var bAddition : Button
    lateinit var bMinus : Button
    lateinit var bMultiply : Button
    lateinit var bDel : Button
    lateinit var bDecimal : Button
    lateinit var bEqual : Button
    lateinit var bClear : Button
    lateinit var bPlusMinus : Button

    var newOp = true
    var firstNum = ""
    var secondNum =""
    var op = ""
    var prev = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        bAddition = findViewById(R.id.bAddition)
        bMinus = findViewById(R.id.bMinus)
        bMultiply = findViewById(R.id.bMultiply)
        bDivision = findViewById(R.id.bDivision)
        bDecimal = findViewById(R.id.bDecimal)
        bDel = findViewById(R.id.bDel)
        bClear = findViewById(R.id.bClear)
        bPlusMinus = findViewById(R.id.bPlusMinus)
        bEqual = findViewById(R.id.bEqual)
        b0 = findViewById(R.id.b0)
    }

    fun numberEvent(view: View) {

        if(newOp)
            result.setText("")

        newOp = false
        var bClicked = result.text.toString()
        var bSelect = view as Button

        when(bSelect.id){
            b1.id -> { bClicked += "1" }
            b2.id -> { bClicked += "2" }
            b3.id -> { bClicked += "3" }
            b4.id -> { bClicked += "4" }
            b5.id -> { bClicked += "5" }
            b6.id -> { bClicked += "6" }
            b7.id -> { bClicked += "7" }
            b8.id -> { bClicked += "8" }
            b9.id -> { bClicked += "9" }
            b0.id -> { bClicked += "0" }
            bPlusMinus.id -> { bClicked = "-$bClicked"}
            bDecimal.id -> {bClicked += "."}
        }
        if (op == "") {
            result.setText(bClicked)
        }else {
            secondNum = bClicked
            result.setText(prev + secondNum)
        }
    }

    fun operatorEvent(view: View) {
        newOp = true
        var bClicked = result.text.toString()
        firstNum = bClicked
        var bSelect = view as Button

        when(bSelect.id){
            bAddition.id -> { op = "+" }
            bMinus.id -> { op = "-" }
            bMultiply.id -> { op= "*" }
            bDivision.id -> { op = "/" }

        }

        prev = firstNum + op
        result.setText(firstNum + op)
    }

    fun equalOperation(view: View) {
        newOp = true
        prev = ""

        // secondNum = result.text.toString()
      //  var bSelect = view as Button
        var operation = 0f


        when (op){
            "+" -> { operation = (firstNum.toFloat() + secondNum.toFloat())}
            "-" -> { operation = (firstNum.toFloat() - secondNum.toFloat())}
            "*" -> { operation = (firstNum.toFloat() * secondNum.toFloat())}
            "/" -> {
                if (secondNum == "0"){
                    operation = 0f
                }else {
                operation = (firstNum.toFloat() / secondNum.toFloat())}}
        }
        result.setText( operation.toString())

    }

    fun clearEvent(view: View) {
        newOp = true
        result.setText("0")

    }
}