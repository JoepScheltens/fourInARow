package com.example.fourinarow

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
//        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
//        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
//        stage.title = "Hello!"
//        stage.scene = scene
//        stage.show()

        val game = Game()

        game.setupBoard()
        game.addDisk(4)
        game.addDisk(5)
        game.addDisk(5)
        game.addDisk(3)
        game.addDisk(5)
        game.addDisk(3)
        game.addDisk(5)
        game.addDisk(3)
        game.addDisk(5)
        game.addDisk(3)
        game.addDisk(5)

    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}