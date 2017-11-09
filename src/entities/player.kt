package entities

import com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener
import rand
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

class Player(val name: String, val playerClass: String, var level: Int, var strength: Int, var constitution: Int, var intelligence: Int) {
    var health = 10 + constitution
    var dmg = if(playerClass == "warrior") strength + level*2 else intelligence + level*2
    var currentHealth = health

    fun showStats(){
        println("Name: $name")
        println("Level: $level")
        println("Class: $playerClass")
        println("Str: $strength")
        println("Con: $constitution")
        println("Int: $intelligence")
    }



    fun attack(en: Enemy){
        println("You are fighting against a ${en.name}")
        when (playerClass){
            "mage" ->{
                println("What attack do you want to use? (enter H for help)")
                val attack: String = readLine().toString().toLowerCase()
                when (attack){
                    "q" -> en.currentHealth -= dmg + 2
                    "w" -> en.currentHealth -= dmg + rand(1, 3)
                    "e" -> {
                        currentHealth = if(currentHealth+intelligence>health)  health else currentHealth + intelligence
                    }
                }
            }
            "warrior" ->
        }
    }

    fun levelUp(){
        println("You leveled up! What do you want to increase? (str/con/int)")
        val increase = readLine().toString().toLowerCase()
        when (increase) {
            "str" -> strength+=1
            "con" -> constitution+=1
            "int" -> intelligence +=1
        }
        level+=1
        health+= constitution
    }

}