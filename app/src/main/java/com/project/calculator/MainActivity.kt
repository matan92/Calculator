package com.project.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private var text=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clearBtn.setOnClickListener {
            calculationsTv.text="0"
            text= calculationsTv.text.toString()
        } //Clear text
        equalsBtn.setOnClickListener {
            showResult()
        } // Result
    }

    fun showNumbers(view: View) {
        text= calculationsTv.text.toString()
        if (text == "0") // Change only the first character
        {
            calculationsTv.text = (view as Button).text
            text= calculationsTv.text.toString()
        }
        else //append characters
        {
                calculationsTv.append((view as Button).text)
                text= calculationsTv.text.toString()
        }
    }

    fun deleteChars(view: View) {
        text= calculationsTv.text.toString()
        if(text!="0"){
            text=text.substring(0,text.length-1) //delete the last character
            if(text.isEmpty()){
                text="0"
                calculationsTv.text=text
            }
            else
                calculationsTv.text=text //show the current text
        }
    }

    fun calculatePercentages(view: View) {
        text= calculationsTv.text.toString()
        if(text!="0") {
            try {
                text = ((text.toDouble()) / 100).toString()
                calculationsTv.text = text
            } // try to divide by 100
            catch (exception:Exception){
                return
            } // Do not return anything if there is nothing to display
        }
    }

    fun addDot(view: View) {
        text= calculationsTv.text.toString()
        if((text[text.length-1]!='.')){
            text+='.'
            calculationsTv.text = text
        }
    } // add a dot if the last character is not a dot

    fun addDivider(view: View) {
        text= calculationsTv.text.toString()
        if(text[text.length-1].isDigit())
            text+="/"
        else
            text=text.substring(0,text.length-1)+"/"
        calculationsTv.text = text
    } // add divider if the last character is only a digit

    fun addMultiplication(view: View) {
        text= calculationsTv.text.toString()
        if(text[text.length-1].isDigit())
            text+="*"
        else
            text=text.substring(0,text.length-1)+"*"
        calculationsTv.text = text
    } // add multiplication if the last character is only a digit

    fun addMinus(view: View) {
        text= calculationsTv.text.toString()
        if(text[text.length-1].isDigit())
            text+="-"
        else
            text=text.substring(0,text.length-1)+"-"
        calculationsTv.text = text
    } // add minus if the last character is only a digit

    fun addPlus(view: View) {
        text= calculationsTv.text.toString()
        if(text[text.length-1].isDigit())
            text+="+"
        else
            text=text.substring(0,text.length-1)+"+"
        calculationsTv.text = text
    } // add plus if the last character is only a digit

    private fun showResult(){
        text= calculationsTv.text.toString()
        if (text=="0") // stay zero
            return
        var result:Number=0
        var index=0
        while (index<text.length){
            var num1:Number
            var num2:Number
            var intFlag1=false
            var doubleFlag1=false
            var intFlag2=false
            var doubleFlag2=false
            // get all the characters before and after the operator and calculate the math expression
            if (text[index]=='+' && index+1<text.length){
                val temp1= text.substring(0,index).toIntOrNull()
                val temp2= text.substring(index+1,text.length).toIntOrNull()
                if (temp1==null) {
                    num1= (text.substring(0,index)).toDouble()
                    doubleFlag1=true
                }
                else {
                    num1 = (text.substring(0, index)).toInt()
                    intFlag1=true
                }

                if(temp2==null) {
                    num2=text.substring(index+1,text.length).toDouble()
                    doubleFlag2=true
                }
                else{
                    num2=text.substring(index+1,text.length).toInt()
                    intFlag2=true
                }

                if (intFlag1 && intFlag2){
                    result=num1.toInt()+num2.toInt()
                }
                else if (doubleFlag1 && doubleFlag2){
                    result=num1.toDouble()+num2.toDouble()
                }
                else if (intFlag1 && doubleFlag2){
                    result=num1.toInt()+num2.toDouble()
                }
                else if (doubleFlag1 && intFlag2)
                {
                    result=num1.toDouble()+num2.toInt()
                }


            }
            if (text[index]=='-' && index+1<text.length && index!=0){
                val temp1= text.substring(0,index).toIntOrNull()
                val temp2= text.substring(index+1,text.length).toIntOrNull()
                if (temp1==null) {
                    num1= (text.substring(0,index)).toDouble()
                    doubleFlag1=true
                }
                else {
                    num1 = (text.substring(0, index)).toInt()
                    intFlag1=true
                }

                if(temp2==null) {
                    num2=text.substring(index+1,text.length).toDouble()
                    doubleFlag2=true
                }
                else{
                    num2=text.substring(index+1,text.length).toInt()
                    intFlag2=true
                }

                if (intFlag1 && intFlag2){
                    result=num1.toInt()-num2.toInt()
                }
                else if (doubleFlag1 && doubleFlag2){
                    result=num1.toDouble()-num2.toDouble()
                }
                else if (intFlag1 && doubleFlag2){
                    result=num1.toInt()-num2.toDouble()
                }
                else if (doubleFlag1 && intFlag2)
                {
                    result=num1.toDouble()-num2.toInt()
                }
            }
            if (text[index]=='*' && index+1<text.length){
                val temp1= text.substring(0,index).toIntOrNull()
                val temp2= text.substring(index+1,text.length).toIntOrNull()
                if (temp1==null) {
                    num1= (text.substring(0,index)).toDouble()
                    doubleFlag1=true
                }
                else {
                    num1 = (text.substring(0, index)).toInt()
                    intFlag1=true
                }

                if(temp2==null) {
                    num2=text.substring(index+1,text.length).toDouble()
                    doubleFlag2=true
                }
                else{
                    num2=text.substring(index+1,text.length).toInt()
                    intFlag2=true
                }

                if (intFlag1 && intFlag2){
                    result=num1.toInt()*num2.toInt()
                }
                else if (doubleFlag1 && doubleFlag2){
                    result=num1.toDouble()*num2.toDouble()
                }
                else if (intFlag1 && doubleFlag2){
                    result=num1.toInt()*num2.toDouble()
                }
                else if (doubleFlag1 && intFlag2)
                {
                    result=num1.toDouble()*num2.toInt()
                }
            }
            if (text[index]=='/' && index+1<text.length){
                try {
                    val temp1= text.substring(0,index).toIntOrNull()
                    val temp2= text.substring(index+1,text.length).toIntOrNull()
                    if (temp1==null) {
                        num1= (text.substring(0,index)).toDouble()
                        doubleFlag1=true
                    }
                    else {
                        num1 = (text.substring(0, index)).toInt()
                        intFlag1=true
                    }

                    if(temp2==null) {
                        num2=text.substring(index+1,text.length).toDouble()
                        doubleFlag2=true
                    }
                    else{
                        num2=text.substring(index+1,text.length).toInt()
                        intFlag2=true
                    }

                    if(num2==0 || num2==0.0){
                        throw Exception()
                    } //Do not allow the user to divide by zero

                    if ((intFlag1 && intFlag2) || (doubleFlag1 && doubleFlag2)){
                            result=num1.toDouble()/num2.toDouble()
                    }
                    else if (intFlag1 && doubleFlag2){
                        result=num1.toInt()/num2.toDouble()
                    }
                    else if (doubleFlag1 && intFlag2)
                    {
                        result=num1.toDouble()/num2.toInt()
                    }
                }
                catch (exception:Exception){
                    Toast.makeText(this,"Can't divide by zero",Toast.LENGTH_SHORT).show()
                    return
                } // Show a message to the user who must not divide by zero
            }
            index++
        }
        text=result.toString()
        if(text.contains(".0")){
            if (text[text.length-2].toString()+text[text.length-1].toString()==".0")
                text=text.substring(0,text.length-2)
        } // convert double to int
        calculationsTv.text = text
    }

}


